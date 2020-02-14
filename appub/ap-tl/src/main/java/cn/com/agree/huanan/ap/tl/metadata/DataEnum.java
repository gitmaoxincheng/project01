package cn.com.agree.huanan.ap.tl.metadata;

import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfEnumException;

/**
 * 数据枚举
 * 
 * @author tan.ch
 */
public interface DataEnum {
    /**
     * 获取枚举代码
     * 
     * @return 枚举代码
     */
    public String getCode();
    
    /**
     * 获取枚举对象
     * 
     * @param type 类型
     * @param code 代码
     * @return 枚举对象
     */
    public static <T extends DataEnum> T get(Class<T> type, String code) {
        // 逐个查找
        for (T item : type.getEnumConstants()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        // 查找失败
        throw new ApValueOutOfEnumException(code, type);
    }
}
