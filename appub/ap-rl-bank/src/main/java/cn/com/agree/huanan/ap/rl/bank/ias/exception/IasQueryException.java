package cn.com.agree.huanan.ap.rl.bank.ias.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class IasQueryException extends ApException{

	private static final long serialVersionUID = 1L;
	
	public IasQueryException() {

	}

	/**
	 * @param errMsg 错误信息
	 */
	public IasQueryException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}

}
