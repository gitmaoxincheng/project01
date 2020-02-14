package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 * 服务调用超时
 */
public class ServiceInvokeTimeOutlException extends ApException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**XXX
     * @param srcServiceId 消费方服务ID
     * @param targetServiceId 服务方服务ID
     */
    public ServiceInvokeTimeOutlException(String srcServiceId, String targetServiceId) {
        super(new Object[]{srcServiceId,targetServiceId});

    }


}
