package cn.com.agree.huanan.ap.al.csiopr.keep.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class KeepNotExistException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6912924151992492186L;
	
	/**
     * @param errMsg 错误信息
     */
    public KeepNotExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public KeepNotExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	

}
