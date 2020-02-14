package cn.com.agree.huanan.ap.al.csiusr.rtmh.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 签约信息登记簿修改失败异常
 * @author bodadmin
 *
 */
public class UpdateUserLoginException extends ApException{

	private static final long serialVersionUID = 1L;
	
	 /**
    * @param errMsg 错误信息
    */
   public UpdateUserLoginException(String errMsg) {
       super(new Object[] {
           errMsg
       });
   }
	
}
