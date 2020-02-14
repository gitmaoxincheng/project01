package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 岗位类别初始化异常
 * @author lixq 
 */
public class DutyInitException  extends ApException{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @param errMsg 错误信息
     */
    public DutyInitException(String errMsg) {
        super(new Object[] {
        		errMsg
        });
    }
}
