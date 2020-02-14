package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author heww 柜员岗位调动类型错误
 */
public class TellerTransOperFlagException extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerTransOperFlagException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
