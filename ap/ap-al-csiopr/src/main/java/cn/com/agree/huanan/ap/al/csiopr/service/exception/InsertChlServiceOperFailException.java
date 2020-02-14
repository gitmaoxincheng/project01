package cn.com.agree.huanan.ap.al.csiopr.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 插入渠道待审批记录失败
 * @author wb
 *
 */

public class InsertChlServiceOperFailException extends ApException{
    private static final long serialVersionUID = 1L;
    public InsertChlServiceOperFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertChlServiceOperFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
