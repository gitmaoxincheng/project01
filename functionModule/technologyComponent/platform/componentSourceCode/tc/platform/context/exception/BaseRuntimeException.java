package tc.platform.context.exception;

import org.slf4j.helpers.MessageFormatter;

import tc.platform.constant.exception.BaseErrorCode;

public class BaseRuntimeException extends RuntimeException {
	
	private BaseErrorCode errorCode;
	
	public BaseRuntimeException(BaseErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public BaseRuntimeException(Throwable cause) {
		super(cause);
	}
	
	public BaseRuntimeException(BaseErrorCode errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public BaseRuntimeException(BaseErrorCode errorCode,Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}
	
	public BaseRuntimeException(BaseErrorCode errorCode,String message,Throwable cause) {
		super(message,cause);
		this.errorCode = errorCode;
	}
	
	public static BaseRuntimeException errorWith(BaseErrorCode errorCode) {
		return new BaseRuntimeException(errorCode);
	}
	
	/**
	 * message和objects跟打印log是的格式一样
	 * 比如:throw BaseRuntimeException.errorWith(CommonErrorCodeEnum.PARAMETER_ERROR,"appid err,appid={}");
	 * @param errorCode  BaseErrorCode的子类枚举
	 * @param message    这里的message只会用于服务端打印日志
	 * @param objects    即message的格式化参数,如果有Throwale类别,放在最后一位
	 * @return
	 */
    public static BaseRuntimeException errorWith(BaseErrorCode errorCode,String message,Object...objects) {
    	if (objects == null || objects.length == 0) {
			return new BaseRuntimeException(errorCode,message);
		}
    	
    	if (objects[objects.length -1] instanceof Throwable) {
			Throwable throwable = (Throwable)objects[objects.length - 1];
			objects = trimmedCopy(objects);
			return new BaseRuntimeException(errorCode,MessageFormatter.arrayFormat(message, objects).getMessage(),throwable);
		}
    	return new BaseRuntimeException(errorCode,MessageFormatter.arrayFormat(message, objects).getMessage());
    }
	
    private static Object[] trimmedCopy(Object[] argArray) {
    	final int trimemdLen = argArray.length - 1;
    	Object[] trimmed = new Object[trimemdLen];
    	System.arraycopy(argArray, 0, trimmed, 0, trimemdLen);
    	return trimmed;
    }
	
    
    public static BaseRuntimeException errorWith(BaseErrorCode errorCode,Throwable cause) {
    	return new BaseRuntimeException(errorCode,cause);
    }
    
    
    public static BaseRuntimeException errorWith(BaseErrorCode errorCode,String message,Throwable cause) {
    	return new BaseRuntimeException(errorCode,message,cause);
    }
    
    public BaseErrorCode getErrorCode() {
    	return errorCode;
    }
    
}
