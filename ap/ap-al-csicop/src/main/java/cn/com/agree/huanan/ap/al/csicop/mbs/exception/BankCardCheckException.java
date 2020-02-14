package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 银行卡信息核对异常
 */
public class BankCardCheckException extends ApException {
	private static final long serialVersionUID = 3213837972120074205L;

	public BankCardCheckException() {
		super();
	}

	public BankCardCheckException(String errorMsgArgs) {
		super(new Object[] { errorMsgArgs });
	}
}
