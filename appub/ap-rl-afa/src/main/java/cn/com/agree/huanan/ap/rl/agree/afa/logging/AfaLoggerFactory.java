package cn.com.agree.huanan.ap.rl.agree.afa.logging;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import cn.com.agree.huanan.ap.tl.logging.Logger;

@Configuration
public class AfaLoggerFactory {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Logger getLogger(InjectionPoint ip) {
        return new AfaLogger(ip.getMember().getDeclaringClass());
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Logger getLogger(Class<?> modType) {
        return new AfaLogger(modType);
    }
}
