package cn.com.agree.huanan.ap.rl.bank.schedule.dao;

import cn.com.agree.huanan.ap.rl.bank.schedule.po.ScheduleFlow;

import java.util.List;

public interface ScheduleFlowDao {

    public List<ScheduleFlow> selectSheduleFlowList(String jobId, String workdate);
    public ScheduleFlow selectSheduleFlow(String seriNo);
    public int insertScheduleFlow(ScheduleFlow scheduleFlow);
    public int updateSheduleFlowStatus(String seriNo, String status);
    public int updateSheduleFlow(String seriNo, ScheduleFlow scheduleFlow);

}
