package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务访问审批记录获取异常类
 * @author 
 *
 */

public class SvrAuthAlreadyAuditException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public SvrAuthAlreadyAuditException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public SvrAuthAlreadyAuditException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
