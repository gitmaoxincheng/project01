package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 柜员存在多个网点
 * @author bodadmin
 *
 */
public class TellerExistMulBrno extends ApException {
	private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerExistMulBrno(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
