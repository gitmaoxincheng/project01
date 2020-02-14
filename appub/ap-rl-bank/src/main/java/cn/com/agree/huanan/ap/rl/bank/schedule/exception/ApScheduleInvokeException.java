package cn.com.agree.huanan.ap.rl.bank.schedule.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP 调度异常
 */
public class ApScheduleInvokeException extends ApException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errMsg 错误信息
     * 描述：调度异常，错误原因：errMsg
     */
    public ApScheduleInvokeException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
