package cn.com.agree.huanan.ap.rl.bank.base.util;

import java.util.HashMap;
import java.util.Map;

import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommParam;
import cn.com.agree.huanan.ap.rl.bank.base.constant.SvcParam;
import cn.com.agree.huanan.ap.tl.exception.busi.ApEumnNotExistException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApSystemException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;
import cn.com.agree.huanan.ap.tl.util.SernoUtil;

/**
 * @author acz hcp
 * 工具类
 */
public class SernoGenUtil {

	private static Logger logger=Logger.getLogger(SernoGenUtil.class);
	private static SvcParam svcParam = SpringUtil.getBean(SvcParam.class);
	private static String svcCode =""; 

	/** 流水号生成器映射，格式：序列名->生成器 */
	private static final Map<String, SernoGenerator> sernoGeneratorMap = new HashMap<String, SernoGenerator>();

	/** 流水号前缀启用日期，为空则直接启用 */
	/*private static String sernoSuffixDate = EnvCfg.getEnvCfg("afa.sernoSuffixDate", "");*/

	static {
//		Map<String, Integer> seqItems = CommParam.SeqItems;
		for (String seq : CommParam.SeqItems.keySet()) {
//			Integer len =  seqItems.get(seq);
			// 创建流水号生成器
			SernoGenerator generator = new SernoGenerator(seq, CommParam.suffixLen);
			// 保存到map
			sernoGeneratorMap.put(seq, generator);
			// 处理下一项
		}
		svcCode = svcParam.getSvcCode()!=null?svcParam.getSvcCode():CommParam.transferCode(EnvContextHolder.getHolder().getContext().getMC());
	}	

	
	/**
	 * 生成登记簿流水号
	 * @param seqName  序列号
	 * @return
	 */
	public static String getRegistSerno(String seqName){
		if(!CommParam.SeqItems.containsKey(seqName)){				//判断序列是否存在
			throw new ApEumnNotExistException("序列"+seqName);
		}
		return DateTimeUtil.getSysDate()+getSequence(seqName, CommParam.SeqItems.get(seqName));
	}

	
	/**
	 * 生成返回流水号
	 * @param seqName  服务标识
	 * @return 返回流水号
	 */
	public static String getRspSerno(){
		//暂时 serviceFlag为预留参数
		return "C0310"+DateTimeUtil.getSysDate()+svcCode+getSequence(CommParam.CSIS_RSP_SEQ,CommParam.SeqItems.get(CommParam.CSIS_RSP_SEQ));
	}


	/**
	 * 获取渠整流水号
	 * @param dbSeq
	 * @return
	 */
	public static String getSerno(String seqName){
		if(!CommParam.SeqItems.containsKey(seqName)){				//判断序列是否存在
			throw new ApEumnNotExistException("序列"+seqName);
		}
		return "C0310"+DateTimeUtil.getSysDate()+svcCode+getSequence(seqName,CommParam.SeqItems.get(seqName));
	}

/*	*//**
	 * 获取渠整平台流水号
	 * @param service 服务标识简称，2位
	 * @param dbSeq 序列名
	 * @return 全局流水号
	 *//*
	public static String getSerno(String service,String dbSeq){
		//暂时 serviceFlag为预留参数
		return "C0310"+DateTimeUtil.getSysDate()+service+getSequence(dbSeq,CommParam.SeqItems.get(dbSeq));
	}
*/
	/**
	 * 获取渠整全局流水号
	 * @param service 服务标识简称，2位
	 * @param dbSeq 序列名
	 * @return 全局流水号
	 */
	public static String getGSerno(String seqName){
		return "G0310"+DateTimeUtil.getSysDate()+svcCode+getSequence(seqName,CommParam.SeqItems.get(seqName));
	}

	
	/**
	 * 获取渠整平台流水号
	 * @param channelCode 渠道代码
	 * @param dbSeq 序列名
	 * @return 全局流水号
	 */
	public static String getGSerno(String channelCode,String dbSeq){
		return "G"+channelCode+DateTimeUtil.getSysDate()+svcCode+SernoUtil.getSerno(dbSeq, CommParam.SeqItems.get(dbSeq));
	}
	

	private static String getSequence(String seqName, int seqLen) throws Error {
		return getSequence(null, seqName, seqLen, true);
	}
	
	
	/**
	 * 序列号操作  获取数据库中指定sequence的当前值,现仅支持Oracle/DB2/Informix三种数据库,对于Informix,dual表是手工创建的
	 * @param poolName 指定的数据库连接池名，如果不填则从第一个连接池中获取连接String
	 * @param seqName 序号名称String 
	 * @param seqLen 序号长度int
	 * @return
	 */
	private static String getSequence(String poolName, String seqName, int seqLen, boolean enabledCache) throws Error {
		// 启动缓存
		if (enabledCache) {
			// 获取生成器
			SernoGenerator generator = sernoGeneratorMap.get(seqName);
			if (generator == null) {
				// 序列名转大写后再次获取
				generator = sernoGeneratorMap.get(seqName.toUpperCase());
			}
			// 从生成器生成流水号
			if (generator != null) {
				String serno = generator.getSerno(poolName, seqLen);
				logger.info("累加生成流水号：%s", serno);
				return serno;
			}else {
				throw new ApSystemException(new Exception(seqName+"流水生成器不存在"));
			}
		}else {
			return SernoUtil.getSerno(poolName,seqName, seqLen);
		}
	}
	
}
