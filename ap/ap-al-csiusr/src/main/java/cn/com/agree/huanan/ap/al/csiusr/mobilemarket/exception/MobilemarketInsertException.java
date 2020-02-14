package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class MobilemarketInsertException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MobilemarketInsertException() {
		// TODO 自动生成的构造函数存根
	}
	
	public MobilemarketInsertException(String errMsg) {
		super(new Object[] {
	            errMsg
	        });
	}

	public MobilemarketInsertException(int index,String errMsg) {
		super(new Object[] {
	            errMsg
	        });
	}
}
