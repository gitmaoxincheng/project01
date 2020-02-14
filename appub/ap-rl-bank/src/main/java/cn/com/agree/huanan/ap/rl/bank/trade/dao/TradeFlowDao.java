package cn.com.agree.huanan.ap.rl.bank.trade.dao;


import java.util.Map;

import cn.com.agree.huanan.ap.rl.bank.trade.po.TradeFlow;

/**
 * 
 * @author HCP 超时流水操作类接口
 */
public interface TradeFlowDao {

	/**
	 * @param tradeFlow
	 *            平台交易流水信息
	 * @return 插入成功笔数
	 */
	public int insertTradeFlow(TradeFlow tradeFlow);

	public int updateTradeFlow(String reqSysId, String reqSerialNo, String status, String errorCode, String errorMsg,
			int totTime);

	/**
	 * 查询一条流水信息
	 * 
	 * @param reqserialno
	 *            请求方流水号
	 * @param reqdate
	 *            请求方日期
	 * @param svccode
	 *            服务码
	 * @param scncode
	 *            场景码
	 * @return
	 */
	Map<String, Object> findFlow(String reqserialno, String reqdate, String svccode, String scncode);
}
