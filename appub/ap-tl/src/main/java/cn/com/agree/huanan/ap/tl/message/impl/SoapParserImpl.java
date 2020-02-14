package cn.com.agree.huanan.ap.tl.message.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.std.SoapParser;

/**
 * Soap报文解析
 * 
 * @author luo.hp
 *
 */
public  abstract class SoapParserImpl implements SoapParser {
	@Autowired
	Logger logger;
	@Override
	public Map<String, Object> unpack(Object msgObject, String encoding) {
		// TODO 自动生成的方法存根
		Map<String, Object> messageMap = null;
		try {
			messageMap = soaptomap(new String( (byte[]) msgObject, encoding), encoding);
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return messageMap;
	}

	@Override
	public Object pack(Map<String, Object> msgMap, String encoding) {
		// TODO 自动生成的方法存根
		return maptosoap(msgMap, encoding);
	}

}
