package cn.com.agree.huanan.ap.al.csitrd.paym.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 支付结算业务登记簿更新失败异常
 * @author MAOW
 *
 */
public class TradePayInfoUpdateFailException extends ApException {

	private static final long serialVersionUID = 1L;
	
    /**
     * @param errMsg 错误信息
     */
    public TradePayInfoUpdateFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
