package cn.com.agree.huanan.ap.rl.bank.schedule.dao;

import cn.com.agree.huanan.ap.rl.bank.schedule.po.ScheduleFlow;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.orm.OrmUpdater;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ScheduleFlowDaoImpl implements ScheduleFlowDao {
	private static final String TABLE="csis_schedule_flow";
	@Autowired private OrmOperator ormOper;
	@Autowired private DbOperator dbOperator;


	@Override
	public ScheduleFlow selectSheduleFlow(String seriNo) {
		OrmSelecter<ScheduleFlow> ormSelecter = ormOper.getOrmSelecter(ScheduleFlow.class);
		ScheduleFlow scheduleFlow = ormSelecter.where(w ->{
			w.setSeriNo(seriNo);
		}).fetchOne();
		return scheduleFlow;
	}

	@Override
	public int insertScheduleFlow(ScheduleFlow scheduleFlow) {
		Inserter inserter= dbOperator.getInserter();
		int count = inserter.insertInto(TABLE).values(ScheduleFlow.getMap(scheduleFlow)).execute();
		return count;
	}

	@Override
	public int updateSheduleFlowStatus(String seriNo, String status) {
		OrmUpdater<ScheduleFlow> ormUpdater = ormOper.getOrmUpdater(ScheduleFlow.class);
		int count = ormUpdater.where(w->{
			w.setSeriNo(seriNo);
		}).set(w->{
			w.setStatus(status);
		}).execute();
		return count;
	}

	@Override
	public List<ScheduleFlow> selectSheduleFlowList(String jobId, String workdate) {
		return null;
	}

	@Override
	public int updateSheduleFlow(String seriNo, ScheduleFlow scheduleFlow) {
		OrmUpdater<ScheduleFlow> ormUpdater = ormOper.getOrmUpdater(ScheduleFlow.class);
		int count = ormUpdater.where(w->{
			w.setSeriNo(seriNo);
		}).set(w->{
			w.setStatus(scheduleFlow.getStatus());
			w.setErrorCode(scheduleFlow.getErrorCode());
			w.setErrorMsg(scheduleFlow.getErrorMsg());
			w.setTime(scheduleFlow.getTime());
			w.setServer(scheduleFlow.getServer());
			w.setServerLog(scheduleFlow.getServerLog());
			w.setProcessId(scheduleFlow.getProcessId());
		}).execute();
		return count;
	}
}
