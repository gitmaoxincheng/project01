package cn.com.agree.huanan.ap.al.csitrd.paym.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.paym.dao.PayInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.paym.exception.TradePayInfoAddFailException;
import cn.com.agree.huanan.ap.al.csitrd.paym.exception.TradePayInfoUpdateFailException;
import cn.com.agree.huanan.ap.al.csitrd.paym.po.PayInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 支付结算业务登记簿service
 * @author MAOW
 *
 */
@Service
public class PayInfoService {
	
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired PayInfoDao payInfoDao;
	
	/**
	 * 新增支付结算业务相关信息
	 * @param payInfo
	 * @return
	 */
	public int addPayInfo(PayInfo payInfo) {
		
		logger.info("开始插入支付结算业务信息");
		int count = payInfoDao.addPayInfo(payInfo);
		if(count != 1) {
			dbo.rollback();
			throw new TradePayInfoAddFailException("支付结算业务登记簿保存失败异常");
		}
		dbo.commit();
		logger.info("插入支付结算业务信息结束");
		return count;
	}
	
	/**
	 * 更新支付结算业务相关信息
	 * @param paramMap
	 * @return
	 */
	public int updatePayInfo(Map<String, Object> paramMap) {
		logger.info("开始更新支付结算业务信息");
		int count = payInfoDao.updatePayInfo(paramMap);
		if(count != 1) {
			dbo.rollback();
			throw new TradePayInfoUpdateFailException("支付结算业务登记簿更新失败异常"); 
		}
		dbo.commit();
		logger.info("更新支付结算业务信息结束");
		return count;
	}
	
	/**
	 * 获取支付结算业务数据
	 * @param tradeDate
	 * @param serialNo
	 * @return
	 */
	public Map<String,Object> queryPayInfo(String tradeDate,String serialNo){
		logger.info("获取支付结算交易数据开始");
		Map<String,Object> param = payInfoDao.selectPayInfo(tradeDate, serialNo);
		if(param.isEmpty()) {
			throw new ApIllegalParamException("该交易日期和交易流水没有对应的支付结算成功数据");
		}
		logger.info("获取支付结算交易数据结束");
		return  param;
	}
}
