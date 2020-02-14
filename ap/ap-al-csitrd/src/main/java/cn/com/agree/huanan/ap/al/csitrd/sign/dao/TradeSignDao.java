package cn.com.agree.huanan.ap.al.csitrd.sign.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.sign.po.TradeSignInfo;

public interface TradeSignDao {
	
	/**
	 * 新增签约信息
	 * @param signInfo 签约信息实体类
	 * @return 
	 */
	int insertTradeSignInfo(TradeSignInfo signInfo);
	
	/**
	 * 修改签约信息
	 * @param signInfo 签约信息实体类
	 * @return
	 */
	
	int updateTradeSignInfo(Map<String,Object> map);
	
	
	/**
	 * 修改签约信息
	 * @param map
	 * @return
	 * Maoxc
	 */
	int updateTradeSignInfoTwo(Map<String,Object> MyMap);
	/**
	 * 贷记卡自扣还款账号查询和维护信息登记
	 * @param signInfo 签约信息实体类
	 * @return 
	 */
	int insertAutoRepaymentInfo(TradeSignInfo signInfo);
	
	/**
	 * 贷记卡自扣还款账号查询和维护信息更新
	 * @param HashMap
	 * @return
	 */
	int updateAutoRepaymentInfo(Map<String,Object> map);
}
