package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP 柜员注册信息新增失败
 */
public class TellerSysAddFailException extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerSysAddFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
