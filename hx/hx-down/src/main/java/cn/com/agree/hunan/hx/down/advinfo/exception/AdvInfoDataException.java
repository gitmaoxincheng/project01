package cn.com.agree.hunan.hx.down.advinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 
 * @author Maoxc
 *
 */

public class AdvInfoDataException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public AdvInfoDataException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public AdvInfoDataException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
