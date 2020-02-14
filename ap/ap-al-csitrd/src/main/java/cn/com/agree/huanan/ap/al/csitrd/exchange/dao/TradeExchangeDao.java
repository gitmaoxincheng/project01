package cn.com.agree.huanan.ap.al.csitrd.exchange.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.exchange.po.TradeExchangeInfo;

public interface TradeExchangeDao {

	/**
	 * @summary 新增外汇业务记录
	 * @param tradeExchangeInfo 外汇业务实体类
	 * @return
	 */
	public int insertTradeExchangeInfo(TradeExchangeInfo tradeExchangeInfo);
	
	/**
	 * 修改外汇业务记录
	 * @param map 
	 * @return
	 */
	public int updateTradeExchangeInfo(Map<String,Object> paramMap);
}
