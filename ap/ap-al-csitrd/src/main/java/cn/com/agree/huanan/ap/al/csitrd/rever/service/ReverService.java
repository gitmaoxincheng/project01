package cn.com.agree.huanan.ap.al.csitrd.rever.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.rever.dao.ReverDaoImpl;
import cn.com.agree.huanan.ap.al.csitrd.rever.po.Rever;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 统一冲正登记簿 Service 层
 * @author ZengS
 *
 */
@Service
public class ReverService {
	@Autowired Logger logger;
	@Autowired ReverDaoImpl reverDao;
	@Autowired DbOperator dbo;
	
	//插入数据
	public int addReverMain(Rever rever) {
		logger.info("统一冲正登记表开始");
		int count = reverDao.insertReverMain(rever);
		if(count < 1) {
			logger.error("统一冲正登记表失败");
			dbo.rollback();
			throw new ApInsertFailException("统一冲正登记表失败");
		}
		dbo.commit();
		logger.info("统一冲正登记表插入成功");
		return count;
	}
	
	//更新数据
	public int changeReverMain(Map<String, Object> paramMap) {
		logger.info("统一冲正登记表开始");
		int count = reverDao.updateReverMain(paramMap);
		if(count < 1) {
			logger.error("统一冲正登记表失败");
			dbo.rollback();
			throw new ApUpdateFailException("统一冲正登记表更新失败");
		}
		dbo.commit();
		logger.info("统一冲正登记表更新成功");
		return count;
	}
}
