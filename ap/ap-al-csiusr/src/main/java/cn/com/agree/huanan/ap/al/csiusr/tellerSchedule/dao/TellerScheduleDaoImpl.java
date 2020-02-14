package cn.com.agree.huanan.ap.al.csiusr.tellerSchedule.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerLog;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 柜员操作流水Dao实现
 * @author xzf
 *
 */
@Component
public class TellerScheduleDaoImpl implements TellerScheduleDao{
    public final Logger logger = Logger.getLogger(TellerScheduleDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	@Override
	public List<TellerLog> queryByAdjdateSvridAndTransstatus(String nowDate, String svrId, String transStatus) {
		logger.info("开始定时任务查询");
		OrmSelecter<TellerLog> ormSelecter = ormOper.getOrmSelecter(TellerLog.class);
    	List<TellerLog>  list = ormSelecter.where(w ->{
    		w.setAdjDate(nowDate);
			w.setSvrId(svrId);
			w.setTransStatus(transStatus);
    	}).fetchAll();
		return list;
	}
	
	@Override
	public Entduty queryByTellernoAndBrno(String tellerno,String brno,int i) {
		OrmSelecter<Entduty> ormSelecter = ormOper.getOrmSelecter(Entduty.class);
		
		Entduty result = ormSelecter.where(w ->{
			w.setTellerNo(tellerno);
			switch (i) {
			case 1:
				w.setZoneNo(brno);
				break;
			case 2:
				w.setMBrNo(brno);
				break;
			case 3:
				w.setBrNo(brno);
				break;
			}
		}).fetchOne();
		return result;
	}
	@Override
	public List<TellerInfo> queryByTellerNo(String tellerNo) {
		OrmSelecter<TellerInfo> ormSelecter = ormOper.getOrmSelecter(TellerInfo.class);
		List<TellerInfo> result = ormSelecter.where(w ->{
			w.setTellerNo(tellerNo);
		}).fetchAll();
		return result;
	}
	@Override
	public int upDateByTellerNo(String brnoFrom, String tellerNo, String zoneno, String mbrno, String brno) {
		logger.info("-----开始修改csis_tellerinfo数据-----");
		if(StringUtils.isEmpty(tellerNo)) {
			throw new ApIllegalParamException("tellerNo为空");
		}
		int count =0;
		if(!StringUtils.isEmpty(zoneno)) {
			count += dbo.getUpdater().update("csis_tellerinfo").where(w -> {w.eq("tellerno", tellerNo);w.eq("brno", brnoFrom);}).set("zoneno", zoneno).execute();
		}
		if(!StringUtils.isEmpty(mbrno)) {
			count += dbo.getUpdater().update("csis_tellerinfo").where(w -> {w.eq("tellerno", tellerNo);w.eq("brno", brnoFrom);}).set("mbrno", mbrno).execute();
		}
		if(!StringUtils.isEmpty(brno)) {
			count += dbo.getUpdater().update("csis_tellerinfo").where(w -> {w.eq("tellerno", tellerNo);w.eq("brno", brnoFrom);}).set("brno", brno).execute();
		}
		logger.info("-----结束修改数据-----");
		return count;
	}
	@Override
	public int upDateBySerialNo(String serialno, String transstatus) {
		logger.info("-----开始修改csis_tellerlog数据-----");
		if(StringUtils.isEmpty(serialno)) {
			throw new ApIllegalParamException("serialno为空");
		}
		if(StringUtils.isEmpty(transstatus)) {
			throw new ApIllegalParamException("transstatus为空");
		}
		int count = dbo.getUpdater().update("csis_tellerlog").where(w -> {w.eq("serialno", serialno);}).set("transstatus", transstatus).execute();
		logger.info("-----结束修改数据-----");
		return count;
	}
	@Override
	public Branch queryByBrno(String brno) {
		OrmSelecter<Branch> ormSelecter = ormOper.getOrmSelecter(Branch.class);
		Branch result = ormSelecter.where(w ->{
			w.setBrno(brno);
		}).fetchOne();
		return result;
	}
	@Override
	public List<TellerInfo> queryByTellerNoAndBrno(String tellerNo, String Brno) {
		OrmSelecter<TellerInfo> ormSelecter = ormOper.getOrmSelecter(TellerInfo.class);
		List<TellerInfo> result = ormSelecter.where(w ->{
			w.setTellerNo(tellerNo);
			w.setBrNo(Brno);
		}).fetchAll();
		return result;
	}
}
