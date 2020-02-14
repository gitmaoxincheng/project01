package cn.com.agree.huanan.ap.al.csitrd.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 证件类型枚举类
 * @author huangchaopeng
 */
public class IdType {
	private static Map<String, String> idtypes = new HashMap<String, String>();
	static {
		idtypes.put("A", "身份证");
		idtypes.put("W", "组织机构代码证");
		idtypes.put("W1", "组织机构代码证");   //（特殊机构代码赋码通知）;
		idtypes.put("M", "营业执照");
		idtypes.put("X", "身份证");

	}
	public static String map(String value) {
/*		for (IdType senum : IdType.values()) {
			if (senum.value.equals(value)) {
				return senum.desc;
			}
		}
		return "";*/
		return null != idtypes.get(value)?idtypes.get(value):"";
	}
	
}
