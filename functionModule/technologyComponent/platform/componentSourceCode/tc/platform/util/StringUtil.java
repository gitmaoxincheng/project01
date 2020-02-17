package tc.platform.util;

import java.util.Arrays;

public class StringUtil {
	/**
	 * 补充长度
	 * @param param 源字符串
	 * @param width 指定填充指定字符串后的字符串长度
	 * @param fillString 指定的填充字符
	 * @return
	 */
	public static String rJust(String param, int width, String fillString) {
		
		while (param.length() < width) {
			param = fillString.concat(param);
		}
		
		return param;
	}
	
	/**
	 * 补充长度
	 * @param str 源字符串
	 * @param width 指定填充指定字符串后的字符串长度
	 * @param fillString 指定的填充字符
	 * @return
	 */
	public static String lJust(String str, int width, String fillString) {
		int length = str.length();
		StringBuilder sb = null;
		while (length < width) {
			sb = new StringBuilder();
			sb.append(str).append(fillString);
			str = sb.toString();
			length = sb.length();
		}
		return str;
	}
	
	  /**
     * 基础判断类
     * @param boolObject 判断是否为真对象
     *
     * @return 返回去掉空格后的字符串
     */
    public static boolean boolFrame(Object boolObject) {
    	if (boolObject == null) {
			throw new NullPointerException();
		}
		if (boolObject instanceof Boolean) {
			if (((Boolean) boolObject).booleanValue()) {
				return true;
			} else {
				return false;
			}
		} else if (boolObject instanceof Integer) {
			if (((Integer) boolObject).intValue() == 0) {
				return false;
			} else {
				return true;
			}
		} else {
			throw new IllegalArgumentException();
		}
    }
    
    /**
	 * 求字符串中指定片段出现的次数
	 * @param source 字符串
	 * @param find  指定字符
	 * @return
	 */
	public static int strCount(String source,String target) {
		int count = 0 ;
		while (source.indexOf(target) >= 0) {
			source = source.substring(source.indexOf(target) + target.length());
			count++;
		}
		return count;
	}
	
	/**
	 * String[]中是否包含String
	 * @param strs
	 * @param target
	 * @return
	 */
	public static boolean contains(String target, String[] strs) {
		return Arrays.asList(strs).contains(target);
	}
}
