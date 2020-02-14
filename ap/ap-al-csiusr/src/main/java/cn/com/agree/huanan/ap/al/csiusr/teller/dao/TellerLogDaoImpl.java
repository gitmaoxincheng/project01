package cn.com.agree.huanan.ap.al.csiusr.teller.dao;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerLog;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;



@Component
public class TellerLogDaoImpl implements TellerLogDao{
	private static String TABLE="csis_tellerlog";
    public final Logger logger = Logger.getLogger(TellerLogDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    
	@Override
	public List<TellerLog> queryTLByTelNoAndODate(String tellerNo, String optDate) {
		OrmSelecter<TellerLog> ormSelecter = ormOper.getOrmSelecter(TellerLog.class);
    	List<TellerLog>  list = ormSelecter.where(w ->{
    		w.setOptTellerNo(tellerNo);
    		if (!StringUtils.isEmpty(optDate)) {
				w.setOptDate(optDate);;
			}
    	}).fetchAll();
    	return list;
	}

	@Override
	public List<TellerLog> queryTLByChaTelNoAndSta(String tellerNo, String transStatus) {
		OrmSelecter<TellerLog> ormSelecter = ormOper.getOrmSelecter(TellerLog.class);
    	List<TellerLog>  list = ormSelecter.where(w ->{
    		w.setChgTellerNo(tellerNo);
    		w.setTransStatus(transStatus);
    	}).fetchAll();
    	return list;
	}

	@Override
	public int insertTellerLog(TellerLog tellerLog) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE).values(TellerLog.getMap(tellerLog)).execute();
		return count;
	}

	@Override
	public TellerLog selectTellerLog(String optdate, String serialno) {
		logger.info("-----开始查询数据-----");
		//检验参数
		if(StringUtils.isEmpty(optdate)) {
			throw new ApIllegalParamException("optdate");
		}else if(StringUtils.isEmpty(serialno)) {
			throw new ApIllegalParamException("serialno");
		}	
		OrmSelecter<TellerLog> ormSelecter = ormOper.getOrmSelecter(TellerLog.class);
		TellerLog tellerLog = ormSelecter.where(w ->{w.setOptDate(optdate);w.setSerialNo(serialno);}).fetchOne();
		logger.info("-----结束查询数据-----");
		return tellerLog;
	}

	@Override
	public int deleteTellerLogByNo(String serialNo, String optDate) {
		//检验参数
		if(StringUtils.isEmpty(optDate)) {
			throw new ApIllegalParamException("optDate");
		}else if(StringUtils.isEmpty(serialNo)) {
			throw new ApIllegalParamException("serialNo");
		}
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {w.eq("optdate", optDate);w.eq("serialno", serialNo);}).execute();
		return count;
	}

	@Override
	public TellerLog queryByOri(String srcDate, String reqNo, String sysId) {
		//检验参数
		if(StringUtils.isEmpty(srcDate)) {
			throw new ApIllegalParamException("srcDate");
		}else if(StringUtils.isEmpty(reqNo)) {
			throw new ApIllegalParamException("reqNo");
		}else if(StringUtils.isEmpty(sysId)) {
			throw new ApIllegalParamException("sysId");
		}
		logger.info("根据请求方日期%s，请求方流水%s和应用系统标识%s查询柜员操作流水", srcDate, reqNo, sysId);
		OrmSelecter<TellerLog> ormSelecter = ormOper.getOrmSelecter(TellerLog.class);
		TellerLog tellerLog = ormSelecter.where(w -> {
			w.setSrcDate(srcDate);
			w.setReqNo(reqNo);
			w.setSysId(sysId);
		}).fetchOne();
		if(tellerLog == null || TellerLog.getMap(tellerLog).isEmpty()) {
			logger.info("无相关柜员操作流水");
			return null;
		}
		return tellerLog;
	}

	@Override
	public int serialnoRegister(Map<String, Object> map) {
		int count = dbo.getInserter().insertInto(TABLE).values(map).execute();
		return count;
	}

	@Override
	public int updateTellerLogMap(String serialNo, String optDate, Map<String, Object> map) {
		int count = dbo.getUpdater().update(TABLE).set(map).where(w ->{
			w.eq("serialno", serialNo);
			w.eq("optdate", optDate);
		}).execute();
		return count;
	} 

	@Override
	public  List<TellerLog> selectInfo(String svrCode, String tellerNo, String transStatus, String optTellerNo, String optBrNo) {
		List<TellerLog> tellerLogList = ormOper.getOrmSelecter(TellerLog.class).where(w ->{
			w.setSvrCode(svrCode);
			w.setChgTellerNo(tellerNo);
			w.setTransStatus(transStatus);
			w.setOptTellerNo(optTellerNo);
			w.setOptBrNo(optBrNo);
		}).fetchAll(); 
		return tellerLogList;
	}

	@Override
	public int updateTellerStatus(String transStatus, String serialNo, String optDate) {
		int execute = dbo.getUpdater().update(TABLE).where(w ->{
			w.eq("serialNo", serialNo);
			w.eq("optDate", optDate);
		}).set("transStatus", transStatus).execute();
		return execute;
	}

	@Override
	public List<TellerLog> selectCurrTellerLog(String svrCode, String transStatus) {
		OrmSelecter<TellerLog> ormSelecter = ormOper.getOrmSelecter(TellerLog.class);
    	List<TellerLog>  list = ormSelecter.where(w ->{
    		w.setSvrCode(svrCode);
    		w.setTransStatus(transStatus);
    	}).fetchAll();
    	return list;
	}

	@Override
	public Map<String, Object> checkTellerLogTime(String strTellerNo, String strBrNo, String svrCode, String optDate) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("chgtellerno", strTellerNo);
				 w.eq("chgtellernobrno", strBrNo);
				 w.eq("svrcode", svrCode);
				 w.eq("optdate", optDate);
				};
		};
		
		Selecter selecter = dbo.getSelecter()
				 .select("chgtellerno", "chgtellernobrno", "svrcode", "optdate", "opttime", "transstatus")
				 .from(TABLE)
				 .where(whereExp)
				 .orderBy("opttime DESC");
		
		Map<String, Object> result = selecter.fetchOne();
    	return result;
	}
	
}
