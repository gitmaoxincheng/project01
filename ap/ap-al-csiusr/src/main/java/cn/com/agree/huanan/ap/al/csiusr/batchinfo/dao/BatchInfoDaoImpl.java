package cn.com.agree.huanan.ap.al.csiusr.batchinfo.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csiusr.batchinfo.po.BatchInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class BatchInfoDaoImpl implements BatchInfoDao {
	private static String TABLE = "csis_batch_info";
//	private static String TABLE2 = "csis_syspara";
	
	public final Logger logger = Logger.getLogger(BatchInfoDaoImpl.class);
	@Autowired DbOperator dbo;
	
	//批次流水表新增
	@Override
	public int insertTradeinfo(BatchInfo batchInfo) {
		int count = dbo.getInserter().insertInto(TABLE).values(BatchInfo.getMap(batchInfo)).execute();
		return count;
	}

	//批次流水表更新
	@Override
	public int updateTradeinfo(Map<String, Object> paramMap) {
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("BATNO", paramMap.get("batno"));
			w.eq("WORKDATE", paramMap.get("workdate"));
		}).set(paramMap).execute();
		return count;
	}

	//查询批次流水表
	@Override
	public Map<String, Object> QueryGenerateInfo(String srcsysid, String gloseqno) {
		Map<String, Object> result = dbo.getSelecter().select("STATUS as status","FILENAME as filename").from(TABLE)
				.where(w ->{
					w.eq("SRCSYSID", srcsysid);
					w.eq("GLOSEQNO", gloseqno);
				}).fetchOne();
		return result;
	}



}
