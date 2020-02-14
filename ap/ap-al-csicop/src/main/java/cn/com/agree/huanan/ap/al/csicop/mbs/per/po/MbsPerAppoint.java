package cn.com.agree.huanan.ap.al.csicop.mbs.per.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 统一签约申请表Bean
 * 
 * @author XZ
 */
@Data
@Table(MbsPerAppoint.CSIS_MBS_PER_APPOINT.class)
public class MbsPerAppoint implements Serializable {
	private static final long serialVersionUID = 5415614017639159851L;

	private String serialno; // 交易流水号
	private String tradedate; // 交易日期
	private String tradetime; // 交易时间
	private String phone; // 手机号
	private String isinb; // 个人网银 0-签约;1-解约;2-未选择;
	private String wpphone; // 手机银行 0-签约;1-解约;2-未选择;
	private String keyapply; // KEY申领 0-申领;1-未选择;
	private String owned_key; // 是否自备KEY 1-否;0-是
	private String keytype; // KEY类型 0-二代KEY;1-蓝牙KEY
	private String keychannel; // KEY渠道 C01-网上银行;C02-手机银行
	private String yxtsigned; // 银信通签约 0-签约;1-解约;2-未选择;3-维护;
	private String yxtphone1; // 银信通手机号1
	private String yxtphone2; // 银信通手机号2
	private String yxtphone3; // 银信通手机号3
	private String yxtphone4; // 银信通手机号4
	private String yxtphone5; // 银信通手机号5
	private String rry; // 日日盈月月盈签约 0-签约;1-解约;2-未选择;3-维护;
	private String busitype; // 业务类型 0-日日盈;1-月月盈
	private String depositterm; // 存期
	private String rese_amount; // 保留金额
	private String settransfer; // 是否设定转账金额 1-不开通;0-开通
	private String tran_amount; // 转账金额
	private String transfer_date; // 转账日期
	private String debit_self; // 借记卡自助服务 0-签约;2-未选择;3-维护;
	private String hn_transfer; // 行内转账 1-不开通;0-开通
	private String hn_tran_quota; // 行内转账日累计限额
	private String kh_transfer; // 跨行转账 1-不开通;0-开通
	private String kh_tran_quota; // 跨行转账日累计限额
	private String territory_quota; // 境内消费日累计限额
	private String overseas_quota; // 境外消费日累计限额
	private String overseas_ench; // 境外取现 1-不开通;0-开通
	private String account; // 追加账号
	private String idtfno; // 证件号
	private String idtftp; // 证件类型
	private String custna; // 姓名
	private String gloseqno; // 全局流水号
	private String tranac; // 账号
	private String numyu1; // 手机号码1是否解约
	private String numyu2; // 手机号码2是否解约
	private String numyu3; // 手机号码3是否解约
	private String numyu4; // 手机号码4是否解约
	private String numyu5; // 手机号码5是否解约
	private String app_id; // 申请编号
	private String status; // 交易状态，01-已激活 02-待激活 03-已取消 04-已过期
	private String contentno; // 证件图片批次号
	private String modelno; // 证件图片模型号
	private String photop; // 拍摄人像面
	private String photog; // 拍摄国徽面
	private String isnewc; // 新开账户 0-是;1-否;
	private String g_pubstatus; // 国徽面推送状态
	private String p_pubstatus; // 人像面推送状态
	private String photor; // 微网点申请单影像
	private String photoc; // 银行卡正面影像
	private String mybank; // 法人号
	private String busistartdate;// 影像上传时间
	private String appointtp;// 统一申请类型
	private String upddate;// 更新日期
	private String updtime;// 更新时间

	public static class CSIS_MBS_PER_APPOINT {
	}

	public static Map<String, Object> getMap(MbsPerAppoint mbsPerAppoint) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", mbsPerAppoint.getSerialno());
		map.put("tradedate", mbsPerAppoint.getTradedate());
		map.put("tradetime", mbsPerAppoint.getTradetime());
		map.put("phone", mbsPerAppoint.getPhone());
		map.put("isinb", mbsPerAppoint.getIsinb());
		map.put("wpphone", mbsPerAppoint.getWpphone());
		map.put("keyapply", mbsPerAppoint.getKeyapply());
		map.put("owned_key", mbsPerAppoint.getOwned_key());
		map.put("keytype", mbsPerAppoint.getKeytype());
		map.put("keychannel", mbsPerAppoint.getKeychannel());
		map.put("yxtsigned", mbsPerAppoint.getYxtsigned());
		map.put("yxtphone1", mbsPerAppoint.getYxtphone1());
		map.put("yxtphone2", mbsPerAppoint.getYxtphone2());
		map.put("yxtphone3", mbsPerAppoint.getYxtphone3());
		map.put("yxtphone4", mbsPerAppoint.getYxtphone4());
		map.put("yxtphone5", mbsPerAppoint.getYxtphone5());
		map.put("rry", mbsPerAppoint.getRry());
		map.put("busitype", mbsPerAppoint.getBusitype());
		map.put("depositterm", mbsPerAppoint.getDepositterm());
		map.put("rese_amount", mbsPerAppoint.getRese_amount());
		map.put("settransfer", mbsPerAppoint.getSettransfer());
		map.put("tran_amount", mbsPerAppoint.getTran_amount());
		map.put("transfer_date", mbsPerAppoint.getTransfer_date());
		map.put("debit_self", mbsPerAppoint.getDebit_self());
		map.put("hn_transfer", mbsPerAppoint.getHn_transfer());
		map.put("hn_tran_quota", mbsPerAppoint.getHn_tran_quota());
		map.put("kh_transfer", mbsPerAppoint.getKh_transfer());
		map.put("kh_tran_quota", mbsPerAppoint.getKh_tran_quota());
		map.put("territory_quota", mbsPerAppoint.getTerritory_quota());
		map.put("overseas_quota", mbsPerAppoint.getOverseas_quota());
		map.put("overseas_ench", mbsPerAppoint.getOverseas_ench());
		map.put("account", mbsPerAppoint.getAccount());
		map.put("idtfno", mbsPerAppoint.getIdtfno());
		map.put("idtftp", mbsPerAppoint.getIdtftp());
		map.put("custna", mbsPerAppoint.getCustna());
		map.put("gloseqno", mbsPerAppoint.getGloseqno());
		map.put("tranac", mbsPerAppoint.getTranac());
		map.put("numyu1", mbsPerAppoint.getNumyu1());
		map.put("numyu2", mbsPerAppoint.getNumyu2());
		map.put("numyu3", mbsPerAppoint.getNumyu3());
		map.put("numyu4", mbsPerAppoint.getNumyu4());
		map.put("numyu5", mbsPerAppoint.getNumyu5());
		map.put("app_id", mbsPerAppoint.getApp_id());
		map.put("status", mbsPerAppoint.getStatus());
		map.put("contentno", mbsPerAppoint.getContentno());
		map.put("modelno", mbsPerAppoint.getModelno());
		map.put("photop", mbsPerAppoint.getPhotop());
		map.put("photog", mbsPerAppoint.getPhotog());
		map.put("isnewc", mbsPerAppoint.getIsnewc());
		map.put("g_pubstatus", mbsPerAppoint.getG_pubstatus());
		map.put("p_pubstatus", mbsPerAppoint.getP_pubstatus());
		map.put("photor", mbsPerAppoint.getPhotor());
		map.put("photoc", mbsPerAppoint.getPhotoc());
		map.put("mybank", mbsPerAppoint.getMybank());
		map.put("busistartdate", mbsPerAppoint.getBusistartdate());
		map.put("appointtp", mbsPerAppoint.getAppointtp());
		map.put("upddate", mbsPerAppoint.getUpddate());
		map.put("updtime", mbsPerAppoint.getUpdtime());
		return map;
	}
}
