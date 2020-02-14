package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 岗位类别新增异常
 * @author heww 
 */
public class DutyAddException  extends ApException{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public DutyAddException(String errMsg) {
        super(new Object[] {
        		errMsg
        });
    }
}
