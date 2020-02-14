package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author lixq 柜员临时签退失败
 */
public class TellerTmpExitFailException extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerTmpExitFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
