package cn.com.agree.huanan.ap.rl.bank.schedule.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.schedule.po.Schedule;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.orm.OrmUpdater;

@Component
public class ScheduleDaoImpl implements ScheduleDao {
//	private static final String TABLE="csis_schedule";
	@Autowired private  OrmOperator ormOper;
	@Override
	public Schedule selectShedule(String jobId) {
		OrmSelecter<Schedule> ormSelecter = ormOper.getOrmSelecter(Schedule.class);
		Schedule schedule = ormSelecter.where(w ->{
			w.setJobId(jobId);
		}).fetchOne();
		return schedule;
	}

	@Override
	public int updateSheduleStatus(String jobId, String status) {
		OrmUpdater<Schedule> ormUpdater = ormOper.getOrmUpdater(Schedule.class);
		int count = ormUpdater.where(w->{
			w.setJobId(jobId);
		}).set(w->{
			w.setStatus(status);
		}).execute();
		return count;

	}

	@Override
	public int updateScheBeforeInvoke(String jobId, String status, String curDate, int curCount, String curSerno) {
		OrmUpdater<Schedule> ormUpdater = ormOper.getOrmUpdater(Schedule.class);
		int count = ormUpdater.where(w->{
			w.setJobId(jobId);
		}).set(w->{
			w.setStatus(status);
			w.setCurDate(curDate);
			w.setCurCount(curCount);
			w.setCurSerno(curSerno);
		}).execute();
		return count;
	}
}
