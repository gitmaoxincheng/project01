package cn.com.agree.huanan.ap.al.csiusr.rtmh.po;

import java.io.Serializable; 
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.RTMHTradInfo.COMP_TRAD_FLOW;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(COMP_TRAD_FLOW.class)

/**
 *其它P（微网点、回单机、排队机）流水表Bean
 */
public class RTMHTradInfo implements Serializable{

	
	private String  tradeDate;		// 平台交易日期	
	private String  serialNo;		// 平台交易流水	
	private String  tradeTime;		// 平台交易时间	
	private String  subTransFlag;	// 子交易事务标识	
	private String  bussCeNo;		// 业务场景流水号	
	private String  serveCodeOut;	// 外部服务码	
	private String  sceneCodeOut;	// 外部场景码	
	private String  serveCode;		// 服务码	
	private String  sceneCode;		// 场景码	
	private String  reqSysId;		// 请求方系统标识	
	private String  reqCalCod;		// 请求方渠道编码	
	private String  reqDate;		// 请求方日期	
	private String  reqTime;		// 请求方时间	
	private String  reqSerialNo;	// 请求方流水号	
	private String	scrSysId;		// 源请求方系统标识
	private String	scrCalCod;		// 源请求方渠道编码
	private String	golSeqNo;		//全局流水号
	private String	tellerNo;		//柜员号
	private String	tellerTp;		//柜员类型
	private String	myBank;			//法人号
	private String	zoneNo;			//分行号
	private String	mbrNo;			//支行号
	private String	brNo;			//网点号
	private String	devNo;			//设备编号
	private String	authTellerNo;	//授权柜员
	private String	respSts;		//交易状态
	private String	errorCode;		//消息码
	private String	errorMsg;		//消息码描述
	private String	backServeCode;	//后台服务码
	private String	backSceneCode;	//后台场景码
	private String	backSysDate;	//后台交易日期
	private String	backSysNo;		//后台交易流水
	private String	backSysSts;		//后台交易状态
	private String	backSysErrorCode;//后台消息码
	private String	backSysErrorMsg;//后台消息码描述
	private String	updTime;		//更新时间
	private String	updDate;		//更新日期

	
	public static class COMP_TRAD_FLOW {
		
	}
	
    public static RTMHTradInfo instance(Map<String, Object> map){
    	
        return null;
    }
    
    public static Map<String, Object> getMap(RTMHTradInfo rtmhTradInfo){
    	
    	Map<String,Object> map = new HashMap<>();
		 map.put("tradeDate", rtmhTradInfo.getTradeDate());
		 map.put("serialNo", rtmhTradInfo.getSerialNo());
		 map.put("tradeTime", rtmhTradInfo.getTradeTime());
		 map.put("subTransFlag", rtmhTradInfo.getSubTransFlag());
		 map.put("bussCeNo", rtmhTradInfo.getBussCeNo());
		 map.put("serveCodeOut", rtmhTradInfo.getServeCodeOut());
		 map.put("sceneCodeOut", rtmhTradInfo.getSceneCodeOut());
		 map.put("serveCode", rtmhTradInfo.getServeCode());
		 map.put("sceneCode", rtmhTradInfo.getSceneCode());
		 map.put("reqSysId", rtmhTradInfo.getReqSysId());
		 map.put("reqCalCod", rtmhTradInfo.getReqCalCod());
		 map.put("reqDate", rtmhTradInfo.getReqDate());
		 map.put("reqTime", rtmhTradInfo.getReqTime());
		 map.put("reqSerialNo", rtmhTradInfo.getReqSerialNo());
		 map.put("scrSysId", rtmhTradInfo.getScrSysId());
		 map.put("scrCalCod", rtmhTradInfo.getScrCalCod());
		 map.put("golSeqNo", rtmhTradInfo.getGolSeqNo());
		 map.put("tellerNo", rtmhTradInfo.getTellerNo());
		 map.put("tellerTp", rtmhTradInfo.getTellerTp());
		 map.put("myBank", rtmhTradInfo.getMyBank());
		 map.put("zoneNo", rtmhTradInfo.getZoneNo());
		 map.put("mbrNo", rtmhTradInfo.getMbrNo());
		 map.put("brNo", rtmhTradInfo.getBrNo());
		 map.put("devNo", rtmhTradInfo.getDevNo());
		 map.put("authTellerNo", rtmhTradInfo.getAuthTellerNo());
		 map.put("respSts", rtmhTradInfo.getRespSts());
		 map.put("errorCode", rtmhTradInfo.getErrorCode());
		 map.put("errorMsg", rtmhTradInfo.getErrorMsg());
		 map.put("backServeCode", rtmhTradInfo.getBackServeCode());
		 map.put("backSceneCode", rtmhTradInfo.getBackSceneCode());
		 map.put("backSysDate", rtmhTradInfo.getBackSysDate());
		 map.put("backSysNo", rtmhTradInfo.getBackSysNo());
		 map.put("backSysSts", rtmhTradInfo.getBackSysSts());
		 map.put("backSysErrorCode", rtmhTradInfo.getBackSysErrorCode());
		 map.put("backSysErrorMsg", rtmhTradInfo.getBackSysErrorMsg());
		 map.put("updTime", rtmhTradInfo.getUpdTime());
		 map.put("updDate", rtmhTradInfo.getUpdDate());	
    	
		return map;
    	
    }
	
}
