package cn.com.agree.huanan.ap.al.csitrd.cert.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.cert.po.TradeInfoCert.TRADEINFO_CERT_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 事故事项登记簿bean
 * @author lanshaojun
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_CERT_MAIN.class)
public class TradeInfoCert implements Serializable{
	
	private static final long serialVersionUID = 7378347747665257981L;
	
	/*header*/
	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String tradeTime;//平台交易时间
	private String subTransFlag;//子交易事务标识
	private String busSceNo;//业务场景流水号
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
	private String respSts;//交易状态
	private String errorCode;//消息码
	private String errorMsg;//消息码描述
	private String backServeCode;//后台服务码
	private String backSceneCode;//后台场景码
	private String backSysDate;//后台交易日期
	private String backSysNo;//后台交易流水
	private String backSysSts;//后台交易状态
	private String backSysErrorCode;//后台消息码
	private String backSysErrorMsg;//后台消息码描述
	private String updDate;//更新日期
	private String updTime;//更新时间
	
	/*body*/
	private String acctNo;//客户账户
	private String acctType;//客户类型
	private String acctName;//客户中文名
	private String amount;//交易金额
	private String certType;//证件种类
	private String certNo;//证件号码
	private String feeAcctNo;//收费账号
	private String feeAmout;//收费金额
	private String totNum;//凭证数量

	private String certFlag;//凭证处理标志
	private String virTlr;//虚拟柜员
	private String cntprTlr;//对方柜员
	private String abstCode;//摘要代码
	private String abstDsc;//摘要描述
	private String remarkKs;//备注信息
	private String taskid;//任务号
	private String rcvname;//领用人名称
	private String rcvcerttype;//领用人证件类型
	private String rcvcertno;//领用人证件号码
	
	public static class TRADEINFO_CERT_MAIN{
		
	}
	
	public static Map<String, Object> getMap(TradeInfoCert tradeInfoCert){
		Map<String, Object> map = new HashMap<>();

		map.put("tradeDate",tradeInfoCert.getTradeDate());
		map.put("serialNo",tradeInfoCert.getSerialNo());
		map.put("tradeTime",tradeInfoCert.getTradeTime());
		map.put("subTransFlag",tradeInfoCert.getSubTransFlag());
		map.put("busSceNo",tradeInfoCert.getBusSceNo());
		map.put("serveCode_Out",tradeInfoCert.getServeCode_Out());
		map.put("sceneCode_Out",tradeInfoCert.getSceneCode_Out());
		map.put("serveCode",tradeInfoCert.getServeCode());
		map.put("sceneCode",tradeInfoCert.getSceneCode());
		map.put("reqSysId",tradeInfoCert.getReqSysId());
		map.put("reqCalCod",tradeInfoCert.getReqCalCod());
		map.put("reqDate",tradeInfoCert.getReqDate());
		map.put("reqTime",tradeInfoCert.getReqTime());
		map.put("reqSerialNo",tradeInfoCert.getReqSerialNo());
		map.put("scrSysId",tradeInfoCert.getScrSysId());
		map.put("scrCalCod",tradeInfoCert.getScrCalCod());
		map.put("golSeqNo",tradeInfoCert.getGolSeqNo());
		map.put("tellerNo",tradeInfoCert.getTellerNo());
		map.put("tellerTp",tradeInfoCert.getTellerTp());
		map.put("myBank",tradeInfoCert.getMyBank());
		map.put("zoneNo",tradeInfoCert.getZoneNo());
		map.put("mBrNo",tradeInfoCert.getMbrNo());
		map.put("brNo",tradeInfoCert.getBrNo());
		map.put("devNo",tradeInfoCert.getDevNo());
		map.put("authTellerNo",tradeInfoCert.getAuthTellerNo());
		map.put("respSts",tradeInfoCert.getRespSts());
		map.put("errorCode",tradeInfoCert.getErrorCode());
		map.put("errorMsg",tradeInfoCert.getErrorMsg());
		map.put("backServeCode",tradeInfoCert.getBackServeCode());
		map.put("backSceneCode",tradeInfoCert.getBackSceneCode());
		map.put("backSysDate",tradeInfoCert.getBackSysDate());
		map.put("backSysNo",tradeInfoCert.getBackSysNo());
		map.put("backSysSts",tradeInfoCert.getBackSysSts());
		map.put("backSysErrorCode",tradeInfoCert.getBackSysErrorCode());
		map.put("backSysErrorMsg",tradeInfoCert.getBackSysErrorMsg());
		map.put("updDate",tradeInfoCert.getUpdDate());
		map.put("updTime",tradeInfoCert.getUpdTime());
		
		map.put("acctNo",tradeInfoCert.getAcctNo());
		map.put("acctType",tradeInfoCert.getAcctType());
		map.put("acctName",tradeInfoCert.getAcctName());
		map.put("amount",tradeInfoCert.getAmount());
		map.put("certType",tradeInfoCert.getCertType());
		map.put("certNo",tradeInfoCert.getCertNo());
		map.put("feeAcctNo",tradeInfoCert.getFeeAcctNo());
		map.put("feeAmout",tradeInfoCert.getFeeAmout());
		map.put("totNum",tradeInfoCert.getTotNum());

		map.put("certType",tradeInfoCert.getCertType());
		map.put("certType",tradeInfoCert.getCertFlag());
		map.put("virTlr",tradeInfoCert.getVirTlr());
		map.put("cntprTlr",tradeInfoCert.getCntprTlr());
		map.put("abstCode",tradeInfoCert.getAbstCode());
		map.put("abstDsc",tradeInfoCert.getAbstDsc());
		map.put("remarkKs",tradeInfoCert.getRemarkKs());
		map.put("taskid",tradeInfoCert.getTaskid());
		map.put("rcvname",tradeInfoCert.getRcvname());
		map.put("rcvcerttype",tradeInfoCert.getRcvcerttype());
		map.put("rcvcertno",tradeInfoCert.getRcvcertno());
		return map;
	}
}
