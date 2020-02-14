package cn.com.agree.huanan.ap.rl.bank.trade.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.rl.bank.trade.po.TimeOutFlow;

public interface TimeOutFlowDao {
	/**
	 * 更新超时流水表
	 */
	public int updateTimeOut(String reqSysId, String reqSerialNo, String status, String errorCode, String errorMsg,
			int totTime);

	/**
	 * 插入超时登记表
	 */
	public int insertTimeOut(TimeOutFlow tradeTimeout);


	/**
	 * 根据条件查询超时流水列表
	 * @param pageFlag 页码
	 * @param maxNum 单页大小
	 * @param begDate  起始日期
	 * @param endDate  结束日志
	 * @param tellerNo 柜员号
	 * @param brNo	   机构号
	 * @param billNo   单据号
	 * @return	流水信息列表
	 */
	public List<Map<String, Object>> selectTimeOutFlow(int page, int pageSize,  String begDate, String endDate, String sysId, String billNo,String tellerNo,String brNo);

	/**
	 *
	 * @param reqserialno 请求流水
	 * @param reqdate 请求日期
	 * @param reqSysId 请求渠道
	 * @return
	 */
	Map<String, Object> selectTimeOutFlow(String reqserialno, String reqdate,String reqSysId);
}
