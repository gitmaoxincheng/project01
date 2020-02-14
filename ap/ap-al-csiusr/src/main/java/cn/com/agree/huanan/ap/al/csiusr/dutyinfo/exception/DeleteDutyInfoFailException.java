package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class DeleteDutyInfoFailException extends ApException{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public DeleteDutyInfoFailException(String errMsg) {
        super(new Object[] {
        		errMsg
        });
    }
}
