package cn.com.agree.huanan.ap.al.csitrd.metalorder.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 更新数据失败失败
 * @author bodadmin
 *
 */
public class TradeFinlinsuInfoUpdateException extends ApException{

	private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
	public TradeFinlinsuInfoUpdateException() {
		
	}
    public TradeFinlinsuInfoUpdateException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
