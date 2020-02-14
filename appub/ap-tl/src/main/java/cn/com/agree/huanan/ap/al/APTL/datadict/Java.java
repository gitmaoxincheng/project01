package cn.com.agree.huanan.ap.al.APTL.datadict;

import cn.com.agree.huanan.ap.tl.metadata.AptlDataTypeList;
import cn.com.agree.huanan.ap.tl.metadata.DataDictItem;
import cn.com.agree.huanan.ap.tl.metadata.MetaDataUtil;

/**
 * 数据字典
 * 
 * @author MetaDataGenerator
 *
 */
public class Java {
    /** 类名 */
    public static final DataDictItem className            = MetaDataUtil.getDataDictItem("className", "类名", AptlDataTypeList.A1, 2, 200, null);
    /** 类简单名 */
    public static final DataDictItem classSimpleName      = MetaDataUtil.getDataDictItem("classSimpleName", "类简单名", AptlDataTypeList.A1, 2, 20, null);
}

