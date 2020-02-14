package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlSvcAuth;
import cn.com.agree.huanan.ap.tl.cache.ApCacheable;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class ChlSvcAuthDaoImpl implements ChlSvcAuthDao {
	private static String TABLE_CA = "csis_channelsvc_auth";
	private static String TABLE_TM = "csis_tran_mapp";
	private static String TABLE_SCT = "csis_service_center";
	public final Logger logger = Logger.getLogger(ChlSvcAuthDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;

	@Override
    @ApCacheable
	public ChlSvcAuth selectChlSvcAuth(String sysId, String svcOutCode, String scnOutCode) {
		
		OrmSelecter<ChlSvcAuth> ormSelecter = ormOper.getOrmSelecter(ChlSvcAuth.class);
		ChlSvcAuth svrAuth = ormSelecter.where(w->{
			w.setSysId(sysId);
			w.setSvcOutCode(svcOutCode);
			w.setScnOutCode(scnOutCode);
		}).fetchOne();
		return svrAuth;
	}

	@Override
	public IPage<Map<String, Object>> getChlSvcAuth(int curPage, int pageSize, String sysId, String svcOutCode,
												 String scnOutCode) {
		// XXX
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp wExp) {
				if(!StringUtils.isEmpty(sysId)) {
					wExp.eq("t1.SYSID", sysId);
				}
				if(!StringUtils.isEmpty(svcOutCode)) {
					wExp.eq("t1.SVCOUTCODE", svcOutCode);
				}
				if(!StringUtils.isEmpty(scnOutCode)) {
					wExp.eq("t1.SCNOUTCODE", scnOutCode);
				}
				wExp.eq("t1.SVCOUTCODE", SqlUtil.getSqlExp("t2.SVCOUTCODE"));
				wExp.eq("t1.SCNOUTCODE", SqlUtil.getSqlExp("t2.SCNOUTCODE"));
				wExp.eq("t2.SVCCODE", SqlUtil.getSqlExp("t3.SVCCENTCODE"));
			}
		};
		String[] tables = new String[] {TABLE_CA + " t1",TABLE_TM + " t2",TABLE_SCT + " t3"};
		String[] selectList = {"t1.SYSID as sysid","t1.CHNLCODE as chnlcode","t1.SVCOUTCODE as svcoutcode",
				"t1.SCNOUTCODE as scnoutcode","t1.STATUS as status","t2.SCNOUTNAME as scnoutname","t3.SVCCENTNAME as svcoutname"};
		
		Selecter selecter = dbo.getSelecter().select(selectList).from(tables).where(whereExp);
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage, pageSize);
		return iPage;
	}

	@Override
	public int insertChlSvcAuth(ChlSvcAuth svrAuth) {
		int count = dbo.getInserter().insertInto(TABLE_CA).values(ChlSvcAuth.getMap(svrAuth)).execute();
		return count;
	}

	@Override
	public int updateChlSvcAuth(ChlSvcAuth svrAuth) {
		int count = dbo.getUpdater().update(TABLE_CA).where(w -> {
			w.eq("SYSID", svrAuth.getSysId());
			w.eq("SVCOUTCODE", svrAuth.getSvcOutCode());
			w.eq("SCNOUTCODE", svrAuth.getScnOutCode());
		}).set(ChlSvcAuth.getMap(svrAuth)).execute();
		return count;
	}

	@Override
	public int deleteChlSvcAuth(ChlSvcAuth svrAuth) {
		int count = dbo.getDeleter().deleteFrom(TABLE_CA).where(w->{
			w.eq("SYSID", svrAuth.getSysId());
			w.eq("SVCOUTCODE", svrAuth.getSvcOutCode());
			w.eq("SCNOUTCODE", svrAuth.getScnOutCode());
		}).execute();
		return count;
	}

}
