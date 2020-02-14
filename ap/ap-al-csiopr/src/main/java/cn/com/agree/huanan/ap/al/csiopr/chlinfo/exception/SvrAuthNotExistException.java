package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务权限记录不存在异常类
 * @author 
 *
 */

public class SvrAuthNotExistException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public SvrAuthNotExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public SvrAuthNotExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
