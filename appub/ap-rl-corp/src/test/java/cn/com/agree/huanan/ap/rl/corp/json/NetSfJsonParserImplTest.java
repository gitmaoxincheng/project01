package cn.com.agree.huanan.ap.rl.corp.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import cn.com.agree.huanan.ap.rl.corp.message.json.NetSfJsonParserImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUN
 */
public class NetSfJsonParserImplTest {


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

    @Test
    public void testMapToJson(){
        JSONObject expected = new JSONObject();
        expected.put("k0",null);
        expected.put("k1","v1");
        expected.put("k2","v2");

        Map<String,Object> map = new HashMap<>();
        map.put("k0",null);
        map.put("k1","v1");
        map.put("k2","v2");

        String actual = jsonParser.mapToJson(map);
        Assert.assertEquals(expected.toString(),actual);

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
