package cn.com.agree.huanan.ap.al.csiusr.branch.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 机构同步操作异常
 * @author xuzhen 
 */
public class PushInfoException extends ApException{

    private static final long serialVersionUID = 1L;
   
    public PushInfoException() {
	}
    
    /**
     * @param errMsg 错误信息
     */
    public PushInfoException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
