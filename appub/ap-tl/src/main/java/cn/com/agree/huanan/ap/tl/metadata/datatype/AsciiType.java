package cn.com.agree.huanan.ap.tl.metadata.datatype;

import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfRangeException;
import cn.com.agree.huanan.ap.tl.metadata.AbstractDataType;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

/**
 * ASCII类型
 * 
 * @author tan.ch
 *
 */
public final class AsciiType extends AbstractDataType {
    @Override
    protected void validateContent(String input) {
        if (!StrUtil.isAscii(input)) {
            throw new ApValueOutOfRangeException(input);
        }
    }
}
