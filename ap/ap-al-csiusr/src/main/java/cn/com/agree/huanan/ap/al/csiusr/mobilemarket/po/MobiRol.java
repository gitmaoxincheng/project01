package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.po.MobiRol.csis_mobi_rol_menu;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 实体岗bean
 * @author liyong
 *
 */
@Getter
@Setter
@ToString
@Table(csis_mobi_rol_menu.class)
public class MobiRol implements Serializable{
	private String dutyno; //实体岗编码  
	private String menuno;//菜单编号
	private String upddate;//更新日期
	private String updtime;//更新时间
	
	public static class csis_mobi_rol_menu {
        
    }

	
	public static Map<String, Object> getMap(MobiRol mobiRol){
		Map<String, Object> map = new HashMap<>();
		map.put("dutyno", mobiRol.getDutyno());
		map.put("menuno", mobiRol.getMenuno());
		map.put("upddate", mobiRol.getUpddate());
		map.put("updtime", mobiRol.getUpdtime());
		return map;
	}
}
