package cn.com.agree.huanan.ap.al.csiusr.entduty.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @summary 已存有有效的具有库管员属性的实体岗异常
 * @author heww
 *
 */
public class WareHouserExistException extends ApException{
	private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
	public WareHouserExistException() {
		
	}
    public WareHouserExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
