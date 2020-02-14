package cn.com.agree.huanan.ap.al.csitrd.voch.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 插入异常
 * @author Maoxc
 *
 */

public class InsertTradeinfoFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public InsertTradeinfoFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertTradeinfoFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
