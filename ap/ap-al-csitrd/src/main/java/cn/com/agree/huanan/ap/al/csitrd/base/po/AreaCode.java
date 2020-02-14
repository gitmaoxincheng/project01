package cn.com.agree.huanan.ap.al.csitrd.base.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.AreaCode.TRADEINFO_AREA_CODE;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 行政区域代码表bean
 * @author liaowen
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_AREA_CODE.class)
public class AreaCode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5556645306617647989L;
	
	private String areacode;   //区域代码
	private String areaname;   //区域名称

	public static class TRADEINFO_AREA_CODE{
		
	}
	
	public static Map<String, Object> getMap(AreaCode area){
		Map<String, Object> map = new HashMap<>();
		
		map.put("areacode",area.getAreacode());
		map.put("areaname",area.getAreaname());

		return map;
	}

}
