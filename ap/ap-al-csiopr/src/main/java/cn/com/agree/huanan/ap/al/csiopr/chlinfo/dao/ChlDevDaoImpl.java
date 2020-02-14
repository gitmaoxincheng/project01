package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;


import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlDev;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Component
public class ChlDevDaoImpl implements ChlDevDao {
	private static String TABLE="csis_channel_dev";
	public final Logger logger = Logger.getLogger(ChlDevDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;

	@Override
	public List<ChlDev> selectChlDevBySysId(String sysId) {
		List<ChlDev> result = ormOper.getOrmSelecter(ChlDev.class).where(w ->{
			w.setSysId(sysId);
		}).fetchAll();
		return result;
	}
	
	@Override
	public ChlDev findChlDev(String sysId, String devip, String devno,String status) {
		ChlDev result = ormOper.getOrmSelecter(ChlDev.class).where(w ->{
			w.setSysId(sysId);
			if (null != devip) w.setDevIp(devip);
			if (null != devno) w.setDevNo(devno);
			w.setStatus(status);
		}).fetchOne();
		return result;
	}

	@Override
	public IPage<Map<String, Object>> queryChlDev(int curPage, int pageSize, String sysId, String devIp, String devNo,
												  String status) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(sysId)) {
					w.eq("SYSID", sysId);
				}
				if (!StringUtils.isEmpty(devIp)) {
					w.eq("DEVIP", devIp);
				}
				if (!StringUtils.isEmpty(devNo)) {
					w.eq("DEVNO", devNo);
				}
				if (!StringUtils.isEmpty(status)) {
					w.eq("STATUS", status);
				}
			};
		};
		
		String[] selectList = new String[] {
				"CHNLCODE as chnlcode",
				"DEVIP as devip",
				"DEV_NAME as devname",
				"DEV_ADDR as devaddr",
				"STATUS as strstatus",
				"DEVNO as devno"
		};
		
		Selecter selecter = dbo.getSelecter().select(selectList).from(TABLE).where(whereExp);
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage,pageSize);
		return iPage;
	}
	
	@Override
	public int addChlDev(ChlDev chlDev) {
		int count = dbo.getInserter().insertInto(TABLE).values(ChlDev.getMap(chlDev)).execute();
		return count;
	}

	@Override
	public int updateChlDev(ChlDev chlDev) {
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("CHNLCODE", chlDev.getChnlCode());
		}).set(ChlDev.getMap(chlDev)).execute();
		return count;
	}

	@Override
	public int deleteChlDev(ChlDev chlDev) {
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {
			w.eq("CHNLCODE", chlDev.getChnlCode());
		}).execute();
		return count;
	}


}
