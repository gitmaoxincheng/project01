package cn.com.agree.huanan.ap.tl.exception.tech;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 系统异常
 * 
 * @author tan.ch
 *
 */
public class ApSystemException extends ApException {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 构造方法
     * 
     * @param ex 源异常
     */
    public ApSystemException(Throwable ex) {
        super(ex);
    }
}
