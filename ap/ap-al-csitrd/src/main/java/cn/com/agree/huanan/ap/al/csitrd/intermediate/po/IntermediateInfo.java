package cn.com.agree.huanan.ap.al.csitrd.intermediate.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.intermediate.po.IntermediateInfo.TRADEINFO_INTERMEDIATE_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 特色业务登记Bean
 * @author bodadmin
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_INTERMEDIATE_MAIN.class)
public class IntermediateInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842907595509021423L;

	private String tradeDate;         //平台交易日期
	private String serialNo;          //平台交易流水
	private String tradeTime;         //平台交易时间
	private String subTransFlag;      //子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo;          //业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
	private String serveCodeOut;     //外部服务码
	private String sceneCodeOut;     //外部场景码
	private String serveCode;         //服务码
	private String sceneCode;         //场景码
	private String reqSysId;          //请求方系统标识
	private String reqCalCod;         //请求方渠道编码
	private String reqDate;           //请求方日期
	private String reqTime;           //请求方时间
	private String reqSerialNo;       //请求方流水号
	private String scrSysId;          //源请求方系统标识
	private String scrCalCod;         //源请求方渠道编码
	private String golSeqNo;          //全局流水号
	private String tellerNo;          //柜员号
	private String tellerTp;          //柜员类型
	private String myBank;            //法人号
	private String zoneNo;            //分行号
	private String mbrno;             //支行号
	private String brNo;              //网点号
	private String devno;             //设备编号
	private String authTellerNo;      //授权柜员
	
	private String respsts;           //交易状态
	private String errorCode;         //消息码
	private String errorMsg;          //消息码描述
	private String backServeCode;     //后台服务码
	private String backSceneCode;     //后台场景码
	private String backSysDate;       //后台交易日期
	private String backSysNo;         //后台交易流水
	private String backSysSts;        //后台交易状态
	private String backSysErrorCode;  //后台消息码
	private String backSysErrorMsg;   //后台消息码描述
	private String updTime2;           //最后更新时间
	private String updDate2;           //最后更新日期
	
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
	
	public static Map<String, Object> getMap(IntermediateInfo trade) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("unitno",trade.getUnitNo());
		map.put("unitnm",trade.getUnitNm());
		map.put("paysno",trade.getPaysNo());
		map.put("paysnm",trade.getPaysNm());
		map.put("payday",trade.getPayDay());
		map.put("amount",trade.getAmount());
		map.put("feeamount",trade.getFeeAmount());
		map.put("busstype",trade.getBussType());
		map.put("msgflag",trade.getMsgFlag());
		map.put("payaccno",trade.getPayAccno());
		map.put("payaccname",trade.getPayAccName());
		map.put("paychannel",trade.getPayChannel());
		map.put("userno",trade.getUserNo());
		map.put("userno_t",trade.getUserNo_t());
		map.put("dfny",trade.getDfny());
		map.put("corpcode",trade.getCorpCode());
		map.put("fxcode",trade.getFxCode());
		map.put("odt",trade.getOdt());
		map.put("olz",trade.getOlz());
		map.put("idtype",trade.getIdType());
		map.put("idcode",trade.getIdCode());
		map.put("billingtype",trade.getBillingType());
		map.put("lateamount",trade.getLateAmount());
		map.put("feeaccno",trade.getFeeAccNo());
		map.put("tradedate",trade.getTradeDate());
		map.put("serialno",trade.getSerialNo());
		map.put("tradetime",trade.getTradeTime());
		map.put("subtransflag",trade.getSubTransFlag());
		map.put("bussceno",trade.getBussceNo());
		map.put("servecode_out",trade.getServeCodeOut());
		map.put("scenecode_out",trade.getSceneCodeOut());
		map.put("servecode",trade.getServeCode());
		map.put("scenecode",trade.getSceneCode());
		map.put("reqsysid",trade.getReqSysId());
		map.put("reqcalcod",trade.getReqCalCod());
		map.put("reqdate",trade.getReqDate());
		map.put("reqtime",trade.getReqTime());
		map.put("reqserialno",trade.getReqSerialNo());
		map.put("scrsysid",trade.getScrSysId());
		map.put("scrcalcod",trade.getScrCalCod());
		map.put("golseqno",trade.getGolSeqNo());
		map.put("tellerno",trade.getTellerNo());
		map.put("tellertp",trade.getTellerTp());
		map.put("mybank",trade.getMyBank());
		map.put("zoneno",trade.getZoneNo());
		map.put("mbrno",trade.getMbrno());
		map.put("brno",trade.getBrNo());
		map.put("devno",trade.getDevno());
		map.put("authtellerno",trade.getAuthTellerNo());
		map.put("respsts",trade.getRespsts());
		map.put("errorcode",trade.getErrorCode());
		map.put("errormsg",trade.getErrorMsg());
		map.put("backservecode",trade.getBackServeCode());
		map.put("backscenecode",trade.getBackSceneCode());
		map.put("backsysdate",trade.getBackSysDate());
		map.put("backsysno",trade.getBackSysNo());
		map.put("backsyssts",trade.getBackSysSts());
		map.put("backsyserrorcode",trade.getBackSysErrorCode());
		map.put("backsyserrormsg",trade.getBackSysErrorMsg());
		map.put("upddate2",trade.getUpdDate2());
		map.put("updtime2",trade.getUpdTime2());
		map.put("billingno",trade.getBillingNo());

		return map;
	}

}
