package tc.bank.base.service;

import static cn.com.agree.afa.jcomponent.GlobalErrorHolder.setGlobalError;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import cn.com.agree.afa.jcomponent.SdkBroker;
import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.afa.util.future.IFuture;
import cn.com.agree.afa.util.future.IFutureListener;
import cn.com.agree.huanan.ap.rl.agree.afa.concurrent.AbstractIFutureAdapter;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.service.exception.ServiceInvokeFailException;
import cn.com.agree.huanan.ap.rl.bank.service.exception.ServiceInvokeTimeOutlException;
import cn.com.agree.huanan.ap.rl.bank.service.po.ServiceRelation;
import cn.com.agree.huanan.ap.rl.bank.service.service.ServiceInvokerService;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResponse;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResult;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResultUtil;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommStatus;
import cn.com.agree.huanan.ap.tl.exception.ApException;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApEumnNotExistException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import cn.com.agree.huanan.ap.tl.util.FileUtil;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 服务调用
 * 
 * @date 2019-06-28 21:7:4
 */
@ComponentGroup(level = "银行", groupName = "测试组件")
public class B_ServiceInvoker2 {

	public static final Logger logger = Logger.getLogger(B_ServiceInvoker.class);
	public static ServiceInvokerService serviceInvoker = SpringUtil.getBean(ServiceInvokerService.class);
	private static final int FAILURE = 0;
	private static final int SUCCESS = 1;
	private static final int EXCEPTION = 2; //或者说UNKNOWN
	//	private static final int PARTSUCCS = 3;
	//	private static final int HANDLE = 4;


	public static <T, R> IFuture getIFuture3(IFuture future,String src, String target,Class<T> rspType, Function<T, JavaDict> action) {
		// 创建适配器
		return new AbstractIFutureAdapter() {
			@Override
			public synchronized Object get() throws InterruptedException, ExecutionException {
				boolean isFailed = false;
				try {
					// 获取结果
					Object rspObj = future.get();
					// 出现异常
					//					if (futureEx != null) {
					// 判断是否失败
					Integer statusProp = (Integer) future.getProperty(IFuture.STATUS);
					logger.error("afa future error: %s", statusProp);
					if (statusProp != null && statusProp.intValue() == IFuture.SEND_REQUEST_FAIL) {
						isFailed = true;
					}
					//						throw futureEx;
					//					}
					if (!rspType.isInstance(rspObj)) {
						logger.error("返回类型非法：[%s], %s", rspObj.getClass(), rspObj);
						throw new ApValueTypeUnsupportException(rspObj);
					}
					// 处理结果：T -> byte[]
					JavaDict msgDict = action.apply((T) rspObj);
					// 返回
					// 通讯成功，处理业务结果
					JavaDict csisHeader = msgDict.getDictItem(CommConstant.CSIS_HEADER, new JavaDict());
					// 根据响应状态选择分支
					String respSts = csisHeader.getStringItem(CommConstant.STATUS, CommConstant.UNKNOWSTATUS);
					String errorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE, CommConstant.UNKNOWCODE); // XXX
					String errorMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG, CommConstant.UNKNOWMSG);
					int retStatus = 2;
					switch (respSts) {
					case CommConstant.FAILSTATUS:
						setGlobalError("F", errorCode, errorMsg);// 全部失败
						retStatus = 0;
						break;
					case CommConstant.SUCCSTATUS:
						// setGlobalError("S", errorCode, errorMsg);// 全部成功
						retStatus = 1;
						break;
					case CommConstant.UNKNOWSTATUS:
						setGlobalError("U", errorCode, errorMsg);// 異常，状态未知
						retStatus = 2;
					default:
						setGlobalError("U", errorCode, errorMsg);// 異常，状态未知
						break;
					}
					return new TCResult(retStatus, Arrays.asList(msgDict)); // 返回状态

				} catch (Throwable ex) {
					logger.exception(ex);
					ApException apEx = null;
					if (ex instanceof TimeoutException) { // 调用超时
						apEx = new ServiceInvokeTimeOutlException(src, target);
					} else {
						apEx = new ServiceInvokeFailException(src, target);// 服务调用异常
					}
					// 返回
					return isFailed ? new TCResult(FAILURE): new TCResult(EXCEPTION);
				}
			}

			@Override
			public IFuture addListener(IFutureListener listener) {
				// 适配
				// 保存结果
				// 通知
				try {
					listener.operationCompleted(this);
				} catch (Exception exLocal) {
					throw new RuntimeException(exLocal);
				}
				return this;
			}
		};
	}	



	/**
	 * @category 服务同步调用3
	 * @param serviceFlag
	 *            入参|服务场景标识|{@link java.lang.String}
	 * @param params
	 *            入参|请求入参|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param attachment
	 *            入参|扩展参数|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since result 出参|返回结果|{@link Object}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 *         2 异常<br>
	 */
	@InParams(param = { @Param(name = "serviceFlag", comment = "服务场景标识", type = java.lang.String.class),
			@Param(name = "params", comment = "请求入参", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "attachment", comment = "扩展参数", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "result", comment = "返回结果", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"),
			@Return(id = "2", desp = "异常") })
	@galaxy.ide.tech.cpt.Component(label = "服务同步调用3", style = "选择型", type = "异步组件", comment = "服务同步调用", date = "2019-12-12 07:57:43")
	public static TCResult B_syncSvcInvoke3(String serviceFlag, JavaDict params, JavaDict attachment) {
		int tcStatus = FAILURE;
		try {
			JavaDict __REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
			String MC = __REQ__.getStringItem("__MC__");
			String TC = __REQ__.getStringItem("__TC__");
			String identifier = null;
			String serviceVersion = "1.0.0";
			String scenarioVersion = "1.0.0";
			long timeoutInMill = CommConstant.DefTimeOut;
			String svcCode = null;
			String scnCode = null;
			String svcGroup = null;
			ServiceRelation serviceRelation = serviceInvoker.queryServiceRelation(serviceFlag, MC, TC); // 查询调用关系
			if (serviceRelation == null) {
				__REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
				MC = __REQ__.getStringItem("__MC__");
				TC = __REQ__.getStringItem("__TC__");
				identifier = MC + "_SDK_OUT";
				// long timeoutInMill = CommConstant.DefTimeOut;
				String[] code = serviceFlag.split("\\.");
				svcCode = code[0];
				scnCode = code[1];
				// attachment = null;
			} else {
				identifier = serviceRelation.getIdentifier(); // serviceRelation.get
				timeoutInMill = serviceRelation.getTimeOut();
				svcCode = serviceRelation.getSvcCode();
				scnCode = serviceRelation.getScnCode();
				svcGroup = serviceRelation.getSvcGroup();
			}
			logger.info("Svc:%s,Scn:%s,Identifier:%s,Group:%s,TimeOut:%s", svcCode, scnCode, identifier, svcGroup,
					timeoutInMill);
			params.put(CommConstant.CSIS_HEADER, params.getDictItem(CommConstant.CSIS_HEADER, new JavaDict()));
			params.put(CommConstant.HEADER, params.getDictItem(CommConstant.HEADER, new JavaDict()));
			params.put(CommConstant.APP_HEADER, params.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
			params.put(CommConstant.APP_BODY, params.getDictItem(CommConstant.APP_BODY, new JavaDict()));
			JavaList reqList = new JavaList();
			logger.debug("12");
			reqList.add(params);
			tcStatus = EXCEPTION; // 通讯前设为异常
			logger.debug("Mark12");
			FileUtil.writeData2File("Mark12\n", "/export/123.txt", true, "UTF-8");
			FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
			TCResult tcRet = SdkBroker.syncInvokeV2(identifier, svcCode, serviceVersion, scnCode, scenarioVersion,
					reqList, timeoutInMill, attachment);// 服务调用，涉及平台内容，本组件使用异步通讯
			logger.info("TcResult：%s, %s, %s", tcRet.getStatus(), tcRet.getErrorCode(), tcRet.getErrorMsg());
			// 处理异步结果
			logger.debug("Mark13");
			FileUtil.writeData2File("Mark13\n", "/export/123.txt", true, "UTF-8");
			FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

			// 提取future
			IFuture ifuture1 = (IFuture) tcRet.getOutputParams().get(0);
			// 转换
			IFuture ifuture = getIFuture3(ifuture1, MC + "." + TC,
					svcCode + "." + scnCode, JavaDict.class, (rspDict) -> {
						logger.info(rspDict.toString());
						JavaDict csisHeader = rspDict.getDictItem(CommConstant.CSIS_HEADER);
						JavaDict header = rspDict.getDictItem(CommConstant.HEADER);
						JavaDict body = rspDict.getDictItem(CommConstant.APP_BODY);
						JavaDict apppHeader = rspDict.getDictItem(CommConstant.APP_HEADER);
						logger.debug("csisHeader:%s", csisHeader);
						logger.debug("header:%s", header);
						logger.debug("appHeader:%s", apppHeader);
						logger.debug("body:%s", body);
						logger.debug("Mark10");
						FileUtil.writeData2File("Mark10\n", "/export/123.txt", true, "UTF-8");
						FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
						return rspDict;
					});
			// 返回成功
			return TCResult.newSuccessResult(ifuture);
		} catch (Exception ex) {
			logger.exception("服务调用失败", ex);
			ApException apException = ExceptionUtil.convert(new ServiceInvokeFailException(serviceFlag));
			setGlobalError(tcStatus, apException.getErrorCode(), apException.getErrorMsg());// 失败，要仔细的检查TechComp还有用么
			return new TCResult(tcStatus);
			// return new Object[] { tcStatus, ex};
		}
	}


	public static TCResult B_syncSvcInvoke3_bak(String serviceFlag, JavaDict params, JavaDict attachment) {
		int tcStatus = FAILURE;
		try {
			JavaDict __REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
			String MC = __REQ__.getStringItem("__MC__");
			String TC = __REQ__.getStringItem("__TC__");
			String identifier = null;
			String serviceVersion = "1.0.0";
			String scenarioVersion = "1.0.0";
			long timeoutInMill = CommConstant.DefTimeOut;
			String svcCode = null;
			String scnCode = null;
			String svcGroup = null;
			ServiceRelation serviceRelation = serviceInvoker.queryServiceRelation(serviceFlag, MC, TC); // 查询调用关系
			if (serviceRelation == null) {
				__REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
				MC = __REQ__.getStringItem("__MC__");
				TC = __REQ__.getStringItem("__TC__");
				identifier = MC + "_SDK_OUT";
				// long timeoutInMill = CommConstant.DefTimeOut;
				String[] code = serviceFlag.split("\\.");
				svcCode = code[0];
				scnCode = code[1];
				// attachment = null;
			} else {
				identifier = serviceRelation.getIdentifier(); // serviceRelation.get
				timeoutInMill = serviceRelation.getTimeOut();
				svcCode = serviceRelation.getSvcCode();
				scnCode = serviceRelation.getScnCode();
				svcGroup = serviceRelation.getSvcGroup();
			}
			logger.info("Svc:%s,Scn:%s,Identifier:%s,Group:%s,TimeOut:%s", svcCode, scnCode, identifier, svcGroup,
					timeoutInMill);
			params.put(CommConstant.CSIS_HEADER, params.getDictItem(CommConstant.CSIS_HEADER, new JavaDict()));
			params.put(CommConstant.HEADER, params.getDictItem(CommConstant.HEADER, new JavaDict()));
			params.put(CommConstant.APP_HEADER, params.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
			params.put(CommConstant.APP_BODY, params.getDictItem(CommConstant.APP_BODY, new JavaDict()));
			JavaList reqList = new JavaList();
			logger.debug("12");
			reqList.add(params);
			tcStatus = EXCEPTION; // 通讯前设为异常
			logger.debug("Mark12");
			FileUtil.writeData2File("Mark12\n", "/export/123.txt", true, "UTF-8");
			FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
			TCResult tcRet = SdkBroker.syncInvokeV2(identifier, svcCode, serviceVersion, scnCode, scenarioVersion,
					reqList, timeoutInMill, attachment);// 服务调用，涉及平台内容，本组件使用异步通讯
			logger.info("TcResult：%s, %s, %s", tcRet.getStatus(), tcRet.getErrorCode(), tcRet.getErrorMsg());
			// 处理异步结果
			logger.debug("Mark13");
			FileUtil.writeData2File("Mark13\n", "/export/123.txt", true, "UTF-8");
			FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

			CompletableFuture<Supplier<CommResult<JavaDict>>> future1 = getCompletableFuture2(MC + "." + TC,
					svcCode + "." + scnCode, tcRet, JavaDict.class, (rspDict) -> {
						logger.info(rspDict.toString());
						JavaDict csisHeader = rspDict.getDictItem(CommConstant.CSIS_HEADER);
						JavaDict header = rspDict.getDictItem(CommConstant.HEADER);
						JavaDict body = rspDict.getDictItem(CommConstant.APP_BODY);
						JavaDict apppHeader = rspDict.getDictItem(CommConstant.APP_HEADER);
						logger.debug("csisHeader:%s", csisHeader);
						logger.debug("header:%s", header);
						logger.debug("appHeader:%s", apppHeader);
						logger.debug("body:%s", body);
						logger.debug("Mark10");
						FileUtil.writeData2File("Mark10\n", "/export/123.txt", true, "UTF-8");
						FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

						return rspDict;
					});

			// 转换
			IFuture ifuture = getIFuture(future1, (commRet, ex) -> {
				// 异常
				if (ex != null) {
					logger.exception("服务调用过程发生错误：", ex);
					// 返回
					return getCommTCResult(EXCEPTION, ex);
				}
				logger.debug("Mark11");
				FileUtil.writeData2File("Mark11\n", "/export/123.txt", true, "UTF-8");
				FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

				// 状态判断
				CommStatus commStatus = commRet.getCommStatus();
				// 成功
				if (commStatus == CommStatus.SUCCESS) {
					// 通讯成功，处理业务结果
					JavaDict msgDict = commRet.getResponse().getBody();
					JavaDict csisHeader = msgDict.getDictItem(CommConstant.CSIS_HEADER, new JavaDict());
					// 根据响应状态选择分支
					String respSts = csisHeader.getStringItem(CommConstant.STATUS, CommConstant.UNKNOWSTATUS);
					String errorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE, CommConstant.UNKNOWCODE); // XXX
					String errorMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG, CommConstant.UNKNOWMSG);
					int retStatus = 2;
					switch (respSts) {
					case CommConstant.FAILSTATUS:
						setGlobalError("F", errorCode, errorMsg);// 全部失败
						retStatus = 0;
						break;
					case CommConstant.SUCCSTATUS:
						// setGlobalError("S", errorCode, errorMsg);// 全部成功
						retStatus = 1;
						break;
					case CommConstant.UNKNOWSTATUS:
						setGlobalError("U", errorCode, errorMsg);// 異常，状态未知
						retStatus = 2;
					default:
						setGlobalError("U", errorCode, errorMsg);// 異常，状态未知
						break;
					}
					return new TCResult(retStatus, Arrays.asList(msgDict)); // 返回状态
					/* return getCommTCResult(tcStatus, errorCode, errorCode, status); */
				} else if (commStatus == CommStatus.FAILED) {
					return new TCResult(FAILURE);
					// return getCommTCResult(FAILURE, commRet.getErrorCode(),
					// commRet.getErrorMsg());
				}
				// 异常
				else {
					// return new Object[] { EXCEPTION}; //返回状态
					return new TCResult(EXCEPTION);
					// return getCommTCResult(EXCEPTION, commRet.getErrorCode(),
					// commRet.getErrorMsg());
				}
			});
			// 返回成功
			return TCResult.newSuccessResult(ifuture);
		} catch (Exception ex) {
			logger.exception("服务调用失败", ex);
			ApException apException = ExceptionUtil.convert(new ServiceInvokeFailException(serviceFlag));
			setGlobalError(tcStatus, apException.getErrorCode(), apException.getErrorMsg());// 失败，要仔细的检查TechComp还有用么
			return new TCResult(tcStatus);
			// return new Object[] { tcStatus, ex};
		}
	}


	/**
	 * @category 服务同步调用4
	 * @param serviceFlag
	 *            入参|服务场景标识|{@link java.lang.String}
	 * @param params
	 *            入参|请求入参|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param attachment
	 *            入参|扩展参数|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since result 出参|返回结果|{@link Object}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 * 		2 异常<br>
	 */
	@InParams(param = { @Param(name = "serviceFlag", comment = "服务场景标识", type = java.lang.String.class),
			@Param(name = "params", comment = "请求入参", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "attachment", comment = "扩展参数", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "result", comment = "返回结果", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"),
			@Return(id = "2", desp = "异常") })
	@galaxy.ide.tech.cpt.Component(label = "服务同步调用4", style = "选择型", type = "异步组件", comment = "服务同步调用", date = "2019-12-17 04:33:20")
	public static TCResult B_syncSvcInvoke4(String serviceFlag, JavaDict params, JavaDict attachment) {
		int tcStatus = FAILURE;
		try {
			JavaDict __REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
			String MC = __REQ__.getStringItem("__MC__");
			String TC = __REQ__.getStringItem("__TC__");
			String identifier = null;
			String serviceVersion = "1.0.0";
			String scenarioVersion = "1.0.0";
			long timeoutInMill = CommConstant.DefTimeOut;
			String svcCode = null;
			String scnCode = null;
			String svcGroup = null;
			if (null == attachment) {
				attachment = new JavaDict();
				attachment.put("physicalGroup", "BaseAtm");	
			}

			ServiceRelation serviceRelation = serviceInvoker.queryServiceRelation(serviceFlag, MC, TC); // 查询调用关系
			if (serviceRelation == null) {
				__REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
				MC = __REQ__.getStringItem("__MC__");
				TC = __REQ__.getStringItem("__TC__");
				identifier = MC + "_SDK_OUT";
				// long timeoutInMill = CommConstant.DefTimeOut;
				String[] code = serviceFlag.split("\\.");
				svcCode = code[0];
				scnCode = code[1];
				// attachment = null;
			} else {
				identifier = serviceRelation.getIdentifier(); // serviceRelation.get
				timeoutInMill = serviceRelation.getTimeOut();
				svcCode = serviceRelation.getSvcCode();
				scnCode = serviceRelation.getScnCode();
				svcGroup = serviceRelation.getSvcGroup();
			}
			logger.info("Svc:%s,Scn:%s,Identifier:%s,Group:%s,TimeOut:%s", svcCode, scnCode, identifier, svcGroup,
					timeoutInMill);
			params.put(CommConstant.CSIS_HEADER, params.getDictItem(CommConstant.CSIS_HEADER, new JavaDict()));
			params.put(CommConstant.HEADER, params.getDictItem(CommConstant.HEADER, new JavaDict()));
			params.put(CommConstant.APP_HEADER, params.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
			params.put(CommConstant.APP_BODY, params.getDictItem(CommConstant.APP_BODY, new JavaDict()));
			JavaList reqList = new JavaList();
			logger.debug(params.toString());
			//			reqList.set(0, params);
			reqList.add(params);
			tcStatus = EXCEPTION; // 通讯前设为异常
			TCResult tcRet = SdkBroker.syncInvokeV2(identifier, svcCode, serviceVersion, scnCode, scenarioVersion,
					reqList, timeoutInMill, attachment);// 服务调用，涉及平台内容，本组件使用异步通讯
			logger.info("TcResult：%s, %s, %s", tcRet.getStatus(), tcRet.getErrorCode(), tcRet.getErrorMsg());
			// 处理异步结果

			CompletableFuture<Supplier<CommResult<JavaDict>>> future1 = getCompletableFuture2(MC + "." + TC,
					svcCode + "." + scnCode, tcRet, JavaDict.class, (rspDict) -> {
						logger.info(rspDict.toString());
						JavaDict csisHeader = rspDict.getDictItem(CommConstant.CSIS_HEADER);
						JavaDict header = rspDict.getDictItem(CommConstant.HEADER);
						JavaDict body = rspDict.getDictItem(CommConstant.APP_BODY);
						JavaDict apppHeader = rspDict.getDictItem(CommConstant.APP_HEADER);
						logger.debug("csisHeader:%s", csisHeader);
						logger.debug("header:%s", header);
						logger.debug("appHeader:%s", apppHeader);
						logger.debug("body:%s", body);
						return rspDict;
					});

			// 转换
			IFuture ifuture = getIFuture(future1, (commRet, ex) -> {
				// 异常
				if (ex != null) {
					logger.exception("服务调用过程发生错误：", ex);
					// 返回
					return getCommTCResult(EXCEPTION, ex);
				}
				// 状态判断
				CommStatus commStatus = commRet.getCommStatus();
				// 成功
				if (commStatus == CommStatus.SUCCESS) {
					// 通讯成功，处理业务结果
					JavaDict msgDict = commRet.getResponse().getBody();
					JavaDict csisHeader = msgDict.getDictItem(CommConstant.CSIS_HEADER, new JavaDict());
					// 根据响应状态选择分支
					String respSts = csisHeader.getStringItem(CommConstant.STATUS, CommConstant.UNKNOWSTATUS);
					String errorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE, CommConstant.UNKNOWCODE); // XXX
					String errorMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG, CommConstant.UNKNOWMSG);
					int retStatus = 2;
					switch (respSts) {
					case CommConstant.FAILSTATUS:
						setGlobalError("F", errorCode, errorMsg);// 全部失败
						retStatus = 0;
						break;
					case CommConstant.SUCCSTATUS:
						// setGlobalError("S", errorCode, errorMsg);// 全部成功
						retStatus = 1;
						break;
					case CommConstant.UNKNOWSTATUS:
						setGlobalError("U", errorCode, errorMsg);// 異常，状态未知
						retStatus = 2;
					default:
						setGlobalError("U", errorCode, errorMsg);// 異常，状态未知
						break;
					}
					return new TCResult(retStatus, Arrays.asList(msgDict)); // 返回状态
					/* return getCommTCResult(tcStatus, errorCode, errorCode, status); */
				} else if (commStatus == CommStatus.FAILED) {
					return new TCResult(FAILURE);
					// return getCommTCResult(FAILURE, commRet.getErrorCode(),
					// commRet.getErrorMsg());
				}
				// 异常
				else {
					// return new Object[] { EXCEPTION}; //返回状态
					return new TCResult(EXCEPTION);
					// return getCommTCResult(EXCEPTION, commRet.getErrorCode(),
					// commRet.getErrorMsg());
				}
			});
			// 返回成功
			return TCResult.newSuccessResult(ifuture);
		} catch (Exception ex) {
			logger.exception("服务调用失败", ex);
			ApException apException = ExceptionUtil.convert(new ServiceInvokeFailException(serviceFlag));
			setGlobalError(tcStatus, apException.getErrorCode(), apException.getErrorMsg());// 失败，要仔细的检查TechComp还有用么
			return new TCResult(tcStatus);
			// return new Object[] { tcStatus, ex};
		}
	}	

	/**
	 * {@code CompletableFuture<T>} -> {@code IFuture}
	 * 
	 * @param future
	 *            CompletableFuture
	 * @return IFuture
	 */
	public static <T, R> IFuture getIFuture(CompletableFuture<? extends Supplier<T>> future,
			BiFunction<T, ? super Throwable, R> whenGet) {
		// 创建适配器
		return new AbstractIFutureAdapter() {
			//
			private volatile Supplier<T> supplier;
			private volatile Throwable throwable;
			private volatile Optional<R> result = null;

			@Override
			public synchronized Object get() throws InterruptedException, ExecutionException {
				logger.debug("Mark15");
				FileUtil.writeData2File("Mark15\n", "/export/123.txt", true, "UTF-8");
				FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
				// 首次获取
				if (result == null) {
					// 获取future结果
					T futureRet = supplier.get();
					logger.debug("Mark16");
					FileUtil.writeData2File("Mark16\n", "/export/123.txt", true, "UTF-8");
					FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
					// 调用处理方法
					R getRet = whenGet.apply(futureRet, throwable);
					logger.debug("Mark17");
					FileUtil.writeData2File("Mark17\n", "/export/123.txt", true, "UTF-8");
					FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
					// 正常（包装）
					result = Optional.ofNullable(getRet);
				}
				// 获取结果
				return result.get();
			}

			@Override
			public IFuture addListener(IFutureListener listener) {
				FileUtil.writeData2File("Mark14\n", "/export/123.txt", true, "UTF-8");
				FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
				// 适配
				future.whenComplete((sup, ex) -> {
					// 保存结果
					supplier = sup;
					throwable = ex;

					// 通知
					try {
						//						logger.debug("Mark8");
						FileUtil.writeData2File("Mark8\n", "/export/123.txt", true, "UTF-8");
						FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
						listener.operationCompleted(this);
						//						logger.debug("Mark9");
						FileUtil.writeData2File("Mark9\n", "/export/123.txt", true, "UTF-8");
						FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

					} catch (Exception exLocal) {
						throw new RuntimeException(exLocal);
					}
				});

				return this;
			}
		};
	}	





	/**
	 * {@code IFuture} -> {@code CompletableFuture<T>}
	 * 
	 * @param ifuture
	 *            IFuture
	 * @return CompletableFuture
	 */
	@SuppressWarnings("unchecked")
	public static <T> CompletableFuture<Supplier<T>> getCompletableFuture(IFuture ifuture) {
		// 创建
		CompletableFuture<Supplier<T>> future = new CompletableFuture<>();
		logger.debug("Mark6");
		FileUtil.writeData2File("Mark6\n", "/export/123.txt", true, "UTF-8");
		FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

		// 添加监听器
		ifuture.addListener((localIFuture) -> {
			// 不成功
			if (!localIFuture.isSuccess()) {
				// 异常结束
				future.completeExceptionally(localIFuture.cause());
				return;
			}
			// 正常结束
			future.complete(() -> {
				logger.debug("Mark7");
				FileUtil.writeData2File("Mark7\n", "/export/123.txt", true, "UTF-8");
				FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
				return (T) localIFuture.getNow();
			});
		});

		// 返回
		return future;
	}	



	public static <T> CompletableFuture<Supplier<T>> wrapByFuture2(T t) {
		CompletableFuture<Supplier<T>> future = new CompletableFuture<>();
		future.complete(() -> t);
		return future;
	}

	public static CompletableFuture<Supplier<CommResult<JavaDict>>> getCompletableFuture2(String src, String target,
			TCResult tcRet, Class<JavaDict> rspType, Function<JavaDict, JavaDict> action) {
		// 异常
		if (tcRet.getStatus() != 1) {
			return CommResultUtil.wrapByFuture(
					CommResultUtil.getAbendResult(tcRet.getErrorCode(), tcRet.getErrorMsg(), new JavaDict()));
		}
		logger.debug("Mark1");
		FileUtil.writeData2File("Mark1\n", "/export/123.txt", true, "UTF-8");
		FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

		// 提取future
		IFuture ifuture = (IFuture) tcRet.getOutputParams().get(0);
		// 创建
		CompletableFuture<Supplier<CommResult<JavaDict>>> future = new CompletableFuture<>();
		logger.debug("Mark2");
		FileUtil.writeData2File("Mark2\n", "/export/123.txt", true, "UTF-8");
		FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

		// 添加监听器
		ifuture.addListener((localIFuture) -> {
			// 不成功
			if (!localIFuture.isSuccess()) {
				// 异常结束
				// 出现异常
				// 判断是否失败
				/*
				 * Integer statusProp = (Integer) ifuture.getProperty(IFuture.STATUS); //
				 * logger.error("afa future error: %s, %s", statusProp, futureEx); if
				 * (statusProp != null && statusProp.intValue() == IFuture.SEND_REQUEST_FAIL) {
				 * isFailed = true; }
				 */
				future.completeExceptionally(localIFuture.cause());
			}
			// 正常结束
			future.complete(() -> {
				boolean isFailed = false;
				try {
					logger.debug("Mark3");
					FileUtil.writeData2File("Mark3\n", "/export/123.txt", true, "UTF-8");
					FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

					// 获取结果
					// Object rspObj = rspSupplier.get();
					Object rspObj = ifuture.getNow();
					logger.debug("Mark4");
					FileUtil.writeData2File("Mark4\n", "/export/123.txt", true, "UTF-8");
					FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

					if (!rspType.isInstance(rspObj)) {
						logger.error("返回类型非法：[%s], %s", rspObj.getClass(), rspObj);
						throw new ApValueTypeUnsupportException(rspObj);
					}
					// 处理结果：T -> byte[]
					JavaDict msgBody = action.apply((JavaDict) rspObj);
					logger.debug("Mark5");
					FileUtil.writeData2File("Mark5\n", "/export/123.txt", true, "UTF-8");
					FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");

					// 返回
					return CommResult.getSuccess(msgBody); // 成功返回
				} catch (Throwable ex) {
					logger.exception(ex);
					ApException apEx = null;
					if (ex instanceof TimeoutException) { // 调用超时
						apEx = new ServiceInvokeTimeOutlException(src, target);
					} else {
						apEx = new ServiceInvokeFailException(src, target);// 服务调用异常
					}
					// 返回
					return isFailed
							? new CommResult<>(CommStatus.FAILED, apEx.getErrorCode(), apEx.getErrorMsg(),
									new CommResponse<>(new JavaDict()))
									: new CommResult<>(CommStatus.ABEND, apEx.getErrorCode(), apEx.getErrorMsg(),
											new CommResponse<>(new JavaDict()));
				}

			});
		});
		// 返回
		return future;
	}



	public static <T> CompletableFuture<Supplier<CommResult<JavaDict>>> procAsyncCommResult2(String src, String target,
			TCResult tcRet, Class<T> rspType, Function<T, JavaDict> action) {
		// 异常
		if (tcRet.getStatus() != 1) {
			return CommResultUtil.wrapByFuture(
					CommResultUtil.getAbendResult(tcRet.getErrorCode(), tcRet.getErrorMsg(), new JavaDict()));
		}
		// 提取future
		IFuture ifuture = (IFuture) tcRet.getOutputParams().get(0);
		// 包装
		CompletableFuture<Supplier<Object>> msgFuture = getCompletableFuture(ifuture);

		CompletableFuture<Supplier<CommResult<JavaDict>>> retFuture = new CompletableFuture<>();
		msgFuture.whenComplete((rspSupplier, futureEx) -> {
			retFuture.complete(() -> {
				boolean isFailed = false;
				try {
					// 出现异常
					if (futureEx != null) {
						// 判断是否失败
						Integer statusProp = (Integer) ifuture.getProperty(IFuture.STATUS);
						logger.error("afa future error: %s, %s", statusProp, futureEx);
						if (statusProp != null && statusProp.intValue() == IFuture.SEND_REQUEST_FAIL) {
							isFailed = true;
						}
						throw futureEx;
					}
					// 获取结果
					Object rspObj = rspSupplier.get();
					if (!rspType.isInstance(rspObj)) {
						logger.error("返回类型非法：[%s], %s", rspObj.getClass(), rspObj);
						throw new ApValueTypeUnsupportException(rspObj);
					}
					// 处理结果：T -> byte[]
					JavaDict msgBody = action.apply((T) rspObj);
					// 返回
					return CommResult.getSuccess(msgBody); // 成功返回
				} catch (Throwable ex) {
					logger.exception(ex);
					ApException apEx = null;
					if (ex instanceof TimeoutException) { // 调用超时
						apEx = new ServiceInvokeTimeOutlException(src, target);
					}
					/*
					 * else if(ex instanceof SdkException) { //熔断，是否要处理看后续流程上是否要对返回信息优化 }
					 */
					else {
						apEx = new ServiceInvokeFailException(src, target);// 服务调用异常
					}
					// 返回
					return isFailed
							? new CommResult<>(CommStatus.FAILED, apEx.getErrorCode(), apEx.getErrorMsg(),
									new CommResponse<>(new JavaDict()))
									: new CommResult<>(CommStatus.ABEND, apEx.getErrorCode(), apEx.getErrorMsg(),
											new CommResponse<>(new JavaDict()));
				}
			});
		});
		//
		return retFuture;
	}

	private static TCResult getCommTCResult(int tcStatus, Throwable ex) {
		// 转换
		ApException apEx = ExceptionUtil.convert(ex);
		// 转发
		return getCommTCResult(tcStatus, apEx.getErrorCode(), apEx.getErrorMsg());
	}

	private static TCResult getCommTCResult(int tcStatus, String errorCode, String errorMsg) {
		return getCommTCResult(tcStatus, errorCode, errorMsg, null);
	}

	private static TCResult getCommTCResult(int tcStatus, String errorCode, String errorMsg, String errStatus) {
		// 转换状态
		if (errStatus == null) {
			errStatus = convertStatus(tcStatus);
		}
		// 返回
		List<Object> outParams = Arrays.asList(errorCode, errorMsg, errStatus);
		return new TCResult(tcStatus, errorCode, errorMsg, outParams);
	}

	private static String convertStatus(int tcStatus) {
		if (tcStatus == SUCCESS) {
			return "S";
		} else if (tcStatus == FAILURE) {
			return "F";
		} else {
			return "U";
		}
	}

	private static int convertStatus(String status) {
		int tcStatus = 1;
		return tcStatus;
	}

}
