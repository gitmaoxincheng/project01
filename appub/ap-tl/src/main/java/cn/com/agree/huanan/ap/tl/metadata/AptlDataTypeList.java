package cn.com.agree.huanan.ap.tl.metadata;

import cn.com.agree.huanan.ap.tl.metadata.datatype.AsciiType;
import cn.com.agree.huanan.ap.tl.metadata.datatype.MultiByteType;
import cn.com.agree.huanan.ap.tl.metadata.datatype.NumberType;
import cn.com.agree.huanan.ap.tl.metadata.datatype.UnicodeType;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

/**
 * 数据类型列表
 * 
 * @author tan.ch
 *
 */
public class AptlDataTypeList {
    private AptlDataTypeList() {
    }

    /** 数值型-int */
    public static final DataType NI = new NumberType(int.class);

    /** 数值型-long */
    public static final DataType NL = new NumberType(long.class);

    /** ASCII型 */
    public static final DataType A1 = new AsciiType();

    /** UNICODE型 */
    public static final DataType U1 = new UnicodeType();

    /** 多字节型.UTF-8 */
    public static final DataType MU = new MultiByteType(StrUtil.CHARSET_UTF8);

    /** 多字节型.GBK */
    public static final DataType MG = new MultiByteType(StrUtil.CHARSET_GBK);

}
