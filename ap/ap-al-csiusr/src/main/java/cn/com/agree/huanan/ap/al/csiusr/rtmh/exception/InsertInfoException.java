package cn.com.agree.huanan.ap.al.csiusr.rtmh.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

//插入异常数据
public class InsertInfoException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * @param errMsg 错误信息
     */
    public InsertInfoException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
}
