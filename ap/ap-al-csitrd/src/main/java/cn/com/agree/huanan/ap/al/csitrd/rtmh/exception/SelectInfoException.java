package cn.com.agree.huanan.ap.al.csitrd.rtmh.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class SelectInfoException extends ApException{

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public SelectInfoException() {
    	super();
    }
    /**
     * @param errMsg 错误信息
     */
    public SelectInfoException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
}
