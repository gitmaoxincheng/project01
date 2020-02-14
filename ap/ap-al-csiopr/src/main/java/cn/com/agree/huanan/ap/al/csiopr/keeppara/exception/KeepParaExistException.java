package cn.com.agree.huanan.ap.al.csiopr.keeppara.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class KeepParaExistException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2402730131740790938L;
	
	/**
     * @param errMsg 错误信息
     */
    public KeepParaExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public KeepParaExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
	

}
