package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class DutyQueryException extends ApException{
	/**
     * 查询岗位异常类
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public DutyQueryException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public DutyQueryException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
