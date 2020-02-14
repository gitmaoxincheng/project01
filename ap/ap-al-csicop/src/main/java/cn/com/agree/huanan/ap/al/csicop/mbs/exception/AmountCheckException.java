package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 金额校验异常
 */
public class AmountCheckException extends ApException {
	private static final long serialVersionUID = 5128839433242276023L;

	public AmountCheckException() {
		super();
	}

	public AmountCheckException(String errorMsgArgs) {
		super(new Object[] { errorMsgArgs });
	}
}
