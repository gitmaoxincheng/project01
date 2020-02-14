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
public class DataEnum {
    /** 枚举中文名称 */
    public static final DataDictItem enumCnName           = MetaDataUtil.getDataDictItem("enumCnName", "枚举中文名称", Base.cnKeywordName);
    /** 枚举名称 */
    public static final DataDictItem enumName             = MetaDataUtil.getDataDictItem("enumName", "枚举名称", Base.enKeywordName);
    /** 枚举项中文名称 */
    public static final DataDictItem itemCnName           = MetaDataUtil.getDataDictItem("itemCnName", "枚举项中文名称", Base.cnKeywordName);
    /** 枚举项代码 */
    public static final DataDictItem itemCode             = MetaDataUtil.getDataDictItem("itemCode", "枚举项代码", AptlDataTypeList.A1, 0, 2, null);
    /** 枚举项名称 */
    public static final DataDictItem itemName             = MetaDataUtil.getDataDictItem("itemName", "枚举项名称", Base.enKeywordName);
}

