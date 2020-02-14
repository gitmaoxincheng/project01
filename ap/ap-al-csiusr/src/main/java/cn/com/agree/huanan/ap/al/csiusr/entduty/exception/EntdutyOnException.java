package cn.com.agree.huanan.ap.al.csiusr.entduty.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 柜员在岗
 * @author lixq
 *
 */
public class EntdutyOnException extends ApException {

	private static final long serialVersionUID = 1L;
	
    /**
     * @param errMsg 错误信息
     */
    public EntdutyOnException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
