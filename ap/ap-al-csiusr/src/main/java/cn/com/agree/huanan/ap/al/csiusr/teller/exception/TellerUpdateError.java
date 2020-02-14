package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新柜员信息失败
 * @author bodadmin
 *
 */
public class TellerUpdateError extends ApException {
	private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerUpdateError(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
