package cn.com.agree.huanan.ap.al.csitrd.cidt.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.cidt.po.TradeMessageInfo;

public interface TradeMessageInfoDao {

	/**
	 * 更新信息
	 * @param paramMap
	 * @return
	 */
	public int updateByDate(Map<String, Object> paramMap);
	
   /**
 	 * 保存信息入库
 	 * @param tradeMessageInfo
 	 * @return
 	 */
     public int insertTradeMessageInfo(TradeMessageInfo tradeMessageInfo);
}
