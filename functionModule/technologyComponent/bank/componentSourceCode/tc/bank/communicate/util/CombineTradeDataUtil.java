/**
 * 
 */
package tc.bank.communicate.util;

import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author xqq
 * 组合交易数据处理工具类
 */
public class CombineTradeDataUtil {
	public static final Logger logger = Logger.getLogger(CombineTradeDataUtil.class);

	/**
	 * 处理组合服务请求数据
	 * @param newTradeDataDict 新请求数据容器
	 * @param originTradeDataDict 原请求数据容器
	 * @param clearBody 清空原报文体容器
	 * @return 处理后的容器
	 */
	public static JavaDict dealCombineTradeData(JavaDict newTradeDataDict, JavaDict REQ, boolean clearBody){
		JavaDict afterDealTradeDict = new JavaDict();
	   JavaDict originHeader = REQ.getDictItem("Head", new JavaDict());
	   JavaDict originBusiHeader = REQ.getDictItem("Body", new JavaDict()).getDictItem("BusiField", new JavaDict());
	   JavaDict originBody = REQ.getDictItem("Body", new JavaDict());
	   JavaDict originReduceBody = new JavaDict();
	   originReduceBody.putAll(originBody);
	   originReduceBody.remove("BusiField");
	   JavaDict originTailDict = REQ.getDictItem("Tail", new JavaDict());
	   
	   
	   JavaDict newHeader = newTradeDataDict.getDictItem("Head");
	   JavaDict newBusiHeader = newTradeDataDict.getDictItem("BusiField");
	   JavaDict newBody = newTradeDataDict.getDictItem("Body");
	   JavaDict newTail = newTradeDataDict.getDictItem("Tail");
	   
		JavaList oldDataDictList = new JavaList(originHeader, originBusiHeader, originReduceBody, originTailDict);
		JavaList newDataDictList = new JavaList(newHeader, newBusiHeader, newBody, newTail);
		JavaList eachDictKeyList = new JavaList("Head", "BusiField", "Body", "Tail");
		
		JavaDict tempDict = new JavaDict();
		for(int i = 0, j = oldDataDictList.size(); i < j; i++){
			JavaDict eachOldDict = oldDataDictList.getDictItem(i);
			JavaDict eachNewDict = newDataDictList.getDictItem(i);
			String eachDictName = eachDictKeyList.getStringItem(i);
			if(eachNewDict != null){
				if("Body".equals(eachDictName)){
					//报文体单独处理
					if(clearBody){
						JavaDict eachNewDictCopy = new JavaDict();
						eachNewDictCopy.putAll(eachNewDict);
						tempDict.put(eachDictName, eachNewDictCopy);
					}else{
						eachOldDict.putAll(eachNewDict);
						tempDict.put(eachDictName, eachOldDict);
					}
				}else{
					//报文头字段直接覆盖
					eachOldDict.putAll(eachNewDict);
					tempDict.put(eachDictName, eachOldDict);
				}
			}else{
				//压入旧容器不作处理
				tempDict.put(eachDictName, eachOldDict);
			}
		}
		
		JavaDict bodyDict = new JavaDict();
		bodyDict.put("BusiField", tempDict.getDictItem("BusiField"));
		bodyDict.putAll(tempDict.getDictItem("Body"));
		//压入新的交易数据
		REQ.put("Head", tempDict.get("Head"));
		REQ.put("Body", bodyDict);
		REQ.put("Tail", tempDict.getDictItem("Tail"));
		logger.debug("处理后的请求容器 ----------->" + REQ);
	   afterDealTradeDict.put("originHeader", originHeader);
	   afterDealTradeDict.put("originBusiHeader", originBusiHeader);
	   afterDealTradeDict.put("originBody", originReduceBody);
	   afterDealTradeDict.put("originTailDict", originTailDict);
		return afterDealTradeDict;
	}
}
