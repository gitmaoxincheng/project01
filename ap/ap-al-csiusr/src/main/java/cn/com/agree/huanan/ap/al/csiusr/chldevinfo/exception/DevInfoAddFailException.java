package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 自助设备添加失败异常
 * @author lixq
 *
 */
public class DevInfoAddFailException extends ApException  {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errMsg 错误信息
     */
    public DevInfoAddFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
}
