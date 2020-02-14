package cn.com.agree.huanan.ap.al.csitrd.exchange.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 插入数据异常
 * @author bodadmin
 *
 */
public class TradeExchangeInfoAddException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * @param errMsg 错误信息
     */
    public TradeExchangeInfoAddException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
