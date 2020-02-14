package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新数据异常
 */
public class UpdateException extends ApException {
	private static final long serialVersionUID = -4538865036466470464L;

	public UpdateException() {
		super();
	}

	public UpdateException(String errorMsgArgs) {
		super(new Object[] { errorMsgArgs });
	}
}
