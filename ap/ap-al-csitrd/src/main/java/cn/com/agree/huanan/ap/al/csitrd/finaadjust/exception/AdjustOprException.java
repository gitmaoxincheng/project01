package cn.com.agree.huanan.ap.al.csitrd.finaadjust.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 
 * @author JZF
 */
public class AdjustOprException extends ApException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8772360042618313431L;

	public AdjustOprException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
