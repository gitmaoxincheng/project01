package cn.com.agree.huanan.ap.rl.bank.trade.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.rl.bank.trade.dao.TableDao;
import cn.com.agree.huanan.ap.rl.bank.trade.dao.TimeOutCfgDao;
import cn.com.agree.huanan.ap.rl.bank.trade.dao.TimeOutFlowDao;
import cn.com.agree.huanan.ap.rl.bank.trade.dao.TradeFlowDao;
import cn.com.agree.huanan.ap.rl.bank.trade.exception.ApNotSupportExptDeal;
import cn.com.agree.huanan.ap.rl.bank.trade.po.TimeOutCfg;
import cn.com.agree.huanan.ap.rl.bank.trade.po.TimeOutFlow;
import cn.com.agree.huanan.ap.rl.bank.trade.po.TradeFlow;
import cn.com.agree.huanan.ap.tl.exception.busi.ApDataExistException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApNullArgsException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author HCP 操作类 平台交易流水， 超时，异常交易相关回查，处理业务层
 */
@Component
public class TradeFlowService {
	@Autowired
	private Logger logger;
	@Autowired
	private TradeFlowDao tradeFlowDao;
	@Autowired
	private TimeOutCfgDao timeOutCfgDao;
	@Autowired
	private TimeOutFlowDao timeOutFlowDao;
	@Autowired
	private TableDao tableDao;

	/**
	 * XXX 待进一步完善 插入请求流水记录
	 * 
	 * @param tradeFlow
	 */
	public void addTradeFlow(TradeFlow tradeFlow) {
		if (StringUtils.isEmpty(tradeFlow.getReqSerialNo())) {
			throw new ApNullArgsException("请求流水号");
		}
		if (StringUtils.isEmpty(tradeFlow.getGloSeqNo())) {
			throw new ApNullArgsException("全局流水号");
		}
		if (StringUtils.isEmpty(tradeFlow.getReqSysId())) {
			throw new ApNullArgsException("渠道系统标识");
		}
		int count = tradeFlowDao.insertTradeFlow(tradeFlow);
		if (count < 1) {
			logger.error("登记渠道交易流水失败,SysId:%s,GloSeqNo:%s,ReqNo:%s", tradeFlow.getSrcSysId(),
					tradeFlow.getGloSeqNo(), tradeFlow.getReqSerialNo());
		}
		logger.info("登记渠道交易流水成功,SysId:%s,GloSeqNo:%s,ReqNo:%s", tradeFlow.getSrcSysId(), tradeFlow.getGloSeqNo(),
				tradeFlow.getReqSerialNo());
	}

	public void updateTradeFlow(String reqSysId, String reqSerialNo, String status, String errorCode, String errorMsg,
			int totTime) {
		if (StringUtils.isEmpty(reqSerialNo) || StringUtils.isEmpty(reqSysId)) {
			throw new ApNullArgsException("请求流水号或系统标识");
		}
		if (StringUtils.isEmpty(status)) {
			throw new ApNullArgsException("状态码");
		}
		if (StringUtils.isEmpty(errorCode)) {
			throw new ApNullArgsException("错误码");
		}
		if (StringUtils.isEmpty(errorMsg)) {
			// throw new NullArgsException("错误信息");
			errorMsg = "错误信息未返回";
		}

		if (errorMsg.length() > 500) {
			logger.info("错误信息超长，截取前500位字符");
			errorMsg = errorMsg.substring(0, 500);
		}

		int count = tradeFlowDao.updateTradeFlow(reqSysId, reqSerialNo, status, errorCode, errorMsg, totTime);
		if (count < 1) {
			logger.error("更新渠道交易流水失败,SysId:%s,SeriNo:%s", reqSysId, reqSerialNo);
			throw new ApUpdateFailException("渠道交易流水", "SeriNo:" + reqSerialNo);
		}
		logger.info("更新渠道交易流水成功,SysId:%s,SeriNo:%s", reqSysId, reqSerialNo);
	}

	/**
	 * XXX 待进一步完善 插入请求流水记录
	 * 
	 * @param tradeFlow
	 */
	/*
	 * public void updateTradeFlow(TradeFlow tradeFlow){
	 * 
	 * int count= tradeFlowDao.updateTradeFlow(tradeFlow.getReqSerialNo(),tradeFlow.
	 * getReqSerialNo(),
	 * tradeFlow.getRespSts(),tradeFlow.getErrorCode(),tradeFlow.getErrorMsg(),
	 * tradeFlow.getTottime()); if (count < 1 ) {
	 * logger.error("更新渠道交易流水失败,SysId:%s,GloSeqNo:%s,SeriNo:%",tradeFlow.getSrcSysId
	 * (),tradeFlow.getGloSeqNo(),tradeFlow.getSerialNo()); }
	 * logger.info("更新渠道交易流水成功,SysId:%s,GloSeqNo:%s,SeriNo:%",tradeFlow.getSrcSysId(
	 * ),tradeFlow.getGloSeqNo(),tradeFlow.getSerialNo()); }
	 */

	/**
	 * 添加超时交易流水信息
	 * 
	 * @param timeOutFlow 超时流水信息
	 */
	public void addTimeOut(TimeOutFlow timeOutFlow) {
		if (StringUtils.isEmpty(timeOutFlow.getReqSerialNo())) {
			throw new ApNullArgsException("请求流水号");
		}
		if (StringUtils.isEmpty(timeOutFlow.getGloSeqNo())) {
			throw new ApNullArgsException("全局流水号");
		}
		if (StringUtils.isEmpty(timeOutFlow.getReqSysId())) {
			throw new ApNullArgsException("渠道系统标识");
		}
		int count = timeOutFlowDao.insertTimeOut(timeOutFlow);
		if (count < 1) {
			logger.error("登记渠道交易流水失败,SysId:%s,GloSeqNo:%s,ReqNo:%s", timeOutFlow.getSrcSysId(),timeOutFlow.getGloSeqNo(), timeOutFlow.getReqSerialNo());
		}
		logger.info("登记渠道交易流水成功,SysId:%s,GloSeqNo:%s,ReqNo:%s", timeOutFlow.getSrcSysId(),timeOutFlow.getGloSeqNo(), timeOutFlow.getReqSerialNo());
	}

	/**
	 * 更新超时交易流水信息
	 */
	public void updateTimeOut(String reqSysId, String reqSerialNo, String status, String errorCode, String errorMsg,
			int totTime) {
		if (StringUtils.isEmpty(reqSerialNo) || StringUtils.isEmpty(reqSysId)) {
			throw new ApNullArgsException("请求流水号或系统标识");
		}
		if (StringUtils.isEmpty(status)) {
			throw new ApNullArgsException("状态码");
		}
		if (StringUtils.isEmpty(errorCode)) {
			throw new ApNullArgsException("错误码");
		}
		if (StringUtils.isEmpty(errorMsg)) {
			// throw new NullArgsException("错误信息");
			errorMsg = "错误信息未返回";
		}
		if (errorMsg.getBytes().length > 512) {
			logger.info("错误信息超长，截取前512位字节");
			errorMsg = errorMsg.substring(0, 512);
		}

		int count = timeOutFlowDao.updateTimeOut(reqSysId, reqSerialNo, status, errorCode, errorMsg, totTime);
		if (count < 1) {
			logger.error("更新超时交易流水失败,SysId:%s,SeriNo:%s", reqSysId, reqSerialNo);
			throw new ApUpdateFailException("超时交易流水", "SeriNo:" + reqSerialNo);
		}
		logger.info("更新超时交易流水成功,SysId:%s,SeriNo:%s", reqSysId, reqSerialNo);

	}

	/**
	 * 查询超时交易配置信息
	 * 
	 * @param trancode
	 */
	public TimeOutCfg queryTradeCfg(String trancode) {
		if (StringUtils.isEmpty(trancode)) {
			throw new ApNullArgsException("交易码");
		}
		return timeOutCfgDao.queryTimeout(trancode);
	}

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
	public Map<String, Object> queryTimeOutFlow(String pageFlag, String maxNum, String begDate,String endDate, String sysId,String tellerNo, String brNo, String billNo){

		if (StringUtils.isEmpty(begDate)) {
			throw new ApNullArgsException("起始日期");
		}
		if (StringUtils.isEmpty(sysId)) {
			throw new ApNullArgsException("系统标识");
		}
		int page = Integer.parseInt(pageFlag);
		int pageSize = Integer.parseInt(maxNum);
		List<Map<String, Object>> dataList = timeOutFlowDao.selectTimeOutFlow(page, pageSize, begDate, endDate,sysId,tellerNo, brNo, billNo);
		if (dataList.isEmpty()) {
			logger.info("查询无记录");
			throw new ApSelectNotFoundException("交易流水");
		}
		// 返回记录数
		int listnm = dataList.size();
		Map<String, Object> result = new HashMap<>();
		result.put("detail_list", dataList);
		result.put("listnm", listnm);
//		result.put("rowcnt", rowcnt); //该接口考虑数据量与使用场景，不返回总记录数
		return result;
	}

	/**
	 * 查询流水信息和需要调取的服务
	 * 
	 * @param reqserialno 请求方流水号
	 * @param reqdate 请求方日期
	 * @param reqSysId  系统标识
	 * @return 单条超时流水
	 */
	public Map<String, Object> queryTimeOutFlow(String reqSerialNo, String reqDate, String reqSysId) {
		Map<String, Object> tradeFlow = timeOutFlowDao.selectTimeOutFlow(reqSerialNo, reqDate,reqSysId);
		if (tradeFlow.isEmpty()) {
			logger.error("无此流水：%s",reqSerialNo);
			throw new ApSelectNotFoundException("超时交易流水");
		}
		return tradeFlow;
	}


	/**
	 * 查询超时配置信息
	 * @param tradeCode 交易码
	 * @return 配置信息
	 */
	public TimeOutCfg queryTimeOutCfg(String tradeCode) {
		logger.info("查询超时交易配置");
		TimeOutCfg cfgInfo = timeOutCfgDao.queryTimeout(tradeCode);
		if (cfgInfo == null) {
			logger.error("超时配置查询无记录");
			throw new ApNotSupportExptDeal(tradeCode);
		}
		return cfgInfo;
	}

	
	/**
	 * 超时处理信息
	 * @param reqserialno 请求方流水号
	 * @param reqdate 请求方日期
	 * @param reqSysId  系统标识
	 * @param tradeCode 交易码
	 * @return 交易状态信息
	 */
	public Map<String, Object> queryRegistInfo( String mainTable,String subTable,String serialNo,String tradeDate) {
		//查询登记簿
		//1、查询登记簿，几个主要关键要素
		String[] columns = {"respsts","errorcode","errormsg"};
		String[] whereCols = {"serialno","tradedate"};
		String[] values = {tradeDate,serialNo};
		Map<String, Object> record = tableDao.selectColumns(mainTable, columns, whereCols, values);
		if (record.isEmpty()) {
			logger.error("交易登记簿流水查询为空");
			throw new ApSelectNotFoundException("交易登记流水");
		}
		Map<String, Object> result = new HashMap<>();
		result.put("tradedate", tradeDate);
		result.put("serialno", serialNo);
		result.put("status", record.get("respsts"));
		result.put("errorcode", record.get("errorcode"));
		result.put("errormsg",  record.get("errormsg"));
		return result;
	}
	
	
	/**
	 * 超时处理信息
	 * @param reqserialno 请求方流水号
	 * @param reqdate 请求方日期
	 * @param reqSysId  系统标识
	 * @param tradeCode 交易码
	 * @return 交易状态信息
	 */
	public Map<String, Object> dealTimeOutFlow( String reqdate, String reqSysId,String tradeCode,String reqSerialNo,String serialNo) {
		logger.info("查询流水信息");
//		Map<String, Object> codeMap = TimeOutCfg.getMap(timeOutCfgDao.queryTimeout(tradeCode));
		TimeOutCfg cfgInfo = timeOutCfgDao.queryTimeout(tradeCode);
		
		if (cfgInfo == null) {
			logger.error("超时配置查询无记录");
			throw new ApNotSupportExptDeal(tradeCode);
		}
		//查询登记簿
		String mainTable = cfgInfo.getMainTable();
		String subTable = cfgInfo.getSubTable();
		String tradeType = cfgInfo.getTradeType();
		String toSvcCode = cfgInfo.getToSvcCode();
		String toScnCode = cfgInfo.getToScnCode();
		//1、查询登记簿，几个主要关键要素
		String[] columns = {};
		String[] whereCols = {};
		String[] values = {};
		Map<String, Object> record = tableDao.selectColumns(mainTable, columns, whereCols, values);
		
		if (record.isEmpty()) {
			logger.error("登记簿未查询到该交易流水:%s");			
			throw new ApDataExistException("交易登记流水");
		}
		//1、根据交易类型判断处理逻辑 本地类的，涉及后台交易的，组合的 
/*		String status = (String) record.get("status");
		switch (status) {	//处理中的状态还需要仔细思考
			case "F":// 处理中
					break;
			case "S":// 未知
				break;
			default:;
		}
		Map<String, Object> result = new HashMap<>();
		if ("F".equals(status) || "S".equals(status)) {
			result.put("tradedate", record.get("tradedate"));
			result.put("serialno", serialNo);
			result.put("status", record.get("respsts"));
			result.put("errorcode", record.get("errorcode"));
			result.put("errormsg",  record.get("errormsg"));
			return result;
		}
		if ("1".equals(tradeType)) {}
			//查询后台交易状态*/
		Map<String, Object> result = new HashMap<>();
		result.put("tradedate", record.get("tradedate"));
		result.put("serialno", serialNo);
		result.put("status", record.get("respsts"));
		result.put("errorcode", record.get("errorcode"));
		result.put("errormsg",  record.get("errormsg"));
		return result;
	}

	/**
	 * 更新渠道主表
	 * @param serialno
	 * @param tradedate
	 * @param tname
	 * @param infomap
	 */
	public void updateTable(String tableName,String  serialNo,String  tradeDate,String  status,String  errorCode,String  errorMsg){
		int count = tableDao.updateTable(tableName, serialNo, tradeDate, status, errorCode, errorMsg);
		if (count != 1) {
			logger.error("更新登记簿交易状态失败：%s",tableName);
			throw new ApUpdateFailException("交易登记流水");
		}
	}


}
