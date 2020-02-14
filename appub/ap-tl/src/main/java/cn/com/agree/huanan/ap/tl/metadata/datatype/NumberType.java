package cn.com.agree.huanan.ap.tl.metadata.datatype;

import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfRangeException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import cn.com.agree.huanan.ap.tl.metadata.AbstractDataType;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

/**
 * 数值类型
 * 
 * @author tan.ch
 *
 */
public final class NumberType extends AbstractDataType {
    /**
     * 构造方法
     * 
     * @param rawType 原始类型
     */
    public NumberType(Class<?> rawType) {
        // 父类
        super(rawType);
        // 检查类型
        if (rawType == int.class) {
        } else if (rawType == long.class) {
        } else {
            throw new ApValueTypeUnsupportException(rawType);
        }
    }

    @Override
    protected void validateContent(String input) {
        if (!StrUtil.isDigits(input)) {
            throw new ApValueOutOfRangeException(input);
        }
    }
}
