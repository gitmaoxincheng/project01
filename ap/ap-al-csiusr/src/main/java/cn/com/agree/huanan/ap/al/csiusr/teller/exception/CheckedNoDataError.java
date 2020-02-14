package cn.com.agree.huanan.ap.al.csiusr.teller.exception;
/**
 * 没有符合的记录
 * @author bodadmin
 *
 */

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class CheckedNoDataError extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public CheckedNoDataError(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
