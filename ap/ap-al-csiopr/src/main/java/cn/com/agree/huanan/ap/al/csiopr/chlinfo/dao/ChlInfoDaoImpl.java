package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfo;
import cn.com.agree.huanan.ap.tl.cache.ApCacheable;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

@Component
public class ChlInfoDaoImpl implements ChlInfoDao{
	private static String TABLE="csis_channel_info";
//	public final Logger logger = Logger.getLogger(ChlInfoDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	@Override
	public ChlInfo queryChlInfoByChnlCode(String chnlCode) {
		OrmSelecter<ChlInfo> ormSelecter = ormOper.getOrmSelecter(ChlInfo.class);
		ChlInfo chlInfo = ormSelecter.where(w ->{
    		w.setChnlCode(chnlCode);
    	}).fetchOne();
    	return chlInfo;
	}

	@Override
    @ApCacheable
	public ChlInfo selectChlInfoById(String sysId) {
		OrmSelecter<ChlInfo> ormSelecter = ormOper.getOrmSelecter(ChlInfo.class);
		ChlInfo chlInfo = ormSelecter.where(w ->{
			w.setSysId(sysId);
		}).fetchOne();
		return chlInfo;
	}

	@Override
	public IPage<Map<String, Object>> getChlInfoPageList(int curPage, int pageSize, String sysId, String chnlCode, String chnlName, String status) {

		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(sysId)) {
					w.eq("SYSID", sysId);
				}
				if (!StringUtils.isEmpty(chnlCode)) {
					w.eq("CHNLCODE", chnlCode);
				}
				if (!StringUtils.isEmpty(chnlName)) {
					w.eq("CHNLNAME", chnlName);
				}
				if (!StringUtils.isEmpty(status)) {
					w.eq("STATUS", status);
				}
			};
		};
		String[] selectList = new String[] {"CHNLCODE as chnlcode","SYSID as sysid","CHNLNAME as chnlname","STATUS as status","CHKFLAG as chkflag"};
		
		Selecter selecter = dbo.getSelecter()
							.select(selectList)
							.from(TABLE)
							.where(whereExp);

		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage,pageSize);
		return iPage;
	}

	//新增渠道信息
	@Override
	public int addChlInfo(ChlInfo chlInfo) {
		int count = dbo.getInserter().insertInto(TABLE).values(ChlInfo.getMap(chlInfo)).execute();
		return count;
	}

	//修改渠道信息
	@Override
	public int updateChlInfo(ChlInfo chlInfo) {
		if (StringUtils.isEmpty(chlInfo.getSysId())) {
			throw new ApIllegalParamException("sysid");
		}
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("SYSID", chlInfo.getSysId());
		}).set(ChlInfo.getMap(chlInfo)).execute();
		return count;
	}

	//删除渠道信息
	@Override
	public int deleteChlInfo(ChlInfo chlInfo) {
		if (StringUtils.isEmpty(chlInfo.getSysId())) {
			throw new ApIllegalParamException("sysid");
		}
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {
			w.eq("SYSID", chlInfo.getSysId());
		}).execute();
		return count;
	}

	@Override
	public ChlInfo queryChlInfoBySysIdAndChnlCode(String sysId,String chnlCode) {
		OrmSelecter<ChlInfo> ormSelecter = ormOper.getOrmSelecter(ChlInfo.class);
		ChlInfo chlInfo = ormSelecter.where(w ->{
    		w.setSysId(sysId);
    		w.setChnlCode(chnlCode);
    	}).fetchOne();
    	return chlInfo;
	}
}  
