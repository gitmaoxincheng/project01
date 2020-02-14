package cn.com.agree.huanan.ap.al.csiopr.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 
 * @author zzc
 *
 */

public class ServiceOperException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    public ServiceOperException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ServiceOperException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
