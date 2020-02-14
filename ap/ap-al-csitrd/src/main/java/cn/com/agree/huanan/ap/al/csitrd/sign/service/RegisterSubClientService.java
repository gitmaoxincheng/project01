package cn.com.agree.huanan.ap.al.csitrd.sign.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.sign.dao.ToSubClientDao;
import cn.com.agree.huanan.ap.al.csitrd.sign.exception.TradeSignInfoAddException;
import cn.com.agree.huanan.ap.al.csitrd.sign.exception.TradeSignInfoUpdateException;
import cn.com.agree.huanan.ap.al.csitrd.sign.po.ToSubClient;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 对公客户信息登记簿子表服务层
 * @author maowei
 *
 */
@Service
public class RegisterSubClientService {
	@Autowired Logger logger;
	@Autowired ToSubClientDao tosubClientDao;
	@Autowired DbOperator dbo;
	
	//插入数据
	public void addSubClientInfo(ToSubClient tosubClient) {
		logger.info("登记对公客户信息登记簿子表开始");	
		int count = tosubClientDao.insertSubClientInfo(tosubClient);
		if( count !=1 ) {
			dbo.rollback();
			logger.info("对公客户信息登记簿子表失败！");
			throw new TradeSignInfoAddException("登记对公客户信息登记簿子表失败！");
		}
		dbo.commit();		
		logger.info("登记对对公客户信息登记簿子表成功");
	}

	public void changeSubClientInfo(Map<String,Object> map ) {
		logger.info("更新对公客户信息登记簿子表开始");		
		int count = tosubClientDao.updateSubClientInfo(map);		
		if(count != 1) {
			dbo.rollback();
			logger.info("更新对公客户信息登记簿子表失败!");	
			throw new TradeSignInfoUpdateException("更新对公客户信息登记簿子表失败！");
		}
		dbo.commit();		
		logger.info("更新对公客户信息登记簿子表成功");
	}
}
