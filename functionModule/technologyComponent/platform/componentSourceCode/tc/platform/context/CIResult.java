package tc.platform.context;

import cn.com.agree.afa.svc.javaengine.TCResult;
import tc.platform.constant.exception.BaseErrorCode;

public class CIResult extends TCResult {
	
	public CIResult(int status) {
		super(status);
	}

	public static TCResult newFailureResult(BaseErrorCode baseErrorCode) {
	    return new TCResult(0, baseErrorCode.getCode(), baseErrorCode.getMsg());
	}
	
	public static TCResult newFailureResult(BaseErrorCode baseErrorCode, String errorMsg) {
		return newFailureResult(baseErrorCode.getCode(), errorMsg);
	}
}
