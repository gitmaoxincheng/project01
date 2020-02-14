package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 不满足查询条件
 */
public class QueryConditionException extends ApException {
	private static final long serialVersionUID = 3213837972120074205L;

	public QueryConditionException() {
		super();
	}

	public QueryConditionException(String errorMsgArgs) {
		super(new Object[] { errorMsgArgs });
	}
}
