package cn.com.agree.huanan.ap.tl.message.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author luo.hp
 * @category 缺省解析消息类型
 *
 */

@Data
@Component
@ConfigurationProperties(prefix="ap.tl.message")
public class DefaultMsgTypeConfig {

    // 默认通信消息类型
    private String defaultMessageType;
    
    // SVC消息解析类型
    private String svcParserMsgType;
}
