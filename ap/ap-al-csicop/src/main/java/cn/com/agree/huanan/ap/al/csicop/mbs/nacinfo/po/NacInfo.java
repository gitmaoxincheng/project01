package cn.com.agree.huanan.ap.al.csicop.mbs.nacinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 网申信用卡信息表
 * 
 * @author GYL
 */

@Data
@Table(NacInfo.CSIS_NAC_INFORMATION_INFO.class)
public class NacInfo implements Serializable {
	private static final long serialVersionUID = 5755491042131540754L;

	private String serialno; // 交易流水
	private String tradedate; // 交易日期
	private String tradetime; // 交易时间
	private String applno; // 申请编号
	private String appl_channel; // 申请渠道
	private String productcode; // 卡产品代码
	private String productname; // 卡产品名称
	private String suppind; // 主附卡标识(B-主卡)
	private String reqfeettp; // 年费代码
	private String reqbrno; // 申请网点
	private String cardfaceid; // 卡版面(Ａ-标准卡面)
	private String identftp; // 证件类型(A-居民18位身份证;B-护照;D-通行证;T-台胞证)
	private String identfno; // 证件号码
	private String validt; // 证件有效期(YYYYMMDD)
	private String fullname; // 主卡申请人中文名
	private String enname; // 主卡申请人英文姓名
	private String sex; // 性别(M-男;F-女)
	private String birthday; // 出生日期(YYYYMMDD)
	private String phone; // 手机号码
	private String card_no; // 卡号
	private String country; // 国籍(1-境内本市户籍;2-外市户籍;3-港澳人士;4-台籍人士;5-外国人士)
	private String cutycd; // 国籍代码
	private String cutyna; // 国家名称
	private String orgnna; // 发证机关
	private String marriage; // 婚姻状况(S-单身;M-已婚)
	private String education; // 教育程度(1-硕士;2-本科;3-大专;4-高中、中专或以下;5-博士)
	private String hometyp; // 住宅类型
	private String hometype_other; // 住宅类型其它
	private String homeaddr_state; // 住宅地址（省）
	private String homeaddr_city; // 住宅地址（市）
	private String homeaddr_district; // 住宅地址（区）
	private String homeaddr_addr; // 住宅地址（详细地址）
	private String home_tele_area; // 住宅电话区号
	private String home_tele_no; // 住宅电话
	private String homeli; // 住宅年数
	private String homeaddr_postcd; // 住宅邮编
	private String regaddr_state; // 户籍地址（省）
	private String regaddr_city; // 户籍地址（市）
	private String regaddr_district; // 户籍地址（区）
	private String regaddr_addr; // 户籍地址（详细地址）
	private String nativeplace_ind; // 本地户口标识
	private String email; // 电子邮件
	private String wechat; // 微信号
	private String qq; // QQ号
	private String carbrand; // 车牌品牌
	private String carno; // 车牌号
	private String unitna; // 单位名称
	private String wkdep; // 任职部门
	private String wkpos; // 职位/岗位
	private String wktime; // 本单位工作年限
	private String yincome; // 年薪（万）
	private String profession; // 公司行业类别码(A021-金融/保险（一般职员）;A022-金融/保险（销售）;A023-政府机关;A024-旅游/饭店/宾馆娱乐;A025-能源及通信服务;A026-公共事业;A027-邮政/交通运输/物流业;A028-批发/零售/百货;A029-轻工业;A030-房地产/基础建设/物管;A031-国内贸易;A032-制造业;A033-律师/会计师/咨询/培训;A034-进出口贸易;A035-IT;A036-媒体/出版/广告/文艺;A037-医疗;A038-其他)
	private String unitchar; // 单位性质(01-机关/事业;02-国有;03-合资/合作;04-股份;06-私营/集体;08-外商独资;09-个体)
	private String unitaddr_state; // 单位地址（省）
	private String unitaddr_city; // 单位地址（市）
	private String unitaddr_district; // 单位地址（区）
	private String unitaddr_address; // 单位地址（详细地址）
	private String unitaddr_postcd; // 单位邮编
	private String unitcallno; // 单位固话
	private String unitcallnoext; // 单位固话分机号
	private String unitaddr_area; // 单位固话区号
	private String wkduty; // 申请人职称(01-厅局级以上;02-处级;03-科级;04-一般员工;05-临时工;11-负责人;12-高级管理;13-中级管理;14-初级管理;15-一般职员;16-专业技术人员;17-临时工)
	private String wkduty_name; // 职称描述
	private String ishaspc; // 是否有专业证书(1-有;2-无)
	private String unitpno; // 单位员工人数(1：10人以下;2：11-50人;3：51-200人,;4：201-1000人;5：1001人以上)
	private String drname; // 直系亲属姓名
	private String drtype; // 与直系亲属关系(1-父母;2-配偶;3-子女;4-兄弟姐妹)
	private String drphone; // 直系亲属手机号码
	private String drcall_area; // 直系亲属固话区号
	private String drcall_no; // 直系亲属固话号码
	private String ecname; // 紧急联系人姓名
	private String ectype; // 与紧急联系人关系(5-亲属;6-同事;7-朋友)
	private String dcphone; // 紧急联系人手机号码
	private String dccall_area; // 紧急联系人固话区号
	private String dccall_no; // 紧急联系人固话号码
	private String receipt_type; // 领卡方式
	private String postmtype; // 卡片邮寄地址(1-经办网点;2-单位地址;3-家庭地址)
	private String webreceiptbrch; // 领卡网点
	private String billmedia; // 账单类型(N-不需要纸质账单;P-纸质账单)
	private String billaddrtype; // 账单地址类型(1-单位地址;2-住宅地址)
	private String isurgent; // 加急办卡(0-无;1-普通加急（每卡收取20元）;2-特别加急（每卡收取100元）)
	private String autp_paym; // 开通自动还款(N-不开通;Y-开通)
	private String cpaymod; // 自动还款类型(F-全额扣款;M-最小扣款)
	private String caccnbr; // 自动还款账号
	private String useyxt; // 银信通服务(N-不开通;Y-开通)
	private String msg_free; // 免收银信通服务费
	private String othbankcradno; // 有几家他行信用卡
	private String totalamount; // 总额度是多少
	private String refidtp; // 推荐人证件类型（A-身份证）
	private String refidno; // 推荐人证件号码
	private String refname; // 推荐人姓名
	private String refcardno; // 推荐人信用卡卡号
	private String refphone; // 推荐人手机号
	private String refid; // 推荐人ID
	private String persno; // 操作员号
	private String persna; // 操作员姓名
	private String businesstype; // 业务类型
	private String issigned; // 申请表是否有客户签名
	private String ishadappldate; // 申请表是否写申请时间
	private String needsign; // 刷卡是否需要签名(0-否;1-是)
	private String brno; // 网点号
	private String custgroupid; // 客群代码
	private String giftid; // 礼品代码
	private String custid; // 客户号
	private String projno; // 项目代码
	private String projna; // 项目名称
	private String reftype; // 身份类型(01-客户;02-行员;03-项目)
	private String resident_permit_no; // 居住证号码
	private String stagductcode; // 分期产品代码
	private String stagductnumber; // 分期产品编号
	private String requestippamount; // 分期额度
	private String stagnumber; // 分期期数
	private String feerate; // 手续费率
	private String fee_charge_type; // 手续费收取方式(0-一次性支付;1-分期支付)
	private String payeebankid; // 收款行ID
	private String payeebankname; // 收款行名称
	private String payeeacctno; // 收款账号
	private String payeeacctname; // 收款账户名
	private String payto_method; // 资金支付方式(1-自主支付 2-委托东莞银行支付)
	private String instjectcode; // 分期项目代码(若为空送 *)
	private String ipppurpose; // 分期用途(1-购车位;2-购车;3-购买大额耐用品;4-住房装修;5-旅游;6-综合性消费;7-其他)
	private String ipppurpose_other; // 分期用途其他
	private String acceptbrchids; // 受理网点
	private String branchnames; // 网点简称
	private String purposea; // 一级用途
	private String purposeaname; // 一级用途名称
	private String purposeb; // 二级用途(若为空送*)
	private String purposebname; // 二级用途名称
	private String ippconfigcode; // 分期配置代码
	private String stagmatchingname; // 分期配置名称
	private String refbrno; // 推荐人机构号
	private String installment; // 每期供款金额
	private String repaymentdate; // 每月还款日期
	private String padsend; // pad发送信审标志(0-未发送;1-已发送)
	private String entrust_acct; // 委托支付方账号
	private String entrust_acctname; // 委托支付方收款账户名
	private String entrust_bankid; // 委托支付方开户行行号
	private String remark; // 备注
	private String upddate; // 更新日期
	private String updtime; // 更新时间

	public static class CSIS_NAC_INFORMATION_INFO {
	}

	public static Map<String, Object> getMap(NacInfo nacInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", nacInfo.getSerialno());
		map.put("tradedate", nacInfo.getTradedate());
		map.put("tradetime", nacInfo.getTradetime());
		map.put("applno", nacInfo.getApplno());
		map.put("appl_channel", nacInfo.getAppl_channel());
		map.put("productcode", nacInfo.getProductcode());
		map.put("productname", nacInfo.getProductname());
		map.put("suppind", nacInfo.getSuppind());
		map.put("reqfeettp", nacInfo.getReqfeettp());
		map.put("reqbrno", nacInfo.getReqbrno());
		map.put("cardfaceid", nacInfo.getCardfaceid());
		map.put("identftp", nacInfo.getIdentftp());
		map.put("identfno", nacInfo.getIdentfno());
		map.put("validt", nacInfo.getValidt());
		map.put("fullname", nacInfo.getFullname());
		map.put("enname", nacInfo.getEnname());
		map.put("sex", nacInfo.getSex());
		map.put("birthday", nacInfo.getBirthday());
		map.put("phone", nacInfo.getPhone());
		map.put("card_no", nacInfo.getCard_no());
		map.put("country", nacInfo.getCountry());
		map.put("cutycd", nacInfo.getCutycd());
		map.put("cutyna", nacInfo.getCutyna());
		map.put("orgnna", nacInfo.getOrgnna());
		map.put("marriage", nacInfo.getMarriage());
		map.put("education", nacInfo.getEducation());
		map.put("hometyp", nacInfo.getHometyp());
		map.put("hometype_other", nacInfo.getHometype_other());
		map.put("homeaddr_state", nacInfo.getHomeaddr_state());
		map.put("homeaddr_city", nacInfo.getHomeaddr_city());
		map.put("homeaddr_district", nacInfo.getHomeaddr_district());
		map.put("homeaddr_addr", nacInfo.getHomeaddr_addr());
		map.put("home_tele_area", nacInfo.getHome_tele_area());
		map.put("home_tele_no", nacInfo.getHome_tele_no());
		map.put("homeli", nacInfo.getHomeli());
		map.put("homeaddr_postcd", nacInfo.getHomeaddr_postcd());
		map.put("regaddr_state", nacInfo.getRegaddr_state());
		map.put("regaddr_city", nacInfo.getRegaddr_city());
		map.put("regaddr_district", nacInfo.getRegaddr_district());
		map.put("regaddr_addr", nacInfo.getRegaddr_addr());
		map.put("nativeplace_ind", nacInfo.getNativeplace_ind());
		map.put("email", nacInfo.getEmail());
		map.put("wechat", nacInfo.getWechat());
		map.put("qq", nacInfo.getQq());
		map.put("carbrand", nacInfo.getCarbrand());
		map.put("carno", nacInfo.getCarno());
		map.put("unitna", nacInfo.getUnitna());
		map.put("wkdep", nacInfo.getWkdep());
		map.put("wkpos", nacInfo.getWkpos());
		map.put("wktime", nacInfo.getWktime());
		map.put("yincome", nacInfo.getYincome());
		map.put("profession", nacInfo.getProfession());
		map.put("unitchar", nacInfo.getUnitchar());
		map.put("unitaddr_state", nacInfo.getUnitaddr_state());
		map.put("unitaddr_city", nacInfo.getUnitaddr_city());
		map.put("unitaddr_district", nacInfo.getUnitaddr_district());
		map.put("unitaddr_address", nacInfo.getUnitaddr_address());
		map.put("unitaddr_postcd", nacInfo.getUnitaddr_postcd());
		map.put("unitcallno", nacInfo.getUnitcallno());
		map.put("unitcallnoext", nacInfo.getUnitcallnoext());
		map.put("unitaddr_area", nacInfo.getUnitaddr_area());
		map.put("wkduty", nacInfo.getWkduty());
		map.put("wkduty_name", nacInfo.getWkduty_name());
		map.put("ishaspc", nacInfo.getIshaspc());
		map.put("unitpno", nacInfo.getUnitpno());
		map.put("drname", nacInfo.getDrname());
		map.put("drtype", nacInfo.getDrtype());
		map.put("drphone", nacInfo.getDrphone());
		map.put("drcall_area", nacInfo.getDrcall_area());
		map.put("drcall_no", nacInfo.getDrcall_no());
		map.put("ecname", nacInfo.getEcname());
		map.put("ectype", nacInfo.getEctype());
		map.put("dcphone", nacInfo.getDcphone());
		map.put("dccall_area", nacInfo.getDccall_area());
		map.put("dccall_no", nacInfo.getDccall_no());
		map.put("receipt_type", nacInfo.getReceipt_type());
		map.put("postmtype", nacInfo.getPostmtype());
		map.put("webreceiptbrch", nacInfo.getWebreceiptbrch());
		map.put("billmedia", nacInfo.getBillmedia());
		map.put("billaddrtype", nacInfo.getBilladdrtype());
		map.put("isurgent", nacInfo.getIsurgent());
		map.put("autp_paym", nacInfo.getAutp_paym());
		map.put("cpaymod", nacInfo.getCpaymod());
		map.put("caccnbr", nacInfo.getCaccnbr());
		map.put("useyxt", nacInfo.getUseyxt());
		map.put("msg_free", nacInfo.getMsg_free());
		map.put("othbankcradno", nacInfo.getOthbankcradno());
		map.put("totalamount", nacInfo.getTotalamount());
		map.put("refidtp", nacInfo.getRefidtp());
		map.put("refidno", nacInfo.getRefidno());
		map.put("refname", nacInfo.getRefname());
		map.put("refcardno", nacInfo.getRefcardno());
		map.put("refphone", nacInfo.getRefphone());
		map.put("refid", nacInfo.getRefid());
		map.put("persno", nacInfo.getPersno());
		map.put("persna", nacInfo.getPersna());
		map.put("businesstype", nacInfo.getBusinesstype());
		map.put("issigned", nacInfo.getIssigned());
		map.put("ishadappldate", nacInfo.getIshadappldate());
		map.put("needsign", nacInfo.getNeedsign());
		map.put("brno", nacInfo.getBrno());
		map.put("custgroupid", nacInfo.getCustgroupid());
		map.put("giftid", nacInfo.getGiftid());
		map.put("custid", nacInfo.getCustid());
		map.put("projno", nacInfo.getProjno());
		map.put("projna", nacInfo.getProjna());
		map.put("reftype", nacInfo.getReftype());
		map.put("resident_permit_no", nacInfo.getResident_permit_no());
		map.put("stagductcode", nacInfo.getStagductcode());
		map.put("stagductnumber", nacInfo.getStagductnumber());
		map.put("requestippamount", nacInfo.getRequestippamount());
		map.put("stagnumber", nacInfo.getStagnumber());
		map.put("feerate", nacInfo.getFeerate());
		map.put("fee_charge_type", nacInfo.getFee_charge_type());
		map.put("payeebankid", nacInfo.getPayeebankid());
		map.put("payeebankname", nacInfo.getPayeebankname());
		map.put("payeeacctno", nacInfo.getPayeeacctno());
		map.put("payeeacctname", nacInfo.getPayeeacctname());
		map.put("payto_method", nacInfo.getPayto_method());
		map.put("instjectcode", nacInfo.getInstjectcode());
		map.put("ipppurpose", nacInfo.getIpppurpose());
		map.put("ipppurpose_other", nacInfo.getIpppurpose_other());
		map.put("acceptbrchids", nacInfo.getAcceptbrchids());
		map.put("branchnames", nacInfo.getBranchnames());
		map.put("purposea", nacInfo.getPurposea());
		map.put("purposeaname", nacInfo.getPurposeaname());
		map.put("purposeb", nacInfo.getPurposeb());
		map.put("purposebname", nacInfo.getPurposebname());
		map.put("ippconfigcode", nacInfo.getIppconfigcode());
		map.put("stagmatchingname", nacInfo.getStagmatchingname());
		map.put("refbrno", nacInfo.getRefbrno());
		map.put("installment", nacInfo.getInstallment());
		map.put("repaymentdate", nacInfo.getRepaymentdate());
		map.put("padsend", nacInfo.getPadsend());
		map.put("entrust_acct", nacInfo.getEntrust_acct());
		map.put("entrust_acctname", nacInfo.getEntrust_acctname());
		map.put("entrust_bankid", nacInfo.getEntrust_bankid());
		map.put("remark", nacInfo.getRemark());
		map.put("upddate", nacInfo.getUpddate());
		map.put("updtime", nacInfo.getUpdtime());
		return map;
	}
}
