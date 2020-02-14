package cn.com.agree.huanan.ap.tl.communicate.comm.exception;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;

public class NoCommParamException extends BaseException{

	/**
	 * 通信异常
	 */
	private static final long serialVersionUID = 1L;
	
	public static NoCommParamException exception = null;
	
	public static final NoCommParamException getException(){
		if (exception == null){
			exception = new NoCommParamException();
		}
		return exception;
	}

}
