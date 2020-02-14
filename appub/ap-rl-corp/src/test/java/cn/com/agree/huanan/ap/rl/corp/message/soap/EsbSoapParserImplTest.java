package cn.com.agree.huanan.ap.rl.corp.message.soap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

//import cn.com.agree.huanan.ap.rl.bank.gnxcomm.io.Demo_I;
import cn.com.agree.huanan.ap.tl.communicate.content.build.StringMsgBuilder;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat;

public class EsbSoapParserImplTest {
//	
//	public String testInitValueMapByFormat(){
//		StringMsgBuilder builder = new StringMsgBuilder();
//		HashMap<String, Object> sysContentMap = new HashMap<>();
//		HashMap<String, Object> appContentMap = new HashMap<>();
//		HashMap<String, Object> localContentMap = new HashMap<>();
//		
//		ArrayList<Map> retList = new ArrayList<>();
//		HashMap<String, String> retMap = new HashMap<String, String>();
//		retMap.put("RetCd", "0000");
//		retMap.put("RetMsg", "测试返回");
//		retList.add(retMap);
//		
//		sysContentMap.put("SvcCd", "12334455");
//		sysContentMap.put("SvcScn", "44");
//		sysContentMap.put("RET", retList);
//		sysContentMap.put("TxnDt", "20181214");
//		
//		appContentMap.put("SvcCd", "11111111111");
//		appContentMap.put("SvcScn", "11");
//		appContentMap.put("RET", retList);
//		appContentMap.put("TxnDt", "20181214");
//		
//		localContentMap.put("SvcCd", "5555555555");
//		localContentMap.put("SvcScn", "55");
//		localContentMap.put("RET", retList);
//		localContentMap.put("TxnDt", "20181214");
//		
//		
//		HashMap<String, Object> msgContentMap = new HashMap<>();
//		HashMap<String, Object> bodyContentMap = new HashMap<>();
//		bodyContentMap.put("Name", "张三");
//		ArrayList<HashMap<String, String>> phoneList = new ArrayList<>();
//		for(int i=0;i<3;i++){
//			HashMap<String, String> phone = new HashMap<String, String>();
//			phone.put("Phone", "123456789000"+i);
//			phoneList.add(phone);
//		}
//		bodyContentMap.put("PhoneList", phoneList);
//		
//		HashMap<String, Object> comInfo = new HashMap<String, Object>();
//		comInfo.put("CName", "李四");
//		
//		ArrayList<Map> telList = new ArrayList<>();
//		
//		for(int i=0;i<5;i++){
//		HashMap<String, String> telMap = new HashMap<String, String>();
//		telMap.put("Tel", "0000000000000"+i);
//		telList.add(telMap);
//		}
//		comInfo.put("CPhoneList", telList);
//		ArrayList<Map> comMap = new ArrayList<>();
//		comMap.add(comInfo);
//		bodyContentMap.put("ComList", comMap);
//		HashMap<String, String> detailMap = new HashMap<String, String>();
//		detailMap.put("Tall", "170");
//		bodyContentMap.put("Details", detailMap);
//		msgContentMap.put("SYS_HEAD", sysContentMap);
//		msgContentMap.put("APP_HEAD", appContentMap);
//		msgContentMap.put("LOCAL_HEAD", localContentMap);
//		msgContentMap.put("BODY", bodyContentMap);
//		LinkedHashMap<String , Object> msgMap = builder.init(msgContentMap, new MsgFormat []{new Demo_I()});
//		EsbSoapParserImpl analyserImpl = new EsbSoapParserImpl();
//		return  analyserImpl.maptosoap(msgMap, "UTF-8");
//	}
//	
//	@Test
//	public  void textSoapToMap(){
//	    String xml = testInitValueMapByFormat();
//	    System.out.println("返回报文:" + xml);
//	    EsbSoapParserImpl analyserImpl = new EsbSoapParserImpl();
//	    Map<String , Object> map =  analyserImpl.soaptomap(xml, "UTF-8");
//	    System.out.println("解析后的结构:" + map);
//	}
//	
////	public static void main(String[] args) {
//////		testInitValueMapByFormat();
////	    textSoapToMap();
////	}
}
