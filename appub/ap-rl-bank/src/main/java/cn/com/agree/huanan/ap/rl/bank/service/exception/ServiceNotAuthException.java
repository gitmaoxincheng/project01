package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 * 服务未授权
 */
public class ServiceNotAuthException extends ApException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param 请求方 
     * @param 服务
     */
    public ServiceNotAuthException(String channel, String service) {
        super(new Object[]{channel,service});
    }

}
