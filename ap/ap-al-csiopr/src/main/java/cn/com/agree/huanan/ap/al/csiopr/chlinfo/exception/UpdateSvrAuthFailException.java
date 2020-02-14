package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务权限记录更新异常类
 * @author 
 *
 */

public class UpdateSvrAuthFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public UpdateSvrAuthFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public UpdateSvrAuthFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
