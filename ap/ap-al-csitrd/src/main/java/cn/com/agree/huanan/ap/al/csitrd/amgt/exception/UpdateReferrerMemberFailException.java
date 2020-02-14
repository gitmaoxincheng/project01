package cn.com.agree.huanan.ap.al.csitrd.amgt.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 营销人员推荐人信息修改异常类
 * @author lanshaojun
 *
 */

public class UpdateReferrerMemberFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public UpdateReferrerMemberFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public UpdateReferrerMemberFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
