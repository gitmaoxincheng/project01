package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 * 服务调用失败异常
 */
public class ServiceInvokeFailException extends ApException {



    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**XXX
     * @param errorMsg 错误信息
     */
    public ServiceInvokeFailException(String errorMsg) {
        super(new Object[]{errorMsg});
    }

    /**XXX
     * @param srcServiceId 消费方服务ID
     * @param targetServiceId 服务方服务ID
     */
    public ServiceInvokeFailException(String srcServiceId, String targetServiceId) {
        super(new Object[]{srcServiceId,targetServiceId});

    }


}
