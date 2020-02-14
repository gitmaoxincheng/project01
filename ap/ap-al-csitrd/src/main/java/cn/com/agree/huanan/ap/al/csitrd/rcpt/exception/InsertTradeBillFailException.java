package cn.com.agree.huanan.ap.al.csitrd.rcpt.exception;


import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 插入单据表异常
 * */
public class InsertTradeBillFailException extends ApException{


	private static final long serialVersionUID = 6904862964025614435L;

	public InsertTradeBillFailException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
	
	
}




