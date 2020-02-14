package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author acz
 * 交易执行异常或失败
 */
public class TradeExcuteFailException extends ApException {



    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errorMsg 错误信息
     */
    public TradeExcuteFailException(String errorMsg) {
        super(new Object[]{errorMsg});

    }




}
