package cn.com.agree.huanan.ap.rl.agree.afa.javadict;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.impl.SvcParserImpl;

/**
 * @author luo.hp
 *
 */
@Component
public class PlatSvcParserImpl extends SvcParserImpl {

    /**
     * logger
     */
    public final static Logger logger = Logger.getLogger(PlatSvcParserImpl.class);


    private Map<String, Object> dictConvertMap(Map<?, ?> rpcMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Entry<?, ?> entry : rpcMap.entrySet()) {
            map.put((String) entry.getKey(), entry.getValue());
        }
        return map;
    }

    private JavaDict mapConvertDict(Map<?, ?> map) {
        JavaDict dict = new JavaDict();
        dict.putAll(map);
        return dict;
    }
    
    @Override
    public Map<String, Object> dictToMap(Object rpcMsg) {
        // TODO 自动生成的方法存根
        return dictConvertMap((Map<?, ?>)rpcMsg);
    }

    @Override
    public Object mapToDict(Map<String, Object> rpcMap) {
        // TODO 自动生成的方法存根
        return mapConvertDict(rpcMap);
    }
}