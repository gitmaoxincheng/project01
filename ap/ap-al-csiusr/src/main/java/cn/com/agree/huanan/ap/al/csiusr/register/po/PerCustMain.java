package cn.com.agree.huanan.ap.al.csiusr.register.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import cn.com.agree.huanan.ap.al.csiusr.register.po.PerCustMain.TRADEINFO_PER_CUST_MAIN;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 个人客户信息登记簿Bean
 * @author HWW
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_PER_CUST_MAIN.class)
public class PerCustMain implements Serializable {
	private static final long serialVersionUID = 9081414180398772574L;
	
	private String custAcctNum;//客户账号
	private String outSubAcctSerl;//转出子账户序号
	private String ccyCodeNum;//货币代号
	private String txnamt;//交易金额
	private String bankNo;//发卡银行编号
	private String bankName;//发卡银行名称
	private String mdisuAcctNo;//医保账号
	private String bankSeq;//银行流水号
	private String socisuSeq;//社保流水号
	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String tradeTime;//平台交易时间
	private String subTransFlag;//子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo;//业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
	private String serveCodeOut;//外部服务码
	private String sceneCodeOut;//外部场景码
	private String serveCode;//服务码
	private String sceneCode;//场景码
	private String reqSysId;//请求方系统标识
	private String reqCalCod;//请求方渠道编码
	private String reqDate;//请求方日期
	private String reqTime;//请求方时间
	private String reqSerialNo;//请求方流水号
	private String scrSysId;//源请求方系统标识
	private String scrCalCod;//源请求方渠道编码
	private String golseqNo;//全局流水号
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
	private String custNum;//客户号
	private String custName;//客户姓名
	private String identType;//证件类型
	private String identNo;//证件号码
	private String certArea;//发证国家或地区
	private String identorgaddid;//
	private String sex;//M-男性;F-女性;N-非个人;U-未知的性别"
	private String nationality;//
	private String marriage;//
	private String highEstedu;//最高学历
	private String schoolName;//学校名称
	private String liveAddrDetail;//居住地址-详细地址
	private String domAddrDetail;//户籍地址-详细地址
	private String internetInspectFlag;//联网核查标识
	private String noInspectCause;//无法核实原因0-不适用;1-无法联系存款人;2-已联系存款人但需要再次核实;3-已联系存款人但需要重新提供身份证件或辅助证件;4-已联系存款人但存款人拒绝重新提供身份证件或辅助证件"
	private String careerType;//职业类别
/*	10000-党的机关、国家机关、群众团体和社会组织、企事业单位负责人;
	20000-专业技术人员;
	20200-工程技术人员;
	20500-卫生专业技术人员;
	20600-经济和金融专业人员;
	20700-法律、社会和宗教专业人员;
	20800-教学人员;
	29900-其他专业技术人员;
	30000-办事人员和有关人员;
	30100-办事人员;
	40000-社会生产服务和生活服务人员;
	40100-批发与零售服务人员;
	40200-交通运输、仓储和邮政业服务人员;
	40300-住宿和餐饮服务人员;
	40400-信息运输、软件和信息技术服务人员;
	40600-房地产服务人员;
	41100-电力、燃气及水供应服务人员;
	41300-文化、体育及娱乐服务人员;
	49900-其他社会生产和生活服务人员;
	50000-农、林、牧、渔业生产及辅助人员;
	60000-生产制造及有关人员;
	70000-军人;
	80000-不便分类的其他从业人员;
	90000-学生;*/
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
/*	001-单位活期结算;
	002-财政预算存款;
	003-财政预算外存款;
	004-财政预算专项存款;
	005-地方财政库款;
	006-代理财政预算外资金活期存款;
	007-验资户;
	008-非验资户;
	009-外管监管账户;
	010-基本建设资金;
	011-更新改造资金;
	012-粮、棉、油收购资金;
	013-证券交易结算资金;
	014-期货交易保证金;
	015-信托基金;
	016-政策性房地产开发资金;
	017-单位银行卡备用金;
	018-住房基金;
	019-社会保障基金;
	020-公积金;
	021-收入汇缴资金和业务支出资金;
	022-党、团、工会设在单位的组织机构经费;
	023-其他需要专项管理和使用的资金;
	024-境外机构境内外汇帐户;
	200-境外机构境内人民币账户-基本户;
	201-境外机构境内人民币账户-一般户;
	202-境外机构境内人民币账户-专户;
	203-境外机构境内人民币账户-临时户;
	026-一般单位定期存款;
	027-股东定期存款;
	028-机关团体事业单位定期存款;
	029-部队定期存款;
	030-代理财政预算外资金定期存款;
	031-承兑保证金(活期);
	032-活期非融资性保函保证金;
	033-活期融资性保函保证金;
	034-担保保证金(活期);
	035-综合授信业务保证金(活期存款);
	036-其他活期保证金;
	037-承兑保证金(定期);
	038-定期非融资性保函保证金;
	039-定期融资性保函保证金;
	040-担保保证金(定期);
	041-综合授信业务保证金(定期存款);
	042-其他定期保证金;
	043-商业银行存放活期款项;
	044-其他银行业存款类金融机构存放活期款项;
	045-银行业非存款类金融机构存放活期款项;
	046-保险业金融机构存放活期款项;
	047-证券业金融机构存放活期款项;
	048-交易及结算类金融机构存放活期款项;
	049-金融控股公司存放活期款项;
	050-特殊目的载体(SPV)存放活期款项;
	051-其他金融机构存放活期款项;
	052-商业银行存放定期款项;
	053-其他银行业存款类金融机构存放定期款项;
	054-银行业非存款类金融机构存放定期款项;
	055-保险业金融机构存放定期款项;
	056-证券业金融机构存放定期款项;
	057-交易及结算类金融机构存放定期款项;
	058-金融控股公司存放定期款项;
	059-特殊目的载体(SPV)存放定期款项;060-其他金融机构存放定期款项;
	100-境内商业银行存放活期款项;
	101-境内其他银行业存款类金融机构存放活期款项;
	102-境外存款类金融机构存放;
	103-境内银行业非存款类金融机构存放活期款项;
	104-境内保险业金融机构存放活期款项;
	105-境内证券业金融机构存放活期款项;
	106-境内交易及结算类金融机构存放活期款项;
	107-境内金融控股公司存放活期款项;
	108-境内特殊目的载体(SPV)存放活期款项;
	109-境内其他金融机构存放活期款项;
	110-境外其他金融机构存放;
	121-临时存款过渡户;
	122-一般外汇账户;
	123-外币临时存款过渡户;
	301-I类账户;
	302-II类账户;
	303-III类账户;
	304-社保卡账户;
	XXX-默认值;*/
	private String openAcctTpWhlsl;//大额存单开户类型
	private String acctTp;//账户类型1-一般户;2-专户;3-基准账户;


    public static class TRADEINFO_PER_CUST_MAIN {
        
    }
    
    public static Map<String, Object> getMap(PerCustMain perCustMain) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("custAcctNum", perCustMain.getCustAcctNum());
    	map.put("outSubAcctSerl", perCustMain.getOutSubAcctSerl());
    	map.put("ccyCodeNum", perCustMain.getCcyCodeNum());
    	map.put("txnamt", perCustMain.getTxnamt());
    	map.put("bankNo", perCustMain.getBankNo());
    	map.put("bankName", perCustMain.getBankName());
    	map.put("mdisuAcctNo", perCustMain.getMdisuAcctNo());
    	map.put("bankSeq", perCustMain.getBankSeq());
    	map.put("socisuSeq", perCustMain.getSocisuSeq());
    	map.put("tradeDate", perCustMain.getTradeDate());
    	map.put("serialNo", perCustMain.getSerialNo());
    	map.put("tradeTime", perCustMain.getTradeTime());
    	map.put("subTransFlag", perCustMain.getSubTransFlag());
    	map.put("bussceNo", perCustMain.getBussceNo());
    	map.put("serveCodeOut", perCustMain.getServeCodeOut());
    	map.put("sceneCodeOut", perCustMain.getSceneCodeOut());
    	map.put("serveCode", perCustMain.getServeCode());
    	map.put("sceneCode", perCustMain.getSceneCode());
    	map.put("reqSysId", perCustMain.getReqSysId());
    	map.put("reqCalCod", perCustMain.getReqCalCod());
    	map.put("reqDate", perCustMain.getReqDate());
    	map.put("reqTime", perCustMain.getReqTime());
    	map.put("reqSerialNo", perCustMain.getReqSerialNo());
    	map.put("scrSysId", perCustMain.getScrSysId());
    	map.put("scrCalCod", perCustMain.getScrCalCod());
    	map.put("golseqNo", perCustMain.getGolseqNo());
    	map.put("tellerNo", perCustMain.getTellerNo());
    	map.put("tellerTp", perCustMain.getTellerTp());
    	map.put("myBank", perCustMain.getMyBank());
    	map.put("zoneNo", perCustMain.getZoneNo());
    	map.put("mbrNo", perCustMain.getMbrNo());
    	map.put("brNo", perCustMain.getBrNo());
    	map.put("devNo", perCustMain.getDevNo());
    	map.put("authTellerNo", perCustMain.getAuthTellerNo());
    	map.put("respSts", perCustMain.getRespSts());
    	map.put("errorCode", perCustMain.getErrorCode());
    	map.put("errorMsg", perCustMain.getErrorMsg());
    	map.put("backServeCode", perCustMain.getBackServeCode());
    	map.put("backSceneCode", perCustMain.getBackSceneCode());
    	map.put("backSysDate", perCustMain.getBackSysDate());
    	map.put("backSysNo", perCustMain.getBackSysNo());
    	map.put("backSysSts", perCustMain.getBackSysSts());
    	map.put("backSysErrorCode", perCustMain.getBackSysErrorCode());
    	map.put("backSysErrorMsg", perCustMain.getBackSysErrorMsg());
    	map.put("updDate", perCustMain.getUpdDate());
    	map.put("updTime", perCustMain.getUpdTime());
    	map.put("custNum", perCustMain.getCustNum());
    	map.put("custName", perCustMain.getCustName());
    	map.put("identType", perCustMain.getIdentType());
    	map.put("identNo", perCustMain.getIdentNo());
    	map.put("certArea", perCustMain.getCertArea());
    	map.put("identorgaddid", perCustMain.getIdentorgaddid());
    	map.put("sex", perCustMain.getSex());
    	map.put("nationality", perCustMain.getNationality());
    	map.put("marriage", perCustMain.getMarriage());
    	map.put("highEstedu", perCustMain.getHighEstedu());
    	map.put("schoolName", perCustMain.getSchoolName());
    	map.put("liveAddrDetail", perCustMain.getLiveAddrDetail());
    	map.put("domAddrDetail", perCustMain.getDomAddrDetail());
    	map.put("internetInspectFlag", perCustMain.getInternetInspectFlag());
    	map.put("noInspectCause", perCustMain.getNoInspectCause());
    	map.put("careerType", perCustMain.getCareerType());
    	map.put("careerExplain", perCustMain.getCareerExplain());
    	map.put("unitName", perCustMain.getUnitName());
    	map.put("unitAddrDetail", perCustMain.getUnitAddrDetail());
    	map.put("unitTel", perCustMain.getUnitTel());
    	map.put("mobile", perCustMain.getMobile());
    	map.put("bornDate", perCustMain.getBornDate());
    	map.put("agentName", perCustMain.getAgentName());
    	map.put("agentTel", perCustMain.getAgentTel());
    	map.put("card_issn_org", perCustMain.getCard_issn_org());
    	map.put("prod_code", perCustMain.getProd_code());
    	map.put("acctAttrCode", perCustMain.getAcctAttrCode());
    	map.put("openAcctTpWhlsl", perCustMain.getOpenAcctTpWhlsl());
    	map.put("acctTp", perCustMain.getAcctTp());
    	return map;
    }
}
