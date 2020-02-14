package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 枚举值不存在
 * 
 *@author HCP
 *
 *
 */
public class ApEumnNotExistException extends ApException {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 构造方法
     * 
     * @param valueName 值
     */
    public ApEumnNotExistException(String valueName) {
        super(new Object[] { valueName });
    }
}
