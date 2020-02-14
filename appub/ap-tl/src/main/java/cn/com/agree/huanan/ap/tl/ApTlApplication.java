package cn.com.agree.huanan.ap.tl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.ApCommandLineApplication;
import cn.com.agree.huanan.ap.tl.spring.ApplicationContextHolder;
import cn.com.agree.huanan.ap.tl.spring.ClassBeanNameGenerator;

@EnableCaching
@SpringBootConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = "${ap.rl.componentScan.basePackages}", nameGenerator = ClassBeanNameGenerator.class)
public class ApTlApplication {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private Logger logger;
    
    @PostConstruct
    public void init() {
        context.getBean(ApplicationContextHolder.class);
    }

    /**
     * 运行程序
     * 
     * @param appType 程序类型
     * @param args 参数
     * @param runBeginTime 运行开始时间
     * @throws Exception 异常
     */
    public void runApplication(Class<? extends ApCommandLineApplication> appType, String[] args,
            long runBeginTime) throws Exception {
        // 计算spring初始化耗时
        long springInitTime = System.currentTimeMillis() - runBeginTime;
        // 启动日志
        logger.info("启动程序：%s", appType.getName());
        try {
            // 获取程序
            ApCommandLineApplication app = (ApCommandLineApplication) context.getBean(appType.getName());
            // 运行程序
            app.run(args);
        } catch (Exception ex) {
            logger.exception(ex);
            throw ex;
        } finally {
            long allTime = System.currentTimeMillis() - runBeginTime;
            logTime("初始耗时", springInitTime);
            logTime("程序耗时", allTime - springInitTime);
            logTime("总共耗时", allTime);
            logger.info("退出程序");
        }
    }

    private void logTime(String timeType, long time) {
        logger.info(timeType + "：%d.%03d", time / 1000, time % 1000);
    }
}
