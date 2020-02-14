package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author lixq 柜员删除失败异常
 */
public class TellerDelFailException extends ApException {
	private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerDelFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
