package ap.ide.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import cn.com.agree.afa.svc.javaengine.context.JavaList;

/**
 * 
 * @author JUN
 *
 */
public class JavaListUtil{
	
	/**
	 * JavaList转String数组
	 * @param javaList
	 * @return String[]
	 */
	public static String[] toStringArray(JavaList javaList){
		Object[] src = javaList.toArray();
		String[] des = new String[src.length];
		for(int i=0;i<src.length;i++){
			des[i] = src[i].toString();
		}
		return des;
	}
	
	/**
	 * JavaList转List
	 * @param javaList
	 * @return List<Object>
	 */
	public static List<Object> toList(JavaList javaList){
		List<Object> des = new ArrayList<Object>();
		for(int i=0;i<javaList.size();i++){
			des.add(javaList.get(i));
		}
		return des;
	}

    /**
     * @param list List列表
     * @return javaList JavaList列表
     */
    public static JavaList listToJavaList(List list) {
		JavaList des = new JavaList();
		for(int i=0;i<list.size();i++){
            Object obj = list.get(i);
            if (obj instanceof Map){
            	des.add(JavaDictUtil.mapToDict((Map)obj));
            }else if (obj instanceof List) {
            	des.add(listToJavaList((List)obj));
			}else {
				des.add(list.get(i));	
			}
			
		}
        return des;
    }
	
	/**
	 * JavaList转List
	 * @param javaList
	 * @return List<Object>
	 */
	public static JavaList toJavaList(List list){
		JavaList des = new JavaList();
		for(int i=0;i<list.size();i++){
			des.add(list.get(i));
		}
		return des;
	}
	
	/**
	 * JavaList转String
	 * @param javaList
	 * @return String
	 */
	public static String javaListToString(JavaList javaList){
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0;i<javaList.size();i++){
			sb.append(javaList.getStringItem(i));
			if(i!=(javaList.size()-1))
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
}