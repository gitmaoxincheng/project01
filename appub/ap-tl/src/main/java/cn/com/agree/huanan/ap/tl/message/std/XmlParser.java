package cn.com.agree.huanan.ap.tl.message.std;

import java.util.Map;

/**
 * XML报文解析接口
 * 
 * @author luo.hp
 *
 */

public interface XmlParser extends MessageParser {
    /**
     * @param xmlString XML字符串
     * @return Map字典
     */
    public Map<String, Object> xmlToMap(String  xmlString,String encoding);
    
    /**
     * @param map Map字典
     * @return xmlString XML字符串
     */
    public String mapToXml(Map<String, Object> map,String encoding);
}
