package cn.com.agree.huanan.ap.al.csitrd.rtmh.service;

import java.util.HashMap; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.dao.TradeRtmhDao;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.exception.InsertInfoException;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.exception.UpdateInfoException;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RTMHTradInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

public class RtmhTradFlowService {

	@Autowired RTMHTradInfo rtmhTradInfo;
	@Autowired TradeRtmhDao tradeRtmhDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	
	/**
	 * @summary 登记其他P(微网点，自助、回单、排第机)交易流水表
	 * @param AppHeader  请求头
	 * @param CsisHeader 
	 * @param Headrt
	 * @param appBody
	 * @param serialno	流水号
	 * @param sceneCode 内部场景码
	 * @return
	 */
	public void addRTMHTradInfo(Map<String,Object> rtmhInfo) {
		logger.info("登记账号回单信息开始");
		int count = tradeRtmhDao.insertTradeRtmhInfo(rtmhInfo);
		if(count != 1) {
			dbo.rollback();
			logger.info("新增账单信息失败！");
			throw new InsertInfoException("新增账单信息失败！");
		}
		dbo.commit();		
		logger.info("登记账单信息结束");
	}
		
	//更新数据
	public void changeRTMHTradInfo(Map<String, Object> map) {
		logger.info("更新账单信息开始");
		int count = tradeRtmhDao.updateTradeRtmhInfo(map);
		if(count != 1) {
			dbo.rollback();
			logger.info("更新数据失败！");
			throw new UpdateInfoException("更新数据失败！");
		}
		dbo.commit();
		logger.info("更新账单信息结束！");
	}
	
}
