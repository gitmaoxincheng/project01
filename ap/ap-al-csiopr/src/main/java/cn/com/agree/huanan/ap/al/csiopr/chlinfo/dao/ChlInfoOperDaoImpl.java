package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfoOper;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class ChlInfoOperDaoImpl implements ChlInfoOperDao{
	private static String TABLE="csis_channel_info_oper";
	public final Logger logger = Logger.getLogger(ChlInfoOperDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;

	@Override
	public ChlInfoOper queryChlInfoOperById(String sysId) {
		OrmSelecter<ChlInfoOper> ormSelecter = ormOper.getOrmSelecter(ChlInfoOper.class);
		ChlInfoOper chlInfoOper = ormSelecter.where(w ->{
    		w.setSysId(sysId);
    		w.setAudStatus("0");
    	}).fetchOne();
    	return chlInfoOper;
	}
	
	@Override
	public int insertChlInfoOper(ChlInfoOper chlInfoOper) {
		return dbo.getInserter().insertInto(TABLE).values(ChlInfoOper.getMap(chlInfoOper)).execute();
	}

	@Override
	public Map<String, Object>  getChlInfoOperPageListBean(String pageFlag, String maxNum, String chnlCode,
			String beginDate, String endDate, String optType, String audStatus, String condition, String idxSeriNo) {
		
		// 查询总记录数
		long rowcnt = dbo.getSelecter().from(TABLE).where(w -> {
			if (!StringUtils.isEmpty(chnlCode)) {
				w.eq("CHNLCODE", chnlCode);
			}
			w.op("CRTDATE", ">=", beginDate);
			w.op("CRTDATE", "<=", endDate);
			if (!StringUtils.isEmpty(optType)) {
				w.eq("OPTTYPE", optType);
			}
			if (!StringUtils.isEmpty(audStatus)) {
				w.eq("AUDSTATUS", audStatus);
			}
			w.op("SERINO", condition, idxSeriNo);
	    }).count();
		logger.info("查找Bean");
		// 查询返回记录
		List<ChlInfoOper> mapList = ormOper.getOrmSelecter(ChlInfoOper.class).fetchAll();
		logger.debug(mapList.get(0).getAudBrNo());
		logger.debug(mapList.get(0).getAudDate());
		logger.debug(mapList.get(0).getAudRemark());
		logger.debug(mapList.get(0).getAudTime());
		logger.debug(mapList.get(0).getAudTlr());
		// 返回记录数
		int listnm = mapList.size();
		Map<String, Object> result = new HashMap<>();
		result.put("rowcnt", rowcnt);
		result.put("chlInfoOperList", mapList);
		result.put("listnm", listnm);
		
		return result;		
	}
	
	@Override
	public IPage<Map<String, Object>> getChlInfoOperPageList(int curPage, int pageSize, String sysId, String beginDate, String endDate, 
			String optType, String audStatus) {

		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(sysId)) {
					w.eq("SYSID", sysId);
				}
				w.op("CRTDATE", ">=", beginDate);
				w.op("CRTDATE", "<=", endDate);
				if (!StringUtils.isEmpty(optType)) {
					w.eq("OPTTYPE", optType);
				}
				if (!StringUtils.isEmpty(audStatus)) {
					w.eq("AUDSTATUS", audStatus);
				}
			}
		};
		String[] selectList = new String[]{"SERINO as serino","OPTTYPE as opttype","SYSID as sysId","CHNLCODE as chnlcode","CHNLNAME as chnlname",
				"STATUS as status","CHKFLAG as chkflag","CRTDATE as crtdate","CRTTIME as crttime","CRTBRNO as crtbrno",
				"CRTTLR as crttlr","AUDDATE as auddate","AUDTIME as audtime","AUDBRNO as audbrno","AUDTLR as audtlr",
				"AUDSTATUS as audstatus","AUDREMARK as audremark"};
		
		Selecter selecter = dbo.getSelecter()
								.select(selectList)
								.from(TABLE)
								.where(whereExp);
		
		IPage<Map<String, Object>> result = selecter.selectMapsPage(curPage, pageSize);
		return result;
	}

	@Override
	public ChlInfoOper queryChlInfoOperByseriNo(String seriNo) {
		OrmSelecter<ChlInfoOper> ormSelecter = ormOper.getOrmSelecter(ChlInfoOper.class);
		ChlInfoOper chlInfoOper = ormSelecter.where(w ->{
    		w.setSeriNo(seriNo);
    		w.setAudStatus("0");
    	}).fetchOne();
    	return chlInfoOper;
	}

	@Override
	public int updateChlInfoOper(ChlInfoOper chlInfoOper) {
		if (StringUtils.isEmpty(chlInfoOper.getSeriNo())) {
			throw new ApIllegalParamException("SeriNo");	
		}
		Updater updater = dbo.getUpdater();
		int count = updater.update(TABLE).where(w -> {w.eq("SERINO", chlInfoOper.getSeriNo());}).set(ChlInfoOper.getMap(chlInfoOper)).execute();
		return count;
	}

	@Override
	public int deleteChlInfoOper(String serino) {
		 if (StringUtils.isEmpty(serino)) {
			 throw new ApIllegalParamException("serino");	
		 }
		 int count = dbo.getDeleter().deleteFrom(TABLE).where(
				 w -> {w.eq("serino", serino);
		 }).execute();
	     return count;
	}

}
