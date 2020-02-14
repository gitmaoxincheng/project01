package cn.com.agree.huanan.ap.al.csiusr.branch.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新状态操作失败
 */
public class BranchUpdateException extends ApException {

	private static final long serialVersionUID = 1L;

	public BranchUpdateException() {
	}

	/**
	 * 
	 * @param errorMsgArgs 异常信息
	 */
	public BranchUpdateException(String errorMsgArgs) {
		super(new Object[] {
				errorMsgArgs
		});
	}
}
