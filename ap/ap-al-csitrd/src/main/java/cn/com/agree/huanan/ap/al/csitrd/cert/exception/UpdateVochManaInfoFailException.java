package cn.com.agree.huanan.ap.al.csitrd.cert.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 凭证管理信息明细更新 异常
 * @author Zengs
 *
 */
public class UpdateVochManaInfoFailException extends ApException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5592706190005610491L;
	
	 /**
     * @param errMsg 错误信息
     */
    public UpdateVochManaInfoFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public UpdateVochManaInfoFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
