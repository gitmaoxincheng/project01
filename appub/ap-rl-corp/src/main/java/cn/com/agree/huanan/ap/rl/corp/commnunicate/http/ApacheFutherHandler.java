package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import org.apache.http.impl.client.HttpRequestFutureTask;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherHandler;

/**
 * @author luo.hp
 *
 */
public class ApacheFutherHandler implements FurtherHandler{
    
    HttpRequestFutureTask<CommContext> futherTask;
    
    ApacheFutherHandler(HttpRequestFutureTask<CommContext> futherTask){
        this.futherTask = futherTask;
    }
 
}
