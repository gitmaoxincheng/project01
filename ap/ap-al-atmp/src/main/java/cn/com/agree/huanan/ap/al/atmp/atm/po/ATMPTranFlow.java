package cn.com.agree.huanan.ap.al.atmp.atm.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.atmp.atm.po.ATMPTranFlow.ATMP_TRAD_FLOW;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Table(ATMP_TRAD_FLOW.class)
/**
 * ATM特色P交易流水表Bean
 */
public class ATMPTranFlow implements Serializable{
	private static final long serialVersionUID = 8294137370489448041L;
	
	private String	tradeDate;//平台交易日期
	private String	serialNo;//平台交易流水
	private String	tradeTime;//平台交易时间
	private String	subTransFlag;//子交易事务标识
	private String	bussCeNo;//业务场景流水号
	private String	serveCodeOut;//外部服务码
	private String	sceneCodeOut;//外部场景码
	private String	serveCode;//服务码
	private String	sceneCode;//场景码
	private String	reqSysId;//请求方系统标识
	private String	reqCalCod;//请求方渠道编码
	private String	reqDate;//请求方日期
	private String	reqTime;//请求方时间
	private String	reqSerialNo;//请求方流水号
	private String	scrSysId;//源请求方系统标识
	private String	scrCalCod;//源请求方渠道编码
	private String	golSeqNo;//全局流水号
	private String	tellerNo;//柜员号
	private String	tellerTp;//柜员类型
	private String	myBank;//法人号
	private String	zoneNo;//分行号
	private String	mbrNo;//支行号
	private String	brNo;//网点号
	private String	devNo;//设备编号
	private String	authTellerNo;//授权柜员
	private String	respSts;//交易状态
	private String	errorCode;//消息码
	private String	errorMsg;//消息码描述
	private String	backServeCode;//后台服务码
	private String	backSceneCode;//后台场景码
	private String	backSysDate;//后台交易日期
	private String	backSysNo;//后台交易流水
	private String	backSysSts;//后台交易状态
	private String	backSysErrorCode;//后台消息码
	private String	backSysErrorMsg;//后台消息码描述
	private String	updTime;//更新时间
	private String	updDate;//更新日期

	
	public static class ATMP_TRAD_FLOW{
		
	}
	
	public static ATMPTranFlow instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(ATMPTranFlow atmpTranFlow){
		 Map<String, Object> map = new HashMap<>();
		 map.put("tradeDate", atmpTranFlow.getTradeDate());
		 map.put("serialNo", atmpTranFlow.getSerialNo());
		 map.put("tradeTime", atmpTranFlow.getTradeTime());
		 map.put("subTransFlag", atmpTranFlow.getSubTransFlag());
		 map.put("bussCeNo", atmpTranFlow.getBussCeNo());
		 map.put("serveCodeOut", atmpTranFlow.getServeCodeOut());
		 map.put("sceneCodeOut", atmpTranFlow.getSceneCodeOut());
		 map.put("serveCode", atmpTranFlow.getServeCode());
		 map.put("sceneCode", atmpTranFlow.getSceneCode());
		 map.put("reqSysId", atmpTranFlow.getReqSysId());
		 map.put("reqCalCod", atmpTranFlow.getReqCalCod());
		 map.put("reqDate", atmpTranFlow.getReqDate());
		 map.put("reqTime", atmpTranFlow.getReqTime());
		 map.put("reqSerialNo", atmpTranFlow.getReqSerialNo());
		 map.put("scrSysId", atmpTranFlow.getScrSysId());
		 map.put("scrCalCod", atmpTranFlow.getScrCalCod());
		 map.put("golSeqNo", atmpTranFlow.getGolSeqNo());
		 map.put("tellerNo", atmpTranFlow.getTellerNo());
		 map.put("tellerTp", atmpTranFlow.getTellerTp());
		 map.put("myBank", atmpTranFlow.getMyBank());
		 map.put("zoneNo", atmpTranFlow.getZoneNo());
		 map.put("mbrNo", atmpTranFlow.getMbrNo());
		 map.put("brNo", atmpTranFlow.getBrNo());
		 map.put("devNo", atmpTranFlow.getDevNo());
		 map.put("authTellerNo", atmpTranFlow.getAuthTellerNo());
		 map.put("respSts", atmpTranFlow.getRespSts());
		 map.put("errorCode", atmpTranFlow.getErrorCode());
		 map.put("errorMsg", atmpTranFlow.getErrorMsg());
		 map.put("backServeCode", atmpTranFlow.getBackServeCode());
		 map.put("backSceneCode", atmpTranFlow.getBackSceneCode());
		 map.put("backSysDate", atmpTranFlow.getBackSysDate());
		 map.put("backSysNo", atmpTranFlow.getBackSysNo());
		 map.put("backSysSts", atmpTranFlow.getBackSysSts());
		 map.put("backSysErrorCode", atmpTranFlow.getBackSysErrorCode());
		 map.put("backSysErrorMsg", atmpTranFlow.getBackSysErrorMsg());
		 map.put("updTime", atmpTranFlow.getUpdTime());
		 map.put("updDate", atmpTranFlow.getUpdDate());		
		 return map;

	}
}
