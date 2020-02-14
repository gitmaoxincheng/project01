/**
 * 
 */
package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.context.AdapterContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResult;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommStatus;
import cn.com.agree.huanan.ap.tl.communicate.comm.manager.CommunicateAdapterManager;
import cn.com.agree.huanan.ap.tl.exception.tech.ApSystemException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApUnsupportedEncodingException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.std.MessageParser;
import cn.com.agree.huanan.ap.tl.message.std.MessageParserManager;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xqq
 * 渠道服务基类
 */
public abstract class  ChannelService  implements Exchange<String, Map<String, Object>> {
	protected static Logger logger = Logger.getLogger(ChannelService.class);

	/**
	 * 对应配置表t_comm_param\t_comm_param_ext NODENAME
	 */
	@Setter
	protected String nodeName;
	/**
	 * 对应配置表 t_comm_param\t_comm_param_ext APPID
	 */
	@Setter
	protected String appId;
	/**
	 *  对应配置表 t_comm_param\t_comm_param_ext COMMITEM
	 */
	@Setter
	protected String commItem;

	@Setter
	protected String messageType;
	/**
	 * 指定请求报文编码
	 */
	@Setter
	protected String requestEncoding;
	/**
	 * 指定响应编码
	 */
	@Setter
	protected String responseEncoding;

	protected MessageParser messageParser;

	/**
	 * 指定响应编码
	 */
	@Getter
	protected String sendMessage;
	@Getter
	protected Object receiveMessage;
	@Getter @Setter
	protected Map<String, Object> requestMsgMap;
	@Getter @Setter
	protected Map<String, Object> responseMsgMap;


	public ChannelService() {

	}

	/**
	 * 创建报文解析器
	 * @return ChannelService
	 */
	protected ChannelService buildParser(){
		try {
			this.messageParser = MessageParserManager.getParser(this.messageType.toUpperCase());
		} catch (ClassNotFoundException e) {
			logger.exception(e);
			throw new ApSystemException(e);
		}
		return this;
	}


	public abstract ChannelService buildSendMessage();

	/**
	 * 根据传入字符串响应报文,使用配置的O表解析后返回报文结构
	 */
	public abstract ChannelService parseReceiveMessage();

	@Override
	public void exchange() {
		buildSendMessage();
		logger.debug("发送报文:" + this.sendMessage);
		byte [] responseMessage =  CommunicateAdapterManager.getCommAdapter(appId, commItem).comm(this.sendMessage)
				.getMessage().getBytesMsg();
		receiveMessage = responseMessage;


		try {
			logger.debug("返回报文:" + new String(responseMessage,responseEncoding));
		} catch (UnsupportedEncodingException e) {
			throw new ApUnsupportedEncodingException(e);
		}
		parseReceiveMessage();
	}

	@Override
	public CompletableFuture<Supplier<CommResult<Map<String, Object>>>> exchangeAsync() {
		// 拼报文
		buildSendMessage();
		logger.debug("发送报文:" + this.sendMessage);
		// 异步通讯
		AdapterContext adapter = CommunicateAdapterManager.getCommAdapter(appId, commItem);
		CompletableFuture<Supplier<CommResult<byte[]>>> commFuture = adapter.commAsync(this.sendMessage);
		// 适配
		CompletableFuture<Supplier<CommResult<Map<String, Object>>>> retFuture = new CompletableFuture<>();
		commFuture.whenComplete((commCtxSupplier, ex) -> {
			// 正常
			if (ex == null) {
				// 通知
				retFuture.complete(() -> parseResponse(commCtxSupplier.get()));
			}
			// 异常
			else {
				retFuture.completeExceptionally(ex);
			}
		});
		return retFuture;
	}

	private CommResult<Map<String, Object>> parseResponse(CommResult<byte[]> commCtx) {
		// 通讯成功
		if (commCtx.getCommStatus() == CommStatus.SUCCESS) {
			// 获取返回报文
			byte[] responseMessage = commCtx.getResponse().getBody();
			try {
				logger.debug("返回报文:" + new String(responseMessage,responseEncoding));
			} catch (UnsupportedEncodingException e) {
				throw new ApUnsupportedEncodingException(e);
			}
			receiveMessage = responseMessage;

			// 解析返回报文
			parseReceiveMessage();

			// 返回成功
			return CommResult.getSuccess(Collections.emptyMap());
		}
		// 通讯失败
		else if (commCtx.getCommStatus() == CommStatus.FAILED) {
			return CommResult.getFailed(commCtx.getErrorCode(), commCtx.getErrorMsg(), Collections.emptyMap());
		}
		// 通讯异常
		else {
			return CommResult.getAbend(commCtx.getErrorCode(), commCtx.getErrorMsg(), Collections.emptyMap());
		}
	}

	@Override
	public String getRequest() {
		return this.sendMessage;
	}


	@Override
	public Map<String, Object> getResponse() {
		return this.responseMsgMap;
	}



}
