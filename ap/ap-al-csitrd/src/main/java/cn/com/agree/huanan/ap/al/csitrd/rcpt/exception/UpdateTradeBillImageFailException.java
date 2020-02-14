package cn.com.agree.huanan.ap.al.csitrd.rcpt.exception;


import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新单据图片表异常
 * */
public class UpdateTradeBillImageFailException extends ApException{


	private static final long serialVersionUID = 6904862964025614439L;

	public UpdateTradeBillImageFailException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
	
	
}




