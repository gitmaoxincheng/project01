package cn.com.agree.huanan.ap.al.csiusr.parasyn.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 综合后管同步登记表插入数据失败
 */
public class ParasynInsertException extends ApException {

	private static final long serialVersionUID = 1L;

	public ParasynInsertException() {
		super();
	}

	/**
	 * 
	 * @param errMsg 错误信息
	 */
	public ParasynInsertException(String errMsg) {
		super(new Object[] {
				errMsg
		});
	}

	
}
