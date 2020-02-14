package cn.com.agree.huanan.ap.al.csiusr.rtmh.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class QueryInfoException extends ApException{

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public QueryInfoException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public QueryInfoException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
}
