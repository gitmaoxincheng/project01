package cn.com.agree.huanan.ap.al.csitrd.amgt.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 数据获取异常类
 * @author lanshaojun
 *
 */

public class GetDataNoExitException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public GetDataNoExitException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public GetDataNoExitException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
