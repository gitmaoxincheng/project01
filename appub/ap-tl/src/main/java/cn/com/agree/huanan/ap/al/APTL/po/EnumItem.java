package cn.com.agree.huanan.ap.al.APTL.po;

import lombok.Data;
import cn.com.agree.huanan.ap.al.APTL.ddl.Aptl_enum_item;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;

/**
 * 枚举项
 * 
 * @author tan.ch
 *
 */
@Data
@Table(Aptl_enum_item.class)
public class EnumItem {
    private String alId;
    private String enumName;
    private String itemCode;
    private String itemName;
    private String itemDesc;
    private int itemNo;
}

