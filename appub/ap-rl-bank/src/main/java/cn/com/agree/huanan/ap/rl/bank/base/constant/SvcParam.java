package cn.com.agree.huanan.ap.rl.bank.base.constant;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @date 2019-12-04 20:16:4
 * @author huangchaopeng
 * 服务配置参数，不同服务读取不同配置文件（类加载路径不同）
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix="ap.svc")
public class SvcParam {
	
	private List<String> svcCheck;
	private String svcName;
	private String svcCode;
	private boolean macCheck;
	private String testA;
	private String testB;
    private Map<String, String> testC;
}
