package cn.com.agree.huanan.ap.tl.communicate.comm.exception;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;
public class CommFailedException extends BaseException{

	/**
	 * 通信失败
	 */
	private static final long serialVersionUID = 1L;
	
	public CommFailedException(String appId) {
		super(new Object[] {appId});
	}

	public static CommFailedException getException() {
		// TODO 自动生成的方法存根
		return null;
	}
}
