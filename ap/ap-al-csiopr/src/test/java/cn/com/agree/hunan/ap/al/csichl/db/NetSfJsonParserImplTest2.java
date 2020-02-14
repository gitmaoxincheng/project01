package cn.com.agree.hunan.ap.al.csichl.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.corp.message.json.NetSfJsonParserImpl;
import javassist.expr.NewArray;
import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author HCP
 */
public class NetSfJsonParserImplTest2 {


//    private NetSfJsonParserImpl jsonParser = new NetSfJsonParserImpl();

    
    public class User implements Serializable {
       
    	private String name;
    	private String age;
    	private String sex;
    	private Child child;
		public Child getChild() {
			return child;
		}
		public void setChild(Child child) {
			this.child = child;
		}
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
			return "User [name=" + name + ", age=" + age + ", sex=" + sex + ", child=" + child + "]";
		}
    	
    }
    
    
    public class Child implements Serializable {
       
    	private String name;
    	private String age;
    	private GrandChild grandChild;
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
		public GrandChild getGrandChild() {
			return grandChild;
		}
		public void setGrandChild(GrandChild grandChild) {
			this.grandChild = grandChild;
		}
		@Override
		public String toString() {
			return "Child [name=" + name + ", age=" + age + ", grandChild=" + grandChild + "]";
		}
		
    }

    public class GrandChild implements Serializable {
        
    	private String name;
    	private String age;
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
		@Override
		public String toString() {
			return "GrandChild [name=" + name + ", age=" + age + "]";
		}
    }
    
    @Test
    public void testObjectToJson2(){
    	Child child = new Child();
    	child.setAge("11111111");
    	child.setName("韦文");
    	
    	GrandChild grandChild = new GrandChild();
    	grandChild.setAge("222222");
    	grandChild.setName("孙子");
    	
    	child.setGrandChild(grandChild);
    	
        User user = new User();
        user.setAge("111");
        user.setSex("sss");
        user.setName("333");
        user.setChild(child);
        
        JavaDict javaDict = new JavaDict();
        javaDict.put("aaa", "sss");
        javaDict.put("bbb", 111);
        javaDict.put("ccc", Arrays.asList("222","222"));
        javaDict.put("ddd", Arrays.asList(user,user,child));
        Map map2 = new HashMap<>();
        map2.put("rr", "dddd");
        map2.put("tt", grandChild);
        javaDict.put("eee", map2);
        
        JSONObject jsonObject = JSONObject.fromObject(javaDict);
        System.out.println(jsonObject.toString());
 /*       String testStr  = "{\"k1\":\"v1\"}";
        JSONObject jsonObject2 = JSONObject.fromObject(testStr);
        System.out.println(jsonObject2.toString());

        Object intValue  = 1;
        JSONObject jsonObjec3 = JSONObject.fromObject(intValue);
        System.out.println(jsonObjec3.toString());
        
        Map<String,Object> map = new HashMap<>();
        map.put("k0",null);
        map.put("k1",user);
        map.put("k2", 1);
        map.put("k3", "333");
        JSONObject jsonObjec4 = JSONObject.fromObject(map);
        System.out.println(jsonObjec4.toString());
        
        List<Map> list = new ArrayList();
        list.add(map);
        list.add(map);
        list.add(map);
        JSONArray jsonObjec5 = JSONArray.fromObject(list);
        System.out.println(jsonObjec5.toString());  
        
        List<Object> list2 = new ArrayList();
        list2.add(map);
        list2.add(map);
        list2.add("sssssss");
        JSONArray jsonObjec6 = JSONArray.fromObject(list2);
        System.out.println(jsonObjec6.toString());*/  
        
        
//        String actual = jsonParser.mapToJson(map);
//        System.out.println(actual);
//        System.out.println(actual);

//        Assert.assertEquals(expected.toString(),actual);

    }

    
    @Test
    public void testObjectToJson3(){
    	Child child = new Child();
    	child.setAge("11111111");
    	child.setName("韦文");
    	
    	GrandChild grandChild = new GrandChild();
    	grandChild.setAge("222222");
    	grandChild.setName("孙子");
    	
    	child.setGrandChild(grandChild);
    	
        User user = new User();
        user.setAge("111");
        user.setSex("sss");
        user.setName("333");
        user.setChild(child);
        
        JavaDict javaDict = new JavaDict();
        javaDict.put("aaa", "sss");
        javaDict.put("bbb", 111);
        javaDict.put("ccc", Arrays.asList("222","222"));
        javaDict.put("ddd", Arrays.asList(user,user,child));
        Map map2 = new HashMap<>();
        map2.put("rr", "dddd");
        map2.put("tt", grandChild);
        javaDict.put("eee", map2);
        
        User user2 = new User();
        user2.setAge("111");
        user2.setSex("sss");
        user2.setName("333");
        Child child2 = new Child();
        user2.setChild(child2);
        
        User user3 = new User();
        user3.setAge("111");
        user3.setSex("sss");
        user3.setName("333");
        
        List<Object> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        list.add(user3);
        list.add(new Child());
        list.add(child2);
        String jsonObject = com.alibaba.fastjson.JSONObject.toJSONString(list);
        System.out.println(jsonObject.toString());
        
    }
        
    
    
/*    
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
        System.out.println(actual.toString());
        Assert.assertEquals("[null,{\"k1\":\"v1\"},{\"k2\":\"v2\"}]",actual.toString());

//        Map<String,Object> map2 = new HashMap<>();
//        map2.put("k2","v2");

    }
*/
}
