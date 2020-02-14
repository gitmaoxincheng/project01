package cn.com.agree.huanan.ap.al.csitrd.base.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.base.dao.TimeoutCfgDao;
import cn.com.agree.huanan.ap.al.csitrd.fina.exception.TradeRegisterException;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 超时处理服务
 * @author zhonggp
 */
@Service
public class TimeOutService {

	@Autowired 
	TimeoutCfgDao timeoutCfgDao;
	@Autowired
	private Logger logger;
	@Autowired DbOperator dbo;
	
	public Map<String ,Object> queryTimeOut(String pageflag, String maxnum, String begdate, String endate, Map<String,Object> map) {

		Map<String ,Object> rspMap = timeoutCfgDao.queryTimeOut(pageflag,  maxnum,  begdate,  endate, map);
		
		if((long)rspMap.get("rowcnt") == 0) {
			logger.info("查询无记录");
			throw new ApSelectNotFoundException("超时配置信息");
		}
		return rspMap;
	}

	/**
	 * 查询超时交易配置表
	 * @param svccode	外部服务码
	 * @param scncode	外部场景码
	 * @return
	 */
	public Map<String,Object>  queryTimeoutCfg(String svccode,String scncode) {
		Map<String,Object> map = timeoutCfgDao.queryTrantype(svccode, scncode);
		if(map.size() == 0) {
			logger.info("查询超时配置表无记录");
			throw new ApSelectNotFoundException("超时配置信息");
		}
		logger.info("查询超时配置表结束");
		return map;
	}

	/**
	 * 查询交易登记表
	 * @param string
	 */
	public Map<String,Object>  queryTimeoutRegister(String tradeDate, String serialNo) {
		logger.info("查询交易类型开始");
		Map<String,Object> map = timeoutCfgDao.TimeoutRegister(tradeDate, serialNo);
		if(map.size() == 0) {
			logger.info("查询超时登记表无记录");
			throw new ApSelectNotFoundException("超时配置信息");
		}
		logger.info("查询交易类型结束");
		return map;
	}

	/**
	 *更新交易对应登记簿
	 * @param tradeDate		
	 * @param serialNo
	 * @param tableName
	 * @param paramMap
	 */
	public void updateTradeTable(String tradeDate, String serialNo, String tableName, Map<String, Object> paramMap) {
		logger.info("更新超时交易登记簿开始");
		long count = timeoutCfgDao.updateTradeTable(tradeDate,  serialNo,  tableName,  paramMap);
		if (count == 1) {
			dbo.commit();
			logger.info("更新超时交易登记簿成功");
		} else {
			dbo.rollback();
			logger.info("更新超时交易登记簿失败");
			throw new TradeRegisterException("更新超时交易登记簿失败");
		}
		logger.info("更新超时交易登记簿结束");
		
	}

	/**
	 * 查询子表返回所有该流水号的全部子交易
	 * @param serialNo
	 */
	public List<Map<String,Object>> querySignSub(String serialNo) {

		List<Map<String,Object>> list = timeoutCfgDao.querySignSub(serialNo);
		if(list == null) {
			logger.info("查询子表无记录");
			throw new ApSelectNotFoundException("子交易信息");
		}
		logger.info("查询子表结束");
		return list;
	}


	/**
	 * 查询交易渠道编码和交易状态
	 * @param tradeDate	交易日期
	 * @param serialNo	交易流水
	 * @param mainTable	交易所登记的表
	 */
	public Map<String,Object> queryTableCalcod(String tradeDate, String serialNo, String mainTable) {
		logger.info("查询交易渠道编码开始");
		Map<String,Object> map = timeoutCfgDao.queryTableCalcod(tradeDate,  serialNo,  mainTable);
		if(map.size() == 0) {
			logger.info("查询交易渠道编码无记录");
			throw new ApSelectNotFoundException("交易渠道编码");
		}
		logger.info("查询交易渠道编码结束");
		return map;
	}

	

	
	
}
