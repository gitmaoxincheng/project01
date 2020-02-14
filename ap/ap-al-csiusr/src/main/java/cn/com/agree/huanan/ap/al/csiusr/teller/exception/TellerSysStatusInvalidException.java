package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author heww 柜员注册系统状态无效
 */
public class TellerSysStatusInvalidException extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerSysStatusInvalidException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
