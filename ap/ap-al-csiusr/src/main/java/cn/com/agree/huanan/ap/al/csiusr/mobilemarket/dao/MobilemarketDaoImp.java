package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.po.MobiRol;
import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.po.Mobilemarket;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class MobilemarketDaoImp implements MobilemarketDao {

	private static String TABLE1="csis_mobi_menu";
	private static String TABLE2="csis_mobi_rol_menu";
    public final Logger logger = Logger.getLogger(MobilemarketDaoImp.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    
    
	@Override
	public Mobilemarket queryByMenuno(String menuno) {
		OrmSelecter<Mobilemarket> ormSelecter = ormOper.getOrmSelecter(Mobilemarket.class);
		Mobilemarket mobilemarket = ormSelecter.where(w ->{
    		w.setMenuno(menuno);
    	}).fetchOne();
		return mobilemarket;
	}


	@Override
	public int addMobilemarket(Mobilemarket mobilemarket) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(Mobilemarket.getMap(mobilemarket)).execute();
		return count;
	}


	@Override
	public int updateMobilemarket(HashMap<String, Object> map,String menuno) {
		Updater updater = dbo.getUpdater();
//		HashMap<String, Object> hashMap = new HashMap<>();
		//int count = updater.update(TABLE1).where(w -> {w.eq("ENTDUTYNO", entdutyNo);}).set(map).execute();
		int count = updater.update(TABLE1).where(w -> {
			w.eq("menuno", menuno);
		}).set(map).execute();
		return count;
	}


	@Override
	public Mobilemarket queryByMenuparno(String menuparno) {
		OrmSelecter<Mobilemarket> ormSelecter = ormOper.getOrmSelecter(Mobilemarket.class);
		Mobilemarket mobilemarket=ormSelecter.where(w ->{
    		w.setMenuparno(menuparno);
    	}).fetchOne();
		return mobilemarket;
	}


	@Override
	public int deleteByMenuno(String menuno) {
		int count = dbo.getDeleter().deleteFrom(TABLE1).where(w -> {w.eq("menuno", menuno);}).execute();
		return count;
	}


	@Override
	public int deleteMobilRolBy(String menuno) {
		int count = dbo.getDeleter().deleteFrom(TABLE2).where(w -> {w.eq("menuno", menuno);}).execute();
		return count;
	}


	@Override
	public int addMobiRol(MobiRol mobiRol) {
		Inserter inserter = dbo.getInserter();
		inserter.insertInto(TABLE2).values(MobiRol.getMap(mobiRol)).execute();
		return 1;
	}


	@Override
	public MobiRol getMobiRolByMenuno(String menuno) {
		OrmSelecter<MobiRol> ormSelecter = ormOper.getOrmSelecter(MobiRol.class);
		MobiRol mobiRol=ormSelecter.where(w ->{
    		w.setMenuno(menuno);
    	}).fetchOne();
		return mobiRol;
	}

	//移动营销菜单查询
	@Override
	public IPage<Map<String, Object>> getMobiPageList(HashMap<String, Object> map) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(map.get("menuno"))) {
					w.eq("MENUNO", map.get("menuno"));
				}
				if (!StringUtils.isEmpty(map.get("menuname"))) {
					w.eq("MENUNAME", map.get("menuname"));
				}
				if (!StringUtils.isEmpty(map.get("menustatus"))) {
					w.eq("MENUSTATUS", map.get("menustatus"));
				}
				if (!StringUtils.isEmpty(map.get("menuparno"))) {
					w.eq("MENUPARNO", map.get("menuparno"));
				}
			};
		};
		
		String[] selectList = new String[] {"MENUNO as menuno","MENUTYPE as menutype","APPID as appid","MENUNAME as menuname",
				"MENUPARNO as menuparno","MENUSORT as menusort","MENUIMG1 as menuimg1","MENUIMG2 as menuimg2","MENUDESC as menudesc"
				,"MENULEVEL as menulevel","MENUABTYPE as menuabtype","MENUSTATUS as menustatus"};
		
		Selecter selecter = dbo.getSelecter()
				.select(selectList)
				.from(TABLE1)
				.where(whereExp).orderBy("menuno");
		
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage((int)map.get("pagenum"),(int)map.get("pagesize"));
		return iPage;
	}

	//移动营销菜单权限查询
	@Override
	public IPage<Map<String, Object>> getMobiRolPageList(HashMap<String, Object> map) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("m.MENUNO", SqlUtil.getSqlExp("n.MENUNO"));
				w.eq("n.DUTYNO", map.get("dutyno"));
				if (!StringUtils.isEmpty(map.get("menuno"))) {
					w.eq("n.MENUNO", map.get("menuno"));
				}
				if (!StringUtils.isEmpty(map.get("menustatus"))) {
					w.eq("m.MENUSTATUS", map.get("menustatus"));
				}
			};
		};
		
		String[] selectList = new String[] {"n.DUTYNO as dutyno","n.MENUNO as menuno","m.MENUTYPE as menutype","m.APPID as appid","m.MENUNAME as menuname",
				"m.MENUPARNO as menuparno","m.MENUSORT as menusort","m.MENUIMG1 as menuimg1","m.MENUIMG2 as menuimg2","m.MENUDESC as menudesc",
				"m.MENULEVEL as menulevel","m.MENUABTYPE as menuabtype","m.MENUSTATUS as menustatus"};
		
		Selecter selecter = dbo.getSelecter()
				.from(TABLE2+" n",TABLE1+" m")
				.select(selectList)
				.where(whereExp).orderBy("n.menuno");
		
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage((int)map.get("pagenum"),(int)map.get("pagesize"));
		return iPage;
	}

	
}
