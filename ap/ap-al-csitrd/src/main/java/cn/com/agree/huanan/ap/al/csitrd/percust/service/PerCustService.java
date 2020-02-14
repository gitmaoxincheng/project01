package cn.com.agree.huanan.ap.al.csitrd.percust.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.percust.dao.PerCustDao;
import cn.com.agree.huanan.ap.al.csitrd.percust.po.PerCust;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 个人客户信息簿service
 * @author Maoxc
 *
 */
@Service
public class PerCustService {
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired PerCustDao perCustDao;
		
	// 插入
	public int addPerCust(PerCust perCust) {
		logger.info("开始插入数据");
 		int count = perCustDao.insertPerCust(perCust);
 		if(count < 1) {
 			logger.error("插入数据失败");
 			dbo.rollback();
 			throw new ApInsertFailException("个人客户信息簿,插入数据失败");
 		}
 		dbo.commit();
 		logger.error("插入数据成功");
 		return count;
	}
	
	// 更新
	public int changePerCust(Map<String, Object> paramMap) {
		logger.info("开始更新数据");
		int count = perCustDao.updatePerCust(paramMap);
		if(count < 1) {
			logger.error("更新失败");
			dbo.rollback();
			throw new ApUpdateFailException("个人客户信息簿更新失败");
		}	
		dbo.commit();
		logger.error("更新成功");
		return count;
	}
	
	
	
}
