package cn.com.agree.huanan.ap.tl.message.std;

import java.util.Map;

/**
 * Json报文解析接口
 * 
 * @author luo.hp
 *
 */

public interface NatpParser extends MessageParser {
    
    /**
     * @param natpMsg Natp报文字节数组
     * @return Map字典
     */
    public Map<String, Object> natpToMap(byte [] natpMsg);
    
    
    /**
     * @param natpMsg Natp报文字节数组
     * @param encoding 编码
     * @return Map字典
     */
    public Map<String, Object> natpToMap(byte [] natpMsg, String encoding);
    
    /**
     * @param natpMap Natp字段MAP
     * @return Natp字节数组
     */
    public  byte [] mapToNatp(Map<String, Object>natpMap);
    
    /**
     * @param natpMap Natp字段MAP
     * @param encoding 编码
     * @return Natp字节数组
     */
    public  byte [] mapToNatp(Map<String, Object>natpMap, String encoding);
}
