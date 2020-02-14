package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author acz 渠道请求非法
 */
public class ChannelReqIllegalException extends ApException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errMsg 错误信息
     */
    public ChannelReqIllegalException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
