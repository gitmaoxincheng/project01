package cn.com.agree.huanan.ap.tl.message.std;

import java.util.Map;

/**
 * 报文解析接口
 * 
 * @author luo.hp
 *
 */
public interface MessageParser {
    /**
     * @param msgObject 消息对象
     * @param encoding 编码
     * @return Map字典
     */
    public Map<String, Object> unpack(Object msgObject, String encoding);
    
    /**
     * @param msgMap 消息MAP字典
     * @param encoding 拼包编码
     * @return 拼包结果对象
     */
    public Object pack(Map<String, Object> msgMap, String encoding);
}
