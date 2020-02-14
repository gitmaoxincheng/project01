package cn.com.agree.huanan.ap.al.csiusr.branch.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 插入数据异常，新增机构失败
 */
public class BranchInsertException extends ApException {
	private static final long serialVersionUID = 1L;
	
	public BranchInsertException() {
	}
	
	/**
	 * 
	 * @param errMsg 错误信息
	 */
	public BranchInsertException(String errMsg){
		super(new Object[] {
				errMsg
		});
	}
}
