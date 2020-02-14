package cn.com.agree.huanan.ap.tl.communicate.comm.adapter.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.HttpAdapter;
import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.http.NotHttpRequestBaseObjectException;
import cn.com.agree.huanan.ap.tl.communicate.comm.msg.SendMessage;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.HttpCommParam;
import cn.com.agree.huanan.ap.tl.communicate.http.base.Const;
import cn.com.agree.huanan.ap.tl.communicate.http.base.ConstMapAndList;
import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpMethodHandler;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * @author luo.hp
 *
 */
@Component
public class HttpAdapterImpl extends CommunicateAdapterImpl implements HttpAdapter{
	
	/**
	 * 日志句柄
	 */
	public Logger logger =  Logger.getLogger(HttpAdapterImpl.class);	
	
	protected CommContext commWith(CommParam param, SendMessage sendMsg, Map<String, Object> additionParam){
		HttpCommParam httpCommParam = new HttpCommParam();
		httpCommParam.init(param, additionParam);
		
		// http header
		Map<String, String> httpHeader = new HashMap<String, String>();
		if (additionParam.containsKey(Const.HEADER_KEY)){
            Object headerObject = (Map<?, ?>) additionParam.get(Const.HEADER_KEY);
            if (headerObject instanceof Map){
                Map<?, ?>headerMap = (Map<?, ?>) headerObject;
                headerMap.forEach((k,v)->httpHeader.put(k==null ? "" : k.toString(), v==null ? "" : v.toString()));
            }
		}
		
		// 检查HTTP操作
		if (!ConstMapAndList.HTTP_OPERATOR_SUPPORT.keySet().contains(httpCommParam.getOperator())){
			logger.error("HTTP不支持%s操作", httpCommParam.getOperator());
			return CommContext.getFailedCommContext(NotHttpRequestBaseObjectException.getException());
		}
		HttpMethodHandler method = (HttpMethodHandler) SpringUtil.getBean(ConstMapAndList.HTTP_OPERATOR_SUPPORT.get(httpCommParam.getOperator()));
		return (httpHeader.isEmpty() ? method.doing(httpCommParam, sendMsg) : method.doing(httpCommParam, sendMsg, httpHeader));
	}


	@Override
	public CommContext comm(CommParam param, byte[] msg, Map<String, Object> additionParam) {
		// TODO 自动生成的方法存根
		return commWith(param, new SendMessage(msg), additionParam);
	}


	@Override
	public CommContext comm(CommParam param, String msg, Map<String, Object> additionParam) {
		// TODO 自动生成的方法存根
		return commWith(param, new SendMessage(msg), additionParam);
	}
}
