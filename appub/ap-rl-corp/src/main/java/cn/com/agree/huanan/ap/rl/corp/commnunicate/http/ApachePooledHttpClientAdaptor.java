package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import cn.com.agree.huanan.ap.tl.logging.Logger;



/**
 * @author luo.hp
 * @category 连接线程池
 *
 */
public final class ApachePooledHttpClientAdaptor {
    
    private static final Logger logger =  Logger.getLogger(ApachePooledHttpClientAdaptor.class);
    
	// 连接池适配器
	private static ApachePooledHttpClientAdaptor adapter = null;
	
	// 连接池管理器
    private PoolingHttpClientConnectionManager gcm = null;
    
    // 连接池监控线程
    private ApacheIdleConnectionMonitorThread idleThread = null;
    
    // 连接池的最大连接数
    private final int maxTotal;
    // 连接池按route配置的最大连接数
    private final int maxPerRoute;
    
    // 连接池默认参数
    private ApachePooledHttpClientAdaptor() {
        this(Const.DEFAULT_POOL_MAX_TOTAL, Const.DEFAULT_POOL_MAX_PER_ROUTE);
    }
    
    private ApachePooledHttpClientAdaptor(int maxTotal, int maxPerRoute) {
        logger.error("ApachePooledHttpClientAdaptor Creating");
    	// 连接池初始化参数
        this.maxTotal = maxTotal;
        this.maxPerRoute = maxPerRoute;
 
        // 连接管理器登记
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
 
        // 管理器初始化
        gcm = new PoolingHttpClientConnectionManager(registry);
        gcm.setMaxTotal(this.maxTotal);
        gcm.setDefaultMaxPerRoute(this.maxPerRoute);
        
        // 建立监控线程
//        idleThread = new ApacheIdleConnectionMonitorThread(gcm);
//        idleThread.start();
    }
    
    
    /**
     * @return 返回HttpClient连接池适配器
     */
    public static synchronized ApachePooledHttpClientAdaptor getPooledHttpClientAdaptor() {
    	if (adapter == null){
    	    adapter = new ApachePooledHttpClientAdaptor();
    	}
    	return adapter;
    }
   
    // 获取HttpClient
    public CloseableHttpClient getHttpClient(int connectTimeout, int socketTimeout){
    	return getHttpClient(connectTimeout, Const.DEFAULT_CONNECT_REQUEST_TIMEOUT, socketTimeout);
    }
    
    // 获取HttpClient
	public CloseableHttpClient getHttpClient(int socketTimeout){
		return getHttpClient(cn.com.agree.huanan.ap.tl.communicate.comm.base.Const.DEFAULT_CONNECT_TIMEOUT, Const.DEFAULT_CONNECT_REQUEST_TIMEOUT, socketTimeout);
	}
	
	// 获取HttpClient
    public CloseableHttpClient getHttpClient(){
    	return getHttpClient(cn.com.agree.huanan.ap.tl.communicate.comm.base.Const.DEFAULT_CONNECT_TIMEOUT, Const.DEFAULT_CONNECT_REQUEST_TIMEOUT, cn.com.agree.huanan.ap.tl.communicate.comm.base.Const.DEFAULT_SOCKET_TIMEOUT);
    }
    // 获取HttpClient
    public CloseableHttpClient getHttpClient(int connectTimeout, int connectRequestTimeout, int socketTimeout){        
        // 请求参数设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeout)                     // 设置连接超时
                .setSocketTimeout(socketTimeout)                       // 设置读取超时
                .setConnectionRequestTimeout(connectRequestTimeout)    // 设置从连接池获取连接实例的超时
                .build();
 
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        return httpClientBuilder.setConnectionManager(gcm)
        		.setDefaultRequestConfig(requestConfig).build();
    }
    
    // 线程池退出
    public void shutdown() {
        idleThread.shutdown();
    }
}
