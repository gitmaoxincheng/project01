package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author heww 操作柜员与被调动柜员相同
 */
public class TellerTheSameException extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerTheSameException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
