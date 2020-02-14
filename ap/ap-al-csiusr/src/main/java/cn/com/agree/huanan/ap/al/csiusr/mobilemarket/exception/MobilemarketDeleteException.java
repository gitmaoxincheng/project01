package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class MobilemarketDeleteException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MobilemarketDeleteException() {
		// TODO 自动生成的构造函数存根
	}
	
	public MobilemarketDeleteException(String errMsg) {
		super(new Object[] {
	            errMsg
	        });
	}

	public MobilemarketDeleteException(int index,String errMsg) {
		super(new Object[] {
	            errMsg
	        });
	}
}
