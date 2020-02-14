package cn.com.agree.huanan.ap.al.csitrd.percust.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.percust.dao.PerCustSubDao;
import cn.com.agree.huanan.ap.al.csitrd.percust.po.PerCustSub;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 个人客户信息登记簿子表service
 * @author czp
 *
 */
@Service
public class PerCustSubService {
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired PerCustSubDao perCustSubDao;
		
	// 插入
	public int addPerCustSub(PerCustSub perCustSub) {
		logger.info("开始插入数据");
 		int count = perCustSubDao.insertPerCustSub(perCustSub);
 		if(count < 1) {
 			logger.error("插入数据失败");
 			dbo.rollback();
 			throw new ApInsertFailException("个人客户信息登记簿子表,插入数据失败");
 		}
 		dbo.commit();
 		logger.error("插入数据成功");
 		return count;
	}
	
	// 更新
	public int changePerCustSub(Map<String, Object> paramMap) {
		logger.info("开始更新数据");
		int count = perCustSubDao.updatePerCustSub(paramMap);
		if(count < 1) {
			logger.error("更新失败");
			dbo.rollback();
			throw new ApUpdateFailException("个人客户信息登记簿子表更新失败");
		}	
		dbo.commit();
		logger.error("更新成功");
		return count;
	}
	
	
	
}
