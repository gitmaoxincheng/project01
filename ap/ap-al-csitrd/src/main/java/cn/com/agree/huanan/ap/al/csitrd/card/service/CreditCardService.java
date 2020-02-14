package cn.com.agree.huanan.ap.al.csitrd.card.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.card.dao.CreditCardDao;
import cn.com.agree.huanan.ap.al.csitrd.card.po.Trainfomain;
import cn.com.agree.huanan.ap.al.csitrd.fina.exception.TradeRegisterException;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class CreditCardService {


	@Autowired
	Logger logger;
	@Autowired
	CreditCardDao creditCardDao;
	@Autowired DbOperator dbo;
	

	/**
	 * 信用卡密码申请/重置登记
	 * @param Trainfomain 
	 */
	public void insertCreCardPwAppRes(Trainfomain trainfomain) {
		logger.info("信用卡密码申请/重置登记开始");
		int count=creditCardDao.getCreditCardInsert(trainfomain);
		if (count == 1) {
			dbo.commit();
			logger.info("信用卡密码申请/重置登记成功");
		} else {
			dbo.rollback();
			logger.info("信用卡密码申请/重置登记失败");
			throw new TradeRegisterException("信用卡密码申请/重置登记失败");
		}
		logger.info("信用卡密码申请/重置登记结束");
	}
	
	/**
	 * 信用卡密码申请/重置更新
	 * @param Map
	 */
	public void updateCreCardPwAppRes(Map<String, Object> paramMap) {
		logger.info("信用卡密码申请/重置更新开始");
		int count=creditCardDao.getCreditCardUpdate(paramMap);
		if (count == 1) {
			dbo.commit();
			logger.info("信用卡密码申请/重置更新成功");
		} else {
			dbo.rollback();
			logger.info("信用卡密码申请/重置更新失败");
			throw new TradeRegisterException("信用卡密码申请/重置更新失败");
		}
		logger.info("信用卡密码申请/重置更新结束");
	}
	
	/**
	 * 信用卡领卡登记
	 * @param Trainfomain 
	 */
	public void insertGetCreditCard(Trainfomain trainfomain) {
		logger.info("信用卡领卡登记开始");
		int count=creditCardDao.getCreditCardInsert(trainfomain);
		if (count == 1) {
			dbo.commit();
			logger.info("信用卡领卡登记成功");
		} else {
			dbo.rollback();
			logger.info("信用卡领卡登记失败");
			throw new TradeRegisterException("信用卡领卡登记失败");
		}
		logger.info("信用卡领卡登记结束");
	}
	/**
	 * 信用卡领卡更新
	 * @param Map
	 */
	public void updateGetCreditCard(Map<String, Object> paramMap) {
		logger.info("信用卡领卡更新开始");
		int count=creditCardDao.getCreditCardUpdate(paramMap);
		if (count == 1) {
			dbo.commit();
			logger.info("信用卡领卡更新成功");
		} else {
			dbo.rollback();
			logger.info("信用卡领卡更新失败");
			throw new TradeRegisterException("信用卡领卡更新失败");
		}
		logger.info("信用卡领卡更新结束");
	}
	
	/**
	 * 信用卡激活登记
	 * @param Trainfomain 
	 */
	public void insertActivateCreditCard(Trainfomain trainfomain) {
		logger.info("信用卡激活登记开始");
		int count=creditCardDao.getCreditCardInsert(trainfomain);
		if (count == 1) {
			dbo.commit();
			logger.info("信用卡激活登记成功");
		} else {
			dbo.rollback();
			logger.info("信用卡激活登记失败");
			throw new TradeRegisterException("信用卡激活登记失败");
		}
		logger.info("信用卡激活登记结束");
	}
	/**
	 * 信用卡激活更新
	 * @param Map
	 */
	public void updateActivateCreditCard(Map<String, Object> paramMap) {
		logger.info("信用卡激活更新开始");
		int count=creditCardDao.getCreditCardUpdate(paramMap);
		if (count == 1) {
			dbo.commit();
			logger.info("信用卡激活更新成功");
		} else {
			dbo.rollback();
			logger.info("信用卡激活更新失败");
			throw new TradeRegisterException("信用卡激活更新失败");
		}
		logger.info("信用卡激活更新结束");
	}
	
}
