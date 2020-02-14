package cn.com.agree.huanan.ap.rl.bank.ias.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class IasUploadException extends ApException{

	private static final long serialVersionUID = 1L;
	
	public IasUploadException() {

	}

	/**
	 * @param errMsg 错误信息
	 */
	public IasUploadException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}

}
