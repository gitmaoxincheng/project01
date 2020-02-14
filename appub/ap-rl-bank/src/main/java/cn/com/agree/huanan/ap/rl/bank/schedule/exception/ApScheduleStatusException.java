package cn.com.agree.huanan.ap.rl.bank.schedule.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP 调度状态异常
 */
public class ApScheduleStatusException extends ApException {

    private static final long serialVersionUID = 1L;
    
    /**
     * @param status 状态
     * 		status: 2, 调度作业正在执行中
     * 		status: 3, 调度作业已完成，无需重复调起
     *      status: 其它，调度处于异常状态
     * @param jobId 任务Id     
     */
    public ApScheduleStatusException(String status,String jobId) {
            super(convert(status),new Object[] {jobId});			
    }
    
    private static int convert(String status) {
    	if (status == "2") {
			return 2;
		}else if(status == "3"){
			return 3;
		}else {
			return 1;
		}
    }
}
