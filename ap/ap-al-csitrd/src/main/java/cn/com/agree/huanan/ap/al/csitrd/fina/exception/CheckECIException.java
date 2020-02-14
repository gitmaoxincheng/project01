package cn.com.agree.huanan.ap.al.csitrd.fina.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class CheckECIException extends ApException{

	/**
	 * ECI校验出错异常
	 * @author jiangzf
	 */
	private static final long serialVersionUID = 3797168664158149471L;

	/**
     * @param errMsg 错误信息
     */
    public CheckECIException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
}
