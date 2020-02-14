package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;


import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlDevOper;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.function.Consumer;

@Component
public class ChlDevOperDaoImpl implements ChlDevOperDao {
	private static String TABLE="csis_channel_dev_oper";
	public final Logger logger = Logger.getLogger(ChlDevOperDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;

	@Override
	public int insertChlDevToOper(ChlDevOper chlDevOper) {
		int count = dbo.getInserter().insertInto(TABLE).values(ChlDevOper.getMap(chlDevOper)).execute();
		dbo.commit();
		return count;
	}

	@Override
	public ChlDevOper findChlDevOperBySysId(String sysId, String authstatus) {
		ChlDevOper chlDevOpen = ormOper.getOrmSelecter(ChlDevOper.class).where(w ->{
			w.setSysId(sysId);
			w.setAuthStatus(authstatus);
		}).fetchOne();
		return chlDevOpen;
	}

	@Override
	public IPage<Map<String, Object>> queryChlDevOper(int curPage, int pageSize, String sysId, String beginDate,
			String endDate, String optType, String authStatus) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(sysId)) {
					w.eq("SYSID", sysId);
				}
				if (!StringUtils.isEmpty(optType)) {
					w.eq("OPTTYPE", optType);
				}
				if (!StringUtils.isEmpty(authStatus)) {
					w.eq("AUTHSTATUS", authStatus);
				}
				w.op("CRTDATE", ">=", beginDate);
				w.op("CRTDATE", "<=", endDate);
			}
		};
		
		String[] selectList = new String[] {
				"SERINO as serino",
				"OPTTYPE as opttype",
				"CHNLCODE as chnlcode",
				"DEVIP as devip",
				"DEVNO as devno",
				"DEVNAME as devname",
				"DEVADDR as devaddr",
				"STATUS as strstatus",
				"CRTDATE as crtdate",
				"CRTTIME as crttime",
				"CRTBRNO as crtbrno",
				"CRTTLR as crttlr",
				"AUDATE as audate",
				"AUDTIME as audtime",
				"AUDBRNO as audbrno",
				"AUDTLR as audtlr",
				"AUTHSTATUS as authstatus",
				"AUTHREMARKS as authremarks"
		};
		
		Selecter selecter = dbo.getSelecter().select(selectList).from(TABLE).where(whereExp);
		
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage, pageSize);

		return iPage;
	}

	@Override
	public ChlDevOper queryChlDevOperByseriNo(String seriNo) {
		ChlDevOper chlDevOper = ormOper.getOrmSelecter(ChlDevOper.class).where(w -> {
			w.setSeriNo(seriNo);
			w.setAuthStatus("0");
		}).fetchOne();
		return chlDevOper;
	}

	@Override
	public int updataChlDevOper(ChlDevOper chlDevOper) {
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("SERINO", chlDevOper.getSeriNo());
		}).set(ChlDevOper.getMap(chlDevOper)).execute();
		return count;
	}


}
