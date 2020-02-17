package ap.ide.utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ap.ide.exception.InvalidInputParamException;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author luo.hp
 *
 */
public class JavaDictUtil {
    
    private static final Logger logger = Logger.getLogger(JavaDictUtil.class);
    
    /**
     * @param dict JavaDict字典
     * @param keyCls Key的类型
     * @param valueCls 值的类型
     * @return map字典
     */
    @SuppressWarnings("unchecked")
    public static <T1, T2> Map<T1, T2> dictToMap(JavaDict dict, Class<T1>keyCls, Class<T2>valueCls) {
        Map<T1, T2> map = new HashMap<T1, T2>();
        for (Entry<Object, Object> entry: dict.entrySet()){
            map.put((T1)entry.getKey(), (T2)entry.getValue());
        }
        return map;
    }
    
    /**
     * @param dict JavaDict字典
     * @return map字典
     */
    public static Map<String, Object> dictToMap(JavaDict dict) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Entry<Object, Object> entry: dict.entrySet()){
            Object obj = entry.getValue();
            if (obj instanceof JavaDict){
                map.put(entry.getKey().toString(), dictToMap((JavaDict)obj));
            }else{
                map.put(entry.getKey().toString(), entry.getValue());
            }
            
        }
        return map;
    }
    
    /**
     * @param map Map字典
     * @return dict JavaDict字典
     */
    public static JavaDict mapToDict(Map<?, ?> map) {
        JavaDict dict =  new JavaDict();
        if(map!=null)
        for (Entry<?, ?> entry: map.entrySet()){
            Object obj = entry.getValue();
            if (obj instanceof Map){
                dict.put(entry.getKey(), mapToDict((Map<?, ?>) entry.getValue()));
            }else{
                dict.put(entry.getKey(), entry.getValue());
            }
        }
        return dict;
    }
    
    /**
     * @param dict JavaDict字典 
     * @param key key值
     * @param value value值 
     */
    public static void put(JavaDict dict, Object key, Object value) {
        dict.put(key, value);
    }
    
    /**
     * @param dict JavaDict字典 
     * @param list JavaList列表 
     */
    public static void put(JavaDict dict, JavaList list) {
        for (int i=0; i<list.size();++i){
            Object obj = list.get(i);
            if (!(obj instanceof JavaList)){
                logger.error("入参JavaList必须为[[A1,B1],...,[An,Bn]]");
                throw new InvalidInputParamException();
            }
            
            JavaList listItem = list.getListItem(i);
            if (listItem.size() != 2){
                logger.error("入参JavaList必须为[[A1,B1],...,[An,Bn]]");
                throw new InvalidInputParamException();
            }
            dict.put(listItem.get(0), listItem.get(1));
        }
    }
    
    /**
     * @param destDict 目标字典
     * @param srcDict 源字典
     * @param argsList 过滤参数列表
     */
    public static void put(JavaDict destDict, JavaDict srcDict, JavaList argsList) {
        if (argsList == null){
            destDict.putAll(srcDict);
        }else{
            for(Entry<?, ?> entry: srcDict.entrySet()){
                if (argsList.contains(entry.getKey())){
                    destDict.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }
    
    /**
     * @param inContext  目标容器
     * @param paramList	   参数列表
     * @author dkk
     */
   public static void setValue(JavaDict inContext,JavaList paramList){

		if (paramList == null || inContext == null) {
			throw new InvalidInputParamException();
		}
		for (int i = 0; i < paramList.size(); i++) {
			Object param = paramList.getItem(i);
			if (!(param instanceof JavaList)) {
				if (paramList.size() < 2) {
					throw new InvalidInputParamException();
				}
				inContext.setItem(paramList.getItem(0), paramList.getItem(1));
				break;
			} else if (((JavaList) param).size() < 2) {
				throw new InvalidInputParamException();
			}
			JavaList param0 = (JavaList) param;
			inContext.setItem(param0.getItem(0), param0.getItem(1));
		}
   }
    
   /**
    * @param resultDict  目标容器
    * @param inDict	   参数列表
    * @author dkk
    */
  public static void DictPutAll(JavaDict resultDict,JavaDict inDict){
	  if(resultDict == null || inDict == null){
		  throw new InvalidInputParamException();
	  }
	  resultDict.putAll(inDict);
  }
  /**
   * @param argContext  数据字典容器
   * @param dataObjList	  数据对象
   * @author dkk
   */
  public static void CreatNewObject(JavaDict argContext,JavaList dataObjList){
		if (argContext == null) {
			throw new InvalidInputParamException();
		}
		if (dataObjList == null) {
			throw new InvalidInputParamException();
		}
		for (Object item : dataObjList) {
			if (!(item instanceof JavaList)) {
				throw new InvalidInputParamException();
			}
			JavaList listItem = (JavaList) item;
			if (listItem.size() != 2) {
				throw new InvalidInputParamException();
			}
			Object type = listItem.get(1);
			Object key = listItem.get(0);
			if (type instanceof JavaDict) {
				argContext.setItem(key, new JavaDict());
			} else if (type instanceof JavaList) {
				argContext.setItem(key, new JavaList());
			} else {
				throw new InvalidInputParamException();
			}
		}
	}
 
}
