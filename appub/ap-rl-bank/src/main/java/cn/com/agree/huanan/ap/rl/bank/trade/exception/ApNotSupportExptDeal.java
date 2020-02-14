package cn.com.agree.huanan.ap.rl.bank.trade.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 * 交易码不支持超时处理
 */
public class ApNotSupportExptDeal extends ApException {

    private static final long serialVersionUID = 1L;
    /*
     * @param tradecode 交易码
     */
    public ApNotSupportExptDeal(String tradecode){
        super(new String[]{tradecode});
    }
}
