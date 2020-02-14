package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author heww 末位柜员撤岗调出错误
 */
public class LastTellerCallOutException extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public LastTellerCallOutException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}