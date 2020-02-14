package cn.com.agree.huanan.ap.al.csiopr.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务待审批存在异常
 * @author wb
 *
 */
public class ChlServiceOperExistException extends ApException{
    private static final long serialVersionUID = 1L;
    public ChlServiceOperExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ChlServiceOperExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }


}
