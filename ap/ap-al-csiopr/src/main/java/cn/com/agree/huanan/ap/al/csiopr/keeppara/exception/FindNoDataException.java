package cn.com.agree.huanan.ap.al.csiopr.keeppara.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class FindNoDataException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3767900514143198801L;
	
	/**
     * @param errMsg 错误信息
     */
    public FindNoDataException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public FindNoDataException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
	

}
