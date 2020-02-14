package cn.com.agree.huanan.ap.al.csitrd.base.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.TradeInfoImageList.TRADEINFO_IMAGE_LIST;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 影像信息列表
 * chents
 * */
@Getter
@Setter
@ToString
@Table(TRADEINFO_IMAGE_LIST.class)
public class TradeInfoImageList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 395123033606879252L;

	private String tradeDate; //平台交易日期
	private String serialNo;  //平台交易流水
	private String imagePath; //图片路径
	private String updTime;   //更新时间
	private String updDate;   //更新日期
	private String imageNum;  //图片序号

	public static class TRADEINFO_IMAGE_LIST { 

	}

	public static Map<String, Object> getMap(TradeInfoImageList info){
		Map<String, Object> map = new HashMap<>();
		
		map.put("tradeDate", info.getTradeDate());
		map.put("serialNo", info.getSerialNo());
		map.put("imagePath", info.getImagePath());
		map.put("updTime", info.getUpdTime());
		map.put("updDate", info.getUpdDate());
		map.put("imageNum", info.getImageNum());
		
		return map;
	}


}




















