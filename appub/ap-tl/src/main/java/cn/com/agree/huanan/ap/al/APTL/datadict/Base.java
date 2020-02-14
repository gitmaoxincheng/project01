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
public class Base {
    /** 应用标识 */
    public static final DataDictItem alId                 = MetaDataUtil.getDataDictItem("alId", "应用标识", AptlDataTypeList.A1, 4, 10, null);
    /** 中文关键字名称 */
    public static final DataDictItem cnKeywordName        = MetaDataUtil.getDataDictItem("cnKeywordName", "中文关键字名称", AptlDataTypeList.U1, 2, 20, null);
    /** 数据长度 */
    public static final DataDictItem dataLen              = MetaDataUtil.getDataDictItem("dataLen", "数据长度", AptlDataTypeList.NI, 0, 10, null);
    /** 英文关键字名称 */
    public static final DataDictItem enKeywordName        = MetaDataUtil.getDataDictItem("enKeywordName", "英文关键字名称", AptlDataTypeList.A1, 2, 20, null);
    /** 序号 */
    public static final DataDictItem seqNo                = MetaDataUtil.getDataDictItem("seqNo", "序号", AptlDataTypeList.NI, 0, 10, null);
}

