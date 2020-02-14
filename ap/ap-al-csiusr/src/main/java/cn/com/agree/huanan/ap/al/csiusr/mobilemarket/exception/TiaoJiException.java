package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class TiaoJiException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TiaoJiException() {
		
	}
	
	public TiaoJiException(String errMsg) {
		 super(new Object[] {
		            errMsg
		        });
	}
	
	public TiaoJiException(int index,String errMsg) {
		super(new Object[] {
	            errMsg
	        });
	}
}
