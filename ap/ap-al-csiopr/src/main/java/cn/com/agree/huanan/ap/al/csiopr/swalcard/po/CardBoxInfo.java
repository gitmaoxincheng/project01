package cn.com.agree.huanan.ap.al.csiopr.swalcard.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiopr.swalcard.po.CardBoxInfo.csis_aums_dev_cardboxinfo;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 设备信息表Bean
 * @author Maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_aums_dev_cardboxinfo.class)
public class CardBoxInfo implements Serializable {
	private static final long serialVersionUID = 1L;	
	private String devId;//设备id
	private String boxType;//卡箱类型
	private String cardBoxNum;//卡箱序列号
	private String cardType;//卡类型
	private String cardPhotoPath;//卡图片路径
	private String cardName;//名字
	private String cardDesc;//卡片描述
	private String totNum;//总数
	private String oriTotNum;//原总数
	private String strtNum;//起始凭证序号
	private String endNum;//终止凭证序号 
	private String rsv1;//备用字段1
	private String rsv2;//备用字段2
	private String rsv3;//备用字段3
 
	public static class csis_aums_dev_cardboxinfo {
	        
	}
	 	 
	/**
	 * @param map 数据map，key:属性名(全大写) value：属性值
	 * @return DutyInfo
	 */
	public static Map<String, Object> getMap(CardBoxInfo cardBoxInfo) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("devId",cardBoxInfo.getDevId());
	    map.put("boxType",cardBoxInfo.getBoxType());
	    map.put("cardBoxNum",cardBoxInfo.getCardBoxNum());
	    map.put("cardType",cardBoxInfo.getCardType());
	    map.put("cardPhotoPath",cardBoxInfo.getCardPhotoPath());
	    map.put("cardName",cardBoxInfo.getCardName());
	    map.put("totNum",cardBoxInfo.getTotNum());
	    map.put("oriTotNum",cardBoxInfo.getOriTotNum());
	    map.put("strtNum",cardBoxInfo.getStrtNum());
	    map.put("endNum",cardBoxInfo.getEndNum());		    
	    map.put("rsv1",cardBoxInfo.getRsv1());
	    map.put("rsv2",cardBoxInfo.getRsv2());
	    map.put("rsv3",cardBoxInfo.getRsv3());	    
	    return map;
	}	

}
