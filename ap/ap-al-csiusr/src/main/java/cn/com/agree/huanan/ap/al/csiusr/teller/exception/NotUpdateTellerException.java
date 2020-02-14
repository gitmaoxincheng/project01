package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 柜员表异常类
 * @author Maoxc
 *
 */

public class NotUpdateTellerException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public NotUpdateTellerException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public NotUpdateTellerException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
