package cn.com.agree.huanan.ap.tl.metadata.datatype;

import cn.com.agree.huanan.ap.tl.metadata.AbstractDataType;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

/**
 * UNICODE类型
 * 
 * @author tan.ch
 *
 */
public final class UnicodeType extends AbstractDataType {
    @Override
    protected int getRawDataLen(String input) {
        return StrUtil.getCharsCount(input);
    }
}
