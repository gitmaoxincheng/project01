package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.TradeInfoImageMain;

public interface TradeInfoImageMainDao {

	/**
	 * 登记到影像登记簿
	 * */
	public int insertTradeInfoImageMain(TradeInfoImageMain tradeInfoImageMain);
	
	/**
	 * 更新到影像登记簿
	 * */
	public int updateTradeInfoImageMain(Map<String, Object> paramMap);
}
