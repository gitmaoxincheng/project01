package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class QueryEmptyException extends ApException{
	/**
     * 查询记录为空
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public QueryEmptyException(String errMsg) {
        super(new Object[] {
        		errMsg
        });
    }
}
