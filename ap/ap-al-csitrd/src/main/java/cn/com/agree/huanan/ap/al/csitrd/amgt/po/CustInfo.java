package cn.com.agree.huanan.ap.al.csitrd.amgt.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//import cn.com.agree.huanan.ap.al.csitrd.amgt.po.CustInfo.TRADEINFO_PER_CUST_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 个人客户信息登记簿bean
 * @author Maoxc
 *
 */
@Getter
@Setter
@ToString
//@Table(TRADEINFO_PER_CUST_MAIN.class)
public class CustInfo implements Serializable{

//	private static final long serialVersionUID = 4966235049447047812L;
//	
//	private String tradeDate;	//平台交易日期
//	private String serialNo;	//平台交易流水
//	private String tradeTime;	//平台交易时间
//	private String subtransFlag;	//子交易事务标识,0不适用1强事务2弱事务
//	private String bussceNo;	//业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
//	private String servecodeOut;	//外部服务码
//	private String scenecodeOut;	//外部场景码
//	private String servecode;	//服务码
//	private String scenecode;	//场景码
//	private String reqSysId;	//请求方系统标识
//	private String reqCalCod;	//请求方渠道编码
//	private String reqDate;	//请求方日期
//	private String reqTime;	//请求方时间
//	private String reqSerialNo;	//请求方流水号
//	private String scrSysId;	//源请求方系统标识
//	private String scrCalCod;	//源请求方渠道编码
//	private String golSeqNo;	//全局流水号
//	private String tellerNo;	//柜员号
//	private String tellerTp;	//柜员类型
//	private String myBank;	//法人号
//	private String zoneNo;	//分行号
//	private String mBrno;	//支行号
//	private String brno;	//网点号
//	private String devno;	//设备编号
//	private String authTellerNo;	//授权柜员
//	private String respSts;		//交易状态
//	private String errorCode;	//消息码
//	private String errorMsg;	//消息码描述
//	private String backServeCode;	//后台服务码
//	private String backSceneCode;	//后台场景码
//	private String backSysDate;	//后台交易日期
//	private String backSysNo;	//后台交易流水
//	private String backSysSts;	//后台交易状态
//	private String backSysErrorCode;	//后台消息码
//	private String backSysErrorMsg;	//后台消息码描述
//	private String updDate;	//最后更新日期
//	private String updTime;	//最后更新时间
//	
//	
//	
//	private String custNum;//客户号
//	private String custName;//客户姓名
//	private String identType;//证件类型
//	private String identNo;//证件号码
//	private String certArea;//发证国家或地区
//	private String identOrgaddId;//发证机关地区代码
//	private String sex;//性别
//	private String nationality;//民族
//	private String marriage;//婚姻状况
//	private String highestEdu;//最高学历
//	private String schoolName;//学校名称
//	private String liveAddrDetail;//居住地址-详细地址
//	private String domAddrDetail;//户籍地址-详细地址
//	private String internetinSpectflag;//联网核查标识
//	private String noinspectCause;//无法核实原因
//	private String careerType;//职业类别
//	private String careerExplain;//职业补充说明
//	private String unitName;//单位名称
//	private String unitAddrDetail;//单位地址-详细地址
//	private String unitTel;//单位电话
//	private String mobile;//手机号码
//	private String bornDate;//出生日期
//	private String agentName;//代理人姓名
//	private String agentTel;//代理人联系方式
//	private String card_issn_org;//发卡机构
//	private String prod_code;//产品代码
//	private String acctAttrCode;//账户属性代码
//	private String openAccttpwhlsl;//大额存单开户类型
//	private String acctTp;//账户类型
//	private String custAcctnum;//客户账号
//	private String outSubAcctserl;//转出子账户序号
//	private String ccycodeNum;//货币代号
//	private String txNamt;//交易金额
//	private String bankNo;//发卡银行编号
//	private String bankName;//发卡银行名称
//	private String mdisuAcctno;//医保账号
//	private String bankSeq;//银行流水号
//	private String socisuSeq;//社保流水号
//
//	public static class TRADEINFO_PER_CUST_MAIN{
//		
//	}
//	
//	public static Map<String, Object> getMap(CustInfo cust){
//		Map<String, Object> map = new HashMap<>();
//		map.put("TradeDate",cust.getTradeDate());
//		map.put("SerialNo",cust.getSerialNo());
//		map.put("tradeTime",cust.getTradeTime());
//		map.put("subtransFlag",cust.getSubtransFlag());
//		map.put("bussceNo",cust.getBussceNo());
//		map.put("servecodeOut",cust.getServecodeOut());
//		map.put("scenecodeOut",cust.getScenecodeOut());
//		map.put("servecode",cust.getServecode());
//		map.put("scenecode",cust.getScenecode());
//		map.put("reqSysId",cust.getReqSysId());
//		map.put("reqCalCod",cust.getReqCalCod());
//		map.put("reqDate",cust.getReqDate());
//		map.put("reqTime",cust.getReqTime());
//		map.put("reqSerialNo",cust.getReqSerialNo());
//		map.put("scrSysId",cust.getScrSysId());
//		map.put("scrCalCod",cust.getScrCalCod());
//		map.put("golSeqNo",cust.getGolSeqNo());
//		map.put("tellerNo",cust.getTellerNo());
//		map.put("tellerTp",cust.getTellerTp());
//		map.put("myBank",cust.getMyBank());
//		map.put("zoneNo",cust.getZoneNo());
//		map.put("mBrno",cust.getMBrno());
//		map.put("brno",cust.getBrno());
//		map.put("devno",cust.getDevno());
//		map.put("authTellerNo",cust.getAuthTellerNo());
//		map.put("respSts",cust.getRespSts());
//		map.put("errorCode",cust.getErrorCode());
//		map.put("errorMsg",cust.getErrorMsg());
//		map.put("backServeCode",cust.getBackServeCode());
//		map.put("backSceneCode",cust.getBackSceneCode());
//		map.put("backSysDate",cust.getBackSysDate());
//		map.put("backSysNo",cust.getBackSysNo());
//		map.put("backSysSts",cust.getBackSysSts());
//		map.put("backSysErrorCode",cust.getBackSysErrorCode());
//		map.put("backSysErrorMsg",cust.getBackSysErrorMsg());
//		map.put("updDate",cust.getUpdDate());
//		map.put("updTime",cust.getUpdTime());
//		
//		map.put("custNum",cust.getCustNum());
//		map.put("custName",cust.getCustName());
//		map.put("identType",cust.getIdentType());
//		map.put("identNo",cust.getIdentNo());
//		map.put("certArea",cust.getCertArea());
//		map.put("identOrgaddId",cust.getIdentOrgaddId());
//		map.put("sex",cust.getSex());
//		map.put("nationality",cust.getNationality());
//		map.put("marriage",cust.getMarriage());
//		map.put("highestEdu",cust.getHighestEdu());
//		map.put("schoolName",cust.getSchoolName());
//		map.put("liveAddrDetail",cust.getLiveAddrDetail());
//		map.put("domAddrDetail",cust.getDomAddrDetail());
//		map.put("internetinSpectflag",cust.getInternetinSpectflag());
//		map.put("noinspectCause",cust.getNoinspectCause());
//		map.put("careerType",cust.getCareerType());
//		map.put("careerExplain",cust.getCareerExplain());
//		map.put("unitName",cust.getUnitName());
//		map.put("unitAddrDetail",cust.getUnitAddrDetail());
//		map.put("unitTel",cust.getUnitTel());
//		map.put("mobile",cust.getMobile());
//		map.put("bornDate",cust.getBornDate());
//		map.put("agentName",cust.getAgentName());
//		map.put("agentTel",cust.getAgentTel());
//		map.put("card_issn_org",cust.getCard_issn_org());
//		map.put("prod_code",cust.getProd_code());
//		map.put("acctAttrCode",cust.getAcctAttrCode());
//		map.put("openAccttpwhlsl",cust.getOpenAccttpwhlsl());
//		map.put("acctTp",cust.getAcctTp());
//		map.put("custAcctnum",cust.getCustAcctnum());
//		map.put("outSubAcctserl",cust.getOutSubAcctserl());
//		map.put("ccycodeNum",cust.getCcycodeNum());
//		map.put("txNamt",cust.getTxNamt());
//		map.put("bankNo",cust.getBankNo());
//		map.put("bankName",cust.getBankName());
//		map.put("mdisuAcctno",cust.getMdisuAcctno());
//		map.put("bankSeq",cust.getBankSeq());
//
//
//		
//		return map;
//	}
}