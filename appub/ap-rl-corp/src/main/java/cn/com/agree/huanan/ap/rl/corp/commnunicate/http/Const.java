package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

public class Const {
    // Http 客户端连接池默认参数
    
    // 连接池最大大小
    public static final int DEFAULT_POOL_MAX_TOTAL = 200;
    
    // 连接池按route配置的最大连接数
    public static final int DEFAULT_POOL_MAX_PER_ROUTE = 100;
    
    // 从连接池获取连接的超时时间
    public static final int DEFAULT_CONNECT_REQUEST_TIMEOUT = 500;
    
    // 监控线程等待时间
    public static final int DEFAULT_WAITTIME = 2000;
        
    // 不活跃线程关闭时间
    public static final int DEFAULT_INACTIVE_TIME = 60;

}
