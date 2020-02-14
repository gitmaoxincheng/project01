package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 查询数据异常
 */
public class SelectException extends ApException {
	private static final long serialVersionUID = 3286543296611097684L;

	public SelectException() {
		super();
	}

	public SelectException(String errorMsg) {
		super(new Object[] { errorMsg });
	}
}
