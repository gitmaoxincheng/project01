package cn.com.agree.huanan.ap.al.csiusr.branch.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 机构已存在
 * @author xuzhen
 *
 */
public class BranchHasExistException extends ApException{

	private static final long serialVersionUID = 1L;

	public BranchHasExistException() {
		super();
	}

	/**
	 * 
	 * @param errMsg 错误信息
	 */
	public BranchHasExistException(String errMsg) {
		super(new Object[] {
				errMsg
		});
		
	}
	
}
