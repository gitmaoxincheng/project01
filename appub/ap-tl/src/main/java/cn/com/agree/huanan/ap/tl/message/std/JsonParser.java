package cn.com.agree.huanan.ap.tl.message.std;

import java.util.Map;

/**
 * Json报文解析接口
 * 
 * @author luo.hp
 *
 */

public interface JsonParser extends MessageParser {
    
    /**
     * @param jsonString JSON字符串
     * @return Map字典
     */
    public Map<String, Object> jsonToMap(String jsonString);
    
    /**
     * @param map Map字典
     * @return jsonString JSON字符串
     */
    public String mapToJson(Map<String, Object> map);
}
