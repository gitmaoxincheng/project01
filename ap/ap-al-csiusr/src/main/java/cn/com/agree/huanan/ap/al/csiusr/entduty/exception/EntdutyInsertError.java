package cn.com.agree.huanan.ap.al.csiusr.entduty.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;
/**
 * 实体岗新增失败
 * @author bodadmin
 *
 */
public class EntdutyInsertError extends ApException{

	private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
	public EntdutyInsertError() {
		
	}
    public EntdutyInsertError(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
