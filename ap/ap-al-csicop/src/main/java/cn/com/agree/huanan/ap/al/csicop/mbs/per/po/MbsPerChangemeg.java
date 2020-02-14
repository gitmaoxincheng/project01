package cn.com.agree.huanan.ap.al.csicop.mbs.per.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 客户信息变更申请表Bean
 * 
 * @author XZ
 */
@Data
@Table(MbsPerChangemeg.CSIS_MBS_PER_CHANGEMEG.class)
public class MbsPerChangemeg implements Serializable {
	private static final long serialVersionUID = -2199087068516034247L;

	private String idtftp; // 证件类型
	private String idtfno; // 证件号码
	private String tranac; // 账号
	private String nowadd; // 现居住地址
	private String offpho; // 办公电话
	private String othpho; // 家庭电话
	private String postno; // 邮政编码
	private String profee; // 职业
	private String workun; // 工作单位
	private String workad; // 工作单位地址
	private String tradetime; // 交易时间
	private String tradedate; // 交易日期
	private String serialno; // 流水号
	private String status; // 交易状态，01-已激活 02-待激活 03-已取消 04-已过期
	private String requno; // 申请编号
	private String upddate; // 修改日期
	private String updtime; // 修改时间
	private String phone; // 手机号
	private String app_id; // 申请编号
	private String gloseqno; // 全局流水
	private String othpro; // 其他职业描述
	private String idinst; // 发证机关
	private String validt; // 证件有效日期
	private String gender; // 性别;F-女性;M-男性;U-未知性别
	private String revenue; // 税收居民身份 1-中国居民税收身份;
	private String identity; // 户籍地址
	private String custna; // 姓名
	private String contentno; // 证件图片批次号
	private String modelno; // 证件图片模型号
	private String photop; // 拍摄人像面
	private String photog; // 拍摄国徽面
	private String isnewc; // 新开账户 0-是;1-否;
	private String g_pubstatus; // 国徽面推送状态
	private String p_pubstatus; // 人像面推送状态
	private String photoc; // 银行卡正面影像
	private String mybank; // 法人号
	private String busistartdate;// 影像上传时间
	private String upphone;// 客户录入手机号

	public static class CSIS_MBS_PER_CHANGEMEG {
	}

	public static Map<String, Object> getMap(MbsPerChangemeg mbsPerChangemeg) {
		Map<String, Object> map = new HashMap<>();
		map.put("idtftp", mbsPerChangemeg.getIdtftp());
		map.put("idtfno", mbsPerChangemeg.getIdtfno());
		map.put("tranac", mbsPerChangemeg.getTranac());
		map.put("nowadd", mbsPerChangemeg.getNowadd());
		map.put("offpho", mbsPerChangemeg.getOffpho());
		map.put("othpho", mbsPerChangemeg.getOthpho());
		map.put("postno", mbsPerChangemeg.getPostno());
		map.put("profee", mbsPerChangemeg.getProfee());
		map.put("workun", mbsPerChangemeg.getWorkun());
		map.put("workad", mbsPerChangemeg.getWorkad());
		map.put("tradetime", mbsPerChangemeg.getTradetime());
		map.put("tradedate", mbsPerChangemeg.getTradedate());
		map.put("serialno", mbsPerChangemeg.getSerialno());
		map.put("status", mbsPerChangemeg.getStatus());
		map.put("requno", mbsPerChangemeg.getRequno());
		map.put("upddate", mbsPerChangemeg.getUpddate());
		map.put("updtime", mbsPerChangemeg.getUpdtime());
		map.put("phone", mbsPerChangemeg.getPhone());
		map.put("app_id", mbsPerChangemeg.getApp_id());
		map.put("gloseqno", mbsPerChangemeg.getGloseqno());
		map.put("othpro", mbsPerChangemeg.getOthpro());
		map.put("idinst", mbsPerChangemeg.getIdinst());
		map.put("validt", mbsPerChangemeg.getValidt());
		map.put("gender", mbsPerChangemeg.getGender());
		map.put("revenue", mbsPerChangemeg.getRevenue());
		map.put("identity", mbsPerChangemeg.getIdentity());
		map.put("custna", mbsPerChangemeg.getCustna());
		map.put("contentno", mbsPerChangemeg.getContentno());
		map.put("modelno", mbsPerChangemeg.getModelno());
		map.put("photop", mbsPerChangemeg.getPhotop());
		map.put("photog", mbsPerChangemeg.getPhotog());
		map.put("isnewc", mbsPerChangemeg.getIsnewc());
		map.put("g_pubstatus", mbsPerChangemeg.getG_pubstatus());
		map.put("p_pubstatus", mbsPerChangemeg.getP_pubstatus());
		map.put("photoc", mbsPerChangemeg.getPhotoc());
		map.put("mybank", mbsPerChangemeg.getMybank());
		map.put("busistartdate", mbsPerChangemeg.getBusistartdate());
		map.put("upphone", mbsPerChangemeg.getUpphone());
		return map;
	}
}
