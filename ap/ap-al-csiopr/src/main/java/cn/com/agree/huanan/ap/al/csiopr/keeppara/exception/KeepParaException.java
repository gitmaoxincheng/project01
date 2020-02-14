package cn.com.agree.huanan.ap.al.csiopr.keeppara.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class KeepParaException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7853182824739540425L;
	
	/**
     * @param errMsg 错误信息
     */
    public KeepParaException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public KeepParaException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	

}
