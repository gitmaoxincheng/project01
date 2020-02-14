package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;
import cn.com.agree.huanan.ap.tl.message.base.BeanPath;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * @author xqq,hcp
 * 渠道服务基类
 */
public  class ChannelServiceImpl extends ChannelService {

	public ChannelServiceImpl(String appId, String commItem, String messageType, String requestEncoding, String responseEncoding) {
		String nodeName=SpringUtil.getBean(BeanPath.class).getNodeName(); //节点信息由配置文件application.yml 提供
		this.nodeName = nodeName != null ? nodeName:Const.DEFAULT_NODE_NAME;
		this.appId = appId;
		this.commItem = commItem;
		this.messageType = messageType;
		this.requestEncoding = requestEncoding;
		this.responseEncoding = responseEncoding;
		buildParser();
	}


	@Override
	public ChannelService buildSendMessage() {
		sendMessage = (String) messageParser.pack(requestMsgMap,requestEncoding); //XXX 暂时先固定为String 待优化
		return this;
	}

	/**
	 * 根据传入字符串响应报文,使用配置的O表解析后返回报文结构
	 */
	@Override
	public ChannelService parseReceiveMessage() {
		responseMsgMap = messageParser.unpack(receiveMessage, this.responseEncoding);
		logger.debug("响应容器:" + responseMsgMap);
		return this;
	}


}



	
