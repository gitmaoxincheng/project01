package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HWW 柜员登录异常
 */
public class TellerLoginException extends ApException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public TellerLoginException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
