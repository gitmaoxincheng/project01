package cn.com.agree.huanan.ap.tl.exception.tech;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;

/**
 * 通讯超时
 * 
 * @author tam
 *
 */
public class ApCommTimeOutException extends BaseException {
    public ApCommTimeOutException(String appId) {
		super(new Object[] {appId});

    }
	
}
