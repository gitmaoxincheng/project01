package cn.com.agree.huanan.ap.al.csitrd.mide.po;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.cidt.po.TradeMessageInfo;
import cn.com.agree.huanan.ap.al.csitrd.mide.po.IntermediateMain.TRADEINFO_INTERMEDIATE_MAIN;

/**
 * 特色业务
 * chents
 * */
@Getter
@Setter
@ToString
@Table(TRADEINFO_INTERMEDIATE_MAIN.class)
public class IntermediateMain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5877508018958359321L;

	//公共部分
	private String tradeDate;	//平台交易日期
	private String serialNo;	//平台交易流水
	private String tradeTime;	//平台交易时间
	private String subtransFlag;	//子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo;	//业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
	private String servecode_out;	//外部服务码
	private String scenecode_out;	//外部场景码
	private String servecode;	//服务码
	private String scenecode;	//场景码
	private String reqSysId;	//请求方系统标识
	private String reqCalCod;	//请求方渠道编码
	private String reqDate;	//请求方日期
	private String reqTime;	//请求方时间
	private String reqSerialNo;	//请求方流水号
	private String scrSysId;	//源请求方系统标识
	private String scrCalCod;	//源请求方渠道编码
	private String golSeqNo;	//全局流水号
	private String tellerNo;	//柜员号
	private String tellerTp;	//柜员类型
	private String myBank;	//法人号
	private String zoneNo;	//分行号
	private String mBrno;	//支行号
	private String brno;	//网点号
	private String devno;	//设备编号
	private String authTellerNo;	//授权柜员
	private String respSts;		//交易状态
	private String errorCode;	//消息码
	private String errorMsg;	//消息码描述
	private String backServeCode;	//后台服务码
	private String backSceneCode;	//后台场景码
	private String backSysDate;	//后台交易日期
	private String backSysNo;	//后台交易流水
	private String backSysSts;	//后台交易状态
	private String backSysErrorCode;	//后台消息码
	private String backSysErrorMsg;	//后台消息码描述
	private String updDate2;	//最后更新日期
	private String updTime2;	//最后更新时间
	
	//APPBody部分
	private String unitNo;//执收单位编码
	private String unitNm;//执收单位名称
	private String paysNo;//缴费凭证单号，例如文书号，缴款通知书号码
	private String paysNm;//缴款人（单位）名称
	private String payDay;//缴款日期
	private String amount;//缴费金额
	private String feeAmount;//手续费金额
	private String bussType;//缴费类型1-交警罚款，2-学费、3-电费
	private String msgFlag;//收费方式0-未缴款，1-现金，3-刷卡，4-网付，5-自助终端，6-批扣，8-微信，9-其他
	private String payAccno;//付款账号
	private String payAccName;//付款账号户名
	private String payChannel;//缴费渠道
	private String userNo;//客户编号，例如用电客户编号，水费客户编号
	private String userNo_t;//结算户编号
	private String dfny;//费用年月，例如电费年月，水费年月
	private String corpCode;//企业代码
	private String fxCode;//费项代码
	private String odt;//原委托日期
	private String olz;//原业务流水
	private String idType;//证件类型
	private String idCode;//证件号码
	private String billingType;//缴费凭证类别，例如文书类别、缴款通知书类别
	private String lateAmount;//滞纳金
	private String feeAccNo;//手续费账号
	private String billingNo;//缴费编号

	public static class TRADEINFO_INTERMEDIATE_MAIN {

	}

	public static Map<String, Object> getMap(IntermediateMain info) {
		Map<String, Object> map = new HashMap<>();
		map.put("tradeDate",info.getTradeDate());
		map.put("serialNo",info.getSerialNo());
		map.put("tradeTime",info.getTradeTime());
		map.put("subtransFlag",info.getSubtransFlag());
		map.put("bussceNo",info.getBussceNo());
		map.put("servecode_out",info.getServecode_out());
		map.put("scenecode_out",info.getScenecode_out());
		map.put("servecode",info.getServecode());
		map.put("scenecode",info.getScenecode());
		map.put("reqSysId",info.getReqSysId());
		map.put("reqCalCod",info.getReqCalCod());
		map.put("reqDate",info.getReqDate());
		map.put("reqTime",info.getReqTime());
		map.put("reqSerialNo",info.getReqSerialNo());
		map.put("scrSysId",info.getScrSysId());
		map.put("scrCalCod",info.getScrCalCod());
		map.put("golSeqNo",info.getGolSeqNo());
		map.put("tellerNo",info.getTellerNo());
		map.put("tellerTp",info.getTellerTp());
		map.put("myBank",info.getMyBank());
		map.put("zoneNo",info.getZoneNo());
		map.put("mBrno",info.getMBrno());
		map.put("brno",info.getBrno());
		map.put("devno",info.getDevno());
		map.put("authTellerNo",info.getAuthTellerNo());
		map.put("respSts",info.getRespSts());
		map.put("errorCode",info.getErrorCode());
		map.put("errorMsg",info.getErrorMsg());
		map.put("backServeCode",info.getBackServeCode());
		map.put("backSceneCode",info.getBackSceneCode());
		map.put("backSysDate",info.getBackSysDate());
		map.put("backSysNo",info.getBackSysNo());
		map.put("backSysSts",info.getBackSysSts());
		map.put("backSysErrorCode",info.getBackSysErrorCode());
		map.put("backSysErrorMsg",info.getBackSysErrorMsg());
		map.put("updDate2",info.getUpdDate2());
		map.put("updTime2",info.getUpdTime2());
		
		map.put("billingType",info.getBillingType());
		map.put("unitNo",info.getUnitNo());
		map.put("unitNm",info.getUnitNm());
		map.put("paysNo",info.getPaysNo());
		map.put("paysNm",info.getPaysNm());
		map.put("payDay",info.getPayDay());
		map.put("amount",info.getAmount());
		map.put("feeAmount",info.getFeeAmount());
		map.put("bussType",info.getBussType());
		map.put("msgFlag",info.getMsgFlag());
		map.put("payAccno",info.getPayAccno());
		map.put("payAccName",info.getPayAccName());
		map.put("payChannel",info.getPayChannel() );
		map.put("userNo",info.getUserNo());
		map.put("userNo_t",info.getUserNo_t() );
		map.put("dfny",info.getDfny());
		map.put("corpCode",info.getCorpCode());
		map.put("fxCode",info.getFxCode());
		map.put("odt",info.getOdt());
		map.put("olz",info.getOlz());
		map.put("idType",info.getIdType());
		map.put("idCode",info.getIdCode());
		map.put("billingType",info.getBillingType());
		map.put("lateAmount",info.getLateAmount());
		map.put("feeAccNo",info.getFeeAccNo());

		return map;
	}
	
}
