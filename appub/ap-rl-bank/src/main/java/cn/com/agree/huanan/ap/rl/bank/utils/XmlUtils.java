package cn.com.agree.huanan.ap.rl.bank.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.XmlUtil;

/**
 * @author huangchaopeng
 * Xml报文处理类
 */
public class XmlUtils {
    public static final Logger logger = Logger.getLogger(XmlUtils.class);


    /**
     * 解析排队机PXML格式请求报文，返回Map
     * @param rspData  请求内容
     * @param encoding 编码
     * @return xml字符串
     * @throws UnsupportedEncodingException 不支持编码
     */
    public static Map<String, Object> parseQmsPXmlReqMsg(byte[] rspData, String encoding) throws UnsupportedEncodingException {
        Map<String, Object> result = new HashMap<String, Object>();
        Document doc = XmlUtil.xmlToDom(new String(rspData, encoding), encoding);
        Element rootElement = doc.getRootElement();
        Map<String, Object> reqMap = XmlUtil.dom2MapWithRoot(rootElement);
//		result.put("ReqHdr", reqMap.get("ReqHdr"));
//		result.put("Content", reqMap.get("Content"));
        if (reqMap.get("ReqHdr") instanceof Map) {
            result.put("ReqHdr", reqMap.get("ReqHdr"));
        } else {
            result.put("ReqHdr", new HashMap<>());
        }

        if (reqMap.get("Content") instanceof Map) {
            result.put("Content", reqMap.get("Content"));
        } else {
            result.put("Content", new HashMap<>());
        }
        return result;
    }

    /**
     * 创建QmsPXml格式报文
     *
     * @param parameters 请求内容
     * @param encoding   编码
     * @return xml字符串
     * @throws IOException IO异常
     */
    public static String buildQmsPXmlRspMsg(Map<String, Object> parameters, String encoding) throws IOException {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("Document");
        doc.setXMLEncoding(encoding);
        XmlUtil.map2element(root, parameters);
        return XmlUtil.domToString(doc);
    }

    /**
     * 创建发送ECI报文，通过标识判断请求或返回
     *
     * @param parameters 请求内容
     * @param encoding   编码
     * @return xml字符串
     * @throws IOException IO异常
     */
    public static String buildEciXmlMessage(Map<String, Object> parameters, String encoding) throws IOException {
        if ("1".equals(parameters.get("ECI_MSG_FLAG"))) {    //返回报文 XXX
            parameters.remove("ECI_MSG_FLAG");
            return buildEciResponseMsg(parameters, encoding);
        } else {                                            //请求报文 XX
            parameters.remove("ECI_MSG_FLAG");
            return buildEciRequestMsg(parameters, encoding);
        }
    }


    /**
     * 创建发送ECI请求报文，返回字节数组
     *
     * @param parameters 请求内容
     * @param encoding   编码
     * @return xml字符串
     * @throws IOException IO异常
     */
    public static byte[] buildEciRequestMsgBytes(Map<String, Object> parameters, String encoding) throws IOException {
        String msgStr = buildEciRequestMsg(parameters, encoding);
        return msgStr.getBytes(encoding);
    }


    /**
     * 创建发送ECI请求报文，返回字符串
     *
     * @param parameters 请求内容
     * @param encoding   编码
     * @return xml字符串
     * @throws IOException IO异常
     */
    public static String buildEciRequestMsg(Map<String, Object> parameters, String encoding) throws IOException {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("Request");
        doc.setXMLEncoding(encoding);
        XmlUtil.map2element(root, parameters);
        return XmlUtil.domToString(doc);
    }

    /**
     * 创建发送ECI返回报文，返回字符串
     *
     * @param parameters 请求内容
     * @param encoding   编码
     * @return xml字符串
     * @throws IOException IO异常
     */
    public static String buildEciResponseMsg(Map<String, Object> parameters, String encoding) throws IOException {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("Response");  //待优化，像XmlReader一样
        doc.setXMLEncoding(encoding);
        XmlUtil.map2element(root, parameters);
        return XmlUtil.domToString(doc);
    }

    /**
     * 解析ECI返回报文，返回Map
     *
     * @param rspData  ECI返回报文
     * @param encoding 编码
     * @return Map报文容器
     * @throws DocumentException            Dom异常
     * @throws UnsupportedEncodingException 编码不支持
     */
    public static Map<String, Object> parseEciXmlMessage(byte[] rspData, String encoding) throws UnsupportedEncodingException, DocumentException {
        Map<String, Object> result = new HashMap<String, Object>();

        //优化前 20191228
//        Map<String, Object> mapData = new HashMap<String, Object>();
//        Document doc = null;
//        doc = XmlUtil.xmlToDom(new String(rspData, encoding), encoding);
//        Element rootElement = doc.getRootElement();
//        element2Map(rootElement, mapData);

        Document doc = XmlUtil.xmlToDom(new String(rspData, encoding), encoding);
        Element rootElement = doc.getRootElement();
        Map<String, Object> mapData = XmlUtil.dom2MapWithRoot(rootElement);
        result.put("Ctrl", mapData.get("Ctrl"));
//		result.put("Body", ((Map)((Map<String,Object>)rsqDict.get(rootElement.getName())).get("Body"))); //优化前
        if (mapData.get("Body") instanceof Map) {
            result.put("Body", mapData.get("Body"));
        } else {
            result.put("Body", new HashMap<>());
        }
        return result;
    }


    /**
     * 解析ECI请求报文，返回JavaDict
     *
     * @param reqData  请求内容
     * @param encoding 编码
     * @return
     * @throws Exception
     */
    public static JavaDict parseReqXmlMessage(byte[] reqData, String encoding)
            throws Exception {

        JavaDict result = new JavaDict();

        JavaDict rsqDict = new JavaDict();
        Document doc = null;
        doc = DocumentHelper.parseText(new String(reqData, encoding));

        Element rootElement = doc.getRootElement();

        element2dict(rootElement, rsqDict);
        JavaDict request = rsqDict.getDictItem("Request");
        result.put("Ctrl", request.getDictItem("Ctrl", new JavaDict()));
        result.put("Body", request.getDictItem("Body", new JavaDict()));
//		result.putAll(rsqDict.getDictItem("Request").getDictItem("Ctrl",new JavaDict()));
//		if (rsqDict.getDictItem("Request").getItem("Body") instanceof Map){
//			result.putAll(rsqDict.getDictItem("Request").getDictItem("Body",new JavaDict()));
//		}
        return result;
    }

    /**
     * 解析ECI返回报文，返回JavaDict
     *
     * @param rspData  返回内容
     * @param encoding 编码
     * @return
     * @throws DocumentException            Dom异常
     * @throws UnsupportedEncodingException 编码不支持on
     */
    public static JavaDict parseRspXmlMessage(byte[] rspData, String encoding) throws UnsupportedEncodingException, DocumentException {

        JavaDict result = new JavaDict();
        JavaDict rsqDict = new JavaDict();
        Document doc = null;
        doc = DocumentHelper.parseText(new String(rspData, encoding));

        Element rootElement = doc.getRootElement();
        element2dict(rootElement, rsqDict);
        result.putAll(rsqDict.getDictItem("Response").getDictItem("Ctrl", new JavaDict()));
        result.putAll(rsqDict.getDictItem("Response").getDictItem("Body", new JavaDict()));
        result.putAll(rsqDict.getDictItem("Response").getDictItem("Head", new JavaDict()));
//		if (rsqDict.getDictItem("Response").getItem("Body") instanceof Map){
//			result.putAll(rsqDict.getDictItem("Response").getDictItem("Body",new JavaDict()));
//		}
        return result;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void element2dict(Element elmt, JavaDict rspDict) {
        if (null == elmt) {
            return;
        }
        String name = elmt.getName();
        if (elmt.isTextOnly()) {
            rspDict.put(name, elmt.getText());
        } else {
            JavaDict dictSub = new JavaDict();
            List<Element> elements = elmt.elements();
            for (Element elmtSub : elements) {
                element2dict(elmtSub, dictSub);
            }
            Object first = rspDict.get(name);
            if (null == first) {
                rspDict.put(name, dictSub);
            } else {
                if (first instanceof JavaList) {
                    ((JavaList) first).add(dictSub);
                } else {
                    JavaList listSub = new JavaList();
                    listSub.add(first);
                    listSub.add(dictSub);
                    rspDict.put(name, listSub);
                }
            }
        }
    }

}
