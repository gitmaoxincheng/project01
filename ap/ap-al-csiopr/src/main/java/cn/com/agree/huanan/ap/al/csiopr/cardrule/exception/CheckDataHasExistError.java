package cn.com.agree.huanan.ap.al.csiopr.cardrule.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class CheckDataHasExistError extends ApException{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public CheckDataHasExistError() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public CheckDataHasExistError(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
