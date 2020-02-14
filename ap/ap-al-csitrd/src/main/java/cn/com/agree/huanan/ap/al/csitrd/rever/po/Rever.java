package cn.com.agree.huanan.ap.al.csitrd.rever.po;

import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.rever.po.Rever.TRADEINFO_REVER_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 统一冲正登记簿bean
 * @author Zengs
 */
@Setter
@Getter
@ToString
@Table(TRADEINFO_REVER_MAIN.class)
public class Rever {

	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String tradeTime;//平台交易时间
	private String subtransFlag;//子交易事务标识
	private String bussceNo;//业务场景流水号
	private String serveCode_out;//外部服务码
	private String sceneCode_out;//外部场景码
	private String serveCode;//服务码
	private String sceneCode;//场景码
	private String reqSysId;//请求方系统标识
	private String reqCalCod;//请求方渠道编码
	private String reqDate;//请求方日期
	private String reqTime;//请求方时间
	private String reqSerialno;//请求方流水号
	private String scrSysId;//源请求方系统标识
	private String scrCalCod;//源请求方渠道编码
	private String golSeqNo;//全局流水号
	private String tellerNo;//柜员号
	private String tellerTp;//柜员类型
	private String myBank;//法人号
	private String zoneNo;//分行号
	private String mbrNo;//支行号
	private String brNo;//网点号
	private String devNo;//设备编号
	private String authtellerNo;//授权柜员
	private String respSts;//交易状态F-失败S-成功U-未知P-部分成功I-处理中
	private String errorCode;//消息码
	private String errorMsg;//消息码描述
	private String backServeCode;//后台服务码
	private String backSceneCode;//后台场景码
	private String backSysDate;//后台交易日期
	private String backSysNo;//后台交易流水
	private String backSysSts;//后台交易状态F-失败S-成功U-未知P-部分成功I-处理中
	private String backSysErrorcode;//后台消息码
	private String backSysErrormsg;//后台消息码描述
	private String updDate;//更新日期
	private String updTime;//更新时间
	private String oriServeCode;//原服务码
	private String oriSceneCode;//原场景码
	private String oriTxnDate;//原交易日期
	private String oriTxnSerino;//原柜员流水号
	private String oriTradeDate;//原平台日期
	private String oriSerialno;//原平台流水

	public static class TRADEINFO_REVER_MAIN{

	}


	public static Map<String, Object> getMap(Rever rever){
		Map<String,Object> map = new HashMap<>();
		map.put("tradedate",rever.getTradeDate());
		map.put("serialno",rever.getSerialNo());
		map.put("tradetime",rever.getTradeTime());
		map.put("subtransflag",rever.getSubtransFlag());
		map.put("bussceno",rever.getBussceNo());
		map.put("servecode_out",rever.getServeCode_out());
		map.put("scenecode_out",rever.getSceneCode_out());
		map.put("servecode",rever.getServeCode());
		map.put("scenecode",rever.getSceneCode());
		map.put("reqsysid",rever.getReqSysId());
		map.put("reqcalcod",rever.getReqCalCod());
		map.put("reqdate",rever.getReqDate());
		map.put("reqtime",rever.getReqTime());
		map.put("reqserialno",rever.getReqSerialno());
		map.put("scrsysid",rever.getScrSysId());
		map.put("scrcalcod",rever.getScrCalCod());
		map.put("golseqno",rever.getGolSeqNo());
		map.put("tellerno",rever.getTellerNo());
		map.put("tellertp",rever.getTellerTp());
		map.put("mybank",rever.getMyBank());
		map.put("zoneno",rever.getZoneNo());
		map.put("mbrno",rever.getMbrNo());
		map.put("brno",rever.getBrNo());
		map.put("devno",rever.getDevNo());
		map.put("authtellerno",rever.getAuthtellerNo());
		map.put("respsts",rever.getRespSts());
		map.put("errorcode",rever.getErrorCode());
		map.put("errormsg",rever.getErrorMsg());
		map.put("backservecode",rever.getBackServeCode());
		map.put("backscenecode",rever.getBackSceneCode());
		map.put("backsysdate",rever.getBackSysDate());
		map.put("backsysno",rever.getBackSysNo());
		map.put("backsyssts",rever.getBackSysSts());
		map.put("backsyserrorcode",rever.getBackSysErrorcode());
		map.put("backsyserrormsg",rever.getBackSysErrormsg());
		map.put("upddate",rever.getUpdDate());
		map.put("updtime",rever.getUpdTime());
		map.put("oriservecode",rever.getOriServeCode());
		map.put("oriscenecode",rever.getOriSceneCode());
		map.put("oritxndate",rever.getOriTxnDate());
		map.put("oritxnserino",rever.getOriTxnSerino());
		map.put("oritradedate",rever.getOriTradeDate());
		map.put("oriserialno",rever.getOriSerialno());


		return map;
	}

}
