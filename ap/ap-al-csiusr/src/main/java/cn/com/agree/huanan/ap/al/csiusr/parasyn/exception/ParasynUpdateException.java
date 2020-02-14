package cn.com.agree.huanan.ap.al.csiusr.parasyn.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新数据异常,更新同步登记表信息失败
 */
public class ParasynUpdateException extends ApException {

	private static final long serialVersionUID = 1L;

	public ParasynUpdateException() {
		
	}
	
	/**
	 * 
	 * @param errMsg 错误信息
	 */
	public ParasynUpdateException(String errMsg) {
		super(new Object[] {
				errMsg
		});
		
	}

}
