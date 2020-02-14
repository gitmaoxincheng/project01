package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 
 * @author zzc
 *
 */

public class CheckNotDataException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public CheckNotDataException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public CheckNotDataException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
