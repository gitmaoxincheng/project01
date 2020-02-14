package cn.com.agree.huanan.ap.al.APTL.po;

import lombok.Data;
import cn.com.agree.huanan.ap.al.APTL.ddl.Aptl_datadict_item;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;

/**
 * 数据字典项
 * 
 * @author tan.ch
 *
 */
@Data
@Table(Aptl_datadict_item.class)
public class DataDictItem {
    private String alId;
    private String typeName;
    private String itemName;
    private String itemCnName;
    private String dataType;
    private String dataEnum;
    private int minLen;
    private int maxLen;
    private String extItem;
}
