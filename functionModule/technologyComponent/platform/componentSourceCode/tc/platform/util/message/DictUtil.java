package tc.platform.util.message;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.com.agree.afa.svc.javaengine.context.JavaDict;
public class DictUtil {

	/**
	 * 
	 * @param inputMap
	 * @param outputDict
	 */
	@SuppressWarnings("unchecked")
	public static void Map2Dict(Map<String, Object> inputMap, JavaDict outputDict){
		
		Iterator<Map.Entry<String, Object>> entries = inputMap.entrySet().iterator();
		
		while(entries.hasNext()){
			
			Map.Entry<String, Object> entry = entries.next();
			
			if (entry.getValue() instanceof String || entry.getValue() instanceof List){
				outputDict.put(entry.getKey(), entry.getValue());
			}else {
				outputDict.put(entry.getKey(), new JavaDict());
				Map2Dict((Map<String, Object>)inputMap.get(entry.getKey()), outputDict.getDictItem(entry.getKey()));
			}
		}
	}
}
