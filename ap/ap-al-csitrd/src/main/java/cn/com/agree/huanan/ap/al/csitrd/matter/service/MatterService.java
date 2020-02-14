package cn.com.agree.huanan.ap.al.csitrd.matter.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.matter.dao.MatterDaoImpl;
import cn.com.agree.huanan.ap.al.csitrd.matter.po.Matter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 
 * @author Maoxc
 *	事故事项服务操作
 */
@Service
public class MatterService {
	@Autowired
	Logger logger;
	@Autowired
	MatterDaoImpl matterDao;
	@Autowired DbOperator dbo;
	
	//插入数据
	public int insertMatter(Matter matter) {
		logger.info("事故事项登记表开始");
		int count = matterDao.insertMatter(matter);
		if(count < 1) {
			logger.error("事故事项登记表失败");
			dbo.rollback();
			throw new ApInsertFailException("事故事项登记表失败");
		}
		dbo.commit();
		logger.info("事故事项登记表插入成功");
		return count;
	}
	
	//更新数据
	public int updateMatter(Map<String, Object> paramMap) {
		logger.info("事故事项登记表开始");
		int count = matterDao.updateMatter(paramMap);
		if(count < 1) {
			logger.error("事故事项登记表失败");
			dbo.rollback();
			throw new ApUpdateFailException("事故事项登记表更新失败");
		}
		dbo.commit();
		logger.info("事故事项登记表更新成功");
		return count;
	}
}
