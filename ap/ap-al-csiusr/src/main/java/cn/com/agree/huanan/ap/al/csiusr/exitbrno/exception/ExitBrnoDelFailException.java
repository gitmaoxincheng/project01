package cn.com.agree.huanan.ap.al.csiusr.exitbrno.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author lixq 网点日终签退删除失败
 */
public class ExitBrnoDelFailException extends ApException{

	private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public ExitBrnoDelFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
