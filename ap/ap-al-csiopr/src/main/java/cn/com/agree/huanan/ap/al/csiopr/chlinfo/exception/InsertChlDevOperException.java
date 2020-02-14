package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 添加渠道白名单审批信息失败
 */
public class InsertChlDevOperException extends ApException {


	private static final long serialVersionUID = 1L;
	/**
     * @param errMsg 错误信息
     */
    public InsertChlDevOperException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertChlDevOperException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	

}
