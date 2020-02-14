package cn.com.agree.huanan.ap.al.csiopr.keeppara.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class KeepParaNotExistException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6912924151992492186L;
	
	/**
     * @param errMsg 错误信息
     */
    public KeepParaNotExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public KeepParaNotExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	

}
