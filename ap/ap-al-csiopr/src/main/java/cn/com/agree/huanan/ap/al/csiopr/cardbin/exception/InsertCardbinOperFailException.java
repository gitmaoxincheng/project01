package cn.com.agree.huanan.ap.al.csiopr.cardbin.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class InsertCardbinOperFailException extends ApException{

	/**
     * @summary 插入卡bin审批表失败
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public InsertCardbinOperFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertCardbinOperFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
