package tc.platform.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ibm.db2.jcc.a.i;
import com.ibm.db2.jcc.a.t;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.exception.BaseException;

/**
 * 转换工具类
 * @author bodadmin
 *
 */
public class ConvertUtils {

	public static JavaDict json2Dict(JSONObject jsonObject) {
		Iterator<Entry<String, Object>> iterator = jsonObject.entrySet().iterator();
		JavaDict dict = new JavaDict();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				dict.put(key, null);
			} else if (value instanceof JSONObject) {
				dict.put(key, json2Dict((JSONObject) value));
			} else if (value instanceof JSONArray) {
				dict.put(key, json2List((JSONArray) value));
			} else {
				dict.put(key, value);
			}
		}
		return dict;
	}
	
	public static JavaList json2List(JSONArray jsonArray) {
		JavaList list = new JavaList();
		for (int i = 0; i < jsonArray.size(); i++) {
			Object value = jsonArray.get(i);
			if (value == null) {
				list.add(null);
			} else if (value instanceof JSONObject) {
				list.add(json2Dict((JSONObject) value));
			} else if (value instanceof JSONArray) {
				list.add(json2List((JSONArray) value));
			} else {
				list.add(value);
			}
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static void map2Dict(Map<String, Object> map, JavaDict dict) {
		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();
			if (entry.getValue() instanceof Map) {
				dict.setItem(entry.getKey(), new JavaDict());
				map2Dict((Map<String, Object>) entry.getValue(), dict.getDictItem(entry.getKey()));
			} else {
				dict.setItem(entry.getKey(), entry.getValue());
			}
		}
	}
	
	public static Map<String, Object> dict2Map(JavaDict dict) {
		Iterator<Entry<Object, Object>> iterator = dict.entrySet().iterator();
		Map<String, Object> ret = new HashMap<>();
		while (iterator.hasNext()) {
			Entry<Object, Object> entry = iterator.next();
			ret.put((String)entry.getKey(), entry.getValue());
		}
		return ret;
	}
	
	/**
	 * 全角字符串转半角字符串
	 * @param str
	 * @throws BaseException 
	 */
	public static String toSingleByte(String str) throws BaseException {
		try {
			char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				int charIntValue = (int) charArray[i];
				if (charIntValue >= 65281 && charIntValue <= 65374) {
					charArray[i] = (char) (charIntValue - 65248);
				} else if (charIntValue == 12288) {
					charArray[i] = (char) 32;
				}
			}
			return new String(charArray);
		} catch (Exception e) {
			throw new BaseException(CommonErrorCodeEnum.DOUBLE_TO_SINGLE_ERROR, String.format("字符编码错误,[%s]存在生僻字,请修改", str));
		}
		
	}
	
	/**
	 * 半角字符串转全角字符串
	 * @param str
	 * @return
	 * @throws BaseException 
	 */
	public static String toDoubleByte(String str) throws BaseException {
		try {
			char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				int charIntValue = (int) charArray[i];
				if (charIntValue >= 33 && charIntValue <= 126) {
					charArray[i] = (char) (charIntValue + 65248);
				} else if (charIntValue == 32) {
					charArray[i] = (char) 12288;
				}
			}
			return new String(charArray);
		} catch (Exception e) {
			throw new BaseException(CommonErrorCodeEnum.SINGLE_TO_DOUBLE_ERROR, String.format("字符编码错误,[%s]存在生僻字,请修改", str));
		}
	}
	
	/**
	 * [[数据表第一条], [数据表第二条], ...] 转成 [{key:value, key:value}, {}, {}]格式
	 * @return
	 */
	public static JavaList list2QueryList(JavaList target, JavaList fields, String aliasconv) {
		JavaList ret = new JavaList();
		if (target != null && target.size() != 0) {
			if (target.getListItem(0).size() != fields.size()) {
				throw new RuntimeException("[ConvertUtils.list2QueryDict]查询结果集与查询字段长度不匹配");
			}
			int vn = target.size();
			int fn = fields.size();
			JavaList fieldsAfterSplit = new JavaList();
			if (aliasconv.trim().equals("Y")) {
				for (int f = 0; f < fn; f++) {
					String field = fields.getStringItem(f);
					//field的格式为"A" or "A as B" or "A B",先把" as "替换成" ",然后按" "切片
					String[] stringFields = field.trim().replace(" as ", " ").split(" ");
					if (stringFields.length == 2) {
						field = stringFields[1];
					}
					fieldsAfterSplit.add(field);
				}
			}
			for (int v = 0; v < vn; v++) {
				JavaDict tmp = new JavaDict();
				for (int f = 0; f < fn; f++) {
					if (aliasconv.trim().equals("Y")) {
						tmp.setItem(fieldsAfterSplit.getStringItem(f), target.getListItem(v).getStringItem(f));
					} else {
						tmp.setItem(fields.getStringItem(f), target.getListItem(v).getStringItem(f));
					}
				}
				ret.add(tmp);
			}
		}
		return ret;
	}
	
}
