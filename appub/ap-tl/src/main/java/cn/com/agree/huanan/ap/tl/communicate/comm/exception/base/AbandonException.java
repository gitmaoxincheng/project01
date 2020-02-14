package cn.com.agree.huanan.ap.tl.communicate.comm.exception.base;

public class AbandonException extends BaseException{

	/**
	 * 无异常类
	 */
	private static final long serialVersionUID = 1L;
	
	public static AbandonException exception = null;
	
	public static final AbandonException getAbandon(){
		if (exception == null){
			exception = new AbandonException();
		}
		return exception;
	}
}
