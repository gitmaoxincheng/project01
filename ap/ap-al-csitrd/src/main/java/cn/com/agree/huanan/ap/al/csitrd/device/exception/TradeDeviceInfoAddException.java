package cn.com.agree.huanan.ap.al.csitrd.device.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 插入数据异常
 * @author bodadmin
 *
 */
public class TradeDeviceInfoAddException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * @param errMsg 错误信息
     */
    public TradeDeviceInfoAddException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
