package cn.com.agree.huanan.ap.tl.communicate.comm.exception.http;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;

public class UnsupportOperatorException extends BaseException{
	/**
	 * 报文格式不支持
	 */
	private static final long serialVersionUID = 1L;
	
	public static NotHttpRequestBaseObjectException exception = null;
	
	public static final NotHttpRequestBaseObjectException getException(){
		if (exception == null){
			exception = new NotHttpRequestBaseObjectException();
		}
		return exception;
	}

}
