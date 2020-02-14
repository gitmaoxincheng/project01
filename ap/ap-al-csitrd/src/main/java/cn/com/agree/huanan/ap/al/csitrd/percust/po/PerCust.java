package cn.com.agree.huanan.ap.al.csitrd.percust.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.percust.po.PerCust;
import cn.com.agree.huanan.ap.al.csitrd.percust.po.PerCust.TRADEINFO_PER_CUST_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Table(TRADEINFO_PER_CUST_MAIN.class)
public class PerCust implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tradeDate;	//平台交易日期
	private String serialNo;	//平台交易流水
	private String tradeTime;	//平台交易时间
	private String subtransFlag;	//子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo;	//业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
	private String servecodeOut;	//外部服务码
	private String scenecodeOut;	//外部场景码
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
	private String updDate;	//最后更新日期
	private String updTime;	//最后更新时间
		
	private String custNum;//客户号
	private String custName;//客户姓名
	private String identType;//证件类型
	private String identNo;//证件号码
	private String certArea;//发证国家或地区
	private String identOrgaddId;//发证机关地区代码
	private String sex;//性别
	private String nationality;//民族
	private String marriage;//婚姻状况
	private String highestEdu;//最高学历
	private String schoolName;//学校名称
	private String liveAddrDetail;//居住地址-详细地址
	private String domAddrDetail;//户籍地址-详细地址
	private String internetinSpectflag;//联网核查标识
	private String noinspectCause;//无法核实原因
	private String careerType;//职业类别
	private String careerExplain;//职业补充说明
	private String unitName;//单位名称
	private String unitAddrDetail;//单位地址-详细地址
	private String unitTel;//单位电话
	private String mobile;//手机号码
	private String bornDate;//出生日期
	private String agentName;//代理人姓名
	private String agentTel;//代理人联系方式
	private String card_issn_org;//发卡机构
	private String prod_code;//产品代码
	private String acctAttrCode;//账户属性代码
	private String openAccttpwhlsl;//大额存单开户类型
	private String acctTp;//账户类型
	private String custAcctnum;//客户账号
	private String outSubAcctserl;//转出子账户序号
	private String ccycodeNum;//货币代号
	private String txNamt;//交易金额
	private String bankNo;//发卡银行编号
	private String bankName;//发卡银行名称
	private String mdisuAcctno;//医保账号
	private String bankSeq;//银行流水号
	private String socisuSeq;//社保流水号

	public static class TRADEINFO_PER_CUST_MAIN{
		
	}
	
	public static Map<String, Object> getMap(PerCust perCust){
		Map<String, Object> map = new HashMap<>();
		map.put("TradeDate",perCust.getTradeDate());
		map.put("SerialNo",perCust.getSerialNo());
		map.put("tradeTime",perCust.getTradeTime());
		map.put("subtransFlag",perCust.getSubtransFlag());
		map.put("bussceNo",perCust.getBussceNo());
		map.put("servecodeOut",perCust.getServecodeOut());
		map.put("scenecodeOut",perCust.getScenecodeOut());
		map.put("servecode",perCust.getServecode());
		map.put("scenecode",perCust.getScenecode());
		map.put("reqSysId",perCust.getReqSysId());
		map.put("reqCalCod",perCust.getReqCalCod());
		map.put("reqDate",perCust.getReqDate());
		map.put("reqTime",perCust.getReqTime());
		map.put("reqSerialNo",perCust.getReqSerialNo());
		map.put("scrSysId",perCust.getScrSysId());
		map.put("scrCalCod",perCust.getScrCalCod());
		map.put("golSeqNo",perCust.getGolSeqNo());
		map.put("tellerNo",perCust.getTellerNo());
		map.put("tellerTp",perCust.getTellerTp());
		map.put("myBank",perCust.getMyBank());
		map.put("zoneNo",perCust.getZoneNo());
		map.put("mBrno",perCust.getMBrno());
		map.put("brno",perCust.getBrno());
		map.put("devno",perCust.getDevno());
		map.put("authTellerNo",perCust.getAuthTellerNo());
		map.put("respSts",perCust.getRespSts());
		map.put("errorCode",perCust.getErrorCode());
		map.put("errorMsg",perCust.getErrorMsg());
		map.put("backServeCode",perCust.getBackServeCode());
		map.put("backSceneCode",perCust.getBackSceneCode());
		map.put("backSysDate",perCust.getBackSysDate());
		map.put("backSysNo",perCust.getBackSysNo());
		map.put("backSysSts",perCust.getBackSysSts());
		map.put("backSysErrorCode",perCust.getBackSysErrorCode());
		map.put("backSysErrorMsg",perCust.getBackSysErrorMsg());
		map.put("updDate",perCust.getUpdDate());
		map.put("updTime",perCust.getUpdTime());
		
		map.put("custNum",perCust.getCustNum());
		map.put("custName",perCust.getCustName());
		map.put("identType",perCust.getIdentType());
		map.put("identNo",perCust.getIdentNo());
		map.put("certArea",perCust.getCertArea());
		map.put("identOrgaddId",perCust.getIdentOrgaddId());
		map.put("sex",perCust.getSex());
		map.put("nationality",perCust.getNationality());
		map.put("marriage",perCust.getMarriage());
		map.put("highestEdu",perCust.getHighestEdu());
		map.put("schoolName",perCust.getSchoolName());
		map.put("liveAddrDetail",perCust.getLiveAddrDetail());
		map.put("domAddrDetail",perCust.getDomAddrDetail());
		map.put("internetinSpectflag",perCust.getInternetinSpectflag());
		map.put("noinspectCause",perCust.getNoinspectCause());
		map.put("careerType",perCust.getCareerType());
		map.put("careerExplain",perCust.getCareerExplain());
		map.put("unitName",perCust.getUnitName());
		map.put("unitAddrDetail",perCust.getUnitAddrDetail());
		map.put("unitTel",perCust.getUnitTel());
		map.put("mobile",perCust.getMobile());
		map.put("bornDate",perCust.getBornDate());
		map.put("agentName",perCust.getAgentName());
		map.put("agentTel",perCust.getAgentTel());
		map.put("card_issn_org",perCust.getCard_issn_org());
		map.put("prod_code",perCust.getProd_code());
		map.put("acctAttrCode",perCust.getAcctAttrCode());
		map.put("openAccttpwhlsl",perCust.getOpenAccttpwhlsl());
		map.put("acctTp",perCust.getAcctTp());
		map.put("custAcctnum",perCust.getCustAcctnum());
		map.put("outSubAcctserl",perCust.getOutSubAcctserl());
		map.put("ccycodeNum",perCust.getCcycodeNum());
		map.put("txNamt",perCust.getTxNamt());
		map.put("bankNo",perCust.getBankNo());
		map.put("bankName",perCust.getBankName());
		map.put("mdisuAcctno",perCust.getMdisuAcctno());
		map.put("bankSeq",perCust.getBankSeq());
		
		return map;
	}

}
