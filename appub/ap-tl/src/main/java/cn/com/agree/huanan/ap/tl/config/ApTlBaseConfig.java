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
@ConfigurationProperties(prefix="ap.tl.base")
public class ApTlBaseConfig {
    /** 数据库类型 */
    private DbType dbType;
}
