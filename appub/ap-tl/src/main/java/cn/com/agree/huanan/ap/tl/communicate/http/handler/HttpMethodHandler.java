package cn.com.agree.huanan.ap.tl.communicate.http.handler;

import java.util.Map;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.msg.SendMessage;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.HttpCommParam;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherCallbackHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherHandler;

/**
 * @author luo.hp
 *
 */
public interface HttpMethodHandler {

    // 同步调用
    /**
     * @param httpParams Http通信参数
     * @param msg 发送消息结构
     * @return 通信结果容器
     */
    public CommContext doing(HttpCommParam httpParams, SendMessage msg);
    
    /**
     * @param httpParams Http通信参数
     * @param headers Http消息头参数
     * @param msg 发送消息结构
     * @return 通信结果容器
     */
    public CommContext doing(HttpCommParam httpParams, SendMessage msg, Map<String, String> headers);
    
    
    // 异步调用
    
    /**
     * @param httpParams Http通信参数
     * @param msg 发送消息结构
     * @return Further处理对象
     */
    public FurtherHandler doingAsync(HttpCommParam httpParams, SendMessage msg) ;
    
    /**
     * @param httpParams Http通信参数
     * @param headers Http头参数
     * @param msg 发送消息结构
     * @return 通信结果容器
     */
    public FurtherHandler doingAsync(HttpCommParam httpParams, SendMessage msg, Map<String, String> headers);
    
    /**
     * @param httpParams Http通信参数
     * @param headers Http头参数
     * @param msg 发送消息结构
     * @param callback 回调处理过程
     * @return 通信结果容器
     */
    public FurtherHandler doingAsync(HttpCommParam httpParams, SendMessage msg, Map<String, String> headers, FurtherCallbackHandler<CommContext> callback);
}
