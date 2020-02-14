package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 值缺失
 * 
 * @author tan.ch
 *
 */
public class ApValueMissException extends ApException {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 构造方法
     * 
     * @param valueName 值
     */
    public ApValueMissException(String valueName) {
        super(new Object[] { valueName });
    }
}
