package cn.com.agree.huanan.ap.al.csiusr.exittellerno.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author lixq 柜员日终签退删除失败
 */
public class ExitTellerDelFailException extends ApException {
	private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public ExitTellerDelFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
