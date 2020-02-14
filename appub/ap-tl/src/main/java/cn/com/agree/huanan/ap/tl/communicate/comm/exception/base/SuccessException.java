package cn.com.agree.huanan.ap.tl.communicate.comm.exception.base;

public class SuccessException extends BaseException{

	/**
	 * 无异常类
	 */
	private static final long serialVersionUID = 1L;
	
	public static SuccessException exception = null;
	
	public static final SuccessException getException(){
		if (exception == null){
			exception = new SuccessException();
		}
		return exception;
	}
}
