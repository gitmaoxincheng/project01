package cn.com.agree.huanan.ap.al.csiopr.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务存在异常
 * @author wb
 *
 */

public class ChlServiceExistException extends ApException{
    private static final long serialVersionUID = 1L;
    public ChlServiceExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ChlServiceExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
