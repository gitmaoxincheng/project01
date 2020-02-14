package cn.com.agree.huanan.ap.al.csitrd.cheq.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.cheq.dao.ChequeDetailDao;
import cn.com.agree.huanan.ap.al.csitrd.cheq.po.ChequeDetail;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 支票业务登记簿service
 * @author lanshaojun
 *
 */
@Service
public class ChequeDetailService {
	@Autowired DbOperator dbOperator;
	@Autowired ChequeDetailDao chequeDetailDao;
	private Logger logger = Logger.getLogger(ChequeDetailService.class);
	
	/**
	 * 插入支票业务登记簿
	 * @param chequeDetail 支票业务登记簿bean
	 * @return 操作状态
	 */
	public int insertChequeDetail(ChequeDetail chequeDetail) {
		logger.info("开始支票业务登记！");
		int count = chequeDetailDao.insertChequeDetail(chequeDetail);
		if(count == 0) {
			dbOperator.rollback();
			logger.error("插入 支票业务登记簿失败！");
			throw new ApInsertFailException("支票业务");
		}
		dbOperator.commit();
		logger.info("支票业务登记完成！");
		return count;
	}
	
	/**
	 * 更新支票业务登记簿
	 * @param paramMap 核心返回值map
	 * @return 操作状态
	 */
	public int updateChequeDetail(Map<String, Object> paramMap) {
		logger.info("开始支票业务更新！");
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		int count = chequeDetailDao.updateChequeDetail(paramMap);
		if(count == 0) {
			dbOperator.rollback();
			logger.error("更新支票业务登记簿失败！");
			throw new ApUpdateFailException("支票业务");
		}
		dbOperator.commit();
		logger.info("支票业务更新完成！");
		return count;
	}

	/**
	 * 根据任务号获取支票业务数据
	 * @param taskId 任务号
	 * @return ChequeDetail 支票业务数据
	 */
	public Map<String, Object> getChequeDetailByTaskId(String taskId) {
		// TODO 自动生成的方法存根

		//检验参数
		if (null == taskId || StringUtils.isEmpty(taskId)) {
			throw new ApIllegalParamException("taskId");	
		}
		
		ChequeDetail chequeDetail = chequeDetailDao.getChequeDetailByTaskId(taskId);
		
		if(null == chequeDetail) {
			logger.error("任务号为"+taskId+"的支票交易无查询数据");
			throw new ApSelectNotFoundException("任务号为"+taskId+"的支票交易");
		}
		return ChequeDetail.getMap(chequeDetail);
	}

	/**
	 * 根据平台交易日期和流水获取支票业务数据
	 * @param tradedate 平台交易日期
	 * @param serialno 平台交易流水
	 * @return ChequeDetail 支票业务数据
	 */
	public Map<String, Object> queryChequeDetail(String tradedate, String serialno) {
		// TODO 自动生成的方法存根
		//检验参数
		if (null == tradedate || StringUtils.isEmpty(tradedate)) {
			throw new ApIllegalParamException("tradedate");	
		}
		if (null == serialno || StringUtils.isEmpty(serialno)) {
			throw new ApIllegalParamException("serialno");	
		}
		
		ChequeDetail chequeDetail = chequeDetailDao.queryChequeDetail(tradedate, serialno);
		
		if(null == chequeDetail) {
			logger.error("交易日期"+tradedate+",流水"+serialno+"的支票交易无查询数据");
			throw new ApSelectNotFoundException("交易日期"+tradedate+",流水"+serialno+"的支票交易");
		}
		return ChequeDetail.getMap(chequeDetail);
	}

	/**
	 * 根据平台交易日期和流水获取支票业务数据状态为02-待提交或04-已退回的数据
	 * @param tradedate 平台交易日期
	 * @param serialno 平台交易流水
	 * @return 判断结果
	 */
	public Map<String, Object> queryChequeDetail02or04(String tradedate, String serialno) {
		// TODO 自动生成的方法存根
		//检验参数
		if (null == tradedate || StringUtils.isEmpty(tradedate)) {
			throw new ApIllegalParamException("tradedate");	
		}
		if (null == serialno || StringUtils.isEmpty(serialno)) {
			throw new ApIllegalParamException("serialno");	
		}
		ChequeDetail chequeDetail02 = chequeDetailDao.queryChequeDetail(tradedate, serialno, "02");
		
		if(null == chequeDetail02) {
			ChequeDetail chequeDetail04 = chequeDetailDao.queryChequeDetail(tradedate, serialno, "04");
			if(null == chequeDetail04) {
				logger.error("交易日期"+tradedate+",流水"+serialno+"的支票交易数据在状态02和04下无查询数据");
				throw new ApSelectNotFoundException("交易日期"+tradedate+",流水"+serialno+"的支票交易数据在状态02和04下");
			}
			return ChequeDetail.getMap(chequeDetail04);
		}
		return ChequeDetail.getMap(chequeDetail02);
	}

	/**
	 * 根据平台交易日期和流水获取支票业务数据状态为传入值的数据
	 * @param tradedate 平台交易日期
	 * @param serialno 平台交易流水
	 * @param status 状态
	 * @return 判断结果
	 */
	public Map<String, Object> queryChequeDetail(String tradedate, String serialno, String status) {
		// TODO 自动生成的方法存根
		//检验参数
		if (null == tradedate || StringUtils.isEmpty(tradedate)) {
			throw new ApIllegalParamException("tradedate");	
		}
		if (null == serialno || StringUtils.isEmpty(serialno)) {
			throw new ApIllegalParamException("serialno");	
		}
		if (null == status || StringUtils.isEmpty(status)) {
			throw new ApIllegalParamException("status");	
		}
		ChequeDetail chequeDetail = chequeDetailDao.queryChequeDetail(tradedate, serialno, status);
		if(null == chequeDetail) {
			logger.error("交易日期"+tradedate+",流水"+serialno+"的支票交易数据在状态"+status+"下无查询数据");
			throw new ApSelectNotFoundException("交易日期"+tradedate+",流水"+serialno+"的支票交易在状态"+status+"下");
		}
		return ChequeDetail.getMap(chequeDetail);
	}

	/**
	 * 根据任务号查询支票业务信息
	 * @param cnttaskid 任务号
	 * @return 支付结算业务信息
	 */
	public Map<String,Object> queryChequeDetailByCnttaskid(String cnttaskid) {
		logger.info("根据任务号获取支票业务数据开始");
		ChequeDetail chequeDetail = chequeDetailDao.queryChequeDetailByCnttaskid(cnttaskid);
		if(null == chequeDetail) {
			throw new ApSelectNotFoundException("该任务号下支票业务数据");
		}
		logger.info("根据任务号获取支票业务数据结束");
		return ChequeDetail.getMap(chequeDetail);
	}
}
