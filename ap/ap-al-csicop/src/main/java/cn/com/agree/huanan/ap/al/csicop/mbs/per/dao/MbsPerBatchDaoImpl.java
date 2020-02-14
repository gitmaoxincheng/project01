package cn.com.agree.huanan.ap.al.csicop.mbs.per.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 批量开户个人信息采集表dao层实现类
 * 
 * @author guyulong
 *
 */
@Component
public class MbsPerBatchDaoImpl implements MbsPerBatchDao {
	private static String TABLE = "CSIS_MBS_PER_BATCH";

	@Autowired
	private DbOperator dbo;

	/** 批量开户个人信息采集 */
	@Override
	public int insertInfo(Map<String, Object> infoMap) {
		return dbo.getInserter().insertInto(TABLE).values(infoMap).execute();
	}
}
