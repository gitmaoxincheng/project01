package cn.com.agree.huanan.ap.al.csiusr.purp.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 柜员登陆随机数生成异常类
 * @author hww
 *
 */
public class tellerLoginRandomGenException extends ApException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public tellerLoginRandomGenException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public tellerLoginRandomGenException(String errMsg) {
        super(new Object[] {
                errMsg
        });
    }
}
