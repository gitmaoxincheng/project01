package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RTMHTradInfo;


public interface TradeRtmhDao {

	/**
	 * 新增账单信息
	 * @param rtmhTradInfo 签约信息实体类
	 * @return 
	 */
	int insertTradeRtmhInfo(Map<String,Object> rtmhInfo);
	
	
	/**
	 * 修改账单信息
	 * @param map 账单信息实体类
	 * @return
	 */
	int updateTradeRtmhInfo(Map<String,Object> map);
	
}
