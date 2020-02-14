package cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 亲子卡信息录入表Bean
 * 
 * @author xuzhen
 */
@Data
@Table(MbsGbbReseInfo.CSIS_MBS_GBB_RESERVEDINFO.class)
public class MbsGbbReseInfo implements Serializable {
	private static final long serialVersionUID = 8294137370489448041L;

	private String tradedate;// 交易日期
	private String serialno;// 交易流水号
	private String tradetime;// 交易时间
	private String name;// 姓名
	private String idtfno;// 证件号
	private String idtftp;// 证件类型
	private String phone;// 手机号
	private String card_type;// 申领卡类型 817-莞宝宝卡(橙色);818-莞宝宝卡(蓝色);
	private String tobrno;// 预约网点
	private String branchnames;// 预约网点简称
	private String rese_date;// 预约领卡日期
	private String status;// 申请状态 0-已申请，1-以制卡，2-已领卡，3-已失效
	private String gbb_type;// 是否办理过亲子卡 Y-是，N-否
	private String en_card_date;// 领卡截止日期
	private String upddate;// 更新日期
	private String updtime;// 更新时间
	private String inform;// 短信通知 0-未通知，1-已通知
	private String product_name;// 卡产品名称
	private String mybank;// 法人号

	public static class CSIS_MBS_GBB_RESERVEDINFO {
	}

	public static Map<String, Object> getMap(MbsGbbReseInfo mbsGbbReseInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("tradedate", mbsGbbReseInfo.getTradedate());
		map.put("serialno", mbsGbbReseInfo.getSerialno());
		map.put("tradetime", mbsGbbReseInfo.getTradetime());
		map.put("name", mbsGbbReseInfo.getName());
		map.put("idtfno", mbsGbbReseInfo.getIdtfno());
		map.put("idtftp", mbsGbbReseInfo.getIdtftp());
		map.put("phone", mbsGbbReseInfo.getPhone());
		map.put("card_type", mbsGbbReseInfo.getCard_type());
		map.put("tobrno", mbsGbbReseInfo.getTobrno());
		map.put("branchnames", mbsGbbReseInfo.getBranchnames());
		map.put("rese_date", mbsGbbReseInfo.getRese_date());
		map.put("status", mbsGbbReseInfo.getStatus());
		map.put("gbb_type", mbsGbbReseInfo.getGbb_type());
		map.put("en_card_date", mbsGbbReseInfo.getEn_card_date());
		map.put("upddate", mbsGbbReseInfo.getUpddate());
		map.put("updtime", mbsGbbReseInfo.getUpdtime());
		map.put("inform", mbsGbbReseInfo.getInform());
		map.put("product_name", mbsGbbReseInfo.getProduct_name());
		map.put("mybank", mbsGbbReseInfo.getMybank());
		return map;
	}
}
