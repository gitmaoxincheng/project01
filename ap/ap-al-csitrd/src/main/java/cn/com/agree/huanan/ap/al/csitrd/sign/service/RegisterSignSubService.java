package cn.com.agree.huanan.ap.al.csitrd.sign.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.sign.dao.TradeSignSubDao;
import cn.com.agree.huanan.ap.al.csitrd.sign.exception.TradeSignInfoAddException;
import cn.com.agree.huanan.ap.al.csitrd.sign.po.TradeSignSub;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;


/**
 * 签约子信息服务层 
 * @author hww
 *
 */
@Service
public class RegisterSignSubService {
	
	@Autowired Logger logger;
	@Autowired TradeSignSubDao signSubDao;
	@Autowired DbOperator dbo;
	
	//插入数据
	public void addSignSub(TradeSignSub tradeSignSub) {
		logger.info("登记签约子信息开始");	
		int count = signSubDao.insertTradeSignInfoSub(tradeSignSub);
		if(count!=1) {
			
			throw new TradeSignInfoAddException("新增失败！");
		}
		dbo.commit();		
		logger.info("登记签约子信息结束");
		
	}

	public void changeSignSub(Map<String,Object> map ) {
		logger.info("更新签约子信息开始");		
		int count = signSubDao.updateTradeSignInfoSub(map);		
		if(count != 1) {
			dbo.rollback();
			logger.info("更新签约子信息失败!");		
		}
		dbo.commit();		
		logger.info("更新签约子信息结束");
	}
}
