package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务权限记录不存在异常类
 * @author 
 *
 */

public class TranMappNotExistException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public TranMappNotExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public TranMappNotExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
