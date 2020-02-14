package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 值过短
 * 
 * @author tan.ch
 *
 */
public class ApValueTooShortException extends ApException {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 构造方法
     * 
     * @param valueLen 值长度
     * @param minLen 最小长度
     */
    public ApValueTooShortException(int valueLen, int minLen) {
        super(new Object[] { valueLen, minLen });
    }
    
    /**
     * 构造方法
     * @param key 键
     * @param valueLen 值长度
     * @param minLen 最小长度
     */
    public ApValueTooShortException(int valueLen, int minLen,String key) {
        super(new Object[] { valueLen, minLen,key});
    }
    
}
