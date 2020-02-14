package cn.com.agree.huanan.ap.al.csitrd.device.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.device.po.TradeDeviceInfo;

public interface TradeDeviceDao {

	/**
	 * @summary 新增设备信息记录
	 * @param tradeDeviceInfo 设备信息实体类
	 * @return
	 */
	public int insertTradeDeviceInfo(TradeDeviceInfo tradeDeviceInfo);
	
	/**
	 * 修改设备信息记录
	 * @param map 
	 * @return
	 */
	public int updateTradeDeviceInfo(Map<String,Object> paramMap);
}
