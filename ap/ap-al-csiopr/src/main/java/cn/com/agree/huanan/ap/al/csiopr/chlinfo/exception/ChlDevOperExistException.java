package cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 渠道白名单审批已存在
 */
public class ChlDevOperExistException extends ApException {


	private static final long serialVersionUID = 1L;
	/**
     * @param errMsg 错误信息
     */
    public ChlDevOperExistException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public ChlDevOperExistException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
