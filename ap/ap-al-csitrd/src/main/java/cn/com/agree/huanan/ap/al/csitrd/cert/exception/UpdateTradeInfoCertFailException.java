package cn.com.agree.huanan.ap.al.csitrd.cert.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 凭证信息登记簿修改异常类
 * @author lanshaojun
 *
 */

public class UpdateTradeInfoCertFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public UpdateTradeInfoCertFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public UpdateTradeInfoCertFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
