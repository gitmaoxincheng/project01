package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class MenuabTypeException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuabTypeException() {
		// TODO 自动生成的构造函数存根
	}
	
	public MenuabTypeException(String errMsg) {
		super(new Object[] {
	            errMsg
	        });
	}
	
	public MenuabTypeException(int index,String errMsg) {
		super(new Object[] {
	            errMsg
	        });
	}

}
