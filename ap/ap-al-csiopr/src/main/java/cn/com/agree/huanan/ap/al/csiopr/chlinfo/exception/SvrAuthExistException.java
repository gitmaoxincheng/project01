package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务权限记录已存在异常类
 * @author 
 *
 */

public class SvrAuthExistException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public SvrAuthExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public SvrAuthExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
