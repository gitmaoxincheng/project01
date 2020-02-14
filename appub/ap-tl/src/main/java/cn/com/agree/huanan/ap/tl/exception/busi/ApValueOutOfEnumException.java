package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;
//import cn.com.agree.huanan.ap.tl.metadata.DataEnum;
import cn.com.agree.huanan.ap.tl.metadata.DataEnum;

/**
 * 值超出枚举
 * 
 * @author tan.ch
 *
 */
public class ApValueOutOfEnumException extends ApException {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 构造方法
     * 
     * @param value 值
     * @param type 枚举类型
     */
    public <T extends DataEnum> ApValueOutOfEnumException(Object value, Class<T> type) {
        super(new Object[] {
                value,
                type.getSimpleName()
        });
    }

    public ApValueOutOfEnumException(Object value) {
        super(new Object[] {
            value
        });
    }
}
