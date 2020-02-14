package cn.com.agree.huanan.ap.tl.communicate.comm.exception;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;

public class TradeInitFailedException extends BaseException{

	/**
	 * 通信异常
	 */
	private static final long serialVersionUID = 1L;
	
	public static TradeInitFailedException exception = null;
	
	public static final TradeInitFailedException getException(){
		if (exception == null){
			exception = new TradeInitFailedException();
		}
		return exception;
	}

}
