package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevMod.csis_channel_devmod;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 设备型号与模块对应表
 * @author Maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_channel_devmod.class)
public class DevMod implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String devTypeNo;//设备类型
	private String devModuleNum;//设备模块id
	
	
	public static class csis_channel_devmod {
        
	}
	 
	 
	/**
	 * @param map 数据map，key:属性名(全大写) value：属性值
	 * @return DevMod
	 */
	public static Map<String, Object> getMap(DevMod devMod) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("devTypeNo",devMod.getDevTypeNo());
	    map.put("devModuleNum",devMod.getDevModuleNum());	   	
	    return map;
	}	

}
