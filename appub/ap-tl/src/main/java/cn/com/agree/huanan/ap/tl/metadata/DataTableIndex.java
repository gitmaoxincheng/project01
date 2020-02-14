package cn.com.agree.huanan.ap.tl.metadata;

import java.util.List;

/**
 * 数据表索引
 * 
 * @author tan.ch
 *
 */
public interface DataTableIndex {
    /**
     * 是否唯一
     * 
     * @return 是否唯一
     */
    public boolean isUnique();
    
    /**
     * 获取字段列表
     * 
     * @return 字段列表
     */
    public List<DataDictItem> getFieldsList();
}
