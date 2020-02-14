package cn.com.agree.huanan.ap.al.csicop.mbs.per.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 个人开卡申请表Bean
 * 
 * @author XZ
 */
@Data
@Table(MbsPerPersonage.CSIS_MBS_PER_PERSONAGE.class)
@Accessors(chain = true)
public class MbsPerPersonage implements Serializable {
	private static final long serialVersionUID = 1379181638093859424L;

	private String serialno; // 交易流水号
	private String tradedate; // 交易日期
	private String tradetime; // 交易时间
	private String idcdad; // 户籍地址
	private String cutycd; // 国籍
	private String custna; // 姓名
	private String idtftp; // 证件类型
	private String idtfno; // 证件号码
	private String gender; // 性别;F-女性;M-男性;U-未知性别
	private String office_phone; // 办公电话
	private String family_phone; // 家庭电话
	private String pres_address; // 现居住地址
	private String postcode; // 邮政编码
	private String wkduty; // 职业
	private String unitna; // 工作单位
	private String unitaddress; // 工作单位地址
	private String revenue; // 税收居民身份
	private String phone; // 手机号
	private String isinb; // 个人网银 0-开通;1-不开通
	private String wpphone; // 手机银行 0-开通;1-不开通
	private String keyapply; // KEY申领 0-开通;1-不开通
	private String owned_key; // 是否自备KEY 0-是;1-否
	private String keytype; // KEY类型 0-二代KEY;1-蓝牙KEY
	private String keychannel; // KEY渠道 C01-网上银行;C02-手机银行
	private String yxtsigned; // 银信通签约 0-开通;1-不开通
	private String yxtphone1; // 银信通手机号1
	private String yxtphone2; // 银信通手机号2
	private String yxtphone3; // 银信通手机号3
	private String yxtphone4; // 银信通手机号4
	private String yxtphone5; // 银信通手机号5
	private String rry; // 日日盈月月盈签约 0-开通;1-不开通
	private String busitype; // 业务类型 0-日日盈;1-月月盈
	private String depositterm; // 存期 1-一天;2-七天;3-三个月;4-六个月;5-一年;6-二年;7-三年;8-五年
	private String rese_amount; // 保留金额
	private String settransfer; // 是否设定转账金额 0-开通;1-不开通
	private String tran_amount; // 转账金额
	private String transfer_date; // 转账日期
	private String debit_self; // 借记卡自助服务 0-开通;1-不开通
	private String hn_transfer; // 行内转账 0-开通;1-不开通
	private String hn_tran_quota; // 行内转账日累计限额
	private String kh_transfer; // 跨行转账 0-开通;1-不开通
	private String kh_tran_quota; // 跨行转账日累计限额
	private String territory_quota; // 境内消费日累计限额
	private String overseas_quota; // 境外消费日累计限额
	private String overseas_ench; // 境外取现 0-开通;1-不开通
	private String status; // 交易状态，01-已激活 02-待激活 03-已取消 04-已过期
	private String tradecode; // 申请类型：批量开户个人信息采集8819701 个人开卡8819702 统一签约8819703 客户信息变更8819704
	private String issuer; // 发证机构
	private String wkduty_remark; // 职业描述，职业为：其他 时有填写
	private String account; // 追加账号
	private String vastdt; // 证件有效期起始日期
	private String vaeddt; // 证件有效期截止日期
	private String app_id; // 申请编号
	private String gloseqno; // 全局流水
	private String upddate; // 更新日期
	private String updtime; // 更新时间
	private String contentno; // 证件图片批次号
	private String modelno; // 证件图片模型号
	private String photop; // 拍摄人像面
	private String photog; // 拍摄国徽面
	private String isnewc; // 新开账户 0-是;1-否;
	private String g_pubstatus; // 国徽面推送状态
	private String p_pubstatus; // 人像面推送状态
	private String photor; // 微网点申请单影像
	private String custno; // 客户号
	private String mybank; // 法人号
	private String busistartdate;// 影像上传时间

	public static class CSIS_MBS_PER_PERSONAGE {
	}

	public static Map<String, Object> getMap(MbsPerPersonage mbsPerPersonage) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", mbsPerPersonage.getSerialno());
		map.put("tradedate", mbsPerPersonage.getTradedate());
		map.put("tradetime", mbsPerPersonage.getTradetime());
		map.put("idcdad", mbsPerPersonage.getIdcdad());
		map.put("cutycd", mbsPerPersonage.getCutycd());
		map.put("custna", mbsPerPersonage.getCustna());
		map.put("idtftp", mbsPerPersonage.getIdtftp());
		map.put("idtfno", mbsPerPersonage.getIdtfno());
		map.put("gender", mbsPerPersonage.getGender());
		map.put("office_phone", mbsPerPersonage.getOffice_phone());
		map.put("family_phone", mbsPerPersonage.getFamily_phone());
		map.put("pres_address", mbsPerPersonage.getPres_address());
		map.put("postcode", mbsPerPersonage.getPostcode());
		map.put("wkduty", mbsPerPersonage.getWkduty());
		map.put("unitna", mbsPerPersonage.getUnitna());
		map.put("unitaddress", mbsPerPersonage.getUnitaddress());
		map.put("revenue", mbsPerPersonage.getRevenue());
		map.put("phone", mbsPerPersonage.getPhone());
		map.put("isinb", mbsPerPersonage.getIsinb());
		map.put("wpphone", mbsPerPersonage.getWpphone());
		map.put("keyapply", mbsPerPersonage.getKeyapply());
		map.put("owned_key", mbsPerPersonage.getOwned_key());
		map.put("keytype", mbsPerPersonage.getKeytype());
		map.put("keychannel", mbsPerPersonage.getKeychannel());
		map.put("yxtsigned", mbsPerPersonage.getYxtsigned());
		map.put("yxtphone1", mbsPerPersonage.getYxtphone1());
		map.put("yxtphone2", mbsPerPersonage.getYxtphone2());
		map.put("yxtphone3", mbsPerPersonage.getYxtphone3());
		map.put("yxtphone4", mbsPerPersonage.getYxtphone4());
		map.put("yxtphone5", mbsPerPersonage.getYxtphone5());
		map.put("rry", mbsPerPersonage.getRry());
		map.put("busitype", mbsPerPersonage.getBusitype());
		map.put("depositterm", mbsPerPersonage.getDepositterm());
		map.put("rese_amount", mbsPerPersonage.getRese_amount());
		map.put("settransfer", mbsPerPersonage.getSettransfer());
		map.put("tran_amount", mbsPerPersonage.getTran_amount());
		map.put("transfer_date", mbsPerPersonage.getTransfer_date());
		map.put("debit_self", mbsPerPersonage.getDebit_self());
		map.put("hn_transfer", mbsPerPersonage.getHn_transfer());
		map.put("hn_tran_quota", mbsPerPersonage.getHn_tran_quota());
		map.put("kh_transfer", mbsPerPersonage.getKh_transfer());
		map.put("kh_tran_quota", mbsPerPersonage.getKh_tran_quota());
		map.put("territory_quota", mbsPerPersonage.getTerritory_quota());
		map.put("overseas_quota", mbsPerPersonage.getOverseas_quota());
		map.put("overseas_ench", mbsPerPersonage.getOverseas_ench());
		map.put("status", mbsPerPersonage.getStatus());
		map.put("tradecode", mbsPerPersonage.getTradecode());
		map.put("issuer", mbsPerPersonage.getIssuer());
		map.put("wkduty_remark", mbsPerPersonage.getWkduty_remark());
		map.put("account", mbsPerPersonage.getAccount());
		map.put("vastdt", mbsPerPersonage.getVastdt());
		map.put("vaeddt", mbsPerPersonage.getVaeddt());
		map.put("app_id", mbsPerPersonage.getApp_id());
		map.put("gloseqno", mbsPerPersonage.getGloseqno());
		map.put("upddate", mbsPerPersonage.getUpddate());
		map.put("updtime", mbsPerPersonage.getUpdtime());
		map.put("contentno", mbsPerPersonage.getContentno());
		map.put("modelno", mbsPerPersonage.getModelno());
		map.put("photop", mbsPerPersonage.getPhotop());
		map.put("photog", mbsPerPersonage.getPhotog());
		map.put("isnewc", mbsPerPersonage.getIsnewc());
		map.put("g_pubstatus", mbsPerPersonage.getG_pubstatus());
		map.put("p_pubstatus", mbsPerPersonage.getP_pubstatus());
		map.put("photor", mbsPerPersonage.getPhotor());
		map.put("custno", mbsPerPersonage.getCustno());
		map.put("mybank", mbsPerPersonage.getMybank());
		map.put("busistartdate", mbsPerPersonage.getBusistartdate());
		return map;
	}
}
