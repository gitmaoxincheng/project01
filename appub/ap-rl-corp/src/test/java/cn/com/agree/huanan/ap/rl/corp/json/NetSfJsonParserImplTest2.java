package cn.com.agree.huanan.ap.rl.corp.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.com.agree.huanan.ap.rl.corp.message.json.NetSfJsonParserImpl;
import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author HCP
 */
public class NetSfJsonParserImplTest2 {


    private NetSfJsonParserImpl jsonParser = new NetSfJsonParserImpl();

    @Test
    public void testJsonToMap(){
        JSONObject json1 = new JSONObject();
        json1.put("k1","v1");
        JSONObject json2 = new JSONObject();
        json2.put("k2","v2");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(json2);
        json1.put("k",jsonArray);

        String expected = "{k1=v1, k=[{k2=v2}]}";

        Map<String,Object> actual = jsonParser.jsonToMap(json1.toString());
        Assert.assertEquals(expected,actual.toString());
        actual = jsonParser.jsonToMap(null);
        Assert.assertNull(actual);

    }
    
    private class User {
       
    	private String name;
    	private String age;
    	private String sex;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + ", sex=" + sex + "]";
		}
    	
    }
    
    @Test
    public void testMapToJson(){
        JSONObject expected = new JSONObject();
        expected.put("k0",null);
        expected.put("k1","v1");
        expected.put("k2","v2");

        Map<String,Object> map = new HashMap<>();
        User user = new User();
        user.setAge("111");
        user.setSex("sss");
        user.setName("333");
        map.put("k0",null);
        map.put("k1",user);
        
        String actual = jsonParser.mapToJson(map);
        System.out.println(actual);
        System.out.println(actual);

//        Assert.assertEquals(expected.toString(),actual);

    }


    @Test
    public void testObjectToJson(){
        Object actual;
        actual = jsonParser.objectToJson(null);
        Assert.assertNull(actual);
        List<Object> list = new ArrayList<>();
        list.add(null);
        Map<String,Object> map = new HashMap<>();
        map.put("k1","v1");
        list.add(map);
        JSONObject json = new JSONObject();
        json.put("k2","v2");
        list.add(json.toString());

        actual = jsonParser.objectToJson(list);
//        System.out.println(actual.toString());
        Assert.assertEquals("[null,{\"k1\":\"v1\"},{\"k2\":\"v2\"}]",actual.toString());

//        Map<String,Object> map2 = new HashMap<>();
//        map2.put("k2","v2");


    }

}
