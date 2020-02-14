package cn.com.agree.huanan.ap.rl.bank.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import cn.com.agree.huanan.ap.tl.exception.tech.ApXmlParseException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

public class SealAPI {

	public static final Logger logger = Logger.getLogger(SealAPI.class);

	/**
	 * 创建发送Svs验印系统发送报文，返回字符串
	 * @param parameters 请求内容
	 * @param encoding 编码
	 * @return
	 * @throws Exception
	 */
	public static String buildSvsReqMsg(Map<String, Object> parameters,String encoding) throws Exception {

		Map<String, Object> result = null;
		StringBuffer sb= new StringBuffer();
		String Encode ="UTF-8";
		String Element ="autoProve";
		String Body ="Body";
		String SEALPROVERESPONSE ="sealProveResponse";
		String RETURN ="return";
		String sendStringData = null;
		try {
			sendStringData = getSendPackString(parameters,Element);
			sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.ws.plseal.yinzhijie.com\"><soapenv:Header/><soapenv:Body><ser:sealProve><ser:request><![CDATA[");
			sb.append(sendStringData);
			sb.append("]]></ser:request> </ser:sealProve></soapenv:Body></soapenv:Envelope>");
		} catch (Exception e) {
			logger.error("拼接验印系统报文失败", e);
			throw e;
		}
		return sb.toString();
	}

	/**
	 * 解析Svs验印系统请求报文，返回JavaDict
	 * @param parameters 请求内容
	 * @param encoding 编码
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> parseSvsRspMsg(String rspData, String encoding) throws Exception {
		Map<String, Object> result = null;
		StringBuffer sb= new StringBuffer();
		String Encode ="UTF-8";
		String Element ="autoProve";
		String Body ="Body";
		String SEALPROVERESPONSE ="sealProveResponse";
		String RETURN ="return";
		String sendStringData = null;
		Map<String, Object> rspResult = null;
		try {
			rspResult =unPackXML(rspData);
			String temp =(String) ((Map<String,Object>) ((Map<String,Object>)rspResult.get(Body)).get(SEALPROVERESPONSE)).get(RETURN);
			logger.info("读到数据--" + temp);
			result =unPackXML(temp);
			logger.info("读到返回数据--" + result);
		} catch (NumberFormatException e) {
			logger.error("读取返回报文长度出错：", e);
			throw new NumberFormatException("读取返回报文长度出错："+ e);
		} catch (Exception e) {
			logger.error("读取返回报文出错", e);
			throw new ApXmlParseException(e);
		}
		return result;
	}

	/**
	 * 解析Svs验印系统请求报文，返回JavaDict
	 * @param parameters 请求内容
	 * @param encoding 编码
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> parseSvsXmlRspMsgfromByte(byte[] rspData, String encoding){
		String rspStr;
		try {
			rspStr = new String(rspData,encoding);
			String message = rspStr.substring(8, rspStr.length());
			Map<String, Object> rspResult;
			rspResult = unPackXML(message);
			if (rspResult.get("RequestBody") == null) {
			throw new ApXmlParseException(new Exception("解析验印系统推送报文出错"));
			}
			 return rspResult;
		} catch (DocumentException | UnsupportedEncodingException e) {
			throw new ApXmlParseException(e);
		}
	}	

	
	/**
	 * 解析Svs验印系统请求报文，返回JavaDict
	 * @param parameters 请求内容
	 * @param encoding 编码
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> parseSvsXmlRspMsg(String rspData, String encoding){
		String message = rspData.substring(8, rspData.length());
		Map<String, Object> rspResult;
		try {
			 rspResult = unPackXML(message);
			 if (rspResult.get("RequestBody") == null) {
				throw new ApXmlParseException(new Exception("解析验印系统推送报文出错"));
			}
			 return rspResult;
		} catch (DocumentException e) {
			throw new ApXmlParseException(e);
		}
	}	

	/**
	 * 创建发送Svs验印系统发送报文，返回字符串
	 * @param parameters 请求内容
	 * @param encoding 编码
	 * @return
	 * @throws Exception
	 */
	public static byte[] buildSvsXmlRspMsg(Map<String, Object> parameters,String encoding) throws Exception {
		String Element ="autoProve";

		String rspXmlMsg = getSendPackString(parameters,Element);
		byte[] bodyBytes = rspXmlMsg.getBytes();
		String msgLength = StrUtil.lJust(String.valueOf(bodyBytes.length), 8, '0');
		byte[] resultByte = new byte[8 + bodyBytes.length];
		System.arraycopy(msgLength.getBytes(), 0, resultByte, 0, 8);
		System.arraycopy(bodyBytes, 0, resultByte, 8, bodyBytes.length);
		return resultByte;
	}	
	

	public static String getSendPackString(Map dataMap, String requestTag) throws IOException {

		DocumentFactory docFactory = DocumentFactory.getInstance();
		Document doc = docFactory.createDocument();
		Element root = docFactory.createElement(requestTag);
		doc.add(root);
		String[] keys = (String[]) dataMap.keySet().toArray(new String[0]);
		for (String key : keys){
			Object obj = dataMap.get(key);
			addElement(root, key, obj);
		}
		String xmlStr = doc.asXML();
		//################xml类型的报文中含有特殊字符时，需要转义，by pengzx
		//OutputFormat format=OutputFormat.createPrettyPrint();
		StringWriter sw=new StringWriter();
		XMLWriter xw=null;
		try {
			xw=new XMLWriter(sw);
			xw.setEscapeText(false);//设置为不转义
			xw.write(doc);
			xw.flush();
			xmlStr=sw.toString();
		} finally{
			xw.close();
		}
		return xmlStr;

	}

	public static void addElement(Element el, String key, Object obj){
		if (obj==null){
			addElement(el, key, "");
		}else if (obj instanceof Map){
			Element varE = el.addElement(key);
			String[] keys = (String[]) ((Map)obj).keySet().toArray(new String[0]);
			for (String mapkey : keys){
				addElement(varE, mapkey, ((Map)obj).get(mapkey) );
			}
		}else if (obj instanceof String){
			el.addElement(key).setText((String) obj);
		}else if (obj instanceof List){
			for (Object var : (List)obj){
				addElement(el, key, var);
			}
		}else if (obj instanceof Object[]){
			for (Object var : (Object[])obj){
				addElement(el, key, var);
			}
		}else{
			addElement(el, key, obj.toString());
		}
	}

	public static Map unPackXML(String xml) throws DocumentException {
		// TODO Auto-generated method stub
		Map resultMap=new LinkedHashMap();
		Document doc = DocumentHelper.parseText(xml);
		Element root = doc.getRootElement();
		unPackXmlElement(resultMap, root);

		return resultMap;
	}

	public static void unPackXmlElement(Map map, Element el){
		Set<String> elNames = new LinkedHashSet<String>();
		for (Element e : (List<Element>)el.elements()){
			elNames.add(e.getName());
		}
		if (elNames.size()==0){//无有子节点，，即本身是叶子节点 <key>value</key>
			map.put(el.getName(), el.getText());
		}else{//有个子节点，，<key><subkey>subValue</subkey>...</key>
			for (String name : elNames){
				List<Element> list = el.elements(name);
				if (list.size()==1){//存在一个同名子节点
					if (list.get(0).elements().size()==0){
						map.put(name, list.get(0).getText());
					}else{
						Map temp = new LinkedHashMap();
						map.put(name, temp);
						unPackXmlElement(temp, list.get(0));
					}
				}else{//存在多个同名子节点   list
					List temp = new ArrayList();
					map.put(name, temp);
					for (Element varE : list ){
						if (varE.elements().size()==0){
							temp.add(varE.getText());
						}else{
							Map varM = new LinkedHashMap();
							temp.add(varM);
							unPackXmlElement(varM, varE);
						}
					}
				}
			}
		}
	}
}
