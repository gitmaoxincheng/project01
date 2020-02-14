package cn.com.agree.huanan.ap.tl.metadata;

import java.util.List;

/**
 * 数据表
 * 
 * @author tan.ch
 *
 */
public interface DataTable {
    /**
     * 获取表名
     * 
     * @return 表名
     */
    public String getTabName();

    /**
     * 获取表注释
     * 
     * @return 表注释
     */
    public String getTabComment();

    /**
     * 获取表名
     * 
     * @return 数据表空间
     */
    public String getDataTabSpace();

    /**
     * 获取表名
     * 
     * @return 索引表空间
     */
    public String getIndexTabSpace();

    /**
     * 获取字段列表
     * 
     * @return 字段列表
     */
    public List<DataDictItem> getFieldsList();

    /**
     * 获取主键
     * 
     * @return 主键
     */
    public DataTableIndex getPrimaryKey();

    /**
     * 获取索引列表
     * 
     * @return 索引列表
     */
    public List<? extends DataTableIndex> getIndexesList();
}
