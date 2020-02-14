package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 非法入参
 * 
 *@author xiaot
 *
 *
 */
public class ApIllegalParamException extends ApException {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 构造方法
     * 
     * @param valueName 值
     */
    public ApIllegalParamException(String valueName) {
        super(new Object[] { valueName });
    }
}
