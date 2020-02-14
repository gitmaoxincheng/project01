package cn.com.agree.huanan.ap.tl.message.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import cn.com.agree.huanan.ap.tl.message.std.SvcParser;

/**
 * Svc报文解析及拼包
 * 
 * @author luo.hp
 *
 */
public abstract class SvcParserImpl implements SvcParser {
    @Autowired
    private SvcParser parser;
    
    @Override
    public Map<String, Object> unpack(Object msgObject, String encoding) {
        // TODO 自动生成的方法存根
        return parser.dictToMap(msgObject);
        
    }
    
    @Override
    public Object pack(Map<String, Object> msgMap, String encoding) {
        // TODO 自动生成的方法存根
        return parser.mapToDict(msgMap);
    }
}
