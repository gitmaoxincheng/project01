package cn.com.agree.huanan.ap.al.csitrd.device.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.device.dao.TradeDeviceDao;
import cn.com.agree.huanan.ap.al.csitrd.device.exception.TradeDeviceInfoAddException;
import cn.com.agree.huanan.ap.al.csitrd.device.exception.TradeDeviceInfoUpdateException;
import cn.com.agree.huanan.ap.al.csitrd.device.po.TradeDeviceInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 设备信息登记簿服务层 
 * @author bodadmin
 *
 */
@Service
public class TradeDeviceService {

	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired TradeDeviceDao tradeDeviceDao;
	
	/**
	 * 登记设备信息记录入库
	 * @param tradeDeviceInfo
	 */
	public void insertTradeinfo(TradeDeviceInfo tradeDeviceInfo) {
		logger.info("登记到设备信息登记簿start");
		int count = tradeDeviceDao.insertTradeDeviceInfo(tradeDeviceInfo);
		if(count != 1) {
			logger.info("登记设备信息记录失败!");
			dbo.rollback();
			throw new TradeDeviceInfoAddException("登记设备信息记录失败!");
		}
		dbo.commit();
		logger.info("登记到设备信息登记簿end");
	}
	
	/**
	 * 登记设备信息记录入库修改
	 * @param 
	 */
	public void updateTradeDeviceInfo(Map<String,Object> map) {
		logger.info("修改设备信息登记簿start");
		int count = tradeDeviceDao.updateTradeDeviceInfo(map);
		if(count != 1) {
			dbo.rollback();
			logger.info("修改设备信息信息失败!");
			throw new TradeDeviceInfoUpdateException("修改设备信息记录失败!");
		}
		dbo.commit();		
		logger.info("修改设备信息登记簿end");
	}
}
