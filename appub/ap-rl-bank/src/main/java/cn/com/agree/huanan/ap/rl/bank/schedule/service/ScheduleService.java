package cn.com.agree.huanan.ap.rl.bank.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.rl.bank.schedule.dao.ScheduleDao;
import cn.com.agree.huanan.ap.rl.bank.schedule.dao.ScheduleFlowDao;
import cn.com.agree.huanan.ap.rl.bank.schedule.exception.ApScheduleStatusException;
import cn.com.agree.huanan.ap.rl.bank.schedule.po.Schedule;
import cn.com.agree.huanan.ap.rl.bank.schedule.po.ScheduleFlow;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApNullArgsException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * @author HCP 调度交易服务
 */
@Service
public class ScheduleService {

    @Autowired private Logger logger;
    @Autowired private ScheduleDao scheduleDao;
    @Autowired private ScheduleFlowDao scheduleFlowDao;

    /**
     * 查询调度任务信息
     * @param jobId 任务ID
     * @return 任务配置信息
     */
    public Schedule querySchedule(String jobId){
        Schedule schedule = scheduleDao.selectShedule(jobId);
        if (schedule == null){
            logger.error("查询调度任务无记录");
            throw new ApSelectNotFoundException("调度任务",jobId);	
        }
        logger.info("查询成功，JobId: "+jobId);
        return schedule;

    }

    /**
     * 更新调度任务状态
     * @param jobId  任务ID
     * @param status 状态
     */
    public void updateScheduleStatus(String jobId,String status){
        int count = scheduleDao.updateSheduleStatus(jobId,status);
        if (count < 1){
            logger.error("更新调度任务状态失败,jobId: "+jobId+",status: "+status);
            throw new ApUpdateFailException("调度任务",jobId);
        }
    }
    /**
     * 回查调度状态
     * @param 调度任务
     * @return 调起日期
     */
    public ScheduleFlow queryScheInvokeStatus(String jobId,String tradeDate){
        Schedule schedule = scheduleDao.selectShedule(jobId);
        ScheduleFlow scheduleFlow  = null;
        if (schedule.getStatus() == "1" && schedule.getCurCount() < 1) {  
        	//作业被调起后，状态为非1，且当日调起次数 >1，作业当日完成所有调度后，状态为1，且当日调起次数 >1，因此使用 状态为，当日调起数 <1判断调度未调起
        		logger.error("回查调度状态时，作业本应已被调起，但登记状态仍为未调起,JobId:%s",jobId);
    			throw new ApScheduleStatusException(schedule.getStatus(), jobId);
		}else if (schedule.getStatus() == "2") {
			logger.error("回查调度状态时，作业仍处于执行中状态,JobId:%s",jobId);
			throw new ApScheduleStatusException(schedule.getStatus(), jobId);
		}else if (schedule.getStatus() == "3" || (schedule.getStatus() == "1" && schedule.getCurCount() > 0)) { // 如何重置这里的调度状态？？？  这里判断是否调度成功的逻辑也有一定漏洞 XXX
			//查询调度流水
			String seriNo = schedule.getCurSerno();
			scheduleFlow = scheduleFlowDao.selectSheduleFlow(seriNo);
	        if (scheduleFlow == null){
	            logger.error("查询调度任务流水无记录");
	            throw new ApSelectNotFoundException("调度流水",seriNo);
	        }
	        logger.info("查询成功，调度任务流水:%，错误码：%s,错误信息：%s,调起时间：%s,完成时间：%s，实际耗时：%s",
	        		seriNo,scheduleFlow.getErrorCode(),scheduleFlow.getErrorMsg(),scheduleFlow.getTradeTime(),scheduleFlow.getTradeTime(),scheduleFlow.getTime());
		}else {
			throw new ApScheduleStatusException(schedule.getStatus(), jobId);
		}

        return scheduleFlow;
    }

    /**
     * 添加调度任务流水
     * @param scheduleFlow 流水信息
     */
    public void addScheduleFlow(ScheduleFlow scheduleFlow){
        int count = scheduleFlowDao.insertScheduleFlow(scheduleFlow);
        if (count < 1){
            logger.error("插入调度任务流水失败,scheduleFlow: "+scheduleFlow);
            throw new ApInsertFailException("调度任务流水");
        }
    }

    /**
     * 查询调度流水
     * @param seriNo 流水号
     * @return 调度流水信息
     */
    public ScheduleFlow queryScheduleFlow(String seriNo){
        ScheduleFlow scheduleFlow = scheduleFlowDao.selectSheduleFlow(seriNo);
        if (scheduleFlow == null){
            logger.error("查询调度任务流水无记录");
            throw new ApSelectNotFoundException("调度任务流水",seriNo);
        }
        logger.info("查询成功，serino: "+seriNo);
        return scheduleFlow;

    }

    /**
     * 更新单次调度状态
     * @param seriNo 调度流水
     * @param status 调度作业状态
     */
    public void updateScheduleFlowStatus(String seriNo,String status){
        int count = scheduleFlowDao.updateSheduleFlowStatus(seriNo,status);
        if (count < 1){
            logger.error("更新调度任务状态失败,serino: "+seriNo+",status: "+status);
            throw new ApUpdateFailException("调度任务",seriNo);
        }
    }
    
    /**
     * 更新单次调度状态
     * @param seriNo 调度流水
     * @param status 调度作业状态
     */
    public void updateScheBeforeInvoke(Schedule schedule){
        int count = scheduleDao.updateScheBeforeInvoke(schedule.getJobId(),schedule.getStatus(),schedule.getCurDate(),schedule.getCurCount(),schedule.getCurSerno());
        if (count < 1){
            logger.error("更新调度任务状态失败,JobId:%s,Serino:%s",schedule.getJobId(),schedule.getCurSerno());
            throw new ApUpdateFailException("调度任务",schedule.getJobId());
        }
    }
    
    
    
    /**
     * 更新单次调度状态
     * @param seriNo 调度流水
     * @param status 调度作业状态
     */
    public void updateScheduleFlow(ScheduleFlow scheduleFlow){
    	if (StringUtils.isEmpty(scheduleFlow.getSeriNo())) {
			throw new ApNullArgsException("serino","流水号");
		}
        int count = scheduleFlowDao.updateSheduleFlow(scheduleFlow.getSeriNo(), scheduleFlow);
        if (count < 1){
            logger.error("更新调度任务状态失败,"+scheduleFlow);
            throw new ApUpdateFailException("调度任务",scheduleFlow.getSeriNo());
        }
    }



}
