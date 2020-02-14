package cn.com.agree.huanan.ap.al.csiusr.sysmenu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.sysmenu.dao.SysMenuDao;
import cn.com.agree.huanan.ap.al.csiusr.sysmenu.po.DevMenu;
import cn.com.agree.huanan.ap.al.csiusr.sysmenu.po.MenuInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApDataExistException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApDeleteFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * 系统菜单服务层
 * @author lw
 */

@Service
public class SysMenuService {
	@Autowired SysMenuDao sysMenuDao;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	
	
	/**
	 * 菜单新增
	 * @param appnum              //菜单类型
	 * @param menunum             //菜单编号
	 * @param menuname            //菜单名称
	 * @param menuicon            //菜单图标
	 * @param menupath            //菜单路径
	 * @param menutype            //菜单类型
	 * @param parentmenunum       //父菜单编号 : 根节点的父节点为0
	 * @param isvisible           //是否可见
	 * @param menusize            //大小
	 * @param bg                  //背景图片
	 * @param navigationmode      //导航模式
	 * @param tradecode           //交易码
	 * @param iscommon            //常用菜单标识
	 * @param englishmenuname     //英文名称
	 * @param upddate             //更新日期
	 * @param updtime             //更新时间
	 */
	public void addMenu(String appnum, String menunum, String menuname, String menuicon,
			String menupath, String tadpath,String menutype, String parentmenunum, String isvisible, String menusize,
			String bg, String navigationmode, String tradecode, String iscommon, String englishmenuname) {
		// 检查系统菜单信息是否存在
		MenuInfo menuInfo = sysMenuDao.findMenuInfoByMenunum(menunum);
		if (menuInfo != null) {
			logger.error("系统菜单表中已有该菜单编号的信息存在,无法新增");
			throw new ApDataExistException("系统菜单表中已有该菜单编号的信息存在,无法新增");
		}
		
		MenuInfo MenuInfoTemp = new MenuInfo();
		MenuInfoTemp.setAppnum(appnum);
		MenuInfoTemp.setMenunum(menunum);
		MenuInfoTemp.setMenuname(menuname);
		MenuInfoTemp.setMenuicon(menuicon);
		MenuInfoTemp.setMenupath(menupath);
		MenuInfoTemp.setTadpath(tadpath);
		MenuInfoTemp.setMenutype(menutype);
		MenuInfoTemp.setParentmenunum(parentmenunum);
		MenuInfoTemp.setIsvisible(isvisible);
		MenuInfoTemp.setMenusize(menusize);
		MenuInfoTemp.setBg(bg);
		MenuInfoTemp.setNavigationmode(navigationmode);
		MenuInfoTemp.setTradecode(tradecode);
		MenuInfoTemp.setIscommon(iscommon);
		MenuInfoTemp.setEnglishmenuname(englishmenuname);
		MenuInfoTemp.setUpddate(DateTimeUtil.getSysDate());
		MenuInfoTemp.setUpdtime(DateTimeUtil.getSysTime());
		
		int count = sysMenuDao.addMenu(MenuInfoTemp);
		
		if(count!=1) {
			logger.error("系统菜单表新增信息失败");
			dbo.rollback();
			throw new ApUpdateFailException("系统菜单表新增信息失败");
		}
		dbo.commit();
	}

	
	/**
	 * 菜单修改
	 * @param menunum             //菜单编号
	 * @param menuname            //菜单名称
	 * @param menuicon            //菜单图标
	 * @param menupath            //菜单路径
	 * @param menutype            //菜单类型
	 * @param parentmenunum       //父菜单编号 : 根节点的父节点为0
	 * @param isvisible           //是否可见
	 * @param menusize            //大小
	 * @param bg                  //背景图片
	 * @param navigationmode      //导航模式
	 * @param tradecode           //交易码
	 * @param iscommon            //常用菜单标识
	 * @param englishmenuname     //英文名称
	 * @param upddate             //更新日期
	 * @param updtime             //更新时间
	 */
	public void updateMenu(String menunum, String menuname, String menuicon,
			String menupath, String tadpath,String menutype, String parentmenunum, String isvisible, String menusize,
			String bg, String navigationmode, String tradecode, String iscommon, String englishmenuname) {
		// 检查系统菜单信息是否存在
		MenuInfo menuInfo = sysMenuDao.findMenuInfoByMenunum(menunum);
		if (menuInfo == null) {
			logger.debug("系统菜单表中没有该菜单编号的信息存在,无法修改");
			throw new ApSelectNotFoundException("系统菜单表中没有该菜单编号的信息存在,无法修改");
		}
		
		MenuInfo MenuInfoTemp = new MenuInfo();
		MenuInfoTemp.setMenunum(menunum);
		MenuInfoTemp.setMenuname(menuname);
		MenuInfoTemp.setMenuicon(menuicon);
		MenuInfoTemp.setMenupath(menupath);
		MenuInfoTemp.setTadpath(tadpath);
		MenuInfoTemp.setMenutype(menutype);
		MenuInfoTemp.setParentmenunum(parentmenunum);
		MenuInfoTemp.setIsvisible(isvisible);
		MenuInfoTemp.setMenusize(menusize);
		MenuInfoTemp.setBg(bg);
		MenuInfoTemp.setNavigationmode(navigationmode);
		MenuInfoTemp.setTradecode(tradecode);
		MenuInfoTemp.setIscommon(iscommon);
		MenuInfoTemp.setEnglishmenuname(englishmenuname);
		MenuInfoTemp.setUpddate(DateTimeUtil.getSysDate());
		MenuInfoTemp.setUpdtime(DateTimeUtil.getSysTime());
		
		int count = sysMenuDao.updateMenu(MenuInfoTemp);
		if(count!=1) {
			logger.debug("系统菜单表修改信息失败");
			dbo.rollback();
			throw new ApUpdateFailException("系统菜单表修改信息失败");
		}
		dbo.commit();
	}

	

	/**
	 * 菜单删除
	 * @param appnum          //菜单类型
	 * @param menunum         //菜单编号
	 */
	public void delectMenu(String appnum, String menunum) {
		//参数校验
		if(StringUtils.isEmpty(appnum) && StringUtils.isEmpty(menunum)) {
			logger.debug("菜单类型和菜单编号不能同时为空");
			throw new ApIllegalParamException("菜单类型和菜单编号不能同时为空");
		}
		if(!StringUtils.isEmpty(appnum) && !StringUtils.isEmpty(menunum)) {
			logger.debug("菜单类型和菜单编号不能同时传值");
			throw new ApIllegalParamException("菜单类型和菜单编号不能同时传值");
		}
		
		// 检查系统菜单信息是否存在
		if(StringUtils.isEmpty(menunum)) {
			MenuInfo menuInfo = sysMenuDao.findMenuInfoByAppnum(appnum);
			if (menuInfo == null) {
				logger.error("系统菜单表中没有该菜单类型的信息存在,无法删除");
				throw new ApSelectNotFoundException("系统菜单表中没有该菜单类型的信息存在,无法删除");
			}
		}else {
			MenuInfo menuInfo = sysMenuDao.findMenuInfoByMenunum(menunum);
			if (menuInfo == null) {
				logger.error("系统菜单表中没有该菜单编号的信息存在,无法删除");
				throw new ApSelectNotFoundException("系统菜单表中没有该菜单编号的信息存在,无法删除");
			}
		}
		
		MenuInfo MenuInfoTemp = new MenuInfo();
		MenuInfoTemp.setAppnum(appnum);
		MenuInfoTemp.setMenunum(menunum);
		
				
		int count = sysMenuDao.deleteMenu(MenuInfoTemp);
		if(count == 0) {
			logger.error("系统菜单表删除信息失败");
			dbo.rollback();
			throw new ApUpdateFailException("系统菜单表删除信息失败");
		}
		dbo.commit();
	}


	/**
	 * 菜单下发
	 * @param appnum       //菜单类型
	 * @param listnm       //设备数
	 * @param dev_list     //设备列表
	 */
	public void downDtbMenu(String appnum, String listnm,  List<Map<String, String>> dev_list) {
		
		DevMenu devMenu = new DevMenu();
		devMenu.setAppnum(appnum);
		devMenu.setUpddate(DateTimeUtil.getSysDate());
		devMenu.setUpdtime(DateTimeUtil.getSysTime());
		
		for(Map<String , String> map : dev_list) {
			String devnum = map.get("devnum");
			devMenu.setDevnum(devnum);
			devMenu.setDevtype(map.get("devtype"));
			
			//先根据设备编号删除再添加新的信息
			logger.info("菜单设备绑定表删除开始");
			sysMenuDao.delectDevMenu(devnum);
			logger.info("菜单设备绑定表新增开始");
			int inscount = sysMenuDao.insertDevMenu(devMenu);
			if(inscount == 0) {
				dbo.rollback();
				logger.error("菜单设备绑定表新增失败");
				throw new ApInsertFailException("菜单下发");
			}
		}
		dbo.commit();
	}
	/**
	 * 根据设备编号查询所有的菜单信息
	 * @param devnum
	 * @return
	 */
	public List<MenuInfo> getMenuInfosByDevnum(String devnum){
		return sysMenuDao.findMenuInfosByDevnum(devnum);
	}
}
