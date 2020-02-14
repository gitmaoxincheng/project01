package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author heww 柜员岗位调动异常
 */
public class TellerTransException extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerTransException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
