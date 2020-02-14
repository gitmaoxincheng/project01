package cn.com.agree.huanan.ap.al.csiusr.exitbrno.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author lixq 网点日终签退更新失败
 */
public class ExitBrnoUpdateFailException extends ApException{

	private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public ExitBrnoUpdateFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
