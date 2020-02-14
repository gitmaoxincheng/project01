package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 更新渠道白名单审批失败
 */
public class UpdateChlDevOperFailException extends ApException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @param errMsg 错误信息
     */
    public UpdateChlDevOperFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public UpdateChlDevOperFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
