package cn.com.agree.huanan.ap.tl.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContext持有者
 * 
 * @author tan.ch
 *
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    /** 程序容器 */
    private static ApplicationContext applicationContext;

    private ApplicationContextHolder() {
    }

    /**
     * 获取bean
     * @param type 类型
     * @return bean
     */
    static <T> T getBean(Class<T> type) {
        return ApplicationContextHolder.applicationContext.getBean(type);
    }

    /**
     * 获取bean
     * @param type 类型
     * @param args 参数
     * @return bean
     */
    static <T> T getBean(Class<T> type, Object... args) {
        return ApplicationContextHolder.applicationContext.getBean(type, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }
}
