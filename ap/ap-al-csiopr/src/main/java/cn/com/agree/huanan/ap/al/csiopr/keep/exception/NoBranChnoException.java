package cn.com.agree.huanan.ap.al.csiopr.keep.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class NoBranChnoException extends ApException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8872005922984817678L;
	
    public NoBranChnoException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public NoBranChnoException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
}
