package cn.com.agree.huanan.ap.al.APTL.ddl;

import cn.com.agree.huanan.ap.al.APTL.datadict.Base;
import cn.com.agree.huanan.ap.al.APTL.datadict.DataEnum;
import cn.com.agree.huanan.ap.tl.metadata.AbstractDataTable;

/**
 * 数据表
 * 
 * @author tan.ch
 *
 */
public class Aptl_enum_item extends AbstractDataTable {
    /** 生成器 */
    private static final DataTableBuilder builder = getBuilder()
    // 表名
    .setTabComment("枚举项信息")
        // 字段列表
        .setFieldsList(fl -> {
            fl.add(Base.alId);
            fl.add(DataEnum.enumName);
            fl.add(DataEnum.itemCode);
            fl.add(DataEnum.itemName);
            fl.add(DataEnum.itemCnName);
            fl.add(Base.seqNo);
        })
        // 主键
        .setPrimaryKey(fl -> {
            fl.add(Base.alId);
            fl.add(DataEnum.enumName);
            fl.add(DataEnum.itemCode);
        })
        // 索引
        .addIndex(false, fl -> {
        });

    /**
     * 构造方法
     */
    public Aptl_enum_item() {
        super(builder);
    }
}
