package cn.com.agree.huanan.ap.al.csitrd.dpst.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.dpst.dao.TradeinfoDepositDao;
import cn.com.agree.huanan.ap.al.csitrd.dpst.po.TraInfoDpst;
import cn.com.agree.huanan.ap.al.csitrd.fina.exception.TradeRegisterException;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 存款类业务服务层
 *	@author Hzp
 */
@Service
public class TradeinfoDepositService {
	@Autowired Logger logger;
	@Autowired TradeinfoDepositDao tradeinfoDepositDao;
	@Autowired DbOperator dbo;
	/**
	 * 登记-存款业务登记簿
	 * @param traInfoDpst
	 */
	public int TradeinfoDeposit_Insert(TraInfoDpst traInfoDpst) {
		logger.info("登记-存款业务登记簿start");
		int count = tradeinfoDepositDao.insertTraInfoDpst(traInfoDpst);
		if(count < 1) {
			logger.error("登记-存款业务登记簿失败");
			dbo.rollback();
			logger.info("登记-存款业务登记簿失败...事务回滚");
			throw new TradeRegisterException("登记-存款业务登记簿失败");
		}
		dbo.commit();
		logger.info("登记-存款业务登记簿end");
		return count;
	}
	
	/**
	 * 更新-存款业务登记簿
	 * @param traInfoDpst
	 */
	public int TradeinfoDeposit_Update(Map<String, Object> paramMap) {
		logger.info("更新-存款业务登记簿start");
		int count = tradeinfoDepositDao.updateTraInfoDpst(paramMap);
		if(count < 1) {
			logger.error("更新-存款业务登记簿失败");
			dbo.rollback();
			logger.info("更新-存款业务登记簿失败...事务回滚");
			throw new TradeRegisterException("更新-存款业务登记簿失败");
		}
		dbo.commit();
		logger.info("更新-存款业务登记簿end");
		return count;
	}
}
