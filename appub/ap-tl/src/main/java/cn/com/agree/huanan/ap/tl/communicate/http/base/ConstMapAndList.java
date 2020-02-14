package cn.com.agree.huanan.ap.tl.communicate.http.base;

import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpDeleteHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpGetHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpHeadHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpOptionsHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpPostHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpPutHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpTraceHandler;

/**
 * @author luo.hp
 *
 */
public class ConstMapAndList {
	
	// Http Operator
	public final static Map<String,Class<?>> HTTP_OPERATOR_SUPPORT = new HashMap<String, Class<?>>(){{
		 put("GET", HttpGetHandler.class);
		 put("HEAD", HttpHeadHandler.class);
         put("POST", HttpPostHandler.class);
         put("PUT", HttpPutHandler.class);
         put("DELETE", HttpDeleteHandler.class);
         put("TRACE", HttpTraceHandler.class);
         put("OPTIONS", HttpOptionsHandler.class);
	}};
}
