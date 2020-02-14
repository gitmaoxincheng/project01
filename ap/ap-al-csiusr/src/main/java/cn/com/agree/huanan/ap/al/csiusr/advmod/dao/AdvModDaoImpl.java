package cn.com.agree.huanan.ap.al.csiusr.advmod.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csiusr.advmod.po.AdvMod;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class AdvModDaoImpl implements AdvModDao {
	private static String TABLE="csis_channel_advmod";
	public final Logger logger = Logger.getLogger(AdvModDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	//向广告模板表中新增信息
	@Override
	public int addAdvMod(AdvMod advMod) {
		int count = dbo.getInserter().insertInto(TABLE).values(AdvMod.getMap(advMod)).execute();
		return count;
	}

	//修改广告模板表信息
	@Override
	public int updateAdvMod(AdvMod advMod) {
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("ADTEMPID", advMod.getAdtempid());
		}).set(AdvMod.getMap(advMod)).execute();
		return count;
	}

	//删除广告模板表信息
	@Override
	public int deleteAdvMod(String adtempid) {
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {
			w.eq("ADTEMPID", adtempid);
		}).execute();
		return count;
	}

	//根据广告模板编码查询广告模板表信息
	@Override
	public List<AdvMod> findAdvModByAdtempId(String adtempid) {
		List<AdvMod> result = ormOper.getOrmSelecter(AdvMod.class).where(w ->{
			w.setAdtempid(adtempid);
		}).fetchAll();
		return result;
	}

	//根据广告模板编码和类别查询广告模板表信息
	@Override
	public AdvMod findAdvMod(String adtempid, String type ,String adid) {
		AdvMod result = ormOper.getOrmSelecter(AdvMod.class).where(w ->{
			w.setAdtempid(adtempid);
			w.setType(type);
			w.setAdid(adid);
		}).fetchOne();
		return result;
	}

}
