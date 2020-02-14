package cn.com.agree.huanan.ap.rl.bank.trade.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.rl.bank.service.exception.SerNoRepeatedException;
import cn.com.agree.huanan.ap.rl.bank.trade.po.TimeOutFlow;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.exception.tech.ApDbExecuteException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TimeOutFlowDaoImpl implements TimeOutFlowDao {
	private static String TABLE = "CSIS_TIMEOUT_FLOW";

	@Autowired
	private DbOperator dbOperator;
	private Logger logger;

	@Override
	public int insertTimeOut(TimeOutFlow timeOutFlow) {
		Inserter inserter = dbOperator.getInserter();
		int count = 0;
		try {
			count = inserter.insertInto(TABLE).values(TimeOutFlow.getMap(timeOutFlow)).execute();
		} catch (ApDbExecuteException e) {
			if (e.getCause() instanceof SQLIntegrityConstraintViolationException) { // 判断是否为主键冲突异常
				logger.error("发生主键冲突异常");
				throw new SerNoRepeatedException(timeOutFlow.getReqSysId(), timeOutFlow.getReqSerialNo()); // 主键冲突异常，流水号重复
			} else {
				logger.error("插入请求流水异常:%s", timeOutFlow.getReqSerialNo());
				throw new ApDbExecuteException(e);
			}
		}
		return count;
	}

	@Override
	public int updateTimeOut(String reqSysId, String reqSerialNo, String status, String errorCode, String errorMsg,
			int totTime) {
		Updater updater = dbOperator.getUpdater().update(TABLE).set("respsts", status).set("errorcode", errorCode)
				.set("errormsg", errorMsg).set("tottime", totTime).where(w -> {
					w.eq("reqserialno", reqSerialNo);
					w.eq("reqsysId", reqSysId);
				});
		return updater.execute();
	}

	@Override
	public List<Map<String, Object>> selectTimeOutFlow(int page, int pageSize, String begDate, String endDate, String sysId, String billNo,String tellerNo,String brNo){
		// 按页码查询
		// 查询返回记录
		Selecter selecter = dbOperator.getSelecter();
		List<Map<String, Object>> dataList = selecter.select("billno", "billtype", "tradedate", "serialno",
				"tradename", "reqsysid", "gloseqno", "reqserialno as reqno", "tellerno", "authtellerno",
				"mybank", "brno", "respsts as status", "svcoutcode", "scnoutcode",
				"custno","custname",   "idtype", "idno", "acctno", "oppacctno","amount").from(TABLE).where(w -> {
					// 查询条件
					if (StringUtils.isEmpty(endDate)) {
						w.op("tradeDate", ">=", begDate);
						w.op("tradeDate", "<=", endDate);
					}else {
						w.eq("tradeDate", begDate);  //起始日期不可为空
					}
					if (!StringUtils.isEmpty(tellerNo)) {
						w.eq("tellerno", tellerNo);
					}
					if (!StringUtils.isEmpty(billNo)) {
						w.eq("billno", billNo);
					}
					if (!StringUtils.isEmpty(brNo)) {
						w.eq("brno", brNo);
					}
					w.eq("sysid", sysId);//系统标识不可为空
				}).fetch((page - 1) * pageSize, pageSize);
		return dataList; //返回信息
	}

	/** 查询一条流水信息 */
	@Override
	public Map<String, Object> selectTimeOutFlow(String reqserialno, String reqdate,String reqSysId) {
		return dbOperator.getSelecter().select("gloseqno","reqserialno as reqno", "tradedate","svcoutcode", "scnoutcode",
				"serialno", "respsts as status").from(TABLE).where(w -> {
					w.eq("reqserialno", reqserialno);
					w.eq("reqdate", reqdate);
					w.eq("sysid", reqSysId);
				}).fetchOne();
	}
}
