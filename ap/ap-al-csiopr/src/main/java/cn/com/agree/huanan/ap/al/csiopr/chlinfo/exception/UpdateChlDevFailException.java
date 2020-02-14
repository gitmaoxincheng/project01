package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新渠道白名单失败
 */
public class UpdateChlDevFailException extends ApException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @param errMsg 错误信息
     */
    public UpdateChlDevFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public UpdateChlDevFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
