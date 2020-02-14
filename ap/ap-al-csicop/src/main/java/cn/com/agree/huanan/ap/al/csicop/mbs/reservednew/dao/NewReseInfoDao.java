package cn.com.agree.huanan.ap.al.csicop.mbs.reservednew.dao;

import java.util.List;
import java.util.Map;

/**
 * 微网点预约登记新表dao层
 * 
 * @author xuzhen
 *
 */
public interface NewReseInfoDao {

	/**
	 * 向微网点预约登记新表中插入预约信息
	 * 
	 * @param newReseInfo
	 *            预约信息
	 * @return
	 */
	Integer insert(Map<String, Object> newReseInfo);

	/**
	 * 查询预约详细信息
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param appnumber
	 *            申请编号
	 * @param tradedate
	 *            申请日期
	 * @return 流水号和申请编号
	 */
	Map<String, Object> findReseInfo(String serialno, String appnumber, String tradedate);

	/**
	 * 概要信息查询
	 * 
	 * @param operphone
	 *            经办人手机号
	 * @param sttradedate
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
	 * @return 预约信息列表
	 */
	List<Map<String, Object>> findInfoList(String operphone, String sttradedate, String edtradedate, String appnumber,
			String tobrno, String applytp, String operidno, String status, String lockedtellerno);

	/**
	 * 更新预约信息
	 * 
	 * @param serialNo
	 *            申请交易流水号
	 * @param appNumber
	 *            申请编号
	 * @param tradeDate
	 *            申请交易日期
	 * @param updateInfo
	 *            更新的信息
	 * @return
	 */
	int updateReseInfo(String serialNo, String appNumber, String tradeDate, Map<String, Object> updateInfo);

	/**
	 * 修改具体预填单业务的状态
	 * 
	 * @param appserialno
	 *            申请交易流水号
	 * @param appnumber
	 *            申请编号
	 * @param apptradedate
	 *            申请日期
	 * @param transt
	 *            状态
	 * @return
	 */
	String updateStatus(String appserialno, String appnumber, String apptradedate, String transt);

	/**
	 * 通过审批状态和当前日期查询所有记录
	 * 
	 * @param status
	 *            审批状态
	 * @param nowdate
	 *            当前日期
	 * @param appnumber
	 *            申请编号
	 * @return
	 */
	List<Map<String, Object>> findApproveList(String status, String nowdate, String appnumber);

	/**
	 * 查询所有即将失效和已失效一天的记录
	 * 
	 * @param befExpiry
	 *            即将失效日期
	 * @param aftExpiry
	 *            失效日期后一天
	 * @param appnumber
	 *            上一条待审批记录的申请编号
	 * @return
	 */
	List<Map<String, Object>> findNoteInform(String befExpiry, String aftExpiry, String appnumber);

	/**
	 * 更新所有过期状态
	 * 
	 * @param nowDate
	 *            当前日期
	 * @return
	 */
	int updApplyIsVal(String nowDate);
}
