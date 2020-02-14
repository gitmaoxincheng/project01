package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 插入数据异常
 */
public class InsertException extends ApException {
	private static final long serialVersionUID = 2918506191613223637L;

	public InsertException() {
		super();
	}

	public InsertException(String errMsg) {
		super(new Object[] { errMsg });
	}
}
