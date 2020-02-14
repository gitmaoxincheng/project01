package cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 *  渠道信息审批表异常类
 * @author maoxc
 *
 */

public class NotDeleteException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public NotDeleteException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public NotDeleteException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
