package cn.com.agree.huanan.ap.al.csitrd.card.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * ESB校验出错异常
 * @author lixq
 *
 */
public class CheckEsbException extends ApException  {

	 private static final long serialVersionUID = 1L;
	    
	    /**
	     * @param errMsg 错误信息
	     */
	    public CheckEsbException(String errMsg) {
	        super(new Object[] {
	            errMsg
	        });
	    }
}
