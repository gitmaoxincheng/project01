package cn.com.agree.huanan.ap.tl.message.std;

import java.util.Map;

/**
 * Dict报文解析接口
 * 
 * @author luo.hp
 *
 */

public interface SvcParser extends MessageParser {
    
    /**
     * @param svcMsg Svc对象
     * @return Map字典
     */
    public  Map<String, Object> dictToMap(Object svcMsg);
    
    /**
     * @param svcMap Map字典
     * @return SVC对象
     */
    public  Object mapToDict(Map<String, Object> svcMap);
}
