package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP 柜员新增失败异常
 */
public class TellerNotExistException extends ApException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public TellerNotExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
