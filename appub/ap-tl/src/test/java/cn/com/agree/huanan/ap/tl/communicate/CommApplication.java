package cn.com.agree.huanan.ap.tl.communicate;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.agree.huanan.ap.tl.ApTlApplication;
import cn.com.agree.huanan.ap.tl.communicate.comm.manager.CommunicateAdapterManager;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.JsonUtil;

/**
 * @author luo.hp
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ApTlApplication.class)
//public class CommApplication {
//
//	@Autowired
//	private Logger logger;
//
//	@SuppressWarnings("unchecked")
//	private void showMap(Object obj, int level){
//		if (obj instanceof Map){
//			Map<String, Object> thisMap = (Map<String, Object>)obj;
//			for (Entry<String, Object> entry:thisMap.entrySet()){
//				Object val = entry.getKey();
//				if (obj instanceof Map) {
//					showMap(val, level+1);
//				}else{
////					logger.debug("%d, key:%s, value:%s", level, entry.getKey(), entry.getValue().toString());
//				}
//			}
//		}
//	}
//
//	@Test
//	public void JsontoMapTest(){
//		String jsonString = "{\"glossary\": {\"title\": \"example glossary\",\"GlossDiv\": {\"title\": \"S\",\"GlossList\": {\"GlossEntry\": {\"ID\": \"SGML\",\"SortAs\": \"SGML\",\"GlossTerm\": \"Standard Generalized Markup Language\",\"Acronym\": \"SGML\",\"Abbrev\": \"ISO 8879:1986\",\"GlossDef\": {\"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\": [\"GML\",\"XML\"]},\"GlossSee\": \"markup\"}}}}}";
//		Map<String, Object> map = JsonUtil.getUtil().jsonStringToMap(jsonString);
//		showMap(map, 1);
//	}
//
//	@Test
//	public void CommAdapterTest(){
//		String appId = "TEST";
//		String commItem = "HTTPTEST";
//		String msg = "{\"name\", {\"name1\":\"xiaoming\",\"name2\":\"daming\"}}";
////		CommunicateAdapter adapter=null;
//////        try {
//////            adapter = CommunicateAdapterManager.getCommAdapter(appId, commItem);
//////        } catch (ClassNotFoundException e) {
//////            // TODO 自动生成的 catch 块
//////            e.printStackTrace();
//////        }
////		adapter.comm(msg);
//	}
//
//	public static void main(String[] args) {
//	    new CommApplication().CommAdapterTest();
//	}
//
//}
