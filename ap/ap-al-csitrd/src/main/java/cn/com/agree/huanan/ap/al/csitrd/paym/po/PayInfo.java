package cn.com.agree.huanan.ap.al.csitrd.paym.po;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.paym.po.PayInfo.TRADEINFO_PAY_MAIN;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 支付结算业务登记簿bean
 * @author MAOW
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_PAY_MAIN.class)
public class PayInfo implements Serializable{
	
	
	private static final long serialVersionUID = 4854915252860459796L;
	private String tradeDate; //平台交易日期
	private String serialNo;//平台交易流水
	private String tradeTime;//平台交易时间
	private String subtransFlag;//子交易事务标识
	private String bussceNo;//业务场景流水号
	private String serveCode_Out;//外部服务码
	private String sceneCode_Out;//外部场景码
	private String serveCode;//服务码
	private String sceneCode;//场景码
	private String reqSysId;//请求方系统标识
	private String reqCalCod;//请求方渠道编码
	private String reqDate;//请求方日期
	private String reqTime;//请求方时间
	private String reqSerialNo;//请求方流水号
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
	private String authTellerNo;//授权柜员
	
	private String respSts;           //交易状态
	private String errorCode;         //消息码
	private String errorMsg;          //消息码描述
	private String backServeCode;     //后台服务码
	private String backSceneCode;     //后台场景码
	private String backSysDate;       //后台交易日期
	private String backSysNo;         //后台交易流水
	private String backSysSts;        //后台交易状态
	private String backSysErrorCode;  //后台消息码
	private String backSysErrorMsg;   //后台消息码描述
	private String updTime;           //最后更新时间
	private String updDate;           //最后更新日期
	
	private String payerAcc;//付款人账号
	private String PayerName;//付款人名称
	private String currType;//币种
	private String payeeAcc;//接收人账号
	private String payeeName;//接收人姓名
	private String receiVer;//接收行号
	private String amount;//交易金额
	private String chargeAmount;//手续费金额
	private String chargeAcctno;//手续费账号
	private String channelDate;//渠道日期
	private String operTg;//走大小额标识
	private String payeraccType;//业务类型
	private String chrgFg;//是否收手续费标志
	private String xnumFlag;//交易方式
	private String reCountry;//收款人国家
	private String tno;//撤销交易的流水
	private String biZno;//渠道业务编号
	private String launchMode;//交易渠道
	
	public static class TRADEINFO_PAY_MAIN{
		
	}
	
	public static Map<String, Object> getMap(PayInfo payInfo){
		Map<String, Object> map = new HashMap<>();
		 map.put("tradedate", payInfo.getTradeDate());
		 map.put("serialno", payInfo.getSerialNo());
		 map.put("tradetime", payInfo.getTradeTime());
		 map.put("subtransflag", payInfo.getSubtransFlag());
		 map.put("bussceno", payInfo.getBussceNo());
		 map.put("servecode_out", payInfo.getServeCode_Out());
		 map.put("scenecode_out", payInfo.getSceneCode_Out());
		 map.put("servecode", payInfo.getServeCode());
		 map.put("scenecode", payInfo.getSceneCode());
		 map.put("reqsysid", payInfo.getReqSysId());
		 map.put("reqcalcod", payInfo.getReqCalCod());
		 map.put("reqdate", payInfo.getReqDate());
		 map.put("reqtime", payInfo.getReqTime());
		 map.put("reqserialno", payInfo.getReqSerialNo());
		 map.put("scrsysid", payInfo.getScrSysId());
		 map.put("scrcalcod", payInfo.getScrCalCod());
		 map.put("golseqno", payInfo.getGolSeqNo());
		 map.put("tellerno", payInfo.getTellerNo());
		 map.put("tellertp", payInfo.getTellerTp());
		 map.put("mybank", payInfo.getMyBank());
		 map.put("zoneno", payInfo.getZoneNo());
		 map.put("mbrno", payInfo.getMbrNo());
		 map.put("brno", payInfo.getBrNo());
		 map.put("devno", payInfo.getDevNo());
		 map.put("authtellerno", payInfo.getAuthTellerNo());
		 map.put("respsts", payInfo.getRespSts());
		 map.put("errorcode", payInfo.getErrorCode());
		 map.put("errormsg", payInfo.getErrorMsg());
		 map.put("backservecode", payInfo.getBackServeCode());
		 map.put("backscenecode", payInfo.getBackSceneCode());
		 map.put("backsysdate", payInfo.getBackSysDate());
		 map.put("backsysno", payInfo.getBackSysNo());
		 map.put("backsyssts", payInfo.getBackSysSts());
		 map.put("backsyserrorcode", payInfo.getBackSysErrorCode());
		 map.put("backsyserrormsg", payInfo.getBackSysErrorMsg());
		 map.put("upddate", payInfo.getUpdDate());
		 map.put("updtime", payInfo.getUpdTime());
		 
		 map.put("payerAcc",payInfo.getPayeeAcc());
		 map.put("PayerName",payInfo.getPayerName());
		 map.put("currType",payInfo.getCurrType());
		 map.put("payeeAcc",payInfo.getPayeeAcc());
		 map.put("payeeName",payInfo.getPayeeAcc());
		 map.put("receiVer",payInfo.getReceiVer());
		 map.put("amount",payInfo.getAmount());
		 map.put("chargeAmount",payInfo.getChargeAmount());
		 map.put("chargeAcctno",payInfo.getChargeAcctno());
		 map.put("channelDate",payInfo.getChannelDate());
		 map.put("operTg",payInfo.getOperTg());
		 map.put("payeraccType",payInfo.getPayeraccType());
		 map.put("chrgFg",payInfo.getChrgFg());
		 map.put("xnumFlag",payInfo.getXnumFlag());
		 map.put("reCountry",payInfo.getReCountry());
		 map.put("tno",payInfo.getTno());
		 map.put("biZno",payInfo.getBiZno());
		 map.put("launchMode",payInfo.getLaunchMode());

		return map;
	}
}
