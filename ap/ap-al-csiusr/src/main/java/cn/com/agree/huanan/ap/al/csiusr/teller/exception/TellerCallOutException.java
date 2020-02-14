package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author heww 柜员调出类型错误
 */
public class TellerCallOutException extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerCallOutException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
