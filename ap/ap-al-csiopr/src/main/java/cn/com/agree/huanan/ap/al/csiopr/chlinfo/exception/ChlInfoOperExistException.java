package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道信息新增异常类
 * @author hww
 *
 */

public class ChlInfoOperExistException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public ChlInfoOperExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ChlInfoOperExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
