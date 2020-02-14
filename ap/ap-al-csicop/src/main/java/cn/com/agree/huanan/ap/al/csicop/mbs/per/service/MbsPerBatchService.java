package cn.com.agree.huanan.ap.al.csicop.mbs.per.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.per.dao.MbsPerBatchDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 批量开户个人信息采集表Service层
 * 
 * @author guyulong
 *
 */

@Service
public class MbsPerBatchService {
	@Autowired
	private MbsPerBatchDao mbsPerBatchDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 批量开户个人信息采集
	 * 
	 * @param infoMap
	 *            采集的信息
	 * @return
	 */
	public void insertInfo(Map<String, Object> batchMap) {
		logger.info("批量开户个人信息采集");
		int count = mbsPerBatchDao.insertInfo(batchMap);
		if (count != 1) {
			logger.info("批量开户个人信息采集失败");
			dbo.rollback();
			throw new InsertException("批量开户个人信息采集失败");
		}
		dbo.commit();
	}
}
