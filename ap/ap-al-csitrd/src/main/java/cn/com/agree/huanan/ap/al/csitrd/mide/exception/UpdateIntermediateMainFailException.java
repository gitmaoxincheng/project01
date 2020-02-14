package cn.com.agree.huanan.ap.al.csitrd.mide.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新特色业务异常
 * */
public class UpdateIntermediateMainFailException extends ApException{

	private static final long serialVersionUID = 7248897643669166051L;

	public UpdateIntermediateMainFailException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}
	
	
}
