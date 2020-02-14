package cn.com.agree.huanan.ap.rl.bank.encrypt.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class MacCheckException extends ApException{

	private static final long serialVersionUID = -5824380977043043062L;

	public MacCheckException() {

	}

	/**
	 * @param errMsg 错误信息
	 */
	public MacCheckException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}


}
