package cn.com.agree.huanan.ap.tl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 *@author Jun
 *
 **/
public class KeyFormatUtil {
	
	private final static char UNDERLIN = '_';

	/**
	 * 
	 * @param key 将key以驼峰格式格式化
	 * @return 返回格式化内容
	 */
	public static String UnderLineToCamel(String key){
		if(key == null || "".equals(key.trim())){
			return "";
		}
		int len = key.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<len;i++){
			char c = key.charAt(i);
			if(i==0){
				if(c!=UNDERLIN){
					sb.append(Character.toUpperCase(c));
				}
				continue;
			}
			if(c == UNDERLIN){
				if(++i<len){
					sb.append(Character.toUpperCase(key.charAt(i)));
				}
			}else{
				sb.append(Character.toLowerCase(c));
			}
		}
		return sb.toString();
	}
	
	
	public static String CamelToDB(String key){
		if(key == null || "".equals(key.trim())){
			return "";
		}
		int len = key.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<len;i++){
			char c = key.charAt(i);
			if(i==0){
				if(c!=UNDERLIN){
					sb.append(c);
				}
				continue;
			}
			if(Character.isUpperCase(c)||!Character.isLetter(c)){
				sb.append(UNDERLIN);
			}
				
			sb.append(c);
		}
		
		return sb.toString();
		
		
	}
	
	
	public static Map<String, Object> formatKey(Map<String, Object> src) {
		if(src==null||src.isEmpty()){
			return src;
		}
		Map<String, Object> des = new HashMap<>();
		Iterator<String> keys = src.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			des.put(UnderLineToCamel(key), src.get(key));
		}
		src.clear();
		src = null;
		return des;
	}
	
	
	
	public static List<Map<String,Object>> formatKey(List<Map<String, Object>> src) {
		if(src.isEmpty()){
			return src;
		}
		List<Map<String,Object>> des = new ArrayList<Map<String,Object>>();
		src.forEach(map->{
			des.add(formatKey(map));
		});
		return des;
	}
	
	
	public static Map<String, Object> formatToDB(Map<String, Object> src){
		if(src == null || src.isEmpty()){
			return src;
		}
		Map<String, Object> des = new HashMap<>();
		Iterator<String> keys = src.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			des.put(CamelToDB(key), src.get(key));
		}
		src.clear();
		src = null;
		return des;
	}
	
	
//	public static void main(String[] args){
//		Map<String,Object> map = new HashMap<>();
//		map.put("StrustKey", "bb");
//		map.put("_AbSt", "ff");
//		System.out.println(formatToDB(map));
//	}
	
}


