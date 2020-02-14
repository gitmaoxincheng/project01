package cn.com.agree.huanan.ap.al.csitrd.amgt.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.amgt.dao.CustInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.amgt.exception.InsertCustInfoFailException;
import cn.com.agree.huanan.ap.al.csitrd.amgt.exception.UpdateCustInfoFailException;
import cn.com.agree.huanan.ap.al.csitrd.amgt.po.CustInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 个人客户信息簿service
 * @author Maoxc
 *
 */
@Service
public class CustInfoService {
//	@Autowired DbOperator dbo;
//	@Autowired Logger logger;
//	@Autowired CustInfoDao custInfoDao;
//	
//	
//	/**
//	 * 插入数据
//	 * @param custInfo
//	 * @return
//	 */
//	public int addCustInfo(CustInfo custInfo) {
//		logger.info("开始插入数据");
// 		int count = custInfoDao.insertCustInfo(custInfo);
// 		if(count < 1) {
// 			logger.error("插入数据失败");
// 			dbo.rollback();
// 			throw new InsertCustInfoFailException("个人客户信息簿,插入数据失败");
// 		}
// 		dbo.commit();
// 		logger.error("插入数据成功");
// 		return count;
//	}
//
//	/**
//	 * 更新数据
//	 * @param paramMap
//	 * @return
//	 */
//	public int changeCustInfo(Map<String, Object> paramMap) {
//		logger.info("开始更新数据");
//		int count = custInfoDao.updateCustInfo(paramMap);
//		if(count < 1) {
//			logger.error("更新失败");
//			dbo.rollback();
//			throw new UpdateCustInfoFailException("消息通知登记更新失败");
//		}	
//		dbo.commit();
//		logger.error("更新成功");
//		return count;
//	}

	
}
