package cn.com.agree.huanan.ap.al.csitrd.rcpt.exception;


import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 插入单据图片表异常
 * */
public class InsertTradeBillImageFailException extends ApException{


	private static final long serialVersionUID = 6904862964025614436L;

	public InsertTradeBillImageFailException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
	
	
}




