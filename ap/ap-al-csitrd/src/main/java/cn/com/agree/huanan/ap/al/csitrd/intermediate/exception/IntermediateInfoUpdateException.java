package cn.com.agree.huanan.ap.al.csitrd.intermediate.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 更新数据异常
 * @author bodadmin
 *
 */
public class IntermediateInfoUpdateException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * @param errMsg 错误信息
     */
    public IntermediateInfoUpdateException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
