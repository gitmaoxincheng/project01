package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 存在有效的申领卡记录但未领卡,暂不支持再申请银行卡
 */
public class CardIsExistException extends ApException {
	private static final long serialVersionUID = 3213837972120074205L;

	public CardIsExistException() {
		super();
	}

	public CardIsExistException(String errorMsgArgs) {
		super(new Object[] { errorMsgArgs });
	}
}
