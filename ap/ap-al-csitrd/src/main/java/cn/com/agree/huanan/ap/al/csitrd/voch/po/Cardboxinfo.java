package cn.com.agree.huanan.ap.al.csitrd.voch.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csitrd.voch.po.Cardboxinfo.CSIS_AUMS_DEV_CARDBOXINFO;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 卡箱信息表bean
 * @author stj
 */
@Setter
@Getter
@ToString
@Table(CSIS_AUMS_DEV_CARDBOXINFO.class)
public class Cardboxinfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2308506161283160395L;

	private String devid;//设备id
	
	private String cardboxnum;//卡箱序列号
	
	private String boxtype;//卡箱类型
	
	private String cardtype;//卡类型
	
	private String oritotnum;//原总数
	
	private String totnum;//当前总数
	
	private String strtnum;//起始凭证序号
	
	private String endnum;//终止凭证序号 
	
	private String cardphotopath;//卡图片路径
	
	private String cardname;//名字
	
	private String carddesc;//卡片描述
	
	private String rsv1;//备用字段1
	
	private String rsv2;//备用字段2
	
	private String rsv3;//备用字段3
	
	public static class CSIS_AUMS_DEV_CARDBOXINFO{
		
	}
	public static Map<String, Object> getMap(Cardboxinfo cardboxinfo){
		 Map<String, Object> map = new HashMap<>();
		 map.put("boxtype", cardboxinfo.getBoxtype());
		 map.put("cardboxnum", cardboxinfo.getCardboxnum());
		 map.put("carddesc", cardboxinfo.getCarddesc());
		 map.put("cardname", cardboxinfo.getCardname());
		 map.put("cardphotopath", cardboxinfo.getCardphotopath());
		 map.put("cardtype", cardboxinfo.getCardtype());
		 map.put("devid", cardboxinfo.getDevid());
		 map.put("endnum", cardboxinfo.getEndnum());
		 map.put("oritotnum", cardboxinfo.getOritotnum());
		 map.put("rsv1", cardboxinfo.getRsv1());
		 map.put("rsv2", cardboxinfo.getRsv2());
		 map.put("rsv3", cardboxinfo.getRsv3());
		 map.put("strtnum", cardboxinfo.getStrtnum());
		 map.put("totnum", cardboxinfo.getTotnum());
		 return map;
	}
}
