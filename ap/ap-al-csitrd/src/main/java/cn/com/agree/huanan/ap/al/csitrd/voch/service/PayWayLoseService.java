package cn.com.agree.huanan.ap.al.csitrd.voch.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.voch.dao.TradeinfoDaoImpl;
import cn.com.agree.huanan.ap.al.csitrd.voch.exception.InsertTradeinfoFailException;
import cn.com.agree.huanan.ap.al.csitrd.voch.exception.UpdateTradeinfoFailException;
import cn.com.agree.huanan.ap.al.csitrd.voch.po.Tradeinfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 
 * @author HZP
 *	事故事项服务操作
 */
@Service
public class PayWayLoseService {
	/*@Autowired
	Logger logger;
	@Autowired
	TradeinfoDaoImpl tradeinfoDao;
	@Autowired DbOperator dbo;
	
	//插入数据
	public int insertTradeinfo(Tradeinfo tradeinfo) {
		logger.info("事故事项登记表开始");
		int count = tradeinfoDao.insertTradeinfo(tradeinfo);
		if(count < 1) {
			logger.error("事故事项登记表失败");
			dbo.rollback();
			logger.info("事故事项登记表失败...事务回滚");
			throw new InsertTradeinfoFailException("事故事项登记表失败");
		}
		dbo.commit();
		logger.info("事故事项登记表成功");
		return count;
	}
	
	//更新数据
	public int updateTradeinfo(Map<String, Object> paramMap) {
		logger.info("事故事项登记表开始");
		int count = tradeinfoDao.updateTradeinfo(paramMap);
		if(count < 1) {
			logger.error("事故事项登记表失败");
			dbo.rollback();
			logger.info("事故事项登记表sql语句失败...事务回滚");
			throw new UpdateTradeinfoFailException("事故事项登记表sql语句失败");
		}
		dbo.commit();
		logger.info("事故事项登记表成功");
		return count;
	}*/
}
