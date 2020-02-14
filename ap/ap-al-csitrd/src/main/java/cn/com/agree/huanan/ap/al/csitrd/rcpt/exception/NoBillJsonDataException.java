package cn.com.agree.huanan.ap.al.csitrd.rcpt.exception;


import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 单据打印内容为空
 * */
public class NoBillJsonDataException extends ApException{


	private static final long serialVersionUID = 6904862964025614436L;

	public NoBillJsonDataException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
	
	
}




