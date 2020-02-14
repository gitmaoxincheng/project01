package cn.com.agree.huanan.ap.tl.communicate.comm.exception.http;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;

public class NullHttpEntityException extends BaseException{
	/**
	 * 报文格式不支持
	 */
	private static final long serialVersionUID = 1L;
	
	public static NullHttpEntityException exception = null;
	
	public static final NullHttpEntityException getException(){
		if (exception == null){
			exception = new NullHttpEntityException();
		}
		return exception;
	}

}
