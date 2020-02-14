package cn.com.agree.huanan.ap.al.csiusr.rtmh.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 插入数据异常
 * @author bodadmin
 *
 */
public class InsertUserLoginException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    /**
     * @param errMsg 错误信息
     */
    public InsertUserLoginException() {
    	
    }
    
	/**
     * @param errMsg 错误信息
     */
    public InsertUserLoginException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
}
