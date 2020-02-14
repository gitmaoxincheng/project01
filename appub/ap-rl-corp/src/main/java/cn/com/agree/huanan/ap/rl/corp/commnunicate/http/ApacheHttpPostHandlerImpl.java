package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.msg.SendMessage;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.HttpCommParam;
import cn.com.agree.huanan.ap.tl.communicate.http.base.HttpHeaderDefine;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherCallbackHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpPostHandler;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author luo.hp
 *
 */
@Component
public class ApacheHttpPostHandlerImpl extends ApacheHttpMethodHandlerImpl implements HttpPostHandler{
    
    /**
     * 日志句柄
     */
    public Logger logger =  Logger.getLogger(ApacheHttpPostHandlerImpl.class);
    
    @Override
    public CommContext doing(HttpCommParam httpParams, SendMessage msg) {
        // TODO 自动生成的方法存根
        return this.doing(httpParams, msg, this.getDefaultStringHeaderMap());
    }

    @Override
    public CommContext doing(HttpCommParam httpParams, SendMessage msg, Map<String, String> headers) {
        // TODO 自动生成的方法存根
        
        HttpPost httpPost = getApachePost(httpParams, msg, headers);
        return this.syncDoing(httpPost, httpParams, msg);
    }

    
    @Override
    public FurtherHandler doingAsync(HttpCommParam httpParams, SendMessage msg) {
        // TODO 自动生成的方法存根
        return doingAsync(httpParams, msg, this.getDefaultStringHeaderMap());
    }

    @Override
    public FurtherHandler doingAsync(HttpCommParam httpParams, SendMessage msg,
            Map<String, String> headers) {
        // TODO 自动生成的方法存根
        return doingAsync(httpParams, msg, headers, null);
    }

    @Override
    public FurtherHandler doingAsync(HttpCommParam httpParams, SendMessage msg,
            Map<String, String> headers, FurtherCallbackHandler<CommContext> callback) {
        // TODO 自动生成的方法存根
        HttpPost httpPost = getApachePost(httpParams, msg, headers);
        return this.asyncDoing(httpPost, httpParams, msg, new ApacheFutureCallback(callback));
    }
    
    // 获取Http Post请求对象
    protected HttpPost getApachePost(HttpCommParam httpParams, SendMessage msg, Map<String, String> headers){
        HttpPost httpPost = new HttpPost(httpParams.getServerUrl());
        HttpEntity entity = null;
        
        // 默认
        Map<String, String>headerMap = headers;
        HttpHeaderDefine define = new  HttpHeaderDefine();
        if (msg.getMsgContentType() == cn.com.agree.huanan.ap.tl.communicate.comm.base.Const.MESSAGE_CONTENT_STRING_TYPE){
            entity = new StringEntity(msg.getStringMsg(), ContentType.create(headerMap.get(define.getContentType()), Charset.forName(httpParams.getEncoding())));
        }else{
            headerMap = this.getDefaultBytesHeaderMap();
            entity = new ByteArrayEntity(msg.getBytesMsg(), ContentType.create(headerMap.get(define.getContentType()), (Charset)null));
        }
        this.setHeader(httpPost, headerMap);
        httpPost.setEntity(entity);
        return httpPost;
    }
}
