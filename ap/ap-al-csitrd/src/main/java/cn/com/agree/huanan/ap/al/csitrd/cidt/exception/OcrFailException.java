package cn.com.agree.huanan.ap.al.csitrd.cidt.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class OcrFailException extends ApException{
	private static final long serialVersionUID = 1L;
	
	 /**
     * @param errMsg 错误信息
     */
    public OcrFailException() {
        super(new Object[] {
            
        });
    }
    
    /**
     * @param errMsg 错误信息
     */
    public OcrFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
