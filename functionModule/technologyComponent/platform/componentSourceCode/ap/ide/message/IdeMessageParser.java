package ap.ide.message;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ap.ide.utils.JavaDictUtil;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.conf.DefaultMsgTypeConfig;
import cn.com.agree.huanan.ap.tl.message.std.MessageParser;
import cn.com.agree.huanan.ap.tl.message.std.MessageParserManager;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * @author luo.hp
 *
 */
public class IdeMessageParser {
    /**
     * 日志句柄
     */
    public static final Logger logger = Logger.getLogger(IdeMessageParser.class);

    // 平台内部SVC服务报文
    public static final String PLATFORM_SDK_MESSAGE_TYPE = "SERVICE";
    
    // 平台内部SVC服务报文
    public static final String PLATFORM_INNER_MESSAGE_TYPE = "SVC";
    // 平台报文类型关键字
    public static final String PLATFORM_MESSAGE_TYPE_KEY = "__PT__";
    // 自定义报文类型关键字
    public static final String MESSAGE_TYPE_KEY = "__MESSAGE_TYPE__";
    // 平台接收报文关键字
    public static final String PLATFORM_RECV_KEY = "__RCVPCK__";
    // 平台发送报文关键字
    public static final String PLATFORM_SEND_KEY = "__SNDPCK__";
    // 解析报文类型Key
    public static final String PARSER_MSGTYPE_KEY = "__PARSER_MSGTYPE_";
    
    // HTTP报文处理
    // 平台HTTP接收报文编码关键字
    public static final String PLATFORM_HTTP_RECV_ENCODING_KEY = "HTTP_REQUEST_CONTENT_CHARSET";
    // 平台HTTP发送报文编码关键字
    public static final String PLATFORM_HTTP_SEND_ENCODING_KEY = "HTTP_RESPONSE_CONTENT_CHARSET";
    // 平台HTTP版本
    public static final String PLATFORM_HTTP_VERSION_KEY = "HTTP_VERSION";
    // HTTP报文类型标识
    public static final String DEFAULT_HTTP_MESSAGE_TYPE = "HTTP";
  
    /**
     * 关于__PT__字段对报文的处理逻辑
     *           通信消息类型           报文类型
     * 1、SVC：                   SVC       配置化(无配置默认为SVC)
     * 2、HTTP：                HTTP      __PT__
     * 3、其他：               __PT__     __PT__
     */
    
    /**
     * @param msgCtx __REQ__字段容器
     * @param bDebug 是否Debug容器信息
     * @throws ClassNotFoundException 类不存在
     */
    public static void unpack(JavaDict msgCtx, boolean bDebug) throws ClassNotFoundException{
       
        // 默认配置
        DefaultMsgTypeConfig cfg = SpringUtil.getBean(DefaultMsgTypeConfig.class);
        
        // 默认为Service
        String msgType = msgCtx.getStringItem(PLATFORM_MESSAGE_TYPE_KEY, null);
        if (msgType == null || "".equals(msgType.trim())){
            msgType = (cfg.getDefaultMessageType() == null ? PLATFORM_INNER_MESSAGE_TYPE : cfg.getDefaultMessageType()) ;
        }
        msgType=msgType.toUpperCase();
                
//        // 消息类型删除
//        msgCtx.put(DEFAULT_MESSAGE_TYPE_KEY, msgType);
        msgCtx.removeItem(PLATFORM_MESSAGE_TYPE_KEY);
        
        // 解析报文类型
        String parserMsgType = msgType;

        // SVC类型
        if (msgType.equals(PLATFORM_INNER_MESSAGE_TYPE)) {
            parserMsgType = (cfg.getSvcParserMsgType() == null ? PLATFORM_INNER_MESSAGE_TYPE : cfg.getSvcParserMsgType());
        }
        // Http类型
        if (msgCtx.containsKey(PLATFORM_HTTP_VERSION_KEY) && !PLATFORM_INNER_MESSAGE_TYPE.equals(msgType)) {
            parserMsgType = msgType;
            msgType = DEFAULT_HTTP_MESSAGE_TYPE;
        }
        // 消息类型
        msgCtx.put(MESSAGE_TYPE_KEY, msgType);
        msgCtx.put(PARSER_MSGTYPE_KEY, parserMsgType);
        
        logger.info("msgType [%s]", msgType);
        logger.info("parser msgType [%s]", parserMsgType);
        
        // 接收的消息
        Object recvMsg = msgCtx.get(PLATFORM_RECV_KEY);
        String encoding = msgCtx.getStringItem(PLATFORM_HTTP_RECV_ENCODING_KEY, Const.DEFAULT_ENCODING);
        if (recvMsg != null){
            // 报文解析
            MessageParser parser = MessageParserManager.getParser(parserMsgType);
            Map<String, Object> recvMap = parser.unpack(recvMsg, encoding);
            msgCtx.putAll(JavaDictUtil.mapToDict(recvMap)); //XXX 可优化
            // 清除当前环境的接受变量信息
            msgCtx.remove(PLATFORM_RECV_KEY);
        }
        if (bDebug){
            contentPrint(msgCtx, "Unpack msgCtx");
        }
    }
    
    /**
     * 平台拆包，保留 __RCVPCK__ 字段
     * @param msgCtx __REQ__字段容器
     * @param bDebug 是否Debug容器信息
     * @throws ClassNotFoundException 类不存在
     */
    public static void unpack2(JavaDict msgCtx, boolean bDebug) throws ClassNotFoundException{
        // 默认配置
        DefaultMsgTypeConfig cfg = SpringUtil.getBean(DefaultMsgTypeConfig.class);
        // 默认为Service
        String msgType = msgCtx.getStringItem(PLATFORM_MESSAGE_TYPE_KEY, null);
        if (msgType == null || "".equals(msgType.trim())){
            msgType = (cfg.getDefaultMessageType() == null ? PLATFORM_INNER_MESSAGE_TYPE : cfg.getDefaultMessageType()) ;
        }
        msgType=msgType.toUpperCase();
        // 消息类型删除
        msgCtx.removeItem(PLATFORM_MESSAGE_TYPE_KEY);
        // 解析报文类型
        String parserMsgType = msgType;
        // SVC类型
        if (msgType.equals(PLATFORM_INNER_MESSAGE_TYPE)) {
            parserMsgType = (cfg.getSvcParserMsgType() == null ? PLATFORM_INNER_MESSAGE_TYPE : cfg.getSvcParserMsgType());
        }
        // Http类型
        if (msgCtx.containsKey(PLATFORM_HTTP_VERSION_KEY) && !PLATFORM_INNER_MESSAGE_TYPE.equals(msgType)) {
            parserMsgType = msgType;
            msgType = DEFAULT_HTTP_MESSAGE_TYPE;
        }
        // 消息类型
        msgCtx.put(MESSAGE_TYPE_KEY, msgType);
        msgCtx.put(PARSER_MSGTYPE_KEY, parserMsgType);
        logger.info("msgType [%s]", msgType);
        logger.info("parser msgType [%s]", parserMsgType);
        // 接收的消息
        Object recvMsg = msgCtx.get(PLATFORM_RECV_KEY);
        String encoding = msgCtx.getStringItem(PLATFORM_HTTP_RECV_ENCODING_KEY, Const.DEFAULT_ENCODING);
        if (recvMsg != null){
            // 报文解析
            MessageParser parser = MessageParserManager.getParser(parserMsgType);
            Map<String, Object> recvMap = parser.unpack(recvMsg, encoding);
            msgCtx.putAll(JavaDictUtil.mapToDict(recvMap));
            // 清除当前环境的接受变量信息
        }
        if (bDebug){
            contentPrint(msgCtx, "Unpack msgCtx");
        }
    }
    
    
    
    
    /**
     * @param msgCtx __RSP__字段容器
     * @param origCtx __REQ__字段容器
     * @param bDebug 是否Debug容器信息
     * @return 拼包对象
     * @throws ClassNotFoundException 类不存在
     */
    public static Object pack(JavaDict msgCtx, JavaDict origCtx, boolean bDebug) throws ClassNotFoundException{
        if (bDebug){
            contentPrint(origCtx, "Pack origCtx");
            contentPrint(msgCtx, "Pack msgCtx");
        }
        String msgType = origCtx.getStringItem(MESSAGE_TYPE_KEY, PLATFORM_INNER_MESSAGE_TYPE);
        String parserMsgType = origCtx.getStringItem(PARSER_MSGTYPE_KEY, PLATFORM_INNER_MESSAGE_TYPE);
        String encoding = origCtx.getStringItem(PLATFORM_HTTP_SEND_ENCODING_KEY, Const.DEFAULT_ENCODING);

        Object packObj = null;
        if (PLATFORM_SDK_MESSAGE_TYPE.equals(parserMsgType)) {
        	JavaDict temp =new JavaDict();
        	temp.putAll(msgCtx);
        	packObj = temp;
		}else {
            // 报文拼包
            MessageParser parser = MessageParserManager.getParser(parserMsgType);
            packObj = parser.pack(JavaDictUtil.dictToMap(msgCtx), encoding);

            // 需求区分HTTP报文，暂时没办法区分使用该标识区分
            if (!msgType.equals(parserMsgType))
            {
                parser = MessageParserManager.getParser(msgType);
                Map<String, Object> contentMap = new HashMap<String, Object>();
                if (msgCtx.get(cn.com.agree.huanan.ap.tl.communicate.http.base.Const.HEADER_KEY)!=null) {
                  contentMap.put(cn.com.agree.huanan.ap.tl.communicate.http.base.Const.HEADER_KEY, msgCtx.get(cn.com.agree.huanan.ap.tl.communicate.http.base.Const.HEADER_KEY));
				}
                // Http
                if (msgType.equals(DEFAULT_HTTP_MESSAGE_TYPE)) {
                    contentMap.put(cn.com.agree.huanan.ap.tl.communicate.http.base.Const.CONTENT_KEY, packObj);
                    packObj = parser.pack(contentMap, encoding);
                }
            }else {
            	if (!packObj.getClass().isArray()) {
            		packObj = packObj.toString().getBytes(); //XXX 临时，应该对应HttpPaserImpl一样，有个SocketParseImpl，根本上 像拼接长度，和拼接http报文体的内容应该被抽离出来。	
				}
				
			}
		}
        return packObj;
    }
    
    /**
     * @param obj 打印对象
     */
    public static void contentPrint(Object obj){
        contentPrint(obj, 0, null);
    }
    
    /**
     * @param obj 打印对象
     * @param headerInfo 头信息
     */
    public static void contentPrint(Object obj, String headerInfo){
        contentPrint(obj, 0, headerInfo);
    }
    /**
     * @param obj 打印对象
     * @param spaceNum 值前到缩进空格数
     * @param headerInfo 头信息 
     */
    public static void contentPrint(Object obj, int spaceNum, String headerInfo){
        
        if (headerInfo != null) {
            logger.debug("Base Info: %s", headerInfo);
        }
        String space = "";
        if (spaceNum > 0){
            space = String.format("%"+String.valueOf(spaceNum*8)+"s"," ");
        }
        
        if (obj instanceof Map){
            Map<?, ?> objMap = (Map<?, ?>)obj;
            for (Entry<?, ?> entry: objMap.entrySet()){
                Object value = entry.getValue();
                if ((value instanceof Map) || (value instanceof List)){
                    logger.debug("%sKey: [%-24s] Value: (NEXT)", space, entry.getKey().toString());
                    contentPrint(value, spaceNum+1, null);
                }
                else if(value == null){
                    logger.debug("%sKey: [%-24s] Value: [%s]", space, entry.getKey().toString(), "null");
                }
                else {
                    logger.debug("%sKey: [%-24s] Value: [%s]", space, entry.getKey().toString(), entry.getValue().toString());
                }
            }
        }
        else if (obj instanceof List){
            List<?> objList = (List<?>)obj;
            Iterator<?> iter = objList.listIterator();
            while(iter.hasNext()){
                Object value = iter.next();
                if ((value instanceof Map) || (value instanceof List)){
                    contentPrint(value, spaceNum+1, null);
                }
                else if (value == null){
                    logger.debug("%sValue: [%s]", space, "null");
                } else {
                    logger.debug("%sValue: [%s]", space, value.toString());
                }
            }
        }
        else if (obj == null){
            logger.debug("%sValue: [null]", space);
        }
        else{
            logger.debug("%sValue: [%s]", space, obj.toString());
        }
    }
}
