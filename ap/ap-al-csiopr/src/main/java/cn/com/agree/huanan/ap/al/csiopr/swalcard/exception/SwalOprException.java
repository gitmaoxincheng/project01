package cn.com.agree.huanan.ap.al.csiopr.swalcard.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class SwalOprException extends ApException {

	/**
	 * @author jiangzf 吞卡操作异常
	 */
	private static final long serialVersionUID = 3733794096234770384L;

	public SwalOprException() {

	}

	public SwalOprException(String str) {
		super(new Object[] { str });
	}

}
