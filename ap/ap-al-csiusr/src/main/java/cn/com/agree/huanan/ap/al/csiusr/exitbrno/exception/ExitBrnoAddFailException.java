package cn.com.agree.huanan.ap.al.csiusr.exitbrno.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author lixq 网点日终签退添加失败
 */
public class ExitBrnoAddFailException extends ApException{

	private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public ExitBrnoAddFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
