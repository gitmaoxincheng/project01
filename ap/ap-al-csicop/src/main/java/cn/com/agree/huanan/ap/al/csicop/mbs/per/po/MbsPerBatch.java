package cn.com.agree.huanan.ap.al.csicop.mbs.per.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 批量开户个人信息采集表po类
 * 
 * @author guyulong
 */
@Data
@Table(MbsPerBatch.CSIS_MBS_PER_BATCH.class)
@Accessors(chain = true)
public class MbsPerBatch implements Serializable {
	private static final long serialVersionUID = -8205764881332950993L;
	private String serialno;// 交易流水号
	private String tradedate;// 交易日期
	private String tradetime;// 交易时间
	private String idcdad;// 户籍地址
	private String validt;// 证件有效期
	private String cutycd;// 国籍
	private String custna;// 姓名
	private String idtftp;// 证件类型
	private String idtfno;// 证件号码
	private String gender;// 性别
	private String presAddress;// 现居住地址
	private String wkduty;// 职业
	private String revenue;// 税收居民身份
	private String phone;// 手机号
	private String vastdt;// 证件有效期起始日期
	private String vaeddt;// 证件有效期截止日期
	private String gloseqno;// 全局流水号
	private String app_id;// 申请编号
	private String status;// 交易状态，01-已激活 02-待激活 03-已取消 04-已过期
	private String othpro;// 职业描述，职业为：其他 时有填写
	private String photop;// 拍摄人像面
	private String photog;// 拍摄国徽面
	private String photof;// 拍摄人脸
	private String contentno;// 影像批次号
	private String modelno;// 影像模型号
	private String mybank;// 法人号
	private String comname;// 企业名称
	private String busistartdate;// 影像上传时间
	private String upddate;// 更新日期
	private String updtime;// 更新时间

	public static class CSIS_MBS_PER_BATCH {
	}

	public static Map<String, Object> getMap(MbsPerBatch mbsPerBatch) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", mbsPerBatch.getSerialno());
		map.put("tradedate", mbsPerBatch.getTradedate());
		map.put("tradetime", mbsPerBatch.getTradetime());
		map.put("idcdad", mbsPerBatch.getIdcdad());
		map.put("validt", mbsPerBatch.getValidt());
		map.put("cutycd", mbsPerBatch.getCutycd());
		map.put("custna", mbsPerBatch.getCustna());
		map.put("idtftp", mbsPerBatch.getIdtftp());
		map.put("idtfno", mbsPerBatch.getIdtfno());
		map.put("gender", mbsPerBatch.getGender());
		map.put("pres_address", mbsPerBatch.getPresAddress());
		map.put("wkduty", mbsPerBatch.getWkduty());
		map.put("revenue", mbsPerBatch.getRevenue());
		map.put("phone", mbsPerBatch.getPhone());
		map.put("vastdt", mbsPerBatch.getVastdt());
		map.put("vaeddt", mbsPerBatch.getVaeddt());
		map.put("gloseqno", mbsPerBatch.getGloseqno());
		map.put("app_id", mbsPerBatch.getApp_id());
		map.put("status", mbsPerBatch.getStatus());
		map.put("othpro", mbsPerBatch.getOthpro());
		map.put("photop", mbsPerBatch.getPhotop());
		map.put("photog", mbsPerBatch.getPhotog());
		map.put("photof", mbsPerBatch.getPhotof());
		map.put("contentno", mbsPerBatch.getContentno());
		map.put("modelno", mbsPerBatch.getModelno());
		map.put("mybank", mbsPerBatch.getMybank());
		map.put("busistartdate", mbsPerBatch.getBusistartdate());
		map.put("upddate", mbsPerBatch.getUpddate());
		map.put("updtime", mbsPerBatch.getUpdtime());
		return map;
	}
}