package cn.com.agree.huanan.ap.rl.bank.schedule.dao;

import cn.com.agree.huanan.ap.rl.bank.schedule.po.Schedule;

public interface ScheduleDao {

    public Schedule selectShedule(String jobId);
	public int updateSheduleStatus(String jobId,String status);
    public int updateScheBeforeInvoke(String jobId, String status,String curDate,int curCount,String curSerno);

}
