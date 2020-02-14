package cn.com.agree.huanan.ap.al.csiusr.teller.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author heww 被操作柜员与网点非隶属关系
 */
public class TellerBranchNotSubjectionException extends ApException {
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public TellerBranchNotSubjectionException(String errMsg) {
        super(new Object[] {
            errMsg,errMsg
        });
    }
}
