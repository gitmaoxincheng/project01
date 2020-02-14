package cn.com.agree.huanan.ap.tl.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import cn.com.agree.huanan.ap.tl.config.ApTlBaseConfig;
import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.base.DbType;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfEnumException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * 流水号工具
 * 
 * @author tan.ch
 *
 */
public class SernoUtil {
	private static Logger logger=Logger.getLogger(SernoUtil.class);
	/**
	 * 逐位生成随机数
	 * @param numLength 随机数长度
	 * @return
	 */
	public static String getRandomNum(int numLength){
		Date date = new Date();
		long timeMills = date.getTime();
		Random rand = new Random(timeMills);
		StringBuffer sb = new StringBuffer();
		while( numLength-- > 0){
			sb.append(String.valueOf(rand.nextInt(9)));
		}
		return sb.toString();
	}
	
	/**
	 * 调用jdk api自动生成UUID,去掉-符号,32位
	 * @return
	 */
	public static String getUUID32(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
    public static String getSerno(String poolName,String seqName, int seqLen) {
    	return getSerno(seqName, seqLen);	//TODO
    }
	
    /**
     * 获取流水号
     * 
     * @param seqName 序列名称
     * @param seqLen 序列长度
     * @return 流水号
     */
    public static String getSerno(String seqName, int seqLen) {
        // bean
        DbConnection dbConn = SpringUtil.getBean(DbConnection.class);
        ApTlBaseConfig cfg = SpringUtil.getBean(ApTlBaseConfig.class);
        // 差异处理
        String sql;
        if (cfg.getDbType() == DbType.ORACLE) {
            sql = String.format("select %s.nextval from dual", seqName);
        } else if (cfg.getDbType() == DbType.DB2) {
            sql = String.format("select nextval for %s from sysibm.sysdummy1", seqName);
        } else {
            throw new ApValueOutOfEnumException(cfg.getDbType());
        }
        // TODO: 长耗时检测
        // 查询
        List<List<Object>> rowSet = dbConn.query(sql);
        // 类型转换
        Object valueObj = rowSet.get(0).get(0);
        Long valueLong;

        if (valueObj instanceof BigDecimal) {
            valueLong = ((BigDecimal) valueObj).longValue();
        } else if (valueObj instanceof Long) {
            valueLong = ((Long) valueObj).longValue();
        } else if (valueObj instanceof Integer) {
            valueLong = (long) ((Integer) valueObj).intValue();
        } else {
            throw new ApValueTypeUnsupportException(valueObj);
        }
        // 补齐
        String valueStr = StrUtil.zfill(valueLong, seqLen);
        // 超长截断
        if (valueStr.length() > seqLen) {
            valueStr = valueStr.substring(valueStr.length() - seqLen);
        }
        logger.debug("获取序列号["+seqName+"]:"+valueStr);
        // 返回
        return valueStr;
    }
    
    
//    public static void main(String[] args){
//    	System.out.println(getRandomNum(15));
//    }
}
