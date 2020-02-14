package cn.com.agree.huanan.ap.al.csitrd.auth.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 审核授权登记簿保存失败异常
 * @author chents
 *
 */
public class TradeInfoAuthCheckMaimAddFailException extends ApException{

	private static final long serialVersionUID = -1494666327376507906L;
	
	/**
     * @param errMsg 错误信息
     */
    public TradeInfoAuthCheckMaimAddFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
