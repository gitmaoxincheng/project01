package cn.com.agree.huanan.ap.al.csiusr.sysmenu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.sysmenu.po.DevMenu;
import cn.com.agree.huanan.ap.al.csiusr.sysmenu.po.MenuInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class SysMenuDaoImpl implements SysMenuDao {
	private static String TABLE1="csis_channel_menuinfo";
	private static String TABLE2="csis_channel_devmenu";
	public final Logger logger = Logger.getLogger(SysMenuDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	//向系统菜单表中新增信息
	@Override
	public int addMenu(MenuInfo menuInfo) {
		int count = dbo.getInserter().insertInto(TABLE1).values(MenuInfo.getMap(menuInfo)).execute();
		
		return count;
	}

	//修改系统菜单表的信息
	@Override
	public int updateMenu(MenuInfo menuInfo) {
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("MENUNUM", menuInfo.getMenunum());
		}).set(MenuInfo.getMap(menuInfo)).execute();
		return count;
	}

	//删除系统菜单表的信息
	@Override
	public int deleteMenu(MenuInfo menuInfo) {
		if(StringUtils.isEmpty(menuInfo.getAppnum())) {
			int count = dbo.getDeleter().deleteFrom(TABLE1).where(w -> {
				w.eq("MENUNUM", menuInfo.getMenunum());
			}).execute();
			return count;
		}
		int count = dbo.getDeleter().deleteFrom(TABLE1).where(w -> {
			w.eq("APPNUM", menuInfo.getAppnum());
		}).execute();
		return count;
		
	}

	//根据菜单编号查询菜单表信息
	@Override
	public MenuInfo findMenuInfoByMenunum(String menunum) {
		MenuInfo result = ormOper.getOrmSelecter(MenuInfo.class).where(w ->{
			w.setMenunum(menunum);
		}).fetchOne();
		return result;
	}

	//根据菜单类型查询菜单信息
	@Override
	public MenuInfo findMenuInfoByAppnum(String appnum) {
		MenuInfo result = ormOper.getOrmSelecter(MenuInfo.class).where(w ->{
			w.setAppnum(appnum);
		}).fetchOne();
		return result;
	}

	//根据设备编号删除菜单设备绑定表信息
	@Override
	public int delectDevMenu(String devnum) {
		int count = dbo.getDeleter().deleteFrom(TABLE2).where(w -> {
			w.eq("DEVNUM", devnum);
		}).execute();
		return count;
	}

	//菜单设备绑定表新增
	@Override
	public int insertDevMenu(DevMenu devMenu) {
		int count = dbo.getInserter().insertInto(TABLE2).values(DevMenu.getMap(devMenu)).execute();
		return count;
	}
	//根据设备编号查询所有菜单
	@Override
	public List<MenuInfo> findMenuInfosByDevnum(String devnum) {
		DevMenu devMenu=ormOper.getOrmSelecter(DevMenu.class).where(w ->{
			w.setDevnum(devnum);
		}).fetchOne();
		if(devMenu==null) {
			return null;
		}else {
			String appnum=devMenu.getAppnum();
			List<MenuInfo> result = ormOper.getOrmSelecter(MenuInfo.class).where(w ->{
				w.setAppnum(appnum);
			}).fetchAll();
			return result;
		}
	}




}
