package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service;

import java.util.ArrayList;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.communicate.content.build.StringMsgBuilder;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import lombok.Getter;
import lombok.Setter;

/**
 * @author HCP
 * IO服务基类
 */
public abstract class IOService extends BaseService {
    protected static Logger logger = Logger.getLogger(IOService.class);
    @Setter
    @Getter
    public String appId;
    /**
     * 对应配置表 t_comm_param\t_comm_param_ext COMMITEM
     */
    @Setter
    @Getter
    public String commItem;
    /**
     * 设定报文类型,对应配置文件/ap-tl/src/main/resources/application.yml 用来指定解码器
     */
    @Setter
    @Getter
    protected String messageType; //XXX 考虑将 messageType ,requestEncoding,responseEncoding配置到配置文件或数据库去
    /**
     * 指定请求报文编码
     */
    @Setter
    @Getter
    protected String requestEncoding;
    /**
     * 指定响应编码
     */
    @Setter
    @Getter
    protected String responseEncoding;
//    @Setter
    protected boolean isCheck = true; //添加这个的意义在于，在返回报文为出错状态，导致部分字段不存在时，也能做字段映射，但不校验
    @Getter @Setter  //允许自定义 builder
    protected StringMsgBuilder builder = new StringMsgBuilder();
    public ArrayList<MsgFormat> requestFormat = new ArrayList<>();
    public ArrayList<MsgFormat> responseFormat = new ArrayList<>();


    public IOService() {

    }
    /**
     * @param tradeContext 请求上下文容器
     * @return I表处理后的容器，IO表用于请求其它系统时，即真正的请求内容
     */
    public Map<String, Object> initInContent(Map<String, Object> tradeContext) {
        return initInContent(tradeContext,isCheck);
    }
    
    public Map<String, Object> initInContent(Map<String, Object> tradeContext,boolean isCheck) {
        Map<String, Object> messageContext = buildInMessageContext(tradeContext);
        messageContext = this.builder.init(messageContext, this.requestFormat, isCheck);
        logger.debug("I后报文容器:" + messageContext);
        return messageContext;
    }
    public Map<String, Object> initOutContent(Map<String, Object> sendContext, Map<String, Object> recvContext,boolean isCheck) {
        Map<String, Object> messageContext = buildOutMessageContext(recvContext);
        messageContext = this.builder.init(messageContext, this.responseFormat, isCheck);
        logger.debug("O后报文容器:" + messageContext);
        return messageContext;
    }
    /**
     * @param sendContext 请求报文容器
     * @param recvContext 返回报文容器
     * @return O表处理后的容器
     */
    public Map<String, Object> initOutContent(Map<String, Object> sendContext, Map<String, Object> recvContext) {
        return initOutContent(sendContext,recvContext,isCheck);
    }

    /**
     * 初始化报文取值容器
     *
     * @param tradeContext 交易上下文容器
     * @return ChannelService
     */
    public Map<String, Object> buildInMessageContext(Map<String, Object> tradeContext) {        //XXX 这里可以抽离实现？
        logger.debug("I表:%s", this.getClass().getName());
        return tradeContext;
    }

    /**
     * 组装请求报文,报文字段校验在此触发
     *
     * @return ChannelService
     */
    public Map<String, Object> buildOutMessageContext(Map<String, Object> tradeContext) {
        logger.debug("O表:%s", this.getClass().getName());
        return tradeContext;
    }

    /**
     * 获取响应报文中的错误码
     *
     * @return String
     */
    public abstract String getErrorCode(Map<String, Object> tradeContext);

    /**
     * 获取响应报文中的错误信息
     *
     * @return String
     */
    public abstract String getErrorMessage(Map<String, Object> tradeContext);

    /**
     * 根据渠道业务规则,判断交易是否成功
     *
     * @return TradeStatus
     */
    public abstract String isTradeSuccess(Map<String, Object> tradeContext);


    /**
     * 获取响应报文的body节点容器 塞入Body节点
     *
     * @return Map<String, Object>
     */
    public Map<String, Object> getResponseBody(Map<String, Object> tradeContext) {
        return null;
    }

    ;


}
