package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author acz
 * 服务不可用
 */
public class ServiceUnusableException extends ApException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errMsg 错误信息
     */
    public ServiceUnusableException(String errMsg) {
        super(new Object[]{errMsg});
    }
}
