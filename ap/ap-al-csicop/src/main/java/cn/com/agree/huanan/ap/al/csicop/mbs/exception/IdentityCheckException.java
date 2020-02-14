package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 身份证核查异常
 */
public class IdentityCheckException extends ApException {
	private static final long serialVersionUID = 3286543296611097684L;

	public IdentityCheckException() {
		super();
	}

	public IdentityCheckException(String errorMsg) {
		super(new Object[] { errorMsg });
	}
}
