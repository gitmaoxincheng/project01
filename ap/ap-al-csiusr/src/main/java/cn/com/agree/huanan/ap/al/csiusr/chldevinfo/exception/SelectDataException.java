package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class SelectDataException extends ApException{

	/**
     * 查询岗位异常类
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public SelectDataException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public SelectDataException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
}
