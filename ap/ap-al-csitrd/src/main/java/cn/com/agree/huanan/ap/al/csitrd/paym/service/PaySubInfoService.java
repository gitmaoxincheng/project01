package cn.com.agree.huanan.ap.al.csitrd.paym.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.paym.dao.PaySubInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.paym.exception.TradePayInfoAddFailException;
import cn.com.agree.huanan.ap.al.csitrd.paym.po.PaySubInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 *  支付结算业务子表 服务层
 * @author ZS
 *
 */
@Service
public class PaySubInfoService {

	@Autowired Logger logger;
	@Autowired PaySubInfoDao paySubInfoDao;
	@Autowired DbOperator dbo;

	//插入数据
	public void addPaySubInfo(PaySubInfo paySubInfo) {
		logger.info("登记支付结算业务子信息开始");	
		int count = paySubInfoDao.insertPaySubInfo(paySubInfo);
		if(count!=1) {

			throw new TradePayInfoAddFailException("新增失败!");
		}
		dbo.commit();		
		logger.info("登记支付结算业务子信息结束");

	}
	
	// 更新数据
	public void changePaySubInfo(Map<String,Object> map ) {
		logger.info("更新支付结算业务子信息开始");		
		int count = paySubInfoDao.updatePaySubInfo(map);	
		if(count != 1) {
			dbo.rollback();
			logger.info("更新支付结算业务子信息失败!");		
		}
		dbo.commit();		
		logger.info("更新支付结算业务子信息结束");
	}
}
