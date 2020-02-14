package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.po.Mobilemarket.csis_mobi_menu;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 移动营销客户端菜单表bean
 * @author liyong
 *
 */
@Getter
@Setter
@ToString
@Table(csis_mobi_menu.class)
public class Mobilemarket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8118086728907567718L;
	private String menuno;//菜单编号
	private String menutype;//菜单类型
	private String appid;//应用ID
	private String menuname;//菜单名称
	private String menuparno;//上级菜单编号
	private String menusort;//菜单排序位置
	private String menuimg1;//菜单图片名称1
	private String menuimg2;//菜单图片名称2
	private String menudesc;//菜单描叙
	private String menulevel;//菜单等级
	private String menuabtype;//菜单AB类型
	private String menustatus;//菜单状态
	private String upddate;//更新日期
	private String updtime;//更新时间
	
	public static class csis_mobi_menu {
        
    }

	public static Map<String, Object> getMap(Mobilemarket mobilemarket){
		Map<String, Object> map = new HashMap<>();
		map.put("menuno", mobilemarket.getMenuno());
		map.put("menutype", mobilemarket.getMenutype());
		map.put("appid", mobilemarket.getAppid());
		map.put("menuname", mobilemarket.getMenuname());
		map.put("menuparno", mobilemarket.getMenuparno());
		map.put("menusort", mobilemarket.getMenusort());
		map.put("menuimg1", mobilemarket.getMenuimg1());
		map.put("menuimg2", mobilemarket.getMenuimg2());
		map.put("menudesc", mobilemarket.getMenudesc());
		map.put("menulevel", mobilemarket.getMenulevel());
		map.put("menuabtype", mobilemarket.getMenuabtype());
		map.put("menustatus", mobilemarket.getMenustatus());
		map.put("upddate", mobilemarket.getUpddate());
		map.put("updtime", mobilemarket.getUpdtime());
		return map;
	}
}
