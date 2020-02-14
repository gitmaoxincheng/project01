package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP 渠道IP无接入权限
 */
public class ChannelIPIllegalException extends ApException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errMsg 错误信息
     */
    public ChannelIPIllegalException() {
    }
    /**
     * @param errMsg 错误信息
     */
    public ChannelIPIllegalException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
