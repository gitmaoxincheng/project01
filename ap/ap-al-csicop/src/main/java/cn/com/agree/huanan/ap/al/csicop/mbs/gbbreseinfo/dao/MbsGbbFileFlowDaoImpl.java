package cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 文件处理流水表Dao实现层
 * 
 * @author guyulong
 */
@Component
public class MbsGbbFileFlowDaoImpl implements MbsGbbFileFlowDao {
	private static String TABLE = "CSIS_MBS_GBB_FILE_FLOW";

	@Autowired
	private DbOperator dbo;

	/** 查询当天文件是否有处理 */
	@Override
	public int findFilepathCount(String filedate) {
		return (int) dbo.getSelecter().from(TABLE).where(w -> {
			w.eq("filedate", filedate);
		}).count();
	}

	/** 插入当天记录 */
	@Override
	public int insertFilepath(Map<String, Object> filepathInfo) {
		return dbo.getInserter().insertInto(TABLE).values(filepathInfo).execute();
	}

	/** 查询十天内的记录 */
	@Override
	public List<Map<String, Object>> findFilepath(String filedate, String fileendate) {
		return dbo.getSelecter().select("filepath", "filedate").from(TABLE).where(w -> {
			w.op("filedate", "<=", filedate);
			w.op("filedate", ">=", fileendate);
			w.in("stat", "0", "3");
		}).fetchAll();
	}

	/** 更新文件记录信息 */
	@Override
	public int updateFilepath(String filedate, Map<String, Object> updateInfo) {
		return dbo.getUpdater().update(TABLE).set(updateInfo).where(w -> {
			w.eq("filedate", filedate);
		}).execute();
	}
}
