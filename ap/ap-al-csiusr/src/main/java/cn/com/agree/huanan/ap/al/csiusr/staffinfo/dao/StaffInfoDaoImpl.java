package cn.com.agree.huanan.ap.al.csiusr.staffinfo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.staffinfo.po.StaffInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class StaffInfoDaoImpl implements StaffInfoDao{

	private static String TABLE1="csis_staffinfo";
	private static String TABLE2="csis_tellerinfo";
    public final Logger logger = Logger.getLogger(StaffInfoDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	
	@Override
	public StaffInfo queryTellerByNo(String tellerNo) {
		OrmSelecter<StaffInfo> ormSelecter = ormOper.getOrmSelecter(StaffInfo.class);
		StaffInfo staffInfo = ormSelecter.where(w ->{
    		w.setTellerNo(tellerNo);
    	}).fetchOne();
    	return staffInfo;
	}

	@Override
	public int insertStaff(StaffInfo staffInfo) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(StaffInfo.getMap(staffInfo)).execute();
//		logger.info(inserter.getSql());
		dbo.commit();
		return count;
	}

	@Override
	public int updateStaffInfo(Map<String, Object> map) {
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			logger.info("传进来的行员号："+map.get("tellerNo"));
			if (null != map.get("tellerNo") && !StringUtils.isEmpty(map.get("tellerNo"))) {
				w.eq("tellerno", map.get("tellerNo"));
			}
			})
				.set(map).execute();
		logger.info("数据库操作完更新的行数为："+count);
		return count;
	}

	//查询[行员信息生成]所需要的字段数据
	@Override
	public List<Map<String, Object>> findStaffInfoGenerate() {
		List<Map<String, Object>> result = dbo.getSelecter().select("TELLERNO as tellerno","NAME as name",
				"TELLERTYPE as tellertype","MYBANK as mybank","STATUS as status","PHONE as phone"
				).from(TABLE1).fetchAll();
		return result;
	}

	@Override
	public int updateTellerInfo(Map<String, Object> map) {
		int count = dbo.getUpdater().update(TABLE2).where(w -> {
			logger.info("传进来的行员号："+map.get("tellerNo"));
			if (null != map.get("tellerNo") && !StringUtils.isEmpty(map.get("tellerNo"))) {
				w.eq("tellerno", map.get("tellerNo"));
			}
			})
				.set(map).execute();
		logger.info("数据库操作完更新的行数为："+count);
		return count;
	}

	


}
