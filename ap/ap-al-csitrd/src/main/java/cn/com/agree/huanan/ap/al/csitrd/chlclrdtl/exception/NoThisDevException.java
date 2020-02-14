package cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class NoThisDevException extends ApException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5631025287130475340L;
	public NoThisDevException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public NoThisDevException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
