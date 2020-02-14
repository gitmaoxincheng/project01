package cn.com.agree.huanan.ap.al.csitrd.mide.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.agree.huanan.ap.al.csitrd.fina.exception.TradeModificationException;
import cn.com.agree.huanan.ap.al.csitrd.fina.exception.TradeRegisterException;
import cn.com.agree.huanan.ap.al.csitrd.mide.dao.TuitionPaymentDao;
import cn.com.agree.huanan.ap.al.csitrd.mide.po.IntermediateMain;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class TuitionPaymentService {
	@Autowired 
	TuitionPaymentDao tuitionPaymentDao;
	@Autowired
	Logger logger;
	@Autowired 
	DbOperator dbo;
	
	/**
	 * chents
	 * 保存信息到特色业务表
	 * @Date 2019-08-13
	 * 
	 * */
	public int insertIntermediateMain(IntermediateMain intermediateMain) {
		
		logger.info("保存到特色业务表开始la");
		int count = tuitionPaymentDao.insertIntermediateMain(intermediateMain);
		logger.info("count:"+count);
		if(count < 1) {
			logger.error("保存到特色业务表失败");
			dbo.rollback();
			throw new TradeRegisterException("保存到特色业务表异常");
		}
		dbo.commit();
		logger.info("提交");
		return count;
		
	}
	/**
	 * 更新特色业务表
	 * @Date 2019-08-14
	 * 
	 * */
	public int upddateIntermediateMain(Map<String, Object> paramMap) {
		
		logger.info("更新特色业务表开始");
		int count = tuitionPaymentDao.updateIntermediateMain(paramMap);
		logger.info("count:"+count);
		if(count < 1) {
			logger.error("更新特色业务表失败");
			dbo.rollback();
			throw new TradeModificationException("更新特色业务表异常");
		}
		dbo.commit();
		logger.info("提交");
		return count;
		
	}
	
	
}
