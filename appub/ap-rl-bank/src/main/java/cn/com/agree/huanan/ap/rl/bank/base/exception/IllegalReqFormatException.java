package cn.com.agree.huanan.ap.rl.bank.base.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 * 非法请求报文格式
 */
public class IllegalReqFormatException extends ApException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errMsg 错误信息
     */
    public IllegalReqFormatException(String errMsg) {
        super(new Object[]{errMsg});
    }
}
