package cn.com.agree.huanan.ap.tl.communicate.http.handler.impl;
import java.util.Map;

import org.apache.http.client.methods.HttpRequestBase;

import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpMethodHandler;

/**
 * @author luo.hp
 *
 */
public abstract class HttpMethodHandlerImpl implements HttpMethodHandler{
    
    protected abstract void setHeader(HttpRequestBase httRequst, Map<String, String> headers);
}
