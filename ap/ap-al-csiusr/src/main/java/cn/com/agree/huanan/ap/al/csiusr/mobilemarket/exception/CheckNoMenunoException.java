package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class CheckNoMenunoException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CheckNoMenunoException() {
		
	}
	
	public CheckNoMenunoException(String errMsg) {
		 super(new Object[] {
		            errMsg
		        });
	}
	
	public CheckNoMenunoException(int index,String errMsg) {
		super(new Object[] {
	            errMsg
	        });
	}
}
