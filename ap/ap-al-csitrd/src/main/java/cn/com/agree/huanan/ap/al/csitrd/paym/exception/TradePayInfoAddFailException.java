package cn.com.agree.huanan.ap.al.csitrd.paym.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 支付结算业务登记簿保存失败异常
 * @author MAOW
 *
 */
public class TradePayInfoAddFailException extends ApException {

	private static final long serialVersionUID = 1L;
	
    /**
     * @param errMsg 错误信息
     */
    public TradePayInfoAddFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
