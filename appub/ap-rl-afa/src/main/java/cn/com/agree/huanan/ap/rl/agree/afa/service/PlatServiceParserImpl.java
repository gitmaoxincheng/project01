package cn.com.agree.huanan.ap.rl.agree.afa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.impl.ServiceParserImpl;

/**
 * @author luo.hp
 *
 */
@Component
public class PlatServiceParserImpl extends ServiceParserImpl {

    /**
     * logger
     */
    public final static Logger logger = Logger.getLogger(PlatServiceParserImpl.class);


    private Object innerUnpack(Object objMsg) {
        Object result = null;
        if (objMsg == null){
            result = null;
        }
        else if (objMsg instanceof Map){
            Map<String, Object> map = new HashMap<String, Object>();
            for (Entry<?, ?> entry: ((Map<?, ?>)objMsg).entrySet()){
                map.put(entry.getKey().toString(), innerUnpack(entry.getValue()));
            }
            result = map;
        }else if (objMsg instanceof List){
            List<Object> list= new ArrayList<Object>();
            for (Iterator<?> iter= ((List<?>)objMsg).iterator(); iter.hasNext();){
                list.add(innerUnpack(iter.next()));
            }
            result = list;
        }else{
            result = objMsg.toString();
        }
        return result;
    }
    
    @Override
    public Map<String, Object> unpack(Object msgObject, String encoding) {
        // TODO 自动生成的方法存根
        Map <String, Object> serviceMap = new HashMap<String, Object>();
        
        // 非MAP参数
//        List<Object> nonMapParamList = new ArrayList<Object>();
//        serviceMap.put("__NonMapParams__", nonMapParamList);
        if (msgObject instanceof List){
            for (Iterator<?> iter= ((List<?>)msgObject).iterator(); iter.hasNext();){
                Object objMsg = iter.next();
                if (objMsg instanceof Map){
                    for (Entry<?, ?> entry: ((Map<?, ?>)objMsg).entrySet()){
                        serviceMap.put(entry.getKey().toString(), innerUnpack(entry.getValue()));
                    }
                }else{
                    logger.debug("Service报文List内容的非Map参数[%s]", objMsg == null ? "null" : objMsg.toString());
//                    nonMapParamList.add(objMsg);
                }
            }
        }else {
            logger.error("Service报文非List对象");
            throw new PlatServiceException();
        }
        return serviceMap;
    }

    @Override
    public Object pack(Map<String, Object> msgMap, String encoding) {
        // TODO 自动生成的方法存根
        return msgMap;
    }
}