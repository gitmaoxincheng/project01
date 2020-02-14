package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务访问参数异常类
 * @author
 *
 */

public class ParamErrorException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public ParamErrorException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ParamErrorException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
