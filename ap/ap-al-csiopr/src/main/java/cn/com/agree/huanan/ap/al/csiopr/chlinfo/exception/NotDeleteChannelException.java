package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道信息审批表异常类
 * @author maoxc
 *
 */

public class NotDeleteChannelException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public NotDeleteChannelException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public NotDeleteChannelException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
