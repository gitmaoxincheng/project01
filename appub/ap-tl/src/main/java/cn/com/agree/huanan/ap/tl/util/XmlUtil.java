/**
 * FileName: StrUtil
 * Author:   Ren Xiaotian hcp
 * Date:     2018/8/14 11:17
 */

package cn.com.agree.huanan.ap.tl.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.com.agree.huanan.ap.tl.exception.tech.ApXmlParseException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.dom4j.io.XMLWriter;

/**
 * XML工具类：XML转换
 */
public class XmlUtil {
    private final static Logger logger = Logger.getLogger(XmlUtil.class);

    private XmlUtil() {
    }

    /**
     * UTF-8编码
     */
    public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");
    /**
     * GBK编码
     */
    public static final Charset CHARSET_GBK = Charset.forName("GBK");
    private static final ThreadLocal<SAXReader> threadLocalsaxReader = ThreadLocal.withInitial(() -> {
        try {
            return new SAXReader();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    });

/*    private static final ThreadLocal<XMLWriter> threadLocalXmlWriter = ThreadLocal.withInitial(() -> {
        try {
            return new XMLWriter();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    });*/


    /**
     * xml字符串转Document
     *
     * @param xmlString XML字符串
     * @return Map
     */
    public static Document xmlToDom(String xmlString, String encoding) {
        Document doc = null;
        try {
            SAXReader saxReader = threadLocalsaxReader.get();
            doc = saxReader.read(new ByteArrayInputStream(xmlString.getBytes(encoding)));
        } catch (DocumentException | UnsupportedEncodingException e) {
            logger.error("xml转换失败!", e);
            throw new ApXmlParseException(e);
        }
        return doc;
    }


    /**
     * xml字符串转Map
     *
     * @param xmlString XML字符串
     * @return Map
     */
    public static Map<String, Object> xmlToMap(String xmlString, String encoding) {
        Document doc = null;
        try {
            SAXReader saxReader = threadLocalsaxReader.get();
            doc = saxReader.read(new ByteArrayInputStream(xmlString.getBytes(encoding)));
            doc = DocumentHelper.parseText(xmlString);
            return dom2Map(doc);
        } catch (DocumentException | UnsupportedEncodingException e) {
            logger.error("xml转换失败!", e);
            throw new ApXmlParseException(e);
        }
    }




    public static Map<String, Object> dom2Map(Document doc) {
        if (doc == null)
            return new HashMap<String, Object>();
        Element root = doc.getRootElement();
        Map<String,Object> result = new HashedMap();
        dom2Map(root,result);
        return result;
    }
    public static Map<String, Object> dom2Map(Element root) {
        if (root == null)
            return null;
        Map<String,Object> result = new HashedMap();
        dom2Map(root,result);
        return result;
    }
    
    public static Map<String, Object> dom2MapWithRoot(Element root) {
        if (root == null)
            return null;
        Map<String,Object> result = new HashedMap();
        dom2Map(root,result);
        return (Map<String, Object>) result.get(root.getName());
    }
    
 /*   @SuppressWarnings("unchecked")
    public static Map<String, Object> dom2Map(Element e) {
		if (null == e) {
			return null;
		}
    	logger.debug("Ele:%s",e.getName());
        Map<String, Object> map = new HashMap<String, Object>();
        List<Element> list = e.elements();
        if (list.size() > 0) {
            List<Object> mapList = null;
            for (int i = 0; i < list.size(); i++) {
                Element iter = list.get(i);
                Map<String, Object> m = dom2Map(iter);
                if (map.get(iter.getName()) == null) {
                	logger.debug("3:key:%s,value:%s",iter.getName(),m);
                    map.put(iter.getName(), m);
                } else {
                    Object obj = map.get(iter.getName());
                    if (!(obj instanceof List)) {            //如果已有该Key ,新解析出来的与已有的值组成，List,即同标签数据多于1个
                        mapList = new ArrayList<Object>();
                        mapList.add(obj);
                        mapList.add(m);
                    	logger.debug("2:key:%s,value:%s",iter.getName(),mapList);
                        map.put(iter.getName(), mapList);
                    } else {                                //如果未有Map,则新解析的值为Map,即同标签数据只有1个
                    	logger.debug("4:key:%s,value:%s",iter.getName(),obj);
                        mapList = (List<Object>) obj;
                        mapList.add(m);
                    }
                }
            }
        } else {
        	logger.debug("1:key:%s,value:%s",e.getName(),e.getText());
            map.put(e.getName(), e.getText());
        }
        return map;
    }*/
	
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void dom2Map(Element elmt, Map<String, Object> dataMap) {
		if (null == elmt) {
			return;
		}
		String name = elmt.getName();
		if (elmt.isTextOnly()) {
			dataMap.put(name, elmt.getText());
		} else {
			Map<String, Object> subMap = new HashMap<>();
			List<Element> elements = (List<Element>) elmt.elements();
			for (Element elmtSub : elements) {
				dom2Map(elmtSub, subMap);
			}
			Object first = dataMap.get(name);
			if (null == first) {
				dataMap.put(name, subMap);
			} else {
				if (first instanceof List) {
					((List<Map<String, Object>>) first).add(subMap);
				} else {
					List<Object> subList = new ArrayList<>();
					subList.add(first);
					subList.add(subMap);
					dataMap.put(name, subList);
				}
			}
		}
	}
    
    
    
    public static String domToString(Document document) throws IOException {
        StringWriter out = new StringWriter();
        try {
            XMLWriter xmlwriter = new XMLWriter(out);
            xmlwriter.write(document);
            xmlwriter.flush();
        } finally {
            out.close();
        }
        return out.toString();
    }

    /**
     * 将map的数据转换到element
     *
     * @param element
     * @param parameters
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static void map2element(Element element, Map<String, Object> parameters) {

        Set<String> keys = parameters.keySet();
        for (String key : keys) {
            if (parameters.get(key) instanceof String) {        //改判断与最后一个else出口实际上作用相同，但实际情况中绝大多数返回类型均为String，故加此判断，提高效率
                element.addElement(key).addText(String.valueOf(parameters.get(key)));
            } else if (parameters.get(key) instanceof List<?>) {    //当返回类型为List时，遍历List
                for (Object value : (List<?>) parameters.get(key)) {
                    //list里是map或String或其他可直接转换为String的内容，不会存在list里直接是list的，
                    if (value instanceof Map) {
                        map2element(element.addElement(key),(Map<String, Object>) value);
                    }
                    /*  XXX 思考点，加上该判断逻辑更严谨，但实际上平台定义的接口内容，基本不会出现该情况，这里略显多余，参照各系统处理方式
                        这里暂时不加，另外，考虑一点，当平台返回内容返回的是包含自定义bean时，基本上是，本Xml处理方法无法处理
                    else if (value instanceof List){
                        logger.error("map2element节点类型非法:%s" + key);
                        throw new ApXmlParseException(new Exception("map2element节点类型非法"));
                    }
                    */
                    else{
                        element.addElement(key).addText(String.valueOf(value));
                    }
                }

            } else if (parameters.get(key) instanceof Map) {   //当返回类型为Map时，递归Map
                map2element(element.addElement(key),(Map<String, Object>) parameters.get(key));
            } else {
                element.addElement(key).addText(String.valueOf(parameters.get(key)));
            }
        }
    }


}
