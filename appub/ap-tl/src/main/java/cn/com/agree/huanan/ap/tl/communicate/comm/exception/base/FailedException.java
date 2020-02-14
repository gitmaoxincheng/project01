package cn.com.agree.huanan.ap.tl.communicate.comm.exception.base;

public class FailedException extends BaseException{

	/**
	 * 无异常类
	 */
	private static final long serialVersionUID = 1L;
	
	public static FailedException exception = null;
	
	public static final FailedException getFailed(){
		if (exception == null){
			exception = new FailedException();
		}
		return exception;
	}
}
