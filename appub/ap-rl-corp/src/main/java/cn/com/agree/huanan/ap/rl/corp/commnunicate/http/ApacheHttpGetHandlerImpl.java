package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.msg.SendMessage;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.HttpCommParam;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherCallbackHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpGetHandler;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author luo.hp
 *
 */
@Component
public class ApacheHttpGetHandlerImpl extends ApacheHttpMethodHandlerImpl implements HttpGetHandler{
    
    /**
     * 日志句柄
     */
    public final static Logger logger =  Logger.getLogger(ApacheHttpGetHandlerImpl.class);
    
    @Override
    public CommContext doing(HttpCommParam httpParams, SendMessage msg) {
        // TODO 自动生成的方法存根
        return this.doing(httpParams, msg, this.getDefaultStringHeaderMap());
    }

    @Override
    public CommContext doing(HttpCommParam httpParams, SendMessage msg, Map<String, String> headers) {
        // TODO 自动生成的方法存根
        HttpGet httpGet = getApacheGet(httpParams, headers);
        return this.syncDoing(httpGet, httpParams, msg);
    }
    
    @Override
    public FurtherHandler doingAsync(HttpCommParam httpParams, SendMessage msg) {
        // TODO 自动生成的方法存根
        return doingAsync(httpParams, msg, this.getDefaultStringHeaderMap());
    }

    @Override
    public FurtherHandler doingAsync(HttpCommParam httpParams,
            SendMessage msg, Map<String, String> headers) {
        // TODO 自动生成的方法存根
        return doingAsync(httpParams, msg, headers, null);
    }

    @Override
    public FurtherHandler doingAsync(HttpCommParam httpParams,
            SendMessage msg, Map<String, String> headers, FurtherCallbackHandler<CommContext> callback) {
        // TODO 自动生成的方法存根
        HttpGet httpGet = getApacheGet(httpParams, headers);
        return this.asyncDoing(httpGet, httpParams, msg, new ApacheFutureCallback(callback));
    }
    
    // 获取Http Get请求对象
    protected HttpGet getApacheGet(HttpCommParam httpParams, Map<String, String> headers){
        HttpGet httpGet = new HttpGet(httpParams.getServerUrl());
        this.setHeader(httpGet, headers);
        return httpGet;
    }
}
