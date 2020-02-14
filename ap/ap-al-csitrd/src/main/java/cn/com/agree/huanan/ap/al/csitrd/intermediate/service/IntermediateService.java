package cn.com.agree.huanan.ap.al.csitrd.intermediate.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.intermediate.dao.IntermediateDao;
import cn.com.agree.huanan.ap.al.csitrd.intermediate.exception.IntermediateInfoAddException;
import cn.com.agree.huanan.ap.al.csitrd.intermediate.exception.IntermediateInfoUpdateException;
import cn.com.agree.huanan.ap.al.csitrd.intermediate.po.IntermediateInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 特色业务登记服务层 
 * @author bodadmin
 *
 */
@Service
public class IntermediateService {

	@Autowired Logger logger;
	@Autowired IntermediateDao intermediateDao;
	@Autowired DbOperator dbo;
	
	/**
	 * 登记特色业务记录入库
	 * @param intermediateInfo
	 */
	public int insertTradeinfo(IntermediateInfo intermediateInfo) {
		logger.info("登记到特色业务登记簿start");
		int count = intermediateDao.insertIntermediateInfo(intermediateInfo);
		if(count != 1) {
			logger.info("登记特色业务记录失败!");
			dbo.rollback();
			throw new IntermediateInfoAddException("登记特色业务记录失败!");
		}
		dbo.commit();
		logger.info("登记到特色业务登记簿end");
		return count;
	}
	
	/**
	 * 登记特色业务记录入库修改
	 * @param intermediateInfo
	 */
	public int updateIntermediateInfo(Map<String,Object> paramMap) {
		logger.info("修改特色业务登记簿start");
		int count = intermediateDao.updateIntermediateInfo(paramMap);
		if(count != 1) {
			dbo.rollback();
			logger.info("修改特色业务信息失败!");
			throw new IntermediateInfoUpdateException("修改特色业务记录失败!");
		}
		dbo.commit();		
		logger.info("修改特色业务登记簿end");
		return count;
	}
}
