package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author acz
 *  能力中心配置不存在
 */
public class CompNotExistException extends ApException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @param serviceId 请求的服务码
     * @param sceneId 请求的场景码
     */
    public CompNotExistException(String serviceId,String sceneId){
        super(new Object[]{serviceId,sceneId});
    }

}
