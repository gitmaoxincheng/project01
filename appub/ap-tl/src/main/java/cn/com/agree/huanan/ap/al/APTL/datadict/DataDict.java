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
public class DataDict {
    /** 数据枚举 */
    public static final DataDictItem dataEnum             = MetaDataUtil.getDataDictItem("dataEnum", "数据枚举", AptlDataTypeList.A1, 0, 50, null);
    /** 数据类型 */
    public static final DataDictItem dataType             = MetaDataUtil.getDataDictItem("dataType", "数据类型", AptlDataTypeList.A1, 0, 20, null);
    /** 扩展项 */
    public static final DataDictItem extItem              = MetaDataUtil.getDataDictItem("extItem", "扩展项", AptlDataTypeList.A1, 0, 50, null);
    /** 项中文名称 */
    public static final DataDictItem itemCnName           = MetaDataUtil.getDataDictItem("itemCnName", "项中文名称", Base.cnKeywordName);
    /** 项名称 */
    public static final DataDictItem itemName             = MetaDataUtil.getDataDictItem("itemName", "项名称", Base.enKeywordName);
    /** 最大长度 */
    public static final DataDictItem maxLen               = MetaDataUtil.getDataDictItem("maxLen", "最大长度", Base.dataLen);
    /** 最小长度 */
    public static final DataDictItem minLen               = MetaDataUtil.getDataDictItem("minLen", "最小长度", Base.dataLen);
    /** 类型中文名称 */
    public static final DataDictItem typeCnName           = MetaDataUtil.getDataDictItem("typeCnName", "类型中文名称", Base.cnKeywordName);
    /** 类型名称 */
    public static final DataDictItem typeName             = MetaDataUtil.getDataDictItem("typeName", "类型名称", Base.enKeywordName);
}

