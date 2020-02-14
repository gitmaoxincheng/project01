package cn.com.agree.huanan.ap.al.csiusr.sysmenu.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.sysmenu.po.DevMenu.csis_channel_devmenu;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(csis_channel_devmenu.class)
public class DevMenu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7033228243102065191L;
	
	private String appnum;    //菜单类型
	private String devnum;    //设备编号
	private String devtype;    //设备类型
	private String upddate;    //更新日期
	private String updtime;    //更新时间
	
	public static class csis_channel_devmenu{	
	}
	
	public static Map<String, Object> getMap(DevMenu devMenu){
		 Map<String, Object> map = new HashMap<>();
		 map.put("appnum", devMenu.getAppnum());
		 map.put("devnum", devMenu.getDevnum());
		 map.put("devtype", devMenu.getDevtype());
		 map.put("upddate", devMenu.getUpddate());
		 map.put("updtime", devMenu.getUpdtime());

		 return map;
	}
}
