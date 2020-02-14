package cn.com.agree.huanan.ap.al.csitrd.mide.exception;


import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 插入特色业务异常
 * */
public class InsertIntermediateMainFailException extends ApException{


	private static final long serialVersionUID = 6904862964025614435L;

	public InsertIntermediateMainFailException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
	
	
}




