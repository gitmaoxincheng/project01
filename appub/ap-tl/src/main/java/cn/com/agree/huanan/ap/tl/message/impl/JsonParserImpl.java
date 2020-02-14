package cn.com.agree.huanan.ap.tl.message.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.agree.huanan.ap.tl.exception.tech.ApUnsupportedEncodingException;
import cn.com.agree.huanan.ap.tl.message.std.JsonParser;

/**
 * Json报文解析
 * 
 * @author luo.hp
 *
 */
public abstract class JsonParserImpl implements JsonParser {
    @Autowired
    private JsonParser parser;
    
    @Override
    public Map<String, Object> unpack(Object msgObject, String encoding) {
        // TODO 自动生成的方法存根
        try {
            String jsonStr = "";
            if (msgObject.getClass().isArray()){
                jsonStr = new String((byte[])msgObject, encoding);
            }else{
                jsonStr = (String)msgObject;
            }
            return parser.jsonToMap(jsonStr);
        } catch (UnsupportedEncodingException e) {
            // TODO 自动生成的 catch 块
            throw new ApUnsupportedEncodingException(e);
        }
    }
    
    @Override
    public Object pack(Map<String, Object> msgMap, String encoding) {
        // TODO 自动生成的方法存根
        return parser.mapToJson(msgMap);
    }
}
