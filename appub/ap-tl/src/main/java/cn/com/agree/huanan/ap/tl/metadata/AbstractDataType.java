package cn.com.agree.huanan.ap.tl.metadata;

import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTooLongException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTooShortException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;

/**
 * 数据类型
 * 
 * @author tan.ch
 *
 */
public abstract class AbstractDataType implements DataType {
    /** 原始类型 */
    private final Class<?> rawType;

    /**
     * 构造方法
     */
    protected AbstractDataType() {
        this(String.class);
    }

    /**
     * 构造方法
     * 
     * @param rawType 原始类型
     */
    protected AbstractDataType(Class<?> rawType) {
        // 检查类型
        if (rawType == String.class) {
        } else if (rawType == int.class) {
        } else if (rawType == long.class) {
        } else {
            throw new ApValueTypeUnsupportException(rawType);
        }
        // 保存
        this.rawType = rawType;
    }

    @Override
    public Class<?> getRawType() {
        return rawType;
    }

    @Override
    public void validate(String input, int minLen, int maxLen) {
        // 校验内容
        validateContent(input);
        // 获取原始数据长度
        int rawDataLen = getRawDataLen(input);
        // 检查最小长度
        if (minLen > 0 && rawDataLen < minLen) {
            throw new ApValueTooShortException(rawDataLen, minLen);
        }
        // 检查最大长度
        if (maxLen > 0 && rawDataLen > maxLen) {
            throw new ApValueTooLongException(rawDataLen, maxLen);
        }
    }

    /**
     * 校验内容
     * 
     * @param input 输入
     */
    protected void validateContent(String input) {
        // 直接通过
        return;
    }

    /**
     * 获取原始数据长度
     * 
     * @param input 输入
     * @return 原始数据长度
     */
    protected int getRawDataLen(String input) {
        // 返回字符个数（UTF-16）
        return input.length();
    }
}
