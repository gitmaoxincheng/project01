package cn.com.agree.huanan.ap.rl.bank.trade.po;

import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author HCP
 * 东莞渠道整合平台交易流水表
 */
@Getter
@Setter
@ToString
@Table(TradeFlow.csis_trade_flow.class)
public class TradeFlow {
	private String	reqSerialNo;//请求方流水号
	private String	reqSysId;//请求方系统标识
	private String	reqDate;//请求方日期
	private String	reqTime;//请求方时间
	private String	gloSeqNo;//全局流水号
	private String	reqCalCod;//请求方渠道编码
	private String	serialNo;//平台交易流水
	private String	tradeDate;//平台交易日期
	private String	tradeTime;//平台交易时间
	private String	traceId;//链路ID
//	private String	subTransFlag;//子交易事务标识  废弃
	private String	bussCeNo;//业务场景流水号
	private String	svcOutCode;//外部服务码
	private String	scnOutCode;//外部场景码
	private String	svcCode;//服务码
	private String	scnCode;//场景码
	private String	srcSysId;//源请求方系统标识
	private String	srcCalCod;//源请求方渠道编码
	private String	tellerNo;//柜员号
	private String	tellerTp;//柜员类型
	private String	myBank;//法人号
	private String	zoneNo;//分行号
	private String	mbrNo;//支行号
	private String	brNo;//网点号
	private String	devNo;//设备编号
	private String	authTellerNo;//授权柜员
	private String  isPass;// 是否交易透传，0-否 1-是 
	private String	respSts;//交易状态
	private String	errorCode;//消息码
	private String	errorMsg;//消息码描述
//	private String	backServeCode;//后台服务码  废弃
//	private String	backSceneCode;//后台场景码
//	private String	backSysDate;//后台交易日期
//	private String	backSysNo;//后台交易流水
//	private String	backSysSts;//后台交易状态
//	private String	backSysErrorCode;//后台消息码
//	private String	backSysErrorMsg;//后台消息码描述
	private String	updTime;//更新时间
	private String	updDate;//更新日期
	private int  totTime; //交易耗时
	
	public static class csis_trade_flow{
		
	}
	
	public static Map<String, Object> getMap(TradeFlow tradeFlow){
		 Map<String, Object> map = new HashMap<>();
		 map.put("reqserialno", tradeFlow.getReqSerialNo());
		 map.put("reqsysid", tradeFlow.getReqSysId());
		 map.put("reqdate", tradeFlow.getReqDate());
		 map.put("reqtime", tradeFlow.getReqTime());
		 map.put("gloseqno", tradeFlow.getGloSeqNo());
		 map.put("reqcalcod", tradeFlow.getReqCalCod());
		 map.put("tradedate", tradeFlow.getTradeDate());
		 map.put("serialno", tradeFlow.getSerialNo());
		 map.put("traceId", tradeFlow.getTraceId());
		 map.put("tradetime", tradeFlow.getTradeTime());
		 map.put("bussceno", tradeFlow.getBussCeNo());
		 map.put("svcoutcode", tradeFlow.getSvcOutCode());
		 map.put("scnoutcode", tradeFlow.getScnOutCode());
		 map.put("svccode", tradeFlow.getSvcCode());
		 map.put("scncode", tradeFlow.getScnCode());
		 map.put("scrsysId", tradeFlow.getSrcSysId());
		 map.put("scrcalcod", tradeFlow.getSrcCalCod());
		 map.put("tellerNo", tradeFlow.getTellerNo());
		 map.put("tellertp", tradeFlow.getTellerTp());
		 map.put("mybank", tradeFlow.getMyBank());
		 map.put("zoneno", tradeFlow.getZoneNo());
		 map.put("mbrno", tradeFlow.getMbrNo());
		 map.put("brno", tradeFlow.getBrNo());
		 map.put("devno", tradeFlow.getDevNo());
		 map.put("authtellerno", tradeFlow.getAuthTellerNo());
		 map.put("ispass", tradeFlow.getIsPass());		 
		 map.put("respsts", tradeFlow.getRespSts());
		 map.put("errorcode", tradeFlow.getErrorCode());
		 map.put("errormsg", tradeFlow.getErrorMsg());
		 map.put("upddate", tradeFlow.getUpdDate());
		 map.put("updtime", tradeFlow.getUpdTime());
		 map.put("tottime", tradeFlow.getTotTime());
		 return map;
	}
}
