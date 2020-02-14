package cn.com.agree.huanan.ap.al.csiusr.entduty.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 实体岗新增异常
 * @author heww
 *
 */
public class EntdutyCreateException extends ApException {

	private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public EntdutyCreateException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
