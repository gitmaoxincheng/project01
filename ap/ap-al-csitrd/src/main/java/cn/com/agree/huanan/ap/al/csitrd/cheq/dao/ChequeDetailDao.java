package cn.com.agree.huanan.ap.al.csitrd.cheq.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.cheq.po.ChequeDetail;

/**
 * 支票業務登记簿dao
 * @author lanshaojun
 *
 */
public interface ChequeDetailDao {

	/**
	 * 插入支票業務登记簿数据
	 * @param chequeDetail 支票業務登记簿bean
	 * @return 操作状态
	 */
	int insertChequeDetail(ChequeDetail chequeDetail);

	/**
	 * 更新支票業務登记簿数据
	 * @param paramMap 核心返回值map
	 * @return 操作状态
	 */
	int updateChequeDetail(Map<String, Object> paramMap);

	/**
	 * 根据任务号获取支票业务数据
	 * @param taskId 任务号
	 * @return ChequeDetail 支票业务数据
	 */
	ChequeDetail getChequeDetailByTaskId(String taskId);

	/**
	 * 根据平台交易日期和流水获取支票业务数据
	 * @param tradedate 平台交易日期
	 * @param serialno 平台交易流水
	 * @return ChequeDetail 支票业务数据
	 */
	ChequeDetail queryChequeDetail(String tradedate, String serialno);

	/**
	 * 根据平台交易日期和流水及状态获取支票业务数据
	 * @param tradedate 平台交易日期
	 * @param serialno 平台交易流水
	 * @param status 状态
	 * @return ChequeDetail 支票业务数据
	 */
	ChequeDetail queryChequeDetail(String tradedate, String serialno, String status);

	/**
	 * 根据任务号查询支票业务信息
	 * @param cnttaskid 任务号
	 * @return 支票业务信息
	 */
	ChequeDetail queryChequeDetailByCnttaskid(String cnttaskid);

}
