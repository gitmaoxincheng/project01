package cn.com.agree.huanan.ap.tl.message.std;

import cn.com.agree.huanan.ap.tl.message.base.BeanPath;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
/**
 * 报文解析接口管理器
 * 
 * @author luo.hp
 *
 */
public class MessageParserManager {
    
    /**
     * @param msgType 报文类型
     * @return MessageParser 报文解析器
     * @throws ClassNotFoundException 类名未找到
     */
    public static MessageParser getParser(String msgType) throws ClassNotFoundException {
        BeanPath cfg = (BeanPath) SpringUtil.getBean(BeanPath.class);
        return (MessageParser) SpringUtil.getBean(Class.forName(cfg.getParser().get(msgType.toUpperCase())));
    } 
}
