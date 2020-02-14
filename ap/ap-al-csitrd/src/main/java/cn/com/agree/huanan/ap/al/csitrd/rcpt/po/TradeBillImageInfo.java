package cn.com.agree.huanan.ap.al.csitrd.rcpt.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillImageInfo.TRADEINFO_BILL_IMAGE;;
/**
 * 单据图片表
 * @author WB
 *
 */
@Setter
@Getter
@ToString
@Table(TRADEINFO_BILL_IMAGE.class)
public class TradeBillImageInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8365202791534377503L;
	//公共部分
	private String updTime;           //最后更新时间
	private String updDate;           //最后更新日期
	
	private String bill;//单据号
	private String imageType;//图片类型（01-身份证正面,02-身份证反面,03-现场照片,04-核查照片,05-手写签名）
	private String imagePath;//图片路径
	public static class TRADEINFO_BILL_IMAGE{
		
	}
	public static Map<String, Object> getMap(TradeBillImageInfo info) {
		Map<String, Object> map = new HashMap<>();
		map.put("updDate",info.getUpdDate());
		map.put("updTime",info.getUpdTime());
		
		map.put("bill", info.getBill());
		map.put("imageType", info.getImageType());
		map.put("imagePath", info.getImagePath());
		return map;
	}
}
