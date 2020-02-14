package cn.com.agree.huanan.ap.al.csitrd.paym.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.paym.dao.PayInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.paym.dao.TradeClearInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.paym.exception.TradePayInfoAddFailException;
import cn.com.agree.huanan.ap.al.csitrd.paym.exception.TradePayInfoUpdateFailException;
import cn.com.agree.huanan.ap.al.csitrd.paym.po.TradeClearInfo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 收支清分登记簿 服务层
 * @author ZS
 *
 */
@Service
public class TradeClearInfoService {
	
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired TradeClearInfoDao tradeClearInfoDao;
	@Autowired PayInfoDao payInfoDao;
	
	/**
	 * 新增收支清分登记簿信息
	 * @param payInfo
	 * @return
	 */
	public int addTradeClearInfo(TradeClearInfo tradeClearInfo) {
		
		logger.info("开始插入收支清分登记簿信息");
		int count = tradeClearInfoDao.insertTradeClearInfo(tradeClearInfo);
		if(count != 1) {
			dbo.rollback();
			throw new TradePayInfoAddFailException("收支清分登记簿保存失败异常");
		}
		dbo.commit();
		logger.info("插入收支清分登记簿信息结束");
		return count;
	}
	
	/**
	 * 更新收支清分登记簿信息
	 * @param paramMap 
	 * @return
	 */
	public int changeTradeClearInfo(Map<String, Object> paramMap) {
		logger.info("开始更新收支清分登记簿信息");
		int count = tradeClearInfoDao.updateTradeClearInfo(paramMap);
		if(count != 1) {
			dbo.rollback();
			throw new TradePayInfoUpdateFailException("收支清分登记簿更新失败异常"); 
		}
		dbo.commit();
		logger.info("更新收支清分登记簿信息结束");
		return count;
	}
	
	/**
	 * 更新收支清分状态
	 * @param status 状态
	 * @param tradeDate 交易日期
	 * @param serialNo 交易流水
	 * @return
	 */
	public int changeTradeClearStatus(String status,String tradeDate,String serialNo) {
		logger.info("更新收支清分状态开始");
		int count = tradeClearInfoDao.updateTradeClearStatus(status, tradeDate, serialNo);
		if(count != 1) {
			dbo.rollback();
			throw new ApIllegalParamException("更新收支清分状态信息失败异常");
		}
		dbo.commit();
		logger.info("更新收支清分状态结束");
		return count;
	}
	
	
	
	/**
	 * 通过法人号获取入账内部账户数据
	 * @param myBank 法人号
	 * @return
	 */
	public Map<String,Object> queryInAcct(String paracode){
		logger.info("获取入账内部账户数据开始");
		Map<String,Object> inAcct = tradeClearInfoDao.queryOutAcctNoAndName(paracode);
		if(inAcct.isEmpty()) {
			dbo.rollback();
			throw new ApIllegalParamException("该法人号"+paracode.substring(0,3)+"与币种["+paracode.substring(3)+"]与没有对应内部账户数据");
		}
		dbo.commit();
		logger.info("获取入账内部账户数据结束");
		return  inAcct;
	}
	
	/**
	 * 通过汇总日期和汇总流水查询收支清分数据
	 * @param mdcldt 汇总日期
	 * @param mdclsq 汇总流水
	 * @return
	 */
	public Map<String,Object> queryTradeClearInfo(String mdcldt,String mdclsq){
		logger.info("获取收支清分交易数据开始");
		Map<String,Object> param = tradeClearInfoDao.selectTradeClearInfo(mdcldt, mdclsq);
		if(param.isEmpty()) {
			throw new ApIllegalParamException("该汇总日期和汇总流水没有对应的总账复核成功数据");
		}
		logger.info("获取收支清分交易数据结束");
		return  param;
	}
	
	/**
	 * 通过汇总日期和汇总流水查询复核冲正异常交易数据
	 * @param mdcldt 汇总日期
	 * @param mdclsq 汇总流水
	 * @return
	 */
	public Map<String,Object> queryExceptionInfo(String coltdate,String coltserialno){
		logger.info("获取收支清分复核、冲正异常处理数据开始");
		Map<String,Object> param = tradeClearInfoDao.selectExceptionData(coltdate, coltserialno);
		if(param.isEmpty()) {
			throw new ApIllegalParamException("该汇总日期和汇总流水没有对应的收支清分复核、冲正异常处理数据");
		}
		logger.info("获取收支清分复核、冲正异常处理数据结束");
		return  param;
	}
	
	/**
	 * 查询是否有总账记账失败的记录存在
	 * @param coltdate 汇总日期
	 * @param coltserialno 汇总流水
	 * @return
	 */
	public Map<String,Object> queryIsExist(String coltdate,String coltserialno){
		logger.info("查询核心记账记录是否存在开始");
		Map<String,Object> param = tradeClearInfoDao.selectByDateAndSeri(coltdate, coltserialno);
		logger.info("查询核心记账记录是否存在结束");
		return param;
	}
	
	/**
	 * 查询复核记账的存量数据
	 * @param coltdate 汇总日期
	 * @param coltserialno 汇总流水
	 * @return
	 */
	public Map<String,Object> queryDataCheck(String coltdate,String coltserialno){
		logger.info("查询复核记账的存量数据开始");
		Map<String,Object> param = tradeClearInfoDao.selectDataCheck(coltdate, coltserialno);
		logger.info("查询复核记账的存量数据结束");
		return param;
	}
	
	/**
	 * 收支清分复核、冲正异常处理查询
	 * @param strartdate  
	 * @param enddate
	 * @param coltserialno
	 * @param pageflag
	 * @param maxnum
	 * @return 查询结果
	 */
	public Map<String,Object> queryTradeException(String strartdate,String enddate,String coltserialno,String brNo,Integer pageflag,Integer maxnum){
		logger.info("收支清分复核、冲正异常交易查询开始");
		pageflag = pageflag < 1 ? 1 : pageflag;   // 将 pageflag 的最小值设为1
		if(maxnum < 1) {
			throw new ApIllegalParamException("每页最多记录数" + maxnum + "不能小于1");
		}
		Map<String,Object> result = new HashMap<>();
		IPage<Map<String,Object>> param = tradeClearInfoDao.selectTradeExeception(strartdate, enddate, coltserialno,brNo, pageflag, maxnum);
		
		result.put("rowcnt", param.getTotal());// 总笔数
		result.put("listnm", param.getSize());// 返回记录数
		result.put("detail_list", param.getRecords());// 返回数据
		
		logger.info("收支清分复核、冲正异常交易查询结束");
		return result;
	}
	
	
}
