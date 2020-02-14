package cn.com.agree.huanan.ap.al.csiusr.exittellerno.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author lixq 柜员日终签退添加失败
 */
public class ExitTellerAddFailException extends ApException {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public ExitTellerAddFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
