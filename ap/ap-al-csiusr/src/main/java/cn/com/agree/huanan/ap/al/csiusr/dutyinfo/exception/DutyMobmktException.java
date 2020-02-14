package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author lixq 移动营销岗位
 */
public class DutyMobmktException extends ApException {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public DutyMobmktException() {
    }
    /**
     * @param brno 机构名
     */
    public DutyMobmktException(String errMsg) {
        super(new Object[] {
        		errMsg
        });
    }
}
