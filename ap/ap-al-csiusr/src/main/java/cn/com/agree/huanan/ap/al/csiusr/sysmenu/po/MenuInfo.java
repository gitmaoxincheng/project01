package cn.com.agree.huanan.ap.al.csiusr.sysmenu.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.sysmenu.po.MenuInfo.csis_channel_menuinfo;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 系统菜单表
 * lw
 */
@Getter
@Setter
@ToString
@Table(csis_channel_menuinfo.class)
public class MenuInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6900332240049567113L;
	
	private String appnum;    //菜单类型
	private String menunum;    //菜单编号
	private String menuname;    //菜单名称
	private String menuicon;    //菜单图标
	private String menupath;    //菜单路径
	private String tadpath;     //交易路径
	private String menutype;    //菜单类型
	private String parentmenunum;    //父菜单编号
	private String isvisible;    //是否可见
	private String menusize;    //大小
	private String bg;    //背景图片
	private String navigationmode;    //导航模式
	private String tradecode;    //交易码
	private String iscommon;    //常用菜单标识
	private String englishmenuname;    //英文名称
	private String upddate;    //更新日期
	private String updtime;    //更新时间

	
	public static class csis_channel_menuinfo {	
	}


	public static Map<String, Object> getMap(MenuInfo menuInfo){
		 Map<String, Object> map = new HashMap<>();
		 map.put("appnum", menuInfo.getAppnum());
		 map.put("menunum", menuInfo.getMenunum());
		 map.put("menuname", menuInfo.getMenuname());
		 map.put("menuicon", menuInfo.getMenuicon());
		 map.put("menupath", menuInfo.getMenupath());
		 map.put("menutype", menuInfo.getMenutype());
		 map.put("parentmenunum", menuInfo.getParentmenunum());
		 map.put("isvisible", menuInfo.getIsvisible());
		 map.put("menusize", menuInfo.getMenusize());
		 map.put("bg", menuInfo.getBg());
		 map.put("navigationmode", menuInfo.getNavigationmode());
		 map.put("tradecode", menuInfo.getTradecode());
		 map.put("iscommon", menuInfo.getIscommon());
		 map.put("englishmenuname", menuInfo.getEnglishmenuname());
		 map.put("upddate", menuInfo.getUpddate());
		 map.put("updtime", menuInfo.getUpdtime());

		 return map;
	}
	

}
