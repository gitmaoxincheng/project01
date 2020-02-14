package cn.com.agree.huanan.ap.al.csitrd.cheq.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.cheq.po.ChequeDetail.TRADEINFO_CHEQUE_DETAIL;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 支票業務登记簿bean
 * @author lanshaojun
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_CHEQUE_DETAIL.class)
public class ChequeDetail implements Serializable{
	
	private static final long serialVersionUID = 5805494678321469598L;
	
	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String brNo;//机构号
	private String tranType;//转账类型 0-托收 1-行内转账2-行外转账
	private String txccy;//币种
	private String amount;//交易金额
	private String payerBranch;//付款行行号
	private String payeeBranch;//收款行行号
	private String payerAcctBranch;//付款人开户行行号
	private String payerAcctNo;//付款人账号
	private String payerName;//付款人名称
	private String payeeAcctBranch;//收款人开户行行号
	private String payeeAcctNo;//收款人账号
	private String payeeName;//收款人名称
	private String remarks;//备注/附言
	private String billType;//凭证类型
	private String billNo;//票据号
	private String billDate;//出票日期
	private String imgTp;//票据图像类型
	private String busiStartDate;//业务开始时间
	private String busiSerialNo;//业务流水号
	private String contentId;//影像CONTENTID
	private String frontFileId;//正面文件ID
	private String backFileId;//背面文件ID
	private String yy_guId;//验印影像ID
	private String templet;//影像模板
	private String txtType;//文档部件名
	private String pmtPswdFlag;//支付密码标示 0-是;1-否
	private String status;//业务状态
	private String devNo;//设备号
	private String taskId;//任务号
	private String mobile;//通知手机号码
	private String printT;//验印取信标示 0-初验;1-复验;3-初验+复验
	private String autoPrintResult;//验印结果 0-通过 1-不通过
	private String printTlrNo1;//验印柜员1
	private String printTlrNo2;//验印柜员2
	private String inputTlrNo1;//录入柜员1
	private String inputTlrNo2;//录入柜员2
	private String inputTlrNo3;//录入柜员3
	private String authTlrNo1;//审核/授权柜员号1
	private String authTlrNo2;//审核/授权柜员号2
	private String authResult;//审核/授权结果 0-通过;1-拒绝;2-退回
	private String authBackMsg;//回退原因
	private String svdptg;//对公对私(付款账户)
	private String priority;//优先级
	private String chrgFg;//是否收手续费标志
	private String chargeAmount;//手续费金额
	private String chargeAcctNo;//手续费账号
	private String smryCd;//摘要码
	private String dscrtx;//交易摘要
	private String payDt;//提示付款日期
	private String purp;//用途
	private String nbofendrsr;//背背书人数
	private String nm;//背背书人清单背背书人名称允许中文
	private String printType;//验印类型
	private String tradeType;//验印交易类型
	private String isSmallCode;//是否小码章
	private String tradeCode;//交易类型
	private String txtpCd;//业务类型
	private String txCd;//业务编号
	private String dbtr_adr;//付款人地址
	private String cdtr_adr;//收款人地址
	private String pmtPswd;//支付密码
	private String reqPostscript;//附言
	
	public static class TRADEINFO_CHEQUE_DETAIL{
		
	}
	
	public static Map<String, Object> getMap(ChequeDetail chequeDetail){
		Map<String, Object> map = new HashMap<>();
		map.put("tradeDate",chequeDetail.getTradeDate());
		map.put("serialNo",chequeDetail.getSerialNo());
		map.put("brNo",chequeDetail.getBrNo());
		map.put("tranType",chequeDetail.getTranType());
		map.put("txccy",chequeDetail.getTxccy());
		map.put("amount",chequeDetail.getAmount());
		map.put("payerBranch",chequeDetail.getPayerBranch());
		map.put("payeeBranch",chequeDetail.getPayeeBranch());
		map.put("payerAcctBranch",chequeDetail.getPayerAcctBranch());
		map.put("payerAcctNo",chequeDetail.getPayerAcctNo());
		map.put("payerName",chequeDetail.getPayerName());
		map.put("payeeAcctBranch",chequeDetail.getPayeeAcctBranch());
		map.put("payeeAcctNo",chequeDetail.getPayeeAcctNo());
		map.put("payeeName",chequeDetail.getPayeeName());
		map.put("remarks",chequeDetail.getRemarks());
		map.put("billType",chequeDetail.getBillType());
		map.put("billNo",chequeDetail.getBillNo());
		map.put("billDate",chequeDetail.getBillDate());
		map.put("imgTp",chequeDetail.getImgTp());
		map.put("busiStartDate",chequeDetail.getBusiStartDate());
		map.put("busiSerialNo",chequeDetail.getBusiSerialNo());
		map.put("contentId",chequeDetail.getContentId());
		map.put("frontFileId",chequeDetail.getFrontFileId());
		map.put("backFileId",chequeDetail.getBackFileId());
		map.put("yy_guId",chequeDetail.getYy_guId());
		map.put("templet",chequeDetail.getTemplet());
		map.put("txtType",chequeDetail.getTxtType());
		map.put("pmtPswdFlag",chequeDetail.getPmtPswdFlag());
		map.put("status",chequeDetail.getStatus());
		map.put("devNo",chequeDetail.getDevNo());
		map.put("taskId",chequeDetail.getTaskId());
		map.put("mobile",chequeDetail.getMobile());
		map.put("printT",chequeDetail.getPrintT());
		map.put("autoPrintResult",chequeDetail.getAutoPrintResult());
		map.put("printTlrNo1",chequeDetail.getPrintTlrNo1());
		map.put("printTlrNo2",chequeDetail.getPrintTlrNo2());
		map.put("inputTlrNo1",chequeDetail.getInputTlrNo1());
		map.put("inputTlrNo2",chequeDetail.getInputTlrNo2());
		map.put("inputTlrNo3",chequeDetail.getInputTlrNo3());
		map.put("authTlrNo1",chequeDetail.getAuthTlrNo1());
		map.put("authTlrNo2",chequeDetail.getAuthTlrNo2());
		map.put("authResult",chequeDetail.getAuthResult());
		map.put("authBackMsg",chequeDetail.getAuthBackMsg());
		map.put("svdptg",chequeDetail.getSvdptg());
		map.put("priority",chequeDetail.getPriority());
		map.put("chrgFg",chequeDetail.getChrgFg());
		map.put("chargeAmount",chequeDetail.getChargeAmount());
		map.put("chargeAcctNo",chequeDetail.getChargeAcctNo());
		map.put("smryCd",chequeDetail.getSmryCd());
		map.put("dscrtx",chequeDetail.getDscrtx());
		map.put("payDt",chequeDetail.getPayDt());
		map.put("purp",chequeDetail.getPurp());
		map.put("nbofendrsr",chequeDetail.getNbofendrsr());
		map.put("nm",chequeDetail.getNm());
		map.put("printType",chequeDetail.getPrintType());
		map.put("tradeType",chequeDetail.getTradeType());
		map.put("isSmallCode",chequeDetail.getIsSmallCode());
		map.put("tradeCode",chequeDetail.getTradeCode());
		map.put("txtpCd",chequeDetail.getTxtpCd());
		map.put("txCd",chequeDetail.getTxCd());
		map.put("dbtr_adr",chequeDetail.getDbtr_adr());
		map.put("cdtr_adr",chequeDetail.getCdtr_adr());
		map.put("pmtPswd",chequeDetail.getPmtPswd());
		map.put("reqPostscript",chequeDetail.getReqPostscript());

		return map;
	}
}
