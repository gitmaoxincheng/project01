package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务访问流程出错异常类
 * @author 
 *
 */

public class ProcessErrorException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public ProcessErrorException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ProcessErrorException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
