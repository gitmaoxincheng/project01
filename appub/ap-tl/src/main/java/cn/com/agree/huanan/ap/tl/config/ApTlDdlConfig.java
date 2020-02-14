package cn.com.agree.huanan.ap.tl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.base.DbType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
@Component
@ConfigurationProperties(prefix="ap.tl.ddl")
public class ApTlDdlConfig {
    /** 默认数据表空间 */
    private String defDataTabSpace;
    /** 默认索引表空间 */
    private String defIndexTabSpace;
    /** sql文件路径格式 */
    private String sqlFilePathFormat;
    /** 表名正则 */
    private String tabNameRegex;
    /** 列名正则 */
    private String colNameRegex;
}
