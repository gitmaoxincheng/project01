package cn.com.agree.huanan.ap.al.csitrd.rtmh.service;

import java.util.HashMap;  
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.dao.RtmhStatisticsServiceDao;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.exception.InsertInfoException;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.exception.SelectInfoException;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.StatisticslInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;



@Service
public class RtmhStatisticsService {

	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	@Autowired RtmhStatisticsServiceDao rtmhStatisticsServiceDao;
	/**
	 * 交易登记
	 * @param  
	 */
	public void insertBealInfo(StatisticslInfo statisticslInfo) {
		logger.info("交易信息统计登记开始");
		logger.info("交易信息："+statisticslInfo.toString());
		logger.info("交易统计信息："+StatisticslInfo.getMap(statisticslInfo));
		//判断交易信息是否已经存在
		StatisticslInfo resultInfo = rtmhStatisticsServiceDao.queryStatistics(statisticslInfo.getChannelSerno(), statisticslInfo.getPrintDate(), statisticslInfo.getPrintTime(), 
																statisticslInfo.getDeviceIp(), statisticslInfo.getDeviceNo(), statisticslInfo.getPrintNo(), statisticslInfo.getAcctNo(), statisticslInfo.getTardeNo(), statisticslInfo.getTellerNo(), 
																statisticslInfo.getTradeName(), statisticslInfo.getBranch(), statisticslInfo.getNote1());
		if (!StringUtils.isEmpty(resultInfo)) {
			logger.error("交易已存在，统计失败!");
			throw new SelectInfoException("交易已存在，统计失败!");
		}
		
		//新增交易信息
		int count = rtmhStatisticsServiceDao.dealInfoInsert(statisticslInfo);
		if(count != 1) {
			logger.error("交易统计失败!");
			throw new InsertInfoException("交易统计失败！");
			}
		dbo.commit();
		logger.info("交易统计成功！");
		}
	
	
	/**
	 * 查询设备信息 
	 */
	public Map<String,Object> updateBealInfo(String sq_commitserno, String channelserno, String printdate, String printtime, String deviceip, 
			     								String deviceno,String printno, String acctno, String tardeno, String tellerno, String tradename, String branch, String note1){
		
		StatisticslInfo statisticslInfo = rtmhStatisticsServiceDao.selectStatistics(sq_commitserno, channelserno, printdate, printtime,
																					deviceip, deviceno, printno, acctno, tardeno, tellerno, 
																					tradename, branch, note1);
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("sq_commitserno", statisticslInfo.getSq_Commitserno());
		resultMap.put("channelserno", statisticslInfo.getChannelSerno());
		resultMap.put("printdate", statisticslInfo.getPrintDate());
		resultMap.put("printtime", statisticslInfo.getPrintTime());
		resultMap.put("deviceip", statisticslInfo.getDeviceIp());
		resultMap.put("deviceno", statisticslInfo.getDeviceNo());
		resultMap.put("printno", statisticslInfo.getPrintNo());
		resultMap.put("acctno", statisticslInfo.getAcctNo());
		resultMap.put("tardeno", statisticslInfo.getTardeNo());
		resultMap.put("tradename", statisticslInfo.getTradeName());
		resultMap.put("branch", statisticslInfo.getBranch());
		resultMap.put("tellerno", statisticslInfo.getTellerNo());
		resultMap.put("note1", statisticslInfo.getNote1());
		
		return resultMap;
		
	}
	
	
}
