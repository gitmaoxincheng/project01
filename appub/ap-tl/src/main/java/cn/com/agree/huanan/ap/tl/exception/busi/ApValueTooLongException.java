package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 值过长
 * 
 * @author tan.ch
 *
 */
public class ApValueTooLongException extends ApException {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;

    
    /**
     * 构造方法
     * 
     * @param valueLen 值长度
     * @param maxLen 最大长度
     */
    public ApValueTooLongException(int valueLen, int maxLen) {
        super(new Object[] {valueLen, maxLen });
    }
    
    /**
     * 构造方法
     * @param key 键
     * @param valueLen 值长度
     * @param maxLen 最大长度
     */
    public ApValueTooLongException(int valueLen, int maxLen,String key) {
        super(2,new Object[] {key, valueLen, maxLen});
    }
}
