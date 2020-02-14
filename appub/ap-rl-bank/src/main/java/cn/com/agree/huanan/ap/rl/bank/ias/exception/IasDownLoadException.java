package cn.com.agree.huanan.ap.rl.bank.ias.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class IasDownLoadException extends ApException{
	
	private static final long serialVersionUID = 1L;
	
	public IasDownLoadException() {

	}

	/**
	 * @param errMsg 错误信息
	 */
	public IasDownLoadException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}

}
