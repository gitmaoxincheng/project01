package cn.com.agree.huanan.ap.al.csitrd.rcpt.exception;


import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 签章时没有手写签名图片异常
 * */
public class NoHandSignImageException extends ApException{


	private static final long serialVersionUID = 6904862964025614436L;

	public NoHandSignImageException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
	
	
}




