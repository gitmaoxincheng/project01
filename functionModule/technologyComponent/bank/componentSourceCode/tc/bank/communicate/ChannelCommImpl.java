package tc.bank.communicate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import ap.ide.utils.JavaDictUtil;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.ChannelService;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.ChannelServiceImpl;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.IOService;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResult;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResultUtil;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommStatus;
import cn.com.agree.huanan.ap.tl.exception.ApException;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.FlowUtil;
import cn.com.agree.huanan.ap.tl.util.FlowUtil.StatusCtrl;
import tc.bank.communicate.util.ChannelServiceUtil;

/**
 * @author xqq hcp
 * 渠道通讯服务实现
 */
public class ChannelCommImpl {
	private static Logger logger = Logger.getLogger(ChannelCommImpl.class);
	private String errorCode;
	private String errorMessage;
	private String status;
	private Map<String, Object> result;
	private ChannelService channelService;
	private IOService ioService;
	/**
	 * 
	 */	
	public ChannelCommImpl() {
		// TODO 自动生成的构造函数存根
	}

	public ChannelCommImpl initService(String systemID, String mc, String tc) {
		this.ioService = ChannelServiceUtil.newIOInstance(systemID, mc, tc);
		this.channelService = new ChannelServiceImpl(ioService.getAppId(),ioService.getCommItem(),ioService.getMessageType(),ioService.getRequestEncoding(),ioService.getResponseEncoding());
		return this;
	}	

	public ChannelCommImpl initTradeContenxt(JavaDict messageMap){
		return this;
	}

//	public void cancelCheck(){
//		ioService.setCheck(false);
//	}
	
	/*
	 	通讯，拆包流程
	    1、经过I化，初始化容器
	    2、通信请求（拼包-通信-拆包）
	    3、经过O化，整理返回内容
	 */
	
	public JavaDict exchange(JavaDict messageMap){
		Map<String, Object> requestContext = JavaDictUtil.dictToMap(messageMap,String.class, Object.class);
		requestContext = ioService.initInContent(requestContext);  // IO化请求报文内容
		this.channelService.setRequestMsgMap(requestContext); //请求容器
		this.channelService.exchange();		  // 拼装请求报文并通讯
		Map<String, Object> responseContext = channelService.getResponse(); //返回内容
		errorCode = ioService.getErrorCode(responseContext); //获取错误码
		errorMessage = ioService.getErrorMessage(responseContext);//获取错误信息
		String status = ioService.isTradeSuccess(responseContext);//获取状态
		logger.info("ErrorCode: %s,ErrorMsg:%s,Status:%s",errorCode,errorMessage,status);
		if(!CommConstant.SUCCSTATUS.equals(status)) {
			logger.error("返回交易失败，不校验必返字段");		
			responseContext = ioService.initOutContent(requestContext,responseContext,false);
		}else {
			responseContext = ioService.initOutContent(requestContext,responseContext);//IO化返回报文内容
		}
		this.status = status.toString();
		result = responseContext;
		return JavaDictUtil.mapToDict(result);
	}

	public CompletableFuture<Supplier<CommResult<JavaDict>>> exchangeAsync(JavaDict messageMap) {

		return FlowUtil.main(ctrl -> {
			return exchangeAsync0(ctrl, messageMap);
		})
				.whenFailed((ex) -> {
					ApException apEx = ExceptionUtil.convert(ex);
					CommResult<JavaDict> commRet = CommResult.getFailed(apEx.getErrorCode(), apEx.getErrorMsg(), new JavaDict());
					return CommResultUtil.wrapByFuture(commRet);
				})
				.whenAbend((ex) -> {
					ApException apEx = ExceptionUtil.convert(ex);
					CommResult<JavaDict> commRet = CommResult.getAbend(apEx.getErrorCode(), apEx.getErrorMsg(), new JavaDict());
					return CommResultUtil.wrapByFuture(commRet);
				})
				.run();
	}

	private CompletableFuture<Supplier<CommResult<JavaDict>>> exchangeAsync0(StatusCtrl ctrl, JavaDict messageMap) {
		logger.debug("运行：ChannelCommImpl.exchangeAsync0");

		// 请求处理
		final Map<String, Object> requestContext = ioService.initInContent(JavaDictUtil.dictToMap(messageMap,String.class, Object.class));  // IO化请求报文内容

		this.channelService.setRequestMsgMap(requestContext); //请求容器
		// 标记异常
		ctrl.setAbend();

		// 发起异步通讯
		CompletableFuture<Supplier<CommResult<Map<String,Object>>>> commFuture = this.channelService.exchangeAsync();

		// 适配
		CompletableFuture<Supplier<CommResult<JavaDict>>> retFuture = new CompletableFuture<>();
		commFuture.whenComplete((commRetSupplier, futureEx) -> {
			// 异常
			if (futureEx != null) {
				retFuture.completeExceptionally(futureEx);
			}

			// 正常
			retFuture.complete(() -> {
				// 获取结果
				CommResult<Map<String,Object>> commRet = commRetSupplier.get();
				CommStatus commStatus = commRet.getCommStatus();
				// 成功
				if (commStatus == CommStatus.SUCCESS) {

					// 结果处理
					Map<String, Object> responseContext = channelService.getResponse(); //返回内容
					errorCode = ioService.getErrorCode(responseContext); //获取错误码
					errorMessage = ioService.getErrorMessage(responseContext);//获取错误信息
					String status = ioService.isTradeSuccess(responseContext);//获取状态
					logger.info("ErrorCode: %s,ErrorMsg:%s,Status:%s",errorCode,errorMessage,status);
					if(!CommConstant.SUCCSTATUS.equals(status)) {
						logger.error("返回交易失败，不校验必返字段");		
						responseContext = ioService.initOutContent(requestContext,responseContext,false);
					}else {
						responseContext = ioService.initOutContent(requestContext,responseContext);//IO化返回报文内容
					}
					this.status = status.toString();
					result = responseContext;
					JavaDict retDict = JavaDictUtil.mapToDict(result);
					return CommResult.getSuccess(retDict);
				}
				// 失败
				else if (commStatus == CommStatus.FAILED) {
					return CommResult.getFailed(commRet.getErrorCode(), commRet.getErrorMsg(), new JavaDict());
				}
				// 异常
				else {
					return CommResult.getAbend(commRet.getErrorCode(), commRet.getErrorMsg(), new JavaDict());
				}
			});
		});

		return retFuture;
	}

	public String getRequest(){
		return this.channelService.getRequest();
	}

	public JavaDict getResponse(){
		return JavaDictUtil.mapToDict(this.channelService.getResponse());
	}

	public JavaDict getResponseBodyDict(){
		return JavaDictUtil.mapToDict((Map<String, Object>) result.get("APPBody"));
	}

	public String getTradeStatus(){
		return status;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
}
