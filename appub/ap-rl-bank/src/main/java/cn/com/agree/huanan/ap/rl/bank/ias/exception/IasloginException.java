package cn.com.agree.huanan.ap.rl.bank.ias.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class IasloginException extends ApException{

	private static final long serialVersionUID = 1L;

	public IasloginException() {

	}

	/**
	 * @param errMsg 错误信息
	 */
	public IasloginException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}

}
