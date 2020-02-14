package cn.com.agree.huanan.ap.al.csiopr.keep.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class ModifyKeepFailException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2639343779380204519L;
	
	/**
     * @param errMsg 错误信息
     */
    public ModifyKeepFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ModifyKeepFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
	
	

}
