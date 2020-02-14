package cn.com.agree.huanan.ap.al.csitrd.rcpt.exception;


import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 单据号错误
 * */
public class NoCorrectBillNo extends ApException{


	private static final long serialVersionUID = 6904862964025614436L;

	public NoCorrectBillNo(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
	
	
}




