package cn.com.agree.huanan.ap.al.csiusr.exittellerno.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HWW 柜员日终签退未完成
 */
public class ExitTellerNotFinishedException extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public ExitTellerNotFinishedException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
