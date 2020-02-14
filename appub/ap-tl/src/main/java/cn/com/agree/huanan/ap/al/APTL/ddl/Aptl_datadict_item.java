package cn.com.agree.huanan.ap.al.APTL.ddl;

import cn.com.agree.huanan.ap.al.APTL.datadict.Base;
import cn.com.agree.huanan.ap.al.APTL.datadict.DataDict;
import cn.com.agree.huanan.ap.tl.metadata.AbstractDataTable;

/**
 * 数据表（抽象）
 * 
 * @author tan.ch
 *
 */
public class Aptl_datadict_item extends AbstractDataTable {
    /** 生成器 */
    private static final DataTableBuilder builder = getBuilder()
    // 表名
    .setTabComment("枚举项信息")
        // 字段列表
        .setFieldsList(fl -> {
            fl.add(Base.alId);
            fl.add(DataDict.typeName);
            fl.add(DataDict.itemName);
            fl.add(DataDict.itemCnName);
            fl.add(DataDict.dataType);
            fl.add(DataDict.dataEnum);
            fl.add(DataDict.minLen);
            fl.add(DataDict.maxLen);
            fl.add(DataDict.extItem);
        })
        // 主键
        .setPrimaryKey(fl -> {
            fl.add(Base.alId);
            fl.add(DataDict.typeName);
            fl.add(DataDict.itemName);
        })
        // 索引
        .addIndex(false, fl -> {
        });

    /**
     * 构造方法
     */
    public Aptl_datadict_item() {
        super(builder);
    }
}
