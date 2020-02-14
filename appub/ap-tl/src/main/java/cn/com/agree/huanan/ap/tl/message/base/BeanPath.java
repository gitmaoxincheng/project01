package cn.com.agree.huanan.ap.tl.message.base;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @author luo.hp
 * @category Bean路径配置
 *
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix="ap.tl.bean.path")
public class BeanPath {
	/** 通讯节点标识，通常用来区分对外通讯的同一系统的不同环境 */
	private String nodeName;
    /** 解析器Bean路径 */
    private Map<String, String> parser;
    
    /** 通信适配器Bean路径 */
    private Map<String, String> commAdapter;
}
