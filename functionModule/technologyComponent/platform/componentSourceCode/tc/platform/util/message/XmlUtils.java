package tc.platform.util.message;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;

public class XmlUtils {

	/**
	 * dom4j解析XML
	 * @param serveCode
	 * @param sceneCode
	 * @param parameters
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static byte[] buildRequestMessage(Map<String, Object> parameters,
			String encoding) throws Exception {

		byte[] result = null;

		Document doc = DocumentHelper.createDocument();

		Element root = doc.addElement("Request");

		doc.setXMLEncoding(CommConstant.ENCODING_UTF8);

		map2element(root, parameters);

		StringWriter out = new StringWriter();
		try {
			XMLWriter xmlwriter = new XMLWriter(out);

			xmlwriter.write(doc);
			xmlwriter.flush();
		} finally {
			out.close();
		}
		result = out.toString().getBytes(CommConstant.ENCODING_UTF8);
		return result;
	}
	
	/**
	 * 将element中的数据存进DICT
	 * @param rspData
	 * @param encoding
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
		JavaDict request =rsqDict.getDictItem("Request");
		result.put("Ctrl", request.getDictItem("Ctrl",new JavaDict()));
		result.put("Body", request.getDictItem("Body",new JavaDict()));
//		result.putAll(rsqDict.getDictItem("Request").getDictItem("Ctrl",new JavaDict()));
//		if (rsqDict.getDictItem("Request").getItem("Body") instanceof Map){
//			result.putAll(rsqDict.getDictItem("Request").getDictItem("Body",new JavaDict()));
//		}
		return result;
	}
	
	/**
	 * 将map的数据转换到element
	 * @param element
	 * @param parameters
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static void map2element(Element element,
			Map<String, Object> parameters) throws Exception {

		Set<String> keys = parameters.keySet();
		for (String key : keys) {

			if (parameters.get(key) instanceof String) {

				element.addElement(key).addText(
						String.valueOf(parameters.get(key)));

			} else if (parameters.get(key) instanceof List<?>) {

				for (Object value : (List<?>) parameters.get(key)) {

					if (value instanceof String) {

						element.addElement(key).addText(String.valueOf(value));

					} else if (value instanceof Map) {

						map2element(element.addElement(key),
								(Map<String, Object>) value);
					} else {
						AppLogger
								.error("map2element节点类型非法:" + value.toString());
						throw new Exception("map2element节点类型非法");
					}
				}

			} else if (parameters.get(key) instanceof Map) {
				map2element(element.addElement(key),
						(Map<String, Object>) parameters.get(key));
			}
		}
	}
	
	/**
	 * 将element中的数据存进DICT
	 * @param rspData
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static JavaDict parseXmlMessage(byte[] rspData, String encoding)
			throws Exception {

		JavaDict result = new JavaDict();

		JavaDict rsqDict = new JavaDict();

		Document doc = null;

		doc = DocumentHelper.parseText(new String(rspData, encoding));

		Element rootElement = doc.getRootElement();

		element2dict(rootElement, rsqDict);
		
		result.putAll(rsqDict.getDictItem("Response").getDictItem("Ctrl",new JavaDict()));
		
		if (rsqDict.getDictItem("Response").getItem("Body") instanceof Map){
			result.putAll(rsqDict.getDictItem("Response").getDictItem("Body",new JavaDict()));
		}

		return result;
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void element2dict(Element elmt, JavaDict rspDict) {
		if (null == elmt) {
			return;
		}
		String name = elmt.getName();
		if (elmt.isTextOnly()) {
			rspDict.put(name, elmt.getText());
		} else {
			JavaDict dictSub = new JavaDict();
			List<Element> elements = (List<Element>) elmt.elements();
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
