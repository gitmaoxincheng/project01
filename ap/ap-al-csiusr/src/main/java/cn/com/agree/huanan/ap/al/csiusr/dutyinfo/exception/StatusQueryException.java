package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 岗位状态查询异常类
 * @author hww
 *
 */

public class StatusQueryException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public StatusQueryException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public StatusQueryException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
