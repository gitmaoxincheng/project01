package cn.com.agree.huanan.ap.al.csicop.mbs.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 柜员锁定
 * @author xuzhen
 */
public class TellerHasLock extends ApException {
	private static final long serialVersionUID = 5128839433242276023L;

	public TellerHasLock() {
		super();
	}

	public TellerHasLock(String errorMsgArgs) {
		super(new Object[] { errorMsgArgs });
	}

	public TellerHasLock(String tellerNo, String errorMsg) {
		super(new Object[] {tellerNo, errorMsg});
	}
	
}
