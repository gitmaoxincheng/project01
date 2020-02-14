package cn.com.agree.huanan.ap.rl.bank.ias.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class IasLogoutException extends ApException{

	private static final long serialVersionUID = 1L;

	public IasLogoutException() {

	}

	/**
	 * @param errMsg 错误信息
	 */
	public IasLogoutException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}


}
