package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务权限审批记录新增异常类
 * @author 
 *
 */

public class InsertSvrAuthOperFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public InsertSvrAuthOperFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertSvrAuthOperFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
