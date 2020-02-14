package cn.com.agree.huanan.ap.tl.metadata;

import java.util.List;

/**
 * 数据表索引（默认实现）
 * 
 * @author tan.ch
 *
 */
public class DefaultDataTableIndex implements DataTableIndex {
    /** 是否唯一 */
    private final boolean isUnique;
    /** 字段列表 */
    private final List<DataDictItem> fieldsList;

    /**
     * 构造主键
     * 
     * @param fieldsList 字段列表
     * @return 索引对象
     */
    public static DataTableIndex ofPrimaryKey(List<DataDictItem> fieldsList) {
        return ofIndex(true, fieldsList);
    }

    /**
     * 构造索引
     * 
     * @param isUnique 是否唯一
     * @param fieldsList 字段列表
     * @return 索引对象
     */
    public static DataTableIndex ofIndex(boolean isUnique,
            List<DataDictItem> fieldsList) {
        return new DefaultDataTableIndex(isUnique, fieldsList);
    }

    /**
     * 构造方法
     * 
     * @param isUnique 是否唯一
     * @param fieldsList 字段列表
     */
    private DefaultDataTableIndex(boolean isUnique,
            List<DataDictItem> fieldsList) {
        this.isUnique = isUnique;
        this.fieldsList = fieldsList;
    }

    @Override
    public boolean isUnique() {
        return isUnique;
    }

    @Override
    public List<DataDictItem> getFieldsList() {
        return fieldsList;
    }
}
