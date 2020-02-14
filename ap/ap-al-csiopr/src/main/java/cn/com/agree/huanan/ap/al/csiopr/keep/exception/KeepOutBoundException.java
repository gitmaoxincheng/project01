package cn.com.agree.huanan.ap.al.csiopr.keep.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class KeepOutBoundException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3206426690763054821L;
	
	/**
     * @param errMsg 错误信息
     */
    public KeepOutBoundException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public KeepOutBoundException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
