package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 参数错误
 */
public class ParamFailException extends ApException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @param errMsg 错误信息
     */
    public ParamFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ParamFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	

}
