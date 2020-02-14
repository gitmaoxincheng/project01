package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 柜员今天发生了交易，不允许调动异常
 * @author heww 
 *
 */
public class TellerHappenTransException extends ApException {
	private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerHappenTransException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
