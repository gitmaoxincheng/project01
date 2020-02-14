package cn.com.agree.huanan.ap.al.csitrd.cert.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 凭证管理信息明细新增异常
 * @author ZengS
 *
 */
public class InsertVochManaInfoFailException extends ApException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8812306419525129817L;
	
	 /**
     * @param errMsg 错误信息
     */
    public InsertVochManaInfoFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertVochManaInfoFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
