package cn.com.agree.huanan.ap.tl.communicate.comm.exception.base;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class BaseException extends ApException{

	protected BaseException(String appId, String errorCode,
			String errorMsg) {
		// TODO 自动生成的构造函数存根
		super(appId, errorCode, errorMsg);
	}
	
    public BaseException(Exception ex) {
        super(ex);
    }
	
	public BaseException(){
		super();
	}
    
	protected BaseException(Object[] objects){
		super(objects);
	}
	/**
	 * 异常基础类
	 */
	private static final long serialVersionUID = 1L;
}
