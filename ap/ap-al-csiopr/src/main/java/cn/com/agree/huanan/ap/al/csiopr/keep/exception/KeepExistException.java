package cn.com.agree.huanan.ap.al.csiopr.keep.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class KeepExistException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2402730131740790938L;
	
	/**
     * @param errMsg 错误信息
     */
    public KeepExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public KeepExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
	

}
