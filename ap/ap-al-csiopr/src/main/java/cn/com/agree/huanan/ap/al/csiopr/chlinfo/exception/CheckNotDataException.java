package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道服务访问审批记录获取异常类
 * @author 
 *
 */

public class CheckNotDataException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public CheckNotDataException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public CheckNotDataException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
