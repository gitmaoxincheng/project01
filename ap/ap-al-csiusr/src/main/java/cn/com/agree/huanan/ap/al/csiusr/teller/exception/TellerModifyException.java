package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 柜员表异常类
 * @author Maoxc
 *
 */

public class TellerModifyException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public TellerModifyException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public TellerModifyException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
