package cn.com.agree.huanan.ap.al.csitrd.device.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 更新数据异常
 * @author bodadmin
 *
 */
public class TradeDeviceInfoUpdateException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * @param errMsg 错误信息
     */
    public TradeDeviceInfoUpdateException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
