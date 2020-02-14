package cn.com.agree.huanan.ap.rl.bank.trade.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.service.exception.SerNoRepeatedException;
import cn.com.agree.huanan.ap.rl.bank.trade.po.TradeFlow;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.exception.tech.ApDbExecuteException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 平台交易流水表数据操作层
 * 
 * @author HCP
 */
@Component
public class TradeFlowDaoImpl implements TradeFlowDao {

	// @Autowired private OrmOperator ormOperator;
	@Autowired
	private DbOperator dbOperator;
	@Autowired
	private Logger logger;
	private static String TABLE = "CSIS_TRADE_FLOW";

	/**
	 * 查询服务调度关系
	 * 
	 * @param serviceId
	 *            服务标识
	 * @param srcSvc
	 *            消费方服务码
	 * @param srcScn
	 *            消费方场景码
	 * @return
	 */
	public int insertTradeFlow(TradeFlow tradeFlow) {
		// OrmUpdater<TradeFlow> ormUpdater =
		// ormOperator.getOrmUpdater(TradeFlow.class);
		Inserter inserter = dbOperator.getInserter();
		int count = 0;
		try {
			count = inserter.insertInto(TABLE).values(TradeFlow.getMap(tradeFlow)).execute();
		} catch (ApDbExecuteException e) {
			if (e.getCause() instanceof SQLIntegrityConstraintViolationException) { // 判断是否为主键冲突异常
				logger.error("发生主键冲突异常");
				throw new SerNoRepeatedException(tradeFlow.getReqSysId(), tradeFlow.getReqSerialNo()); // 主键冲突异常，流水号重复
			} else {
				logger.error("插入请求流水异常:%s", tradeFlow.getReqSerialNo());
				throw new ApDbExecuteException(e);
			}
		}
		return count;

	}

	/**
	 * 更新渠道交易流水
	 */
	@Override
	public int updateTradeFlow(String reqSysId, String reqSerialNo, String status, String errorCode, String errorMsg,
			int totTime) {
		Updater updater = dbOperator.getUpdater().update(TABLE).set("respsts", status).set("errorcode", errorCode)
				.set("errormsg", errorMsg).set("tottime", totTime)
				// .set("upddate",updDate) //添加了耗时字段，更新时间，更新日期字段废弃
				// .set("updtime",updTime)
				.where(w -> {
					w.eq("reqserialno", reqSerialNo);
					w.eq("reqsysId", reqSysId);
				});
		return updater.execute();
	}

	/** 查询一条流水信息 */
	@Override
	public Map<String, Object> findFlow(String reqserialno, String reqdate, String svccode, String scncode) {
		return dbOperator.getSelecter().select("reqserialno as oriserialno", "reqdate as oritradedate", "tradedate",
				"serialno", "respsts as status", "tottime").from(TABLE).where(w -> {
					w.eq("reqserialno", reqserialno);
					w.eq("reqdate", reqdate);
					w.eq("svccode", svccode);
					w.eq("scncode", scncode);
				}).fetchOne();
	}
}
