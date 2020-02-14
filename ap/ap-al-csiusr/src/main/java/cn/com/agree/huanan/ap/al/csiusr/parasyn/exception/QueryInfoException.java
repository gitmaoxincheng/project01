package cn.com.agree.huanan.ap.al.csiusr.parasyn.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 综合后管同步登记表插入数据失败
 */
public class QueryInfoException extends ApException {

	private static final long serialVersionUID = 1L;

	public QueryInfoException() {
		super();
	}

	/**
	 * 
	 * @param errMsg 错误信息
	 */
	public QueryInfoException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}

	
}
