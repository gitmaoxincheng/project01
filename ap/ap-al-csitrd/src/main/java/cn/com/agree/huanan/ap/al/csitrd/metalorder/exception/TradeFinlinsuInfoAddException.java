package cn.com.agree.huanan.ap.al.csitrd.metalorder.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 贵金属订单新增失败
 * @author bodadmin
 *
 */
public class TradeFinlinsuInfoAddException extends ApException{

	private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
	public TradeFinlinsuInfoAddException() {
		
	}
    public TradeFinlinsuInfoAddException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
