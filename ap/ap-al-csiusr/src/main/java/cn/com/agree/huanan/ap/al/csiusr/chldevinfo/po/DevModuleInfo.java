package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevModuleInfo.csis_channel_moduleinfo;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 设备模块信息表
 * @author liaowen
 */
@Getter
@Setter
@ToString
@Table(csis_channel_moduleinfo.class)
public class DevModuleInfo implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String devmodulenum;//自助设备号
	private String devmodulename;//设备模块名称
	private String devmodulestapath;//设备状态映射
	private String upddate;//更新日期
	private String updtime;//更新时间

	
	public static class csis_channel_moduleinfo {
        
	}
	
	public static Map<String, Object> getMap(DevModuleInfo devModuleInfo){
		Map<String, Object> map = new HashMap<>();
		map.put("devmodulenum",devModuleInfo.getDevmodulenum());
		map.put("devmodulename",devModuleInfo.getDevmodulename());
		map.put("devmodulestapath",devModuleInfo.getDevmodulestapath());
		map.put("upddate",devModuleInfo.getUpddate());
		map.put("updtime",devModuleInfo.getUpdtime());
		return map;
	}
	

}
