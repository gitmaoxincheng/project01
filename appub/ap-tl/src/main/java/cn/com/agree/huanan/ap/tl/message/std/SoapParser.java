package cn.com.agree.huanan.ap.tl.message.std;

import java.util.Map;

/**
 * Soap报文解析接口
 * 
 * @author luo.hp
 *
 */
public interface SoapParser extends MessageParser {
	Map<String, Object> soaptomap(String soapmessage, String encoding);
	String maptosoap(Map<String, Object> messageInfoMap, String encoding);
}
