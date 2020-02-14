package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.StatisticslInfo;

public interface RtmhStatisticsServiceDao {

	
	/**
	 *  交易信息登记
	 * @param 
	 * @return 
	 */
	public int dealInfoInsert(StatisticslInfo statisticslInfo);
	
	

	/**
	 * 根据流水号代码查询订单信息
	 * @param serialno 回单流水
	 * @return 回单信息
	 */
	public StatisticslInfo selectStatistics(String sq_commitserno, String channelserno, String printdate, String printtime, String deviceip, 
												String deviceno, String printno, String acctno, String tardeno, String tellerno, 
												String tradename, String branch, String note1);
	
	
	
	/**
	 * 根据流水号代码查询订单信息
	 * @param serialno 回单流水
	 * @return 回单信息
	 */
	public StatisticslInfo queryStatistics(String channelserno, String printdate, String printtime, String deviceip, 
												String deviceno, String printno, String acctno, String tardeno, String tellerno, 
												String tradename, String branch, String note1);
	
	
}
