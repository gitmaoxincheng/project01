package cn.com.agree.huanan.ap.al.csitrd.rcpt.exception;


import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新单据表异常
 * */
public class UpdateTradeBillFailException extends ApException{


	private static final long serialVersionUID = 6904862964025614438L;

	public UpdateTradeBillFailException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
	
	
}




