package cn.com.agree.huanan.ap.al.csitrd.rcpt.exception;


import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新单据子表异常
 * */
public class UpdateTradeBillSubFailException extends ApException{


	private static final long serialVersionUID = 6904862964025614440L;

	public UpdateTradeBillSubFailException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
	
	
}




