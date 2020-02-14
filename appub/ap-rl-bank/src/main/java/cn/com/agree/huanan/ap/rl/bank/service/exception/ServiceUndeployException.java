package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author acz
 * 服务未部署
 */
public class ServiceUndeployException extends ApException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errMsg 错误信息
     */
    public ServiceUndeployException(String errMsg) {
        super(new Object[]{errMsg});
    }

}
