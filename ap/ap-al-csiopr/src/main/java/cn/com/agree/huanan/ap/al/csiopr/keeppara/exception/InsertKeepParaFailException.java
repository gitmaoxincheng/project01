package cn.com.agree.huanan.ap.al.csiopr.keeppara.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class InsertKeepParaFailException extends ApException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3631303452267443799L;
	
	/**
     * @param errMsg 错误信息
     */
    public InsertKeepParaFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertKeepParaFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	

}
