package cn.com.agree.huanan.ap.al.csitrd.exchange.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.exchange.dao.TradeExchangeDao;
import cn.com.agree.huanan.ap.al.csitrd.exchange.exception.TradeExchangeInfoAddException;
import cn.com.agree.huanan.ap.al.csitrd.exchange.exception.TradeExchangeInfoUpdateException;
import cn.com.agree.huanan.ap.al.csitrd.exchange.po.TradeExchangeInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 外汇业务登记服务层 
 * @author bodadmin
 *
 */
@Service
public class TradeExchangeSerive {

	@Autowired Logger logger;
	@Autowired TradeExchangeDao tradeExchangeDao;
	@Autowired DbOperator dbo;
	
	/**
	 * 登记外汇业务记录入库
	 * @param tradeExchangeInfo
	 */
	public void insertTradeinfo(TradeExchangeInfo tradeExchangeInfo) {
		logger.info("登记到外汇业务登记簿start");
		int count = tradeExchangeDao.insertTradeExchangeInfo(tradeExchangeInfo);
		if(count != 1) {
			logger.info("登记外汇业务记录失败!");
			dbo.rollback();
			throw new TradeExchangeInfoAddException("登记外汇业务记录失败!");
		}
		dbo.commit();
		logger.info("登记到外汇业务登记簿end");
	}
	
	/**
	 * 登记外汇业务记录入库修改
	 * @param tradeExchangeInfo
	 */
	public void updateTradeExchangeInfo(Map<String,Object> map) {
		logger.info("修改外汇业务登记簿start");
		int count = tradeExchangeDao.updateTradeExchangeInfo(map);
		if(count != 1) {
			dbo.rollback();
			logger.info("修改外汇业务信息失败!");
			throw new TradeExchangeInfoUpdateException("修改外汇业务记录失败!");
		}
		dbo.commit();		
		logger.info("修改外汇业务登记簿end");
	}
}
