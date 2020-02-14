package cn.com.agree.huanan.ap.al.APTL.po;

import lombok.Data;
import cn.com.agree.huanan.ap.al.APTL.ddl.Aptl_datadict_type;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;

/**
 * 数据字典类型
 * 
 * @author tan.ch
 *
 */
@Data
@Table(Aptl_datadict_type.class)
public class DataDictType {
    private String alId;
    private String typeName;
    private String typeCnName;
}
