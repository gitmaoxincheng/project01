package cn.com.agree.huanan.ap.al.csiopr.holiday.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.holiday.po.Holiday.csis_holiday;
import cn.com.agree.huanan.ap.al.csiopr.keep.po.Keep;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(csis_holiday.class)
public class Holiday implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -494822308361188302L;
	
	private String workdate; //日期
	private String workflag; //是否工作日:0-非工作日,1-工作日
	private String remarks; //备注说明
	private String upddate; //更新日期
	private String updtime; //更新时间
	private String updtlrno; //更新柜员
	
	public static class csis_holiday{
		
	}
	
	public static Map<String, Object> getMap(Holiday holiday) {
		Map<String, Object> map = new HashMap<>();
		map.put("workdate",holiday.getWorkdate());
		map.put("workflag",holiday.getWorkflag());
		map.put("remarks",holiday.getRemarks());
		map.put("upddate",holiday.getUpddate());
		map.put("updtime",holiday.getUpdtime());
		map.put("updtlrno",holiday.getUpdtlrno());

		return map;
	}

}
