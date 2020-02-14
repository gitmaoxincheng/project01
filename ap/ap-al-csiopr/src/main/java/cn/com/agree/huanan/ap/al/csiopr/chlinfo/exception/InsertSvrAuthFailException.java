package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务权限记录新增异常类
 * @author 
 *
 */

public class InsertSvrAuthFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public InsertSvrAuthFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertSvrAuthFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
