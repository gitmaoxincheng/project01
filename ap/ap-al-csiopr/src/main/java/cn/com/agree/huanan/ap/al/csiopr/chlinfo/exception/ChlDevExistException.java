package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道白名单已存在异常
 */
public class ChlDevExistException extends ApException {


	private static final long serialVersionUID = 1L;
	/**
     * @param errMsg 错误信息
     */
    public ChlDevExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ChlDevExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
