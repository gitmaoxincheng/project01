package cn.com.agree.huanan.ap.al.csiopr.keep.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class HandleOverException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8240528063067683582L;

    public HandleOverException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public HandleOverException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
	
}
