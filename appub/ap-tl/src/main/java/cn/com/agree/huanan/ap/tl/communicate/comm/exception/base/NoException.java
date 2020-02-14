package cn.com.agree.huanan.ap.tl.communicate.comm.exception.base;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;

public class NoException extends BaseException{

	/**
	 * 无异常类
	 */
	private static final long serialVersionUID = 1L;
	
	public static NoException exception = null;
	
	public static final NoException getNoException(){
		if (exception == null){
			exception = new NoException();
		}
		return exception;
	}
	
	
	private NoException(){
		super(Const.DEFAULT_COMM_APPID, Const.DEFAULT_NO_EORRORCODE, Const.DEFAULT_NO_EORRORMSG);
	}
}
