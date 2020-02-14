package cn.com.agree.huanan.ap.al.csitrd.sign.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.sign.po.ToPublicClient.TRADEINFO_CORP_CUST_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 对公客户信息Bean
 * @author ZS
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_CORP_CUST_MAIN.class)
public class ToPublicClient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String tradeTime;//平台交易时间
	private String subTransFlag;//子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo;//业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
	private String serveCode_out;//外部服务码
	private String sceneCode_out;//外部场景码
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
	private String updDate;//最后更新日期
	private String updTime;//最后更新时间
	private String cust_tp;//客户类型，3-同业客户;1-个人客户;2-一般公司客户;4-联名客户;9-潜在客户;
	private String custNum;//
	private String custNm;//客户名称
	private String identType;//证件类型
	private String identNo;//证件号码
	private String certArea;//发证国家或地区
	private String open_acct_quick_flg;//快速开户标志 0-快速开户;1-正常开户;
	private String aprvl_filg_flg;//核准备案标志 0-核准类账户;1-备案类账户; 
	private String cust_acct_num;//客户账号
	private String sub_acct_serl_num;//子账户序号
	private String acctNm;//账户名称
	private String cardNum;//卡号
	private String crdhddocsCatg;//持卡人证件种类
	private String crdhddocsNum;//持卡人证件号码
	private String crdhdcustNm;//持卡人客户名称
	private String crdhdcustNum;//持卡人客户号
	private String crdhd_cntct_tel;//持卡人联系电话
	private String ccycodeNum;//货币代号
	private String prodCode;//产品编号
	private String acctClasf;//账户分类
	private String acctAttr;//账户属性
	private String inoutFlag;//境内外标识 1-境内;0-境外
	private String induStry;//行业分类
	private String basicaccSeq;//基本账户编号
	private String basicacctNo;//基本户账号
	private String orgcreditNo;//机构信用代码证号
	private String enterScale;//企业规模（企业规模代码）10-大型企业;20-中型企业;30-小型企业;40-微型企业;90-其他(非企业)
	private String localtaxNo;//地税登记号
	private String nationtaxNo;//国税登记号
	private String regAddrdetail;//注册地址-详细地址
	private String unitTle;//单位电话
	private String unitAddrdetail;//单位地址-详细地址
	private String contact;//联系人
	private String email;//电子邮件
	private String legalName;//法定代表人客户名称
	private String mobileNum;//法定代表人手机号码
	private String agentName;//代理人姓名
	private String agentTel;//代理人联系方式

	
	public static class TRADEINFO_CORP_CUST_MAIN{
			
	}
	
	public static Map<String,Object> getMap(ToPublicClient toPublicClient){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tradedate",toPublicClient.getTradeDate());
		map.put("serialno",toPublicClient.getSerialNo());
		map.put("tradetime",toPublicClient.getTradeTime());
		map.put("subtransflag",toPublicClient.getSubTransFlag());
		map.put("bussceno",toPublicClient.getBussceNo());
		map.put("servecode_out",toPublicClient.getServeCode_out());
		map.put("scenecode_out",toPublicClient.getSceneCode_out());
		map.put("servecode",toPublicClient.getServeCode());
		map.put("scenecode",toPublicClient.getSceneCode());
		map.put("reqsysid",toPublicClient.getReqSysId());
		map.put("reqcalcod",toPublicClient.getReqCalCod());
		map.put("reqdate",toPublicClient.getReqDate());
		map.put("reqtime",toPublicClient.getReqTime());
		map.put("reqserialno",toPublicClient.getReqSerialNo());
		map.put("scrsysid",toPublicClient.getScrSysId());
		map.put("scrcalcod",toPublicClient.getScrCalCod());
		map.put("golseqno",toPublicClient.getGolSeqNo());
		map.put("tellerno",toPublicClient.getTellerNo());
		map.put("tellertp",toPublicClient.getTellerTp());
		map.put("mybank",toPublicClient.getMyBank());
		map.put("zoneno",toPublicClient.getZoneNo());
		map.put("mbrno",toPublicClient.getMbrNo());
		map.put("brno",toPublicClient.getBrNo());
		map.put("devno",toPublicClient.getDevNo());
		map.put("authtellerno",toPublicClient.getAuthTellerNo());
		map.put("respsts",toPublicClient.getRespSts());
		map.put("errorcode",toPublicClient.getErrorCode());
		map.put("errormsg",toPublicClient.getErrorMsg());
		map.put("backservecode",toPublicClient.getBackServeCode());
		map.put("backscenecode",toPublicClient.getBackSceneCode());
		map.put("backsysdate",toPublicClient.getBackSysDate());
		map.put("backsysno",toPublicClient.getBackSysNo());
		map.put("backsyssts",toPublicClient.getBackSysSts());
		map.put("backsyserrorcode",toPublicClient.getBackSysErrorCode());
		map.put("backsyserrormsg",toPublicClient.getBackSysErrorMsg());
		map.put("upddate",toPublicClient.getUpdDate());
		map.put("updtime",toPublicClient.getUpdTime());
		map.put("cust_tp",toPublicClient.getCust_tp());
		map.put("custnum",toPublicClient.getCustNum());
		map.put("custnm",toPublicClient.getCustNm());
		map.put("identtype",toPublicClient.getIdentType());
		map.put("identno",toPublicClient.getIdentNo());
		map.put("certarea",toPublicClient.getCertArea());
		map.put("open_acct_quick_flg",toPublicClient.getOpen_acct_quick_flg());
		map.put("aprvl_filg_flg",toPublicClient.getAprvl_filg_flg());
		map.put("cust_acct_num",toPublicClient.getCust_acct_num());
		map.put("sub_acct_serl_num",toPublicClient.getSub_acct_serl_num());
		map.put("acctnm",toPublicClient.getAcctNm());
		map.put("cardnum",toPublicClient.getCardNum());
		map.put("crdhddocscatg",toPublicClient.getCrdhddocsCatg());
		map.put("crdhddocsnum",toPublicClient.getCrdhddocsNum());
		map.put("crdhdcustnm",toPublicClient.getCrdhdcustNm());
		map.put("crdhdcustnum",toPublicClient.getCrdhdcustNum());
		map.put("crdhd_cntct_tel",toPublicClient.getCrdhd_cntct_tel());
		map.put("ccycodenum",toPublicClient.getCcycodeNum());
		map.put("prodcode",toPublicClient.getProdCode());
		map.put("acctclasf",toPublicClient.getAcctClasf());
		map.put("acctattr",toPublicClient.getAcctAttr());
		map.put("inoutflag",toPublicClient.getInoutFlag());
		map.put("industry",toPublicClient.getInduStry());
		map.put("basicaccseq",toPublicClient.getBasicaccSeq());
		map.put("basicacctno",toPublicClient.getBasicacctNo());
		map.put("orgcreditno",toPublicClient.getOrgcreditNo());
		map.put("enterscale",toPublicClient.getEnterScale());
		map.put("localtaxno",toPublicClient.getLocaltaxNo());
		map.put("nationtaxno",toPublicClient.getNationtaxNo());
		map.put("regaddrdetail",toPublicClient.getRegAddrdetail());
		map.put("unittle",toPublicClient.getUnitTle());
		map.put("unitaddrdetail",toPublicClient.getUnitAddrdetail());
		map.put("contact",toPublicClient.getContact());
		map.put("email",toPublicClient.getEmail());
		map.put("legalname",toPublicClient.getLegalName());
		map.put("mobilenum",toPublicClient.getMobileNum());
		map.put("agentname",toPublicClient.getAgentName());
		map.put("agenttel",toPublicClient.getAgentTel());

		return map;
	}
}
