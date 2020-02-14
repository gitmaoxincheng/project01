package cn.com.agree.huanan.ap.al.csiopr.keeppara.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class GetKeepParaListFailException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4204634033551175269L;

	
	/**
     * @param errMsg 错误信息
     */
    public GetKeepParaListFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public GetKeepParaListFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
	
	
	
}
