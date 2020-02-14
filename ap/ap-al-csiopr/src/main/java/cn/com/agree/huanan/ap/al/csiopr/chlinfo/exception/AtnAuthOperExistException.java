package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道认证信息新增异常类
 * @author hww
 *
 */

public class AtnAuthOperExistException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public AtnAuthOperExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public AtnAuthOperExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
