package cn.com.agree.huanan.ap.al.csiusr.rtmh.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

//等级修改异常数据
public class UpdateInfoException extends ApException{

	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public UpdateInfoException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public UpdateInfoException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

	
}
