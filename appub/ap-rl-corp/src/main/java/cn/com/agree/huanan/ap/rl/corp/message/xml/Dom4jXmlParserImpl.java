package cn.com.agree.huanan.ap.rl.corp.message.xml;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Component;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIOException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApUnsupportedEncodingException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApXmlParseException;
import cn.com.agree.huanan.ap.tl.message.impl.XmlParserImpl;
import cn.com.agree.huanan.ap.tl.util.StrUtil;
import cn.com.agree.huanan.ap.tl.util.XmlUtil;

/**
 * @author acz,hcp
 *
 */
@Component
public class Dom4jXmlParserImpl extends XmlParserImpl {
	
	
    @Override
    public Map<String, Object> unpack(Object msgObject, String encoding) {
     // TODO 自动生成的方法存根
        try {
            String xmlStr = "";
            if (msgObject.getClass().isArray()){
                xmlStr = new String((byte[])msgObject, "GBK");
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
	public Map<String, Object> xmlToMap(String xmlString,String encoding) {
		Map<String, Object> result = null;
		try {
			xmlString = new String(xmlString.getBytes("GBK"));
			logger.debug("XmlStr: "+xmlString);
			xmlString = xmlString.substring(4);
			result = XmlUtil.xmlToMap(xmlString,encoding);
		} catch (Exception e) {
			logger.error("xml转换失败!",e);
			throw new ApXmlParseException(e);
		}
//		Map<String, Object> resMap = new HashMap<String, Object>();//不应该在 Dom4jXmlParserImpl 写这样的定制性质属性
//		resMap.put("GNET", result);
		return result; 
	}



	@Override
	public Object pack(Map<String, Object> msgMap, String encoding) {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("GNET");
		doc.setXMLEncoding(encoding);
		XmlUtil.map2element(root, (Map<String, Object>) msgMap.get("GNET"));
		StringWriter out = new StringWriter();
		try {
			XMLWriter xmlwriter = new XMLWriter(out);
			xmlwriter.write(doc);
			xmlwriter.flush();
			encoding = "GBK";
			byte[] msgBytes = out.toString().getBytes(encoding);
			String msgLength = StrUtil.lJust(String.valueOf(msgBytes.length), 4, '0');
			byte[] resultByte = new byte[4 + msgBytes.length];
			System.arraycopy(msgLength.getBytes(), 0, resultByte, 0, 4);
			System.arraycopy(msgBytes, 0, resultByte, 4, msgBytes.length);
			logger.debug("xmlMsg: "+new String(resultByte,encoding));
			return resultByte;
		} catch (IOException e) {
			throw new ApIOException(e);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				throw new ApIOException(e);
			}
		}
	}

	@Override
	public String mapToXml(Map<String, Object> map, String encoding) {
		return null;
	}

}
