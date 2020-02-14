package cn.com.agree.huanan.ap.rl.bank.base.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 * 消息通知失败异常
 */
public class ApMsgInformFailException extends ApException {

    private static final long serialVersionUID = 1L;
    /** XXX 未配置错误码
     * @param key 消息通知目标
     * @param desc 消息来源
     */
    public ApMsgInformFailException(String target,String src){
        super(new String[]{src,target});
    }
}
