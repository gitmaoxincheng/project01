package cn.com.agree.huanan.ap.al.csiusr.staffinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HYS 柜员同步操作异常
 */
public class StaffInfoSynchronizationException extends ApException{

    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public StaffInfoSynchronizationException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
