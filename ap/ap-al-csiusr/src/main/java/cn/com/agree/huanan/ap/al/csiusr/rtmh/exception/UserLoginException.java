package cn.com.agree.huanan.ap.al.csiusr.rtmh.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;



/**
 * 插入数据异常，新增机构失败
 */
public class UserLoginException extends ApException{

	private static final long serialVersionUID = 1L;
	
	public UserLoginException() {
	}
	
	/**
	 * 
	 * @param errMsg 错误信息
	 */
	public UserLoginException(String errMsg){
		super(new Object[] {
				errMsg
		});
	}
	
}
