package cn.com.agree.huanan.ap.al.csicop.mbs.reserved.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csicop.mbs.reserved.po.MbsReservedInfo;

/**
 * 微网点预约登记表dao层
 * 
 * @author xuzhen
 *
 */
public interface MbsReservedInfoDao {

	/**
	 * 向微网点预约登记表中插入预约信息
	 * 
	 * @param mbsReservedInfo
	 *            预约信息
	 * @return
	 */
	Integer insert(Map<String, Object> mbsReservedInfo);

	/**
	 * 查询交易明细信息
	 * 
	 * @param tradedate
	 *            申请交易日期
	 * @param serialno
	 *            申请交易流水号
	 * @param appnumber
	 *            申请编号
	 * @return
	 */
	MbsReservedInfo findMbsReservedInfo(String tradedate, String serialno, String appnumber);

	/**
	 * 登记表概要信息查询
	 * 
	 * @param operphone
	 *            经办人手机号
	 * @param tradedate
	 *            申请起始日期
	 * @param edtradedate
	 *            申请截止日期
	 * @param appnumber
	 *            申请编号
	 * @param tobrno
	 *            开户网点
	 * @param applytp
	 *            申请类型
	 * @param operidno
	 *            证件号码
	 * @param status
	 *            状态
	 * @param lockedtellerno
	 *            锁定柜员号
	 * @return
	 */
	List<Map<String, Object>> findInfoList(String operphone, String sttradedate, String edtradedate, String appnumber,
			String tobrno, String operidno, String status, String lockedtellerno);

	/**
	 * 根据交易流水号和申请日期更新预约信息
	 * 
	 * @param serialNo
	 *            申请交易流水号
	 * @param tradeDate
	 *            申请交易日期
	 * @param updateInfo
	 *            更新的信息
	 * @return
	 */
	int updateReservedInfo(String serialNo, String tradeDate, Map<String, Object> updateInfo);

	/**
	 * 查询待审批记录
	 * 
	 * @param status
	 *            状态
	 * @param nowDate
	 *            当前日期
	 * @param st_serialno
	 *            上一个待审批记录的流水号
	 * @return
	 */
	List<Map<String, Object>> findCheckInfo(String status, String nowDate, String st_serialno);
	
	/**
	 * 查询所有待发送集中作业的记录
	 */
	List<MbsReservedInfo> findchkInfoList();
	
	/**
	 * 柜员日终受控检查
	 * @param startDate 起始日期
	 * @param tradedate 检查日期
	 * @param tellerNo 柜员号
	 * @return
	 */
	int queryTellerCheck(String startDate,String tradedate,String tellerNo);
}
