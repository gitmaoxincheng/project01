package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;


import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlSvcAuthOper;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class ChlSvcAuthOperDaoImpl implements ChlSvcAuthOperDao {
	private static String TABLE_CAO = "csis_channelsvc_auth_oper";
	private static String TABLE_TM = "csis_tran_mapp";
	private static String TABLE_SCT = "csis_service_center";
	public final Logger logger = Logger.getLogger(ChlSvcAuthOperDaoImpl.class);
	@Autowired
	OrmOperator ormOper;
	@Autowired
	DbOperator dbo;

	@Override
	public ChlSvcAuthOper queryChlSvcAuthOper(String sysId, String svcOutCode, String scnOutCode) {
		// TODO 自动生成的方法存根
		OrmSelecter<ChlSvcAuthOper> ormSelecter = ormOper.getOrmSelecter(ChlSvcAuthOper.class);
		ChlSvcAuthOper svrAuthOper = ormSelecter.where(w->{
			w.setSysId(sysId);
			w.setSvcOutCode(svcOutCode);
			w.setScnOutCode(scnOutCode);
    		w.setAudStatus("0");
		}).fetchOne();
		return svrAuthOper;
	}

	@Override
	public ChlSvcAuthOper queryChlSvcAuthOperBySeriNo(String seriNo) {
		// TODO 自动生成的方法存根
		OrmSelecter<ChlSvcAuthOper> ormSelecter = ormOper.getOrmSelecter(ChlSvcAuthOper.class);
		ChlSvcAuthOper svrAuthOper = ormSelecter.where(w->{
			w.setSeriNo(seriNo);
		}).fetchOne();
		return svrAuthOper;
	}
	
	@Override
	public IPage<Map<String, Object>> getChlSvcAuthOper(int curPage, int pageSize, String sysId, String chnlCode, String beginDate, String endDate,
			String optType, String audStatus) {
		// TODO 自动生成的方法存根
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp wExp) {
				if(!StringUtils.isEmpty(sysId)) {
					wExp.eq("SYSID", sysId);
				}
				if(!StringUtils.isEmpty(chnlCode)) {
					wExp.eq("CHNLCODE", chnlCode);
				}
				if(!StringUtils.isEmpty(optType)) {
					wExp.eq("OPTTYPE", optType);
				}
				if(!StringUtils.isEmpty(audStatus)) {
					wExp.eq("AUDSTATUS", audStatus);
				}
				wExp.op("CRTDATE", ">=", beginDate);
				wExp.op("CRTDATE", "<=", endDate);

				wExp.eq("t1.SVCOUTCODE", SqlUtil.getSqlExp("t2.SVCOUTCODE"));
				wExp.eq("t1.SCNOUTCODE", SqlUtil.getSqlExp("t2.SCNOUTCODE"));
				wExp.eq("t2.SVCCODE", SqlUtil.getSqlExp("t3.SVCCENTCODE"));
			}
		};

		String[] tables = new String[] {TABLE_CAO + " t1",TABLE_TM + " t2",TABLE_SCT + " t3"};
		String[] selectList = {"t1.SERINO as serino","t1.OPTTYPE as opttype","t1.SYSID as sysid","t1.CHNLCODE as chnlcode","t1.SVCOUTCODE as svcoutcode",
				"t1.SCNOUTCODE as scnoutcode","t1.CRTDATE as crtdate","t1.CRTTIME as crttime","t1.CRTBRNO as crtbrno","t1.CRTTLR as crttlr",
				"t1.AUDDATE as auddate","t1.AUDTIME as audtime","t1.AUDBRNO as audbrno","t1.AUDTLR as audtlr","t1.AUDSTATUS as audstatus",
				"t1.AUDREMARK as audremark","t2.SCNOUTNAME as scnoutname","t3.SVCCENTNAME as svcoutname"};
		
		Selecter selecter = dbo.getSelecter().select(selectList).from(tables).where(whereExp);
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage, pageSize);
		return iPage;
	}
	
	@Override
	public int insertChlSvcAuthOper(ChlSvcAuthOper svrAuthOper) {
		int count = dbo.getInserter().insertInto(TABLE_CAO).values(ChlSvcAuthOper.getMap(svrAuthOper)).execute();
		return count;
	}

	@Override
	public int updateChlSvcAuthOper(ChlSvcAuthOper svrAuthOper) {
		int count = dbo.getUpdater().update(TABLE_CAO).where(w -> {w.eq("SERINO", svrAuthOper.getSeriNo());}).set(ChlSvcAuthOper.getMap(svrAuthOper)).execute();
		return count;
	}

	@Override
	public int deleteChlSvcAuthOper(ChlSvcAuthOper svrAuthOper) {
		int count = dbo.getDeleter().deleteFrom(TABLE_CAO).where(w->{
			w.eq("SERINO", svrAuthOper.getSeriNo());
		}).execute();
		return count;
	}

	@Override
	public int deleteChlSvcAuthOper(String serino) {
		 if (StringUtils.isEmpty(serino)) {
			 throw new ApIllegalParamException("serino");	
		 }
		 int count = dbo.getDeleter().deleteFrom(TABLE_CAO).where(w -> {w.eq("serino", serino);}).execute();
	     return count;
	}
	

}
