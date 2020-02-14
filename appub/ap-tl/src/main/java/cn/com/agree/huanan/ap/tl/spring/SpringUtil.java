package cn.com.agree.huanan.ap.tl.spring;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import cn.com.agree.huanan.ap.tl.ApTlApplication;

/**
 * spring工具
 * 
 * @author tan.ch
 *
 */
public class SpringUtil {
    /** 程序容器 */
    private static volatile ApplicationContext applicationContext = null;
    
    /**
     * 获取bean
     * 
     * @param type 类型
     * @return bean
     */
    public static <T> T getBean(Class<T> type) {
        return ApplicationContextHolder.getBean(type);
    }

    /**
     * 获取bean
     * 
     * @param type 类型
     * @param args 参数
     * @return bean
     */
    public static <T> T getBean(Class<T> type, Object... args) {
        return ApplicationContextHolder.getBean(type, args);
    }

    /**
     * 初始化容器
     */
    public static void initContext() {
        initContext(new String[] {});
    }

    /**
     * 初始化容器
     * 
     * @param args 参数
     * @return 容器
     */
    public static ApplicationContext initContext(String[] args) {
        // double check lock
        if (applicationContext == null) {
            synchronized (SpringUtil.class) {
                if (applicationContext == null) {
                    // 初始化
                	SpringApplication app = new SpringApplication(ApTlApplication.class);
                	app.setRegisterShutdownHook(false);
                    applicationContext = app.run(args);
                }
            }
        }
        // 返回
        return applicationContext;
    }

    /**
     * 运行程序
     * 
     * @param appType 程序类型
     * @param args 参数
     * @throws Exception 异常
     */
    public static void runApplication(Class<? extends ApCommandLineApplication> appType,
            String[] args) throws Exception {
        // 获取时间
        long runBeginTime = System.currentTimeMillis();
        // 初始化eclipse环境
        initEclipseEnv();
        // 初始化容器
        ApplicationContext context = initContext(args);
        // 获取程序
        ApTlApplication app = context.getBean(ApTlApplication.class);
        // 运行
        app.runApplication(appType, args, runBeginTime);
    }

    private static void initEclipseEnv() throws Exception {
        // 判断是否通过eclipse启动
        String runner = System.getProperty("ap.tl.runner", "");
        if (!runner.equals("eclipse")) {
            return;
        }
        // 获取ap目录
        // C:\Users\tam\git\afa-base-platform\ap\ap-tl
        // ->
        // C:\Users\tam\git\afa-base-platform\ap
        String cwd = System.getProperty("user.dir");
        File apFile = new File(cwd).getParentFile();
        // 获取URL列表
        String[] dirList = {
                "ap-tl/bin",
                "ap-rl-aptl/bin",
                "ap-rl-corp/bin",
        };
        URL[] urlList = new URL[dirList.length];
        for (int i = 0; i < dirList.length; i++) {
            File dirFile = new File(apFile, dirList[i]);
            urlList[i] = dirFile.toURI().toURL();
        }
        // 设置classloader
        ClassLoader curLoader = Thread.currentThread().getContextClassLoader();
        URLClassLoader newLoader = new URLClassLoader(urlList, curLoader);
        Thread.currentThread().setContextClassLoader(newLoader);
    }
}
