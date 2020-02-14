package cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 清机维护明细数据新增异常
 * @author hzp
 *
 */
public class InsertChlClrdtlFailException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6243602270283024101L;
	public InsertChlClrdtlFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public InsertChlClrdtlFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
