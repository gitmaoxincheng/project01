package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class MobilemarketUpdateException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MobilemarketUpdateException() {
		// TODO 自动生成的构造函数存根
	}
	
	public MobilemarketUpdateException(String errMsg) {
		super(new Object[] {
	            errMsg
	        });
	}

	public MobilemarketUpdateException(int index,String errMsg) {
		super(new Object[] {
	            errMsg
	        });
	}
}
