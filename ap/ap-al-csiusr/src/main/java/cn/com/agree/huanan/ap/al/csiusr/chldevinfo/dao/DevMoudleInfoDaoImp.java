package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevModuleInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
@Component
public class DevMoudleInfoDaoImp implements DevMoudleInfoDao {
	private static String TABLE="csis_channel_moduleinfo";
	@Autowired DbOperator dbo;	
	@Autowired OrmOperator ormOper;	
	
	@Override
	public DevModuleInfo queryModuleinfoByID(String devmodulenum) {
		return ormOper.getOrmSelecter(DevModuleInfo.class).where(w -> {
			w.setDevmodulenum(devmodulenum);
		}).fetchOne();
	}

	@Override
	public int addModuleinfo(DevModuleInfo devModule) {
		return dbo.getInserter().insertInto(TABLE).values(DevModuleInfo.getMap(devModule)).execute();
	}

	@Override
	public int updataModuleinfo(DevModuleInfo devModule) {
		return dbo.getUpdater().set(DevModuleInfo.getMap(devModule)).update(TABLE).where(w -> {
			w.eq("DEVMODULENUM", devModule.getDevmodulenum());
		}).execute();
	}

	@Override
	public int deleteModuleinfo(String devmodulenum) {
		return dbo.getDeleter().deleteFrom(TABLE).where(w -> {
			w.eq("DEVMODULENUM", devmodulenum);
		}).execute();
	}

}
