package cn.com.agree.huanan.ap.al.csitrd.auth.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 审核授权登记簿更新失败异常
 * @author chents
 *
 */
public class TradeInfoAuthCheckMaimUpdateFailException extends ApException{

	private static final long serialVersionUID = 650823120999557931L;
	
	
	/**
     * @param errMsg 错误信息
     */
    public TradeInfoAuthCheckMaimUpdateFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
