package cn.com.agree.huanan.ap.tl.communicate.comm.exception;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;

public class NoBeanPathParamException extends BaseException{

	/**
	 * No Bean Path Param
	 */
	private static final long serialVersionUID = 1L;
	
	public static NoBeanPathParamException exception = null;
	
	public static final NoBeanPathParamException getException(){
		if (exception == null){
			exception = new NoBeanPathParamException();
		}
		return exception;
	}

}
