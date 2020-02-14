package cn.com.agree.huanan.ap.al.csiusr.sysmenu.dao;

import java.util.List;

import cn.com.agree.huanan.ap.al.csiusr.sysmenu.po.DevMenu;
import cn.com.agree.huanan.ap.al.csiusr.sysmenu.po.MenuInfo;


public interface SysMenuDao {
	
	
	/**
	 * 根据菜单编号查询系统菜单表
	 * @param menunum  菜单编码
	 * @return
	 */
	public MenuInfo findMenuInfoByMenunum(String menunum);
	
	
	/**
	 * 根据菜单类型查询系统菜单表
	 * @param appnum   菜单类型
	 * @return
	 */
	public MenuInfo findMenuInfoByAppnum(String appnum);
	
	/**
	 * 菜单表新增
	 * @param menuInfo 系统菜单bean
	 * @return
	 */
	public int addMenu(MenuInfo menuInfo);

	/**
	 * 菜单表修改
	 * @param menuInfo 系统菜单bean
	 * @return
	 */
	public int updateMenu(MenuInfo menuInfo);

	/**
	 * 菜单表删除
	 * @param menuInfo 系统菜单bean
	 * @return
	 */
	public int deleteMenu(MenuInfo menuInfo);
	
	
	/**
	 * 根据设备编号删除菜单设备绑定表信息
	 * @param devnum 设备编号
	 * @return
	 */
	public int delectDevMenu(String devnum);
	

	/**
	 * 菜单设备绑定表新增
	 * @param devMenu 菜单设备绑定表bean
	 * @return
	 */
	public int insertDevMenu(DevMenu devMenu);
	/**
	 * 根据设备编号查询出所有的菜单记录
	 * @param devnum   设备编号
	 * @return
	 */
	public List<MenuInfo> findMenuInfosByDevnum(String devnum);
	
}
