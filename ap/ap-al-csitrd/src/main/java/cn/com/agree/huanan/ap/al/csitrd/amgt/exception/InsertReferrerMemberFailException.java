package cn.com.agree.huanan.ap.al.csitrd.amgt.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 营销人员推荐人信息新增异常类
 * @author lanshaojun
 *
 */

public class InsertReferrerMemberFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public InsertReferrerMemberFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertReferrerMemberFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
