package cn.com.agree.huanan.ap.al.csiopr.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 
 * @author zzc
 *
 */

public class ServiceCataException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    public ServiceCataException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ServiceCataException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
