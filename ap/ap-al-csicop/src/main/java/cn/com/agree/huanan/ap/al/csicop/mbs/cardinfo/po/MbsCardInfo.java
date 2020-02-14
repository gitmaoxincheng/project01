package cn.com.agree.huanan.ap.al.csicop.mbs.cardinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 卡信息表
 * 
 * @author guyulong
 */
@Data
@Table(MbsCardInfo.CSIS_MBS_CARDINFO.class)
public class MbsCardInfo implements Serializable {
	private static final long serialVersionUID = -5736188608327284017L;

	private String product_type;// 分类标识(0001-网申信用卡，0002-莞宝宝卡信息)
	private String product_code;// 卡产品代码
	private String product_name;// 卡产品名称
	private String product_simple_name;// 卡产品简称
	private String feetype;// 年费代码
	private String feetype_name;// 年费名称
	private String card_photo_path;// 卡版面图片路径
	private String cardback_photo_path;// 卡版背面图片路径
	private String card_content_desc;// 内容描述
	private String card_content_desc2;// 内容描述2
	private String valid_ind;// 有效标识 Y-是；N-否
	private String st_date;// 有效开始日期
	private String up_date;// 有效截止日期
	private String seq;// 排序
	private String createdate;// 创建日期
	private String createtime;// 创建时间
	private String upddate;// 更新日期
	private String updtime;// 更新时间
	private String mybank;// 法人号

	public static class CSIS_MBS_CARDINFO {
	}

	public static Map<String, Object> getMap(MbsCardInfo mbsCardInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("product_type", mbsCardInfo.getProduct_type());
		map.put("product_code", mbsCardInfo.getProduct_code());
		map.put("product_name", mbsCardInfo.getProduct_name());
		map.put("product_simple_name", mbsCardInfo.getProduct_simple_name());
		map.put("feetype", mbsCardInfo.getFeetype());
		map.put("feetype_name", mbsCardInfo.getFeetype_name());
		map.put("card_photo_path", mbsCardInfo.getCard_photo_path());
		map.put("cardback_photo_path", mbsCardInfo.getCardback_photo_path());
		map.put("card_content_desc", mbsCardInfo.getCard_content_desc());
		map.put("card_content_desc2", mbsCardInfo.getCard_content_desc2());
		map.put("valid_ind", mbsCardInfo.getValid_ind());
		map.put("st_date", mbsCardInfo.getSt_date());
		map.put("up_date", mbsCardInfo.getUp_date());
		map.put("seq", mbsCardInfo.getSeq());
		map.put("createdate", mbsCardInfo.getCreatedate());
		map.put("createtime", mbsCardInfo.getCreatetime());
		map.put("upddate", mbsCardInfo.getUpddate());
		map.put("updtime", mbsCardInfo.getUpdtime());
		map.put("mybank", mbsCardInfo.getMybank());
		return map;
	}
}
