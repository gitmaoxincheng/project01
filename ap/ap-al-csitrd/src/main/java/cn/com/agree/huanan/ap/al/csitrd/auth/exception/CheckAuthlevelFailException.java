package cn.com.agree.huanan.ap.al.csitrd.auth.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class CheckAuthlevelFailException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4346313903009686193L;

	/**
	 * @param errMsg 错误信息
	 */
	public CheckAuthlevelFailException() {

	}
	/**
	 * @param errMsg 错误信息
	 */
	public CheckAuthlevelFailException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}



}
