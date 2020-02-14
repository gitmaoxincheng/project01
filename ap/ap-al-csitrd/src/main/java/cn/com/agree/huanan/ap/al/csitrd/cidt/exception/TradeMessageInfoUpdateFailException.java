package cn.com.agree.huanan.ap.al.csitrd.cidt.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 消息登记簿保存失败异常
 * @author lixq
 *
 */
public class TradeMessageInfoUpdateFailException extends ApException {

	private static final long serialVersionUID = 1L;
	
    /**
     * @param errMsg 错误信息
     */
    public TradeMessageInfoUpdateFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
