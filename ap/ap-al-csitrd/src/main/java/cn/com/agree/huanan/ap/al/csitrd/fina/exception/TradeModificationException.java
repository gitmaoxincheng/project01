package cn.com.agree.huanan.ap.al.csitrd.fina.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 修改数据异常
 * @author bodadmin
 *
 */
public class TradeModificationException extends ApException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * @param errMsg 错误信息
     */
    public TradeModificationException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
