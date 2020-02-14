package cn.com.agree.huanan.ap.al.csiusr.entduty.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @summary 无数据异常
 * @author bodadmin
 *
 */
public class CheckNoDataException extends ApException{
	private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
	public CheckNoDataException() {
		
	}
    public CheckNoDataException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
