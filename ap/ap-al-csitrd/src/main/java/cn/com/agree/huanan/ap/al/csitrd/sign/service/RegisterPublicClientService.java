package cn.com.agree.huanan.ap.al.csitrd.sign.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.sign.dao.ToPublicClientDao;
import cn.com.agree.huanan.ap.al.csitrd.sign.exception.TradeSignInfoAddException;
import cn.com.agree.huanan.ap.al.csitrd.sign.exception.TradeSignInfoUpdateException;
import cn.com.agree.huanan.ap.al.csitrd.sign.po.ToPublicClient;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 对公客户信息服务层
 * @author ZS
 *
 */
@Service
public class RegisterPublicClientService {
	
	@Autowired Logger logger;
	@Autowired ToPublicClientDao toPublicClientDao;
	@Autowired DbOperator dbo;
	
	//插入数据
	public void addPublicClientInfo(ToPublicClient publicClientInfo) {
		logger.info("登记对公客户信息开始");	
		int count = toPublicClientDao.insertPublicClientInfo(publicClientInfo);
		if(count!=1) {
			dbo.rollback();
			logger.info("新增对公客户信息失败！");
			throw new TradeSignInfoAddException("新增失败！");
		}
		dbo.commit();		
		logger.info("登记对公客户信息结束");
		
	}

	public void changePublicClientInfo(Map<String,Object> map ) {
		logger.info("更新对公客户信息开始");		
		int count = toPublicClientDao.updatePublicClientInfo(map);		
		if(count != 1) {
			dbo.rollback();
			logger.info("更新对公客户信息失败!");	
			throw new TradeSignInfoUpdateException("更新对公客户信息失败！");
		}
		dbo.commit();		
		logger.info("更新对公客户信息结束");
	}
}
