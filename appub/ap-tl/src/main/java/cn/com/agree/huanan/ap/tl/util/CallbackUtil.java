package cn.com.agree.huanan.ap.tl.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * 
 * @author xiaot 2018年8月14日 下午3:13:52
 *
 */

public class CallbackUtil {
    
    private static final String tableName = "T_CALLBACKINFO";


    

    /**
     * @param payDate 交易日期
     * @param paySerno 交易时间
     * @param busiType 业务类型
     * @return 记录数
     */
    public static int countCallbackInfo(String payDate, String paySerno,
            String busiType)   {
        
        return SpringUtil.getBean(Selecter.class).select("BUSISERNO").from(tableName).where(w -> {
            w.eq("BUSIDATE", payDate);
            w.eq("BUSISERNO", paySerno);
            w.eq("BUSITYPE", busiType);
        }).fetchAll().size();
        


    }

    /**
     * 查询回调记录
     * @param payDate 交易日期
     * @param paySerno 交易流水
     * @param busiType 业务类型
     * @return 回调记录
     */
    public static List<Map<String, Object>>  getCallbackInfo(String payDate, String paySerno,
            String busiType)  {
        // 查询
         return SpringUtil.getBean(Selecter.class).select("BUSIINFO","MC","TC").from(tableName).where(w -> {
            w.eq("BUSIDATE", payDate);
            w.eq("BUSISERNO", paySerno);
            w.eq("BUSITYPE", busiType);
        }).fetchAll();
        
       
    }


    /**
     * @param payDate 交易日期
     * @param paySerno 交易流水
     * @param busiType 业务类型
     * @param mc 模板代码
     * @param tc 交易代码
     * @param retFileName 返回文件
     * @param busiInfo 业务信息
     * @return 插入结果
     */
    public static boolean insertCallbackInfo(String payDate, String paySerno,
            String busiType, String mc, String tc, String retFileName,
            Map<String, Object> busiInfo) {
        
        boolean ret = false;
        // 已存在则直接返回
        int count = countCallbackInfo(payDate, paySerno, busiType);
        if (count > 0) {
            return false;
        }

        Map<String, Object> cbInfo = new HashMap<String, Object>();
        cbInfo.put("mc", mc);
        cbInfo.put("tc", tc);
        cbInfo.put("busiDate", payDate);
        cbInfo.put("busiSerno", paySerno);
        cbInfo.put("busiType", busiType);
        cbInfo.put("retFileName", retFileName);
        cbInfo.put("busiInfo", JsonUtil.getUtil().mapToJsonString(busiInfo));
        if(SpringUtil.getBean(Inserter.class).insertInto(tableName).values(cbInfo).execute()>0){
            ret = true;
        };

        return ret;
    }
    

}
