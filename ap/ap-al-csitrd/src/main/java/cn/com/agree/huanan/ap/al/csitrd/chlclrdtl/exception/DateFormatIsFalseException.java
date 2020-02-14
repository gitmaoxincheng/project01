package cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class DateFormatIsFalseException extends ApException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5605529581032666833L;
	public DateFormatIsFalseException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public DateFormatIsFalseException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
