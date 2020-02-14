package cn.com.agree.huanan.ap.al.csitrd.sign.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.sign.dao.TradeSignDao;
import cn.com.agree.huanan.ap.al.csitrd.sign.exception.TradeSignInfoAddException;
import cn.com.agree.huanan.ap.al.csitrd.sign.exception.TradeSignInfoUpdateException;
import cn.com.agree.huanan.ap.al.csitrd.sign.po.TradeSignInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;


/**
 * 签约信息服务层 
 * @author Maoxc
 *
 */
@Service
public class RegisterSignService {
	
	@Autowired Logger logger;
	@Autowired TradeSignDao signDao;
	@Autowired DbOperator dbo;
	
	//插入数据
	public void addSignInfo(TradeSignInfo signInfo) {
		logger.info("登记签约信息开始");	
		int count = signDao.insertTradeSignInfo(signInfo);
		if(count!=1) {
			dbo.rollback();
			logger.info("新增签约信息失败！");
			throw new TradeSignInfoAddException("新增失败！");
		}
		dbo.commit();		
		logger.info("登记签约信息结束");
		
	}

	public void changeSignInfo(Map<String,Object> map ) {
		logger.info("更新签约信息开始");		
		int count = signDao.updateTradeSignInfo(map);		
		if(count != 1) {
			dbo.rollback();
			logger.info("更新签约信息失败!");	
			throw new TradeSignInfoUpdateException("更新签约信息失败！");
		}
		dbo.commit();		
		logger.info("更新签约信息结束");
	}
	
	/**
	 * 更新签约信息表   Maoxc
	 * @param MyMap
	 */
	public void changeSignInfoTwo(Map<String,Object> MyMap ) {
		logger.info("更新签约信息开始");	
		logger.info("@Service_MyMap"+MyMap);	
		int count = signDao.updateTradeSignInfoTwo(MyMap);		
		if(count != 1) {
			dbo.rollback();
			logger.info("更新签约信息失败!");	
			throw new TradeSignInfoUpdateException("更新签约信息失败！");
		}
		dbo.commit();		
		logger.info("更新签约信息结束");
	}
	
		/**
		 * 贷记卡还款账号信息登记
		 * @param signInfo
		 */
		public void insertAutoRepaymentAccount(TradeSignInfo signInfo) {
			logger.info("贷记卡自扣还款账号查询和维护信息登记开始");	
			int count = signDao.insertAutoRepaymentInfo(signInfo);
			if(count!=1) {
				dbo.rollback();
				logger.info("贷记卡自扣还款账号查询和维护信息登记信息失败！");
				throw new TradeSignInfoAddException("贷记卡自扣还款账号查询和维护信息登记失败");
			}
			dbo.commit();		
			logger.info("贷记卡自扣还款账号查询和维护信息登记结束");
			
		}

		/**
		 * 贷记卡还款账号信息更新
		 * @param map
		 */
		public void updateAutoRepaymentAccount(Map<String,Object> map ) {
			logger.info("贷记卡自扣还款账号查询和维护信息更新开始");		
			int count = signDao.updateAutoRepaymentInfo(map);		
			if(count != 1) {
				dbo.rollback();
				logger.info("贷记卡自扣还款账号查询和维护信息更新失败!");	
				throw new TradeSignInfoUpdateException("贷记卡自扣还款账号查询和维护信息更新失败");
			}
			dbo.commit();		
			logger.info("贷记卡自扣还款账号查询和维护信息更新结束");
		}

		
		public void changeSignInfo(TradeSignInfo tsi) {
			// TODO 自动生成的方法存根
			changeSignInfo(TradeSignInfo.getMap(tsi));
		}
		
		
		
}
