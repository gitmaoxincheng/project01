package cn.com.agree.huanan.ap.tl.metadata;

/**
 * 元数据工具
 * 
 * @author tan.ch
 *
 */
public class MetaDataUtil {
    /**
     * 获取数据字典工具
     * 
     * @param name 名称
     * @param cnName 中文名称
     * @param item 数据字典项
     * @return 数据字典项
     */
    public static DataDictItem getDataDictItem(String name, String cnName, DataDictItem item) {
        return new DefaultDataDictItem(name, cnName, item);
    }
    
    /**
     * 
     * @param name 名称
     * @param cnName 中文名称
     * @param dataType 数据类型
     * @param minLen 最小长度
     * @param maxLen 最大长度
     * @param dataEnum 数据枚举
     * @return 数据字典项
     */
    public static DataDictItem getDataDictItem(String name, String cnName, DataType dataType,
            int minLen, int maxLen, Class<? extends DataEnum> dataEnum) {
        return new DefaultDataDictItem(name, cnName, dataType, minLen, maxLen, dataEnum);
    }
}
