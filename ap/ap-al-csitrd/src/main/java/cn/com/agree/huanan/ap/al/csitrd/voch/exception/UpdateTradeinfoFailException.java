package cn.com.agree.huanan.ap.al.csitrd.voch.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新异常
 * @author Maoxc
 *
 */

public class UpdateTradeinfoFailException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public UpdateTradeinfoFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public UpdateTradeinfoFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
