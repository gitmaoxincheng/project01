package cn.com.agree.huanan.ap.al.csitrd.sign.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 签约顺序异常
 * @author hww
 *
 */
public class SignFlagException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * @param errMsg 错误信息
     */
    public SignFlagException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
