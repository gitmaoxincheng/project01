package cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class AtmtellernoEmptyException extends ApException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4365515778243066112L;
	public AtmtellernoEmptyException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public AtmtellernoEmptyException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
