package cn.com.agree.huanan.ap.al.csiopr.keep.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class InsertKeepFailException extends ApException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3631303452267443799L;
	
	/**
     * @param errMsg 错误信息
     */
    public InsertKeepFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertKeepFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	

}
