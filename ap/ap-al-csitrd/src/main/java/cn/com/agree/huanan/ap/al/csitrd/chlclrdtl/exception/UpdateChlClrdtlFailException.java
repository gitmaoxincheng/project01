package cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class UpdateChlClrdtlFailException extends ApException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 544709886192449995L;

	/**
	 * 默认构造函数
	 */
	public UpdateChlClrdtlFailException(){
		super();
	}
	
	/**
	 * 
	 * @param msg 错误信息
	 */
	public UpdateChlClrdtlFailException(String msg) {
		super(new Object[] {msg});
	}
}
