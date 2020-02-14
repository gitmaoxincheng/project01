package cn.com.agree.huanan.ap.al.APTL.po;

import lombok.Data;
import cn.com.agree.huanan.ap.al.APTL.ddl.Aptl_enum_info;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;

/**
 * 枚举信息
 * 
 * @author tan.ch
 *
 */
@Data
@Table(Aptl_enum_info.class)
public class EnumInfo {
    private String alId;
    private String enumName;
    private String enumDesc;
}
