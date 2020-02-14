package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 值超出范围
 * 
 * @author tan.ch
 *
 */
public class ApValueOutOfRangeException extends ApException {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 构造方法
     * 
     * @param value 值
     */
    public ApValueOutOfRangeException(Object value) {
        super(new Object[] { value });
    }
}
