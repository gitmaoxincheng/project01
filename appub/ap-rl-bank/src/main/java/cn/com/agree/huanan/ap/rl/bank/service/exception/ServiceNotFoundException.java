package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author acz
 * 服务找不到
 */
public class ServiceNotFoundException  extends ApException {

    /**
     * 
     */
    private static final long serialVersionUID = 8660853303574490491L;
    /**
     * @param errMsg 错误信息
     */
    public ServiceNotFoundException(String errMsg) {
        super(new Object[]{errMsg});
    }

}
