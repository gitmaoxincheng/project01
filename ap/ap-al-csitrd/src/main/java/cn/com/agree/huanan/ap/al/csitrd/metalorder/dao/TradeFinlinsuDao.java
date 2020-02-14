package cn.com.agree.huanan.ap.al.csitrd.metalorder.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.metalorder.po.TradeFinlinsuInfo;

public interface TradeFinlinsuDao {

	/**
	 * @summary 新增理财保险业务记录
	 * @param tradeFinlinsuInfo 理财保险业务实体
	 * @return
	 */
	public int insertTradeFinlinsuInfo(TradeFinlinsuInfo tradeFinlinsuInfo);
	
	/**
	 * 理财保险业务记录
	 * @param paramMap
	 * @return
	 */
	public int updateByDate(Map<String, Object> paramMap);
}
