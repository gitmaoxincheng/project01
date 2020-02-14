package cn.com.agree.huanan.ap.al.csiopr.keeppara.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class ModifyKeepParaFailException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2639343779380204519L;
	
	/**
     * @param errMsg 错误信息
     */
    public ModifyKeepParaFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ModifyKeepParaFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
	
	

}
