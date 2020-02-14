package cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 *  渠道信息审批表异常类
 * @author maoxc
 *
 */

public class NotUpdateException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public NotUpdateException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public NotUpdateException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
