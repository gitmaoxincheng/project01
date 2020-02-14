package cn.com.agree.huanan.ap.al.csitrd.cidt.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.cidt.dao.TradeMessageInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.cidt.exception.TradeMessageInfoUpdateFailException;
import cn.com.agree.huanan.ap.al.csitrd.cidt.po.TradeMessageInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 消息通知登记服务层
 */
@Service
public class TradeMessageInfoService {

	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired TradeMessageInfoDao tradeMessageInfoDao;
	
	/**
	 * 更新信息
	 * @param paramMap
	 * @return
	 */
	public int updateTradeMessageInfo(Map<String, Object> paramMap) {
		
		logger.info("消息通知登记更新接口开始"+paramMap);
		int count = tradeMessageInfoDao.updateByDate(paramMap);
		if(count < 1) {
			logger.error("消息通知登记更新失败");
			dbo.rollback();
			throw new TradeMessageInfoUpdateFailException("消息通知登记更新失败");
		}
		dbo.commit();
		
		return count;
	}
	
   /**
 	 * 保存信息入库
 	 * @param tradeMessageInfo
 	 * @return
 	 */
     public int insertTradeMessageInfo(TradeMessageInfo tradeMessageInfo) {
    	 
    	 logger.info("消息通知登记保存接口开始");
    	 logger.info("tradeMessageInfo"+tradeMessageInfo.toString());
 		int count = tradeMessageInfoDao.insertTradeMessageInfo(tradeMessageInfo);
 		if(count != 1) {
 			logger.error("消息通知登记保存失败");
 			dbo.rollback();
 			throw new TradeMessageInfoUpdateFailException("消息通知登记保存失败");
 		}
 		dbo.commit();
 		
 		return count;
     }
}
