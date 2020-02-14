package cn.com.agree.huanan.ap.tl.message.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import cn.com.agree.huanan.ap.tl.message.std.NatpParser;

/**
 * Natp报文解析及拼包
 * 
 * @author luo.hp
 *
 */
public abstract class NatpParserImpl implements NatpParser {
    @Autowired
    private NatpParser parser;
    
    @Override
    public Map<String, Object> unpack(Object msgObject, String encoding) {
        // TODO 自动生成的方法存根
        return parser.natpToMap((byte[])msgObject, encoding);
    }
    
    @Override
    public Object pack(Map<String, Object> msgMap, String encoding) {
        // TODO 自动生成的方法存根
        return parser.mapToNatp(msgMap, encoding);
    }
}
