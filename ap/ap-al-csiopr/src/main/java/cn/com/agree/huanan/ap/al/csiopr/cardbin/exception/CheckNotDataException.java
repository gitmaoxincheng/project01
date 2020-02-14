package cn.com.agree.huanan.ap.al.csiopr.cardbin.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 卡bin信息新增异常类
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
