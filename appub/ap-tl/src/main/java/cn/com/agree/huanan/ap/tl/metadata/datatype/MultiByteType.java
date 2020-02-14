package cn.com.agree.huanan.ap.tl.metadata.datatype;

import java.nio.charset.Charset;
import java.util.Objects;

import cn.com.agree.huanan.ap.tl.metadata.AbstractDataType;

/**
 * 多字节类型
 * 
 * @author tan.ch
 *
 */
public final class MultiByteType extends AbstractDataType {
    /** 字符集 */
    private final Charset charset;

    /**
     * 构造方法
     * 
     * @param charset 字符集
     */
    public MultiByteType(Charset charset) {
        Objects.requireNonNull(charset);
        this.charset = charset;
    }
    
    @Override
    protected int getRawDataLen(String input) {
        return input.getBytes(charset).length;
    }
}
