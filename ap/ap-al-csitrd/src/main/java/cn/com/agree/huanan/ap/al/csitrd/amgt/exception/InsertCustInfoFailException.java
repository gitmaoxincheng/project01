package cn.com.agree.huanan.ap.al.csitrd.amgt.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 个人客户信息新增异常类
 * @author lanshaojun
 *
 */

public class InsertCustInfoFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public InsertCustInfoFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertCustInfoFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
