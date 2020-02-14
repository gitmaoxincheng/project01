package cn.com.agree.huanan.ap.tl.message.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.exception.tech.ApUnsupportedEncodingException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.std.XmlParser;

/**
 * Xml报文解析及拼包
 * 
 * @author luo.hp
 *
 */
public abstract class XmlParserImpl implements XmlParser {
    protected final static Logger logger = Logger.getLogger(XmlParserImpl.class);

    @Override
    public Map<String, Object> unpack(Object msgObject, String encoding) {
     // TODO 自动生成的方法存根
        try {
            String xmlStr = "";
            if (msgObject.getClass().isArray()){
                xmlStr = new String((byte[])msgObject, encoding);
            }else{
                xmlStr = (String)msgObject;
            }
            return xmlToMap(xmlStr,encoding);
        } catch (UnsupportedEncodingException e) {
            // TODO 自动生成的 catch 块
            throw new ApUnsupportedEncodingException(e);
        }
    }

    @Override
    public Object pack(Map<String, Object> msgMap, String encoding) {
        // TODO 自动生成的方法存根
        return mapToXml(msgMap,encoding);
    }

}
