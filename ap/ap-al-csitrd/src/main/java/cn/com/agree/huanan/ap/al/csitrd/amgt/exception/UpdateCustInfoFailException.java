package cn.com.agree.huanan.ap.al.csitrd.amgt.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 个人客户信息修改异常类
 * @author lanshaojun
 *
 */

public class UpdateCustInfoFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public UpdateCustInfoFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public UpdateCustInfoFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
