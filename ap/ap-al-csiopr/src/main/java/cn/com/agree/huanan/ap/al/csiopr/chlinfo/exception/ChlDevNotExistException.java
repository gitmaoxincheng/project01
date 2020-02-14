package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道白名单不存在
 */
public class ChlDevNotExistException extends ApException {


	private static final long serialVersionUID = 1L;
	/**
     * @param errMsg 错误信息
     */
    public ChlDevNotExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ChlDevNotExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
