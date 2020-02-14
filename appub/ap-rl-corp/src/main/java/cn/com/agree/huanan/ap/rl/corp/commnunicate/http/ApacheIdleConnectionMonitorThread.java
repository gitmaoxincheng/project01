package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import java.util.concurrent.TimeUnit;

import org.apache.http.conn.HttpClientConnectionManager;

import cn.com.agree.huanan.ap.tl.exception.tech.ApSystemException;
import cn.com.agree.huanan.ap.tl.logging.Logger;


// 连接池Idle连接监控
/**
 * @author luo.hp
 *
 */
public class ApacheIdleConnectionMonitorThread extends Thread {
	 
    public static final Logger logger =  Logger.getLogger(ApacheIdleConnectionMonitorThread.class);
	// 连接池管理器
    private final HttpClientConnectionManager connMgr;
    // 退出标识
    private volatile boolean exitFlag = false;
 
    /**
     * @param connMgr Http连接管理器
     */
    public ApacheIdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
        this.connMgr = connMgr;
        setDaemon(true);
    }
 
    @Override
    public void run() {
        while (!this.exitFlag) {
            synchronized (this) {
                try {
                    this.wait(Const.DEFAULT_WAITTIME);
                } catch (InterruptedException exception) {
                    throw new ApSystemException(exception);
                }
            }
            
            // 关闭失效的连接
            connMgr.closeExpiredConnections();
            // 可选的, 关闭60秒内不活动的连接
            connMgr.closeIdleConnections(Const.DEFAULT_INACTIVE_TIME, TimeUnit.SECONDS);
        }
    }
    
    /**
     * 线程退出
     */
    public void shutdown() {
        logger.debug("shutdown---------");
        this.exitFlag = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
