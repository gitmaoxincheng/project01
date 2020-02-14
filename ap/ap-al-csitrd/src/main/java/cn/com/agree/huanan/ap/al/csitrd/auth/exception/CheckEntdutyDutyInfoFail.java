package cn.com.agree.huanan.ap.al.csitrd.auth.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class CheckEntdutyDutyInfoFail extends ApException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7202141988466263520L;
	
	/**
     * @param errMsg 错误信息
     */
    public CheckEntdutyDutyInfoFail() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public CheckEntdutyDutyInfoFail(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
}
