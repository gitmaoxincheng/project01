package tc.platform.context.exception;

import java.sql.SQLException;

import tc.platform.constant.exception.BaseErrorCode;

public class DBException extends SQLException {

	private BaseErrorCode errorCode;
	
	public DBException(BaseErrorCode errorCode) {
		super(errorCode.getMsg());
		this.errorCode = errorCode;
	}
	
	public DBException(Throwable throwable) {
		super(throwable);
	}
	
	public DBException(BaseErrorCode errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public DBException(BaseErrorCode errorCode,Throwable throwable) {
		super(throwable);
		this.errorCode = errorCode;
	}
	
	public DBException(BaseErrorCode errorCode,String message,Throwable throwable) {
		super(message,throwable);
		this.errorCode = errorCode;
	}
	
	public BaseErrorCode getBaseErrorCode() {
		return errorCode;
	}
	
}