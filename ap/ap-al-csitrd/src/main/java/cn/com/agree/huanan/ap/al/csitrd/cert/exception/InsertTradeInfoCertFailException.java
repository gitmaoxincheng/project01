package cn.com.agree.huanan.ap.al.csitrd.cert.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 凭证信息登记簿新增异常类
 * @author lanshaojun
 *
 */

public class InsertTradeInfoCertFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public InsertTradeInfoCertFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertTradeInfoCertFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
