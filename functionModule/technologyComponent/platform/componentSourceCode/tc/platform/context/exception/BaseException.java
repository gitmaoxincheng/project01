package tc.platform.context.exception;

import tc.platform.constant.exception.BaseErrorCode;

public class BaseException extends Exception {

	private BaseErrorCode errorCode;
	
	public BaseException(BaseErrorCode errorCode) {
		super(errorCode.getMsg());
		this.errorCode = errorCode;
	}
	
	public BaseException(Throwable throwable) {
		super(throwable);
	}
	
	public BaseException(BaseErrorCode errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public BaseException(BaseErrorCode errorCode,Throwable throwable) {
		super(throwable);
		this.errorCode = errorCode;
	}
	
	public BaseException(BaseErrorCode errorCode,String message,Throwable throwable) {
		super(message,throwable);
		this.errorCode = errorCode;
	}
	
	public BaseErrorCode getErrorCode() {
		return errorCode;
	}
	
}
