package cn.com.agree.huanan.ap.tl.communicate.comm.params;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import lombok.Getter;
import cn.com.agree.huanan.ap.tl.cache.ApCacheable;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.NoCommParamException;
import cn.com.agree.huanan.ap.tl.communicate.http.base.Const;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * @author luo.hp
 * @category Http通信参数实现
 */
@Getter
public class HttpCommParam extends CommParam{
    /**
     * 日志句柄
     */
    public Logger logger =  Logger.getLogger(HttpCommParam.class);
    
    // Url地址
    private String serverUrl;
    
    // 操作类型
    private String operator;
    
    // Http消息类型
    private String msgType;
    
    // HTTP版本
    private String httpVersion;
    
    // MC
    private String mc;
    
    // TC
    private String tc;
    
    // 备注
    private String remark;
    
    /**
     * @param paramMap 基本通信参数
     * @param additionMap 附属参数
     */
    protected void SetCommHttpParam(Map<String, Object> paramMap, Map<String, Object> additionMap) {
        // Operator
        String operator_t = Const.DEFAULT_HTTP_OPERATOR;
        String operator_k = "operator";
        if (paramMap.containsKey(operator_k)){
            operator_t = paramMap.get(operator_k).toString();
        }
        operator = additionMap.getOrDefault(operator_k, operator_t).toString();
        
        // Message Type
        String msgType_t = Const.DEFAULT_CONTENT_TYPE;
        String msgType_k = "msgType";
        if (paramMap.containsKey(msgType_k)){
            msgType_t = paramMap.get(msgType_k).toString();
        }
        msgType = additionMap.getOrDefault(msgType_k, msgType_t).toString();
        
        // Http version
        String httpVersion_t = Const.DEFAULT_HTTP_VERSION_TYPE;
        String httpVersion_k = "httpVersion";
        if (paramMap.containsKey(httpVersion_k)){
            httpVersion_t = paramMap.get(httpVersion_k).toString();
        }
        httpVersion = additionMap.getOrDefault(httpVersion_k, httpVersion_t).toString();
        
        // Server Url
        String serverUrl_t = "";
        String serverUrl_k = "serverUrl";
        if (paramMap.containsKey(serverUrl_k)){
            serverUrl_t = paramMap.get(serverUrl_k).toString();
        }
        
        // 待转换Map
        Map<String, String> convertMap = new HashMap<String, String>();
        if (this.getServerIp() != null && !this.getServerIp().isEmpty()){
            convertMap.put("IP", this.getServerIp());
        }
        if (this.getServerPort() != 0){
            convertMap.put("PORT", String.valueOf(this.getServerPort()));
        }
        // MC
        String mc_t = "";
        String mc_k = "mc";
        if (paramMap.containsKey(mc_k)){
            mc_t = paramMap.get(mc_k).toString();
        }
        mc = additionMap.getOrDefault(mc_k, mc_t).toString();
        convertMap.put(mc_k.toUpperCase(), mc);
        
        // TC
        String tc_t = "";
        String tc_k = "tc";
        if (paramMap.containsKey(tc_k)){
            tc_t = paramMap.get(tc_k).toString();
        }                
        tc =additionMap.getOrDefault(tc_k, tc_t).toString();
        convertMap.put(tc_k.toUpperCase(), tc);
        

        for (Entry<String, String> entry: convertMap.entrySet()){
//            logger.debug("serverUrl_t: %s, Key: %s, Value: %s", serverUrl_t, entry.getKey().toString(), entry.getValue().toString());
            int index = serverUrl_t.toUpperCase().indexOf("{"+entry.getKey().toString()+"}");
            if (index >=0){
                serverUrl_t = serverUrl_t.substring(0, index)+entry.getValue()+serverUrl_t.substring(index+entry.getKey().toString().length()+2);
            }
        }
        serverUrl = serverUrl_t;
        logger.debug("URL: "+serverUrl);
        // Remark
        String remark_t = "";
        String remark_k = "remark";
        if (paramMap.containsKey(remark_k)){
            remark = paramMap.get(remark_k).toString();
        }
        remark = remark_t;      
    }
    
    @Override
    public void SetCommParam(Map<String, Object> paramMap) {
        super.SetCommParam(paramMap);
        this.SetCommHttpParam(paramMap, Collections.emptyMap());
    }
    
    /**
     * 无参构造
     */
    public HttpCommParam() {
        super();
    }
    
    @Override
    public CommParam init(CommParam param){
        return this.init(param, Collections.emptyMap());
    }
    
    /**
     * @param param 基本通信参数
     * @param addtionMap 附属参数
     */
    @ApCacheable
    public CommParam init(CommParam param, Map<String, Object> addtionMap){
        super.init(param);
        // 待添加获取HTTP参数
        HttpParamDao httpParamDao = SpringUtil.getBean(HttpParamDao.class);
        Map<String, Object> paramsMap = httpParamDao.initParams(param.getAppId(),param.getCommItem(),param.getNodeName());
        if (paramsMap.isEmpty()){
            logger.error("未配置通信参数");
            throw NoCommParamException.getException();
        }
		logger.info("通讯参数："+paramsMap);
        SetCommHttpParam(paramsMap, addtionMap);
        return this;
    }
    
    // 打印
    public void showInfo(){
        super.showInfo();
        logger.debug("Server URL: %s", serverUrl);
        logger.debug("Operator: %s", operator);
        logger.debug("MsgType: %s", msgType);
        logger.debug("Http Version: %s", httpVersion);
        logger.debug("MC: %s", mc);
        logger.debug("TC: %s", tc);
        logger.debug("Remark: %s", remark);
    }
}
