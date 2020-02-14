package cn.com.agree.huanan.ap.tl.util;

import java.util.Map;

import net.sf.json.JSONObject;
import cn.com.agree.huanan.ap.tl.message.std.JsonParser;

/**
 * @author luo.hp
 * @category Json tools
 *
 */
public class JsonUtil extends UtilBase<JsonParser>{

    private static JsonUtil util = null;
    
    protected JsonUtil() {
        super(JsonParser.class);
        // TODO 自动生成的构造函数存根
    }
    
	/**
	 * @param jsonStr Json String
	 * @return Map Object
	 */
	public Map<String, Object> jsonStringToMap(String jsonStr){  
	    return this.thisUtil().jsonToMap(jsonStr);
    } 
	
	/**
	 * @param map Map Object
	 * @return Json String
	 */
	public String mapToJsonString(Map<String,Object> map){
	    return this.thisUtil().mapToJson(map);
	}
	
	/**
	 * @param map Map
	 * @return Json Object
	 */
	public JSONObject mapToJsonObject(Map<String,Object> map){
	    return JSONObject.fromObject(map);
	}
	
	/**
	 * @return 生成Json Util单例
	 */
	public static JsonUtil getUtil(){
	    if (util == null){
	        util = new JsonUtil();
	    }
	    return util;
	}
}
