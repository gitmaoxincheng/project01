package cn.com.agree.huanan.ap.al.csitrd.intermediate.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 插入数据异常
 * @author bodadmin
 *
 */
public class IntermediateInfoAddException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * @param errMsg 错误信息
     */
    public IntermediateInfoAddException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
