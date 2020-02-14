package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 存在待处理记录
 * @author xuzhen
 */
public class ExistToBeProcessed extends ApException {
	private static final long serialVersionUID = 5128839433242276023L;

	public ExistToBeProcessed() {
		super();
	}

	public ExistToBeProcessed(String errorMsgArgs) {
		super(new Object[] { errorMsgArgs });
	}
}
