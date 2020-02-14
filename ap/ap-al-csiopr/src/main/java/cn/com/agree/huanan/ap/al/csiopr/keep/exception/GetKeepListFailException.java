package cn.com.agree.huanan.ap.al.csiopr.keep.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class GetKeepListFailException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4204634033551175269L;

	
	/**
     * @param errMsg 错误信息
     */
    public GetKeepListFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public GetKeepListFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
	
	
	
}
