package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 删除数据异常
 */
public class DeleteException extends ApException {
	private static final long serialVersionUID = -3951304499084613915L;

	public DeleteException() {
		super();
	}

	public DeleteException(String errMsg) {
		super(new Object[] { errMsg });
	}
}
