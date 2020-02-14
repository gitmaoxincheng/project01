package cn.com.agree.huanan.ap.tl.communicate.comm.exception;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;

public class CommAbandException extends BaseException{

	/**
	 * 通信异常
	 */
	private static final long serialVersionUID = 1L;
	public CommAbandException(String appId) {
		super(new Object[] {appId});
	}
	public static CommAbandException getException() {
		// TODO 自动生成的方法存根
		return null;
	}

}
