package cn.com.agree.huanan.ap.rl.corp.message.json;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.exception.tech.ApJsonParseException;
import cn.com.agree.huanan.ap.tl.message.impl.JsonParserImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

/**
 * @author luo.hp
 *
 */
@Component
public class NetSfJsonParserImpl extends JsonParserImpl{
//	private final static Logger logger = Logger.getLogger(NetSfJsonParserImpl.class);
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> jsonToMap(String jsonString) {
        // TODO 自动生成的方法存根
        if (jsonString == null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();  
        try {
            JSONObject json = JSONObject.fromObject(jsonString); 
            startDeal(json, map);	
		} catch (Exception e) {
			throw new ApJsonParseException(e);//Json报文解析异常
		}
        return map;
    }
    
    private void startDeal(JSONObject jsonObject, Map <String , Object> allMap){
        ArrayDeque <Object> deque = new ArrayDeque<>(Arrays.asList(jsonObject.keySet().toArray()));
		while(!deque.isEmpty()){
			String key = deque.poll().toString();
			Object currentObject = jsonObject.get(key);
			Object obj = dealJsonObject(currentObject);
			if(obj == null){
			    continue;
			}
//			logger.debug("压入:%s:%s", key, obj);
			allMap.put(key, obj);
			}
    }
    
    private Object dealJsonObject(Object currentObject){
        if(currentObject instanceof JSONArray){
            List<Object> jsonList = new ArrayList<Object>();
            JSONArray currentJsonArray = (JSONArray) currentObject;
            for(Object nextObj : currentJsonArray){
                if(nextObj ==null || nextObj instanceof JSONNull){
                    continue;
                }
            	jsonList.add(dealJsonObject(nextObj));
            }
            return jsonList;
        } if(currentObject instanceof JSONObject){
        	HashMap <String , Object> jmap = new HashMap<>();
        	JSONObject subJobj = (JSONObject) currentObject;
        	for(Object nextk : subJobj.keySet()){
        		Object currentJsonObj = subJobj.get(nextk);
        		if(currentJsonObj ==null || currentJsonObj instanceof JSONNull){
                    continue;
                }
        		jmap.put(nextk.toString(), dealJsonObject(currentJsonObj));
        	}
        	return jmap;
        }else {
            if(currentObject ==null || currentObject instanceof JSONNull){
                return null;
            }else{
                return currentObject;
            }
        	
        }
    }

    @Override
    public String mapToJson(Map<String, Object> map) {
        // TODO 自动生成的方法存根
        Object json = objectToJson(map);
        if (json == null){
            return null;
        }
        return json.toString();
    }

    /**
     * @param obj 数据对象Map/List/String/null
     * @return Json对象
     */
    public Object objectToJson(Object obj) {
    	// TODO 自动生成的方法存根
        if (obj == null){
            return null;
        }else if (obj instanceof List){
        	return JSONArray.fromObject(obj);
        }else if(obj instanceof Map){
        	return JSONObject.fromObject(obj);
        }else {	
        	return obj;
		}
    }
}
