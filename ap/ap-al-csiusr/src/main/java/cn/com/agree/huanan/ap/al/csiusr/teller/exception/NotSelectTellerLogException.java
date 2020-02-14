package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 *  柜员操作流水类
 * @author maoxc
 *
 */

public class NotSelectTellerLogException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public NotSelectTellerLogException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public NotSelectTellerLogException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
