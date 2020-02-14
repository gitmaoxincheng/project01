package cn.com.agree.huanan.ap.rl.bank.ias.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class IasUpdateException extends ApException{
	private static final long serialVersionUID = 1L;

	public IasUpdateException() {

	}

	/**
	 * @param errMsg 错误信息
	 */
	public IasUpdateException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
}
