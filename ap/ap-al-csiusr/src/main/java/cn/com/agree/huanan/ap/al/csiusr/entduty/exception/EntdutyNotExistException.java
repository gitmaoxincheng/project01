package cn.com.agree.huanan.ap.al.csiusr.entduty.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @summary 实体岗不存在异常
 * @author heww
 *
 */
public class EntdutyNotExistException extends ApException{
	private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
	public EntdutyNotExistException() {
		
	}
    public EntdutyNotExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
