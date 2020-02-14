package cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 *  岗位受控系统异常类
 * @author heww
 *
 */

public class ExitCtrlDtsyException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public ExitCtrlDtsyException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ExitCtrlDtsyException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
