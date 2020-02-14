package cn.com.agree.huanan.ap.al.csitrd.amgt.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 调用核心异常类
 * @author lanshaojun
 *
 */

public class GetErrorCodeException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public GetErrorCodeException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public GetErrorCodeException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
