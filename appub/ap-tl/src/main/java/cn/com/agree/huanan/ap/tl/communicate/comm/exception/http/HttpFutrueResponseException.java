package cn.com.agree.huanan.ap.tl.communicate.comm.exception.http;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;

public class HttpFutrueResponseException extends BaseException{
	/**
	 * 报文格式不支持
	 */
	private static final long serialVersionUID = 1L;
	
	public static HttpFutrueResponseException exception = null;
	
	public static final HttpFutrueResponseException getException(){
		if (exception == null){
			exception = new HttpFutrueResponseException();
		}
		return exception;
	}

}
