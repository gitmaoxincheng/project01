package cn.com.agree.huanan.ap.al.csiusr.advinfo.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.advinfo.po.AdvInfo;
import cn.com.agree.huanan.ap.al.csiusr.advinfo.po.DevAdv;
import cn.com.agree.huanan.ap.al.csiusr.advmod.po.AdvMod;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class AdvInfoDaoImp implements AdvInfoDao {
	public final Logger logger = Logger.getLogger(AdvInfoDaoImp.class);
	private static String TABLE = "csis_channel_advinfo";
	private static String TABLE1 = "csis_channel_devadv";
	@Autowired DbOperator dbo;
	@Autowired OrmOperator ormOper;
	
	//插入，广告文件信息表
	@Override
	public int insertAdvInfo(AdvInfo advInfo) {
		logger.info("--@Component增加数据advInfo--"+advInfo);
		if (StringUtils.isEmpty(AdvInfo.getMap(advInfo))) {
			throw new ApIllegalParamException("advInfo");
		}
		int count = dbo.getInserter().insertInto(TABLE).values(AdvInfo.getMap(advInfo)).execute();
		return count;
		
	}
	
	//更新，广告文件信息表
	@Override
	public int updateAdvInfo(Map<String, Object> advMap) {
		if (StringUtils.isEmpty(advMap.get("adid"))) {
			throw new ApIllegalParamException("adid");
		}
		int count = dbo.getUpdater().update(TABLE).where(w -> {
					   w.eq("adid", advMap.get("adid"));			  
					}).set(advMap).execute();
		return count;
	}
	
    //删除，广告文件信息表
	@Override
	public int deleteAdvInfo(String adid) { 
		 //检验
		 if (StringUtils.isEmpty(adid)) {
			 throw new ApIllegalParamException("adid");	
		 }
		 int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {w.eq("adid", adid);}).execute();
	     return count;
	}
	
	 //查询，广告文件信息表
	@Override
	public AdvInfo selectAdvInfo(String adid) {
		if (StringUtils.isEmpty(adid)) {
			throw new ApIllegalParamException("adid");
		}
		OrmSelecter<AdvInfo> ormSelecter = ormOper.getOrmSelecter(AdvInfo.class);
		AdvInfo advInfo = ormSelecter.where(w ->{
			w.setAdId(adid);
		}).fetchOne();
		return advInfo;	
	}

	//插入，广告发布表
	@Override
	public int insertDevAdv(DevAdv devAdv) {
		//检验
		if (StringUtils.isEmpty(devAdv)) {
			throw new ApIllegalParamException("devAdv");
		}	
		int count = dbo.getInserter().insertInto(TABLE1).values(DevAdv.getMap(devAdv)).execute();
		return count;
	}

	//查询，广告文件信息表
	@Override
	public DevAdv selectDevAdv(String devid, String adtempid) {
		//校验
		if (StringUtils.isEmpty(devid)) {
			throw new ApIllegalParamException("devid");
		}else if(StringUtils.isEmpty(adtempid)) {
			throw new ApIllegalParamException("adtempid");
		}	
		//查询
		OrmSelecter<DevAdv> ormSelecter = ormOper.getOrmSelecter(DevAdv.class);
		DevAdv devAdv = ormSelecter.where(w -> {
			w.setDevId(devid);
			w.setAdTempId(adtempid);
		}).fetchOne();
		return devAdv;
	}
	
	//根据设备id查询广告
	@Override
	public DevAdv getDevAdvByDevid(String devid) {
		OrmSelecter<DevAdv> ormSelecter = ormOper.getOrmSelecter(DevAdv.class);
		DevAdv devAdv = ormSelecter.where(w ->{
    		w.setDevId(devid);
    	}).fetchOne();
    	return devAdv;
	}
	
    // 删除,广告发布表
	@Override
	public int deleteDevAdv(String devid) {
		 //检验
		 if (StringUtils.isEmpty(devid)) {
			 throw new ApIllegalParamException("devid");	
		 }
		 int count = dbo.getDeleter().deleteFrom(TABLE1) .where(w -> { w.eq("devid", devid);  }).execute();
	     return count;
	}
	//根据adid查询广告模板
	@Override
	public AdvMod selectAdvmodByAdid(String adid) {
		//校验
		if (StringUtils.isEmpty(adid)) {
			throw new ApIllegalParamException("adid");
		}
		//查询
		OrmSelecter<AdvMod> ormSelecter = ormOper.getOrmSelecter(AdvMod.class);
		AdvMod advMod = ormSelecter.where(w -> {w.setAdid(adid);}).fetchOne();
		return advMod;
	}

	//根据广告模板编号查询广告发布表
	@Override
	public DevAdv queryAdvByAdtempid(String adtempid) {
		return ormOper.getOrmSelecter(DevAdv.class).where(w ->{
    		w.setAdTempId(adtempid);
    	}).fetchOne();
	}

	@Override
	public AdvMod selectAdvmodByAdtempid(String adtempid) {
		//校验
		if (StringUtils.isEmpty(adtempid)) {
			throw new ApIllegalParamException("adtempid");
		}
		//查询
		OrmSelecter<AdvMod> ormSelecter = ormOper.getOrmSelecter(AdvMod.class);
		AdvMod advMod = ormSelecter.where(w -> {w.setAdtempid(adtempid);}).fetchOne();
		return advMod;
	}

	

	

}
