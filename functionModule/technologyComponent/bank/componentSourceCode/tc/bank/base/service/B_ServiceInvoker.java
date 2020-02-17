package tc.bank.base.service;

import static cn.com.agree.afa.jcomponent.GlobalErrorHolder.setGlobalError;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import ap.ide.techcomp.TechComp;
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
import cn.com.agree.huanan.ap.tl.exception.ApException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 服务调用
 * @author huangchaopeng
 * 
 * @date 2019-06-28 21:7:4
 */
@ComponentGroup(level = "银行", groupName = "服务调用")
public class B_ServiceInvoker {

	public static final Logger logger = Logger.getLogger(B_ServiceInvoker.class);
	public static ServiceInvokerService serviceInvoker = SpringUtil.getBean(ServiceInvokerService.class);
	private static final int FAILURE = 0;
	private static final int SUCCESS = 1;
	private static final int EXCEPTION = 2;
	//	private static final int PARTSUCCS = 3;
	//	private static final int HANDLE = 4;



	/**
	 * @category 场景同步调用
	 * @param serviceCode
	 *            入参|服务码|{@link java.lang.String}
	 * @param scenarioCode
	 *            入参|场景码|{@link java.lang.String}
	 * @param params
	 *            入参|请求入参|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since result 出参|返回结果|{@link Object}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 *         2 异常<br>
	 */
	@InParams(param = { @Param(name = "serviceCode", comment = "服务码", type = java.lang.String.class),
			@Param(name = "scenarioCode", comment = "场景码", type = java.lang.String.class),
			@Param(name = "params", comment = "请求入参", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "result", comment = "返回结果", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"),
			@Return(id = "2", desp = "异常") })
	@Component(label = "场景同步调用", style = "选择型", type = "异步组件", comment = "场景同步调用，返回状态分别为失败，成功，异常， 调用异常如超时，熔断，服务未启动等归类为异常", date = "2019-12-24 11:26:59")
	public static TCResult B_syncInvoke(String serviceCode, String scenarioCode, JavaDict params) {
		int tcStatus = FAILURE;
		try {
			JavaDict __REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
			String MC = __REQ__.getStringItem("__MC__");
			String TC = __REQ__.getStringItem("__TC__");
			String identifier = null;
			String serviceVersion = "1.0.0";
			String scenarioVersion = "1.0.0";
			long timeoutInMill = CommConstant.DefTimeOut;
			JavaDict attachment = null;
			// String serviceCode = null;
			// String scenarioCode = null;
			String svcGroup = null;
			ServiceRelation serviceRelation = null;
			//暂未启用
			//			ServiceRelation serviceRelation = serviceInvoker.queryServiceRelation(serviceCode + "." + serviceCode, MC, TC); // 查询调用关系
			if (serviceRelation == null) {
				__REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
				MC = __REQ__.getStringItem("__MC__");
				TC = __REQ__.getStringItem("__TC__");
				identifier = MC + "_SDK_OUT";
			} else {
				identifier = serviceRelation.getIdentifier(); // serviceRelation.get
				timeoutInMill = serviceRelation.getTimeOut();
				serviceCode = serviceRelation.getSvcCode();
				scenarioCode = serviceRelation.getScnCode();
				svcGroup = serviceRelation.getSvcGroup();
			}
			logger.info("Svc:%s,Scn:%s,Identifier:%s,Group:%s,TimeOut:%s", serviceCode, scenarioCode, identifier, svcGroup,
					timeoutInMill);
			params.put(CommConstant.CSIS_HEADER, params.getDictItem(CommConstant.CSIS_HEADER, new JavaDict()));
			params.put(CommConstant.HEADER, params.getDictItem(CommConstant.HEADER, new JavaDict()));
			params.put(CommConstant.APP_HEADER, params.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
			params.put(CommConstant.APP_BODY, params.getDictItem(CommConstant.APP_BODY, new JavaDict()));
			JavaList reqList = new JavaList();
			reqList.add(params);
			tcStatus = EXCEPTION; // 通讯前设为异常
			TCResult tcRet = SdkBroker.syncInvokeV2(identifier, serviceCode, serviceVersion, scenarioCode, scenarioVersion,
					reqList, timeoutInMill, attachment);// 服务调用，涉及平台内容，本组件使用异步通讯
			logger.info("TcRet：%s, %s, %s", tcRet.getStatus(), tcRet.getErrorCode(), tcRet.getErrorMsg());
			// 处理异步结果
			// 提取future
			IFuture ifuture1 = (IFuture) tcRet.getOutputParams().get(0);
			// 转换
			IFuture ifuture = getSdkIFuture(ifuture1, MC + "." + TC,
					serviceCode + "." + scenarioCode, JavaDict.class, (rspDict) -> {
						//						logger.info(rspDict.toString());
						//						FileUtil.writeData2File("Mark\n", "/export/123.txt", true, "UTF-8");
						//						FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
						return rspDict;
					});
			// 返回成功
			return TCResult.newSuccessResult(ifuture);
		} catch (Exception ex) {
			logger.exception("服务调用失败", ex);
			ApException apException = new ServiceInvokeFailException(serviceCode + "." + scenarioCode);
			setGlobalError(tcStatus, apException.getErrorCode(), apException.getErrorMsg());// 失败，要仔细的检查TechComp还有用么
			return new TCResult(tcStatus);
			// return new Object[] { tcStatus, ex};
		}
	}

	public static TCResult B_syncSvcInvoke(String serviceCode, String scenarioCode, JavaList params) {
		JavaDict __REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
		String MC = __REQ__.getStringItem("__MC__");
		String TC = __REQ__.getStringItem("__TC__");
		String identifier = MC + "_SDK_OUT";
		String serviceVersion = "1.0.0";
		String scenarioVersion = "1.0.0";
		long timeoutInMill = CommConstant.DefTimeOut;
		JavaDict attachment = null;
		logger.info("MC:%s,TC:%s,Identifier:%s,TimeOut:%s", serviceCode, scenarioCode, identifier, timeoutInMill);
		JavaDict reqDict = new JavaDict();
		JavaDict req = params.getDictItem(0);
		reqDict.put(CommConstant.CSIS_HEADER, req.getDictItem(CommConstant.CSIS_HEADER, new JavaDict()));
		reqDict.put(CommConstant.HEADER, req.getDictItem(CommConstant.HEADER, new JavaDict()));
		reqDict.put(CommConstant.APP_HEADER, req.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
		reqDict.put(CommConstant.APP_BODY, req.getDictItem(CommConstant.APP_BODY, new JavaDict()));
		params.set(0, reqDict);
		try {
			TCResult result = SdkBroker.syncInvokeV2(identifier, serviceCode, serviceVersion, scenarioCode,
					scenarioVersion, params, timeoutInMill, attachment);
			return result;
		} catch (Exception e) {
			logger.exception("场景同步调用异常", e);
			ApException apException = new ServiceInvokeFailException(serviceCode + "." + scenarioCode);
			return new TCResult(2, apException.getErrorCode(), apException.getErrorMsg());
		}
	}

	/**
	 * @category 场景同步调用2
	 * @param serviceCode
	 *            入参|服务码|{@link java.lang.String}
	 * @param scenarioCode
	 *            入参|场景码|{@link java.lang.String}
	 * @param params
	 *            入参|请求入参|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param attachment
	 *            入参|扩展参数|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since result 出参|返回结果|{@link Object}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 * 		2 异常<br>
	 */
	@InParams(param = { @Param(name = "serviceCode", comment = "服务码", type = java.lang.String.class),
			@Param(name = "scenarioCode", comment = "场景码", type = java.lang.String.class),
			@Param(name = "params", comment = "请求入参", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "attachment", comment = "扩展参数", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "result", comment = "返回结果", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"),
			@Return(id = "2", desp = "异常") })
	@Component(label = "场景同步调用2", style = "选择型", type = "异步组件", comment = "场景同步调用，返回状态分别为失败，成功，异常，部分成功，处理中共五种， 调用异常如超时，熔断，服务未启动等归类为异常。平台服务调度的目前扩展入参主要有__ReqNo__传递流水号，__ST__ 场景区分标识", date = "2019-12-24 08:14:58")
	public static TCResult B_syncInvoke4(String serviceCode, String scenarioCode, JavaDict params, JavaDict attachment) {
		JavaDict sysHeader = params.getDictItem(CommConstant.CSIS_HEADER, new JavaDict());
		sysHeader.putAll(attachment);
		return B_syncInvoke(serviceCode, scenarioCode, params);
	}

	/**
	 * @category 场景同步调用3
	 * @param serviceCode
	 *            入参|服务码|{@link java.lang.String}
	 * @param scenarioCode
	 *            入参|场景码|{@link java.lang.String}
	 * @param params
	 *            入参|请求入参|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since result 出参|返回结果|{@link Object}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 *         2 异常<br>
	 *         3 部分成功<br>
	 *         4 处理中<br>
	 */
	@InParams(param = { @Param(name = "serviceCode", comment = "服务码", type = java.lang.String.class),
			@Param(name = "scenarioCode", comment = "场景码", type = java.lang.String.class),
			@Param(name = "params", comment = "请求入参", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "result", comment = "返回结果", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"), @Return(id = "2", desp = "异常"),
			@Return(id = "3", desp = "部分成功"), @Return(id = "4", desp = "处理中") })
	@Component(label = "场景同步调用3", style = "选择型", type = "异步组件", comment = "场景同步调用，返回状态分别为失败，成功，异常，部分成功，处理中共五种， 调用异常如超时，熔断，服务未启动等归类为异常", date = "2019-12-24 12:30:40")
	public static TCResult B_syncInvoke3(String serviceCode, String scenarioCode, JavaDict params) {
		int tcStatus = FAILURE;
		try {
			JavaDict __REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
			String MC = __REQ__.getStringItem("__MC__");
			String TC = __REQ__.getStringItem("__TC__");
			String identifier = null;
			String serviceVersion = "1.0.0";
			String scenarioVersion = "1.0.0";
			long timeoutInMill = CommConstant.DefTimeOut;
			JavaDict attachment = null;
			// String serviceCode = null;
			// String scenarioCode = null;
			String svcGroup = null;
			ServiceRelation serviceRelation = null;
			//暂未启用
			//			ServiceRelation serviceRelation = serviceInvoker.queryServiceRelation(serviceCode + "." + serviceCode, MC, TC); // 查询调用关系
			if (serviceRelation == null) {
				__REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
				MC = __REQ__.getStringItem("__MC__");
				TC = __REQ__.getStringItem("__TC__");
				identifier = MC + "_SDK_OUT";
			} else {
				identifier = serviceRelation.getIdentifier(); // serviceRelation.get
				timeoutInMill = serviceRelation.getTimeOut();
				serviceCode = serviceRelation.getSvcCode();
				scenarioCode = serviceRelation.getScnCode();
				svcGroup = serviceRelation.getSvcGroup();
			}
			logger.info("Svc:%s,Scn:%s,Identifier:%s,Group:%s,TimeOut:%s", serviceCode, scenarioCode, identifier, svcGroup,
					timeoutInMill);
			params.put(CommConstant.CSIS_HEADER, params.getDictItem(CommConstant.CSIS_HEADER, new JavaDict()));
			params.put(CommConstant.HEADER, params.getDictItem(CommConstant.HEADER, new JavaDict()));
			params.put(CommConstant.APP_HEADER, params.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
			params.put(CommConstant.APP_BODY, params.getDictItem(CommConstant.APP_BODY, new JavaDict()));
			JavaList reqList = new JavaList();
			reqList.add(params);
			tcStatus = EXCEPTION; // 通讯前设为异常
			TCResult tcRet = SdkBroker.syncInvokeV2(identifier, serviceCode, serviceVersion, scenarioCode, scenarioVersion,
					reqList, timeoutInMill, attachment);// 服务调用，涉及平台内容，本组件使用异步通讯
			logger.info("TcRet：%s, %s, %s", tcRet.getStatus(), tcRet.getErrorCode(), tcRet.getErrorMsg());
			// 处理异步结果
			// 提取future
			IFuture ifuture1 = (IFuture) tcRet.getOutputParams().get(0);
			// 转换
			IFuture ifuture = getSdkIFuture2(ifuture1, MC + "." + TC,
					serviceCode + "." + scenarioCode, JavaDict.class, (rspDict) -> {
						//						logger.info(rspDict.toString());
						//						FileUtil.writeData2File("Mark\n", "/export/123.txt", true, "UTF-8");
						//						FileUtil.writeData2File(Thread.currentThread().getName()+"\n", "/export/123.txt", true, "UTF-8");
						return rspDict;
					});
			// 返回成功
			return TCResult.newSuccessResult(ifuture);
		} catch (Exception ex) {
			logger.exception("服务调用失败", ex);
			ApException apException = new ServiceInvokeFailException(serviceCode + "." + scenarioCode);
			setGlobalError(tcStatus, apException.getErrorCode(), apException.getErrorMsg());// 失败，要仔细的检查TechComp还有用么
			return new TCResult(tcStatus);
			// return new Object[] { tcStatus, ex};
		}
	}


	/**
	 * @category 服务调用异常
	 * @param serviceCode
	 *            入参|服务码|{@link java.lang.String}
	 * @param scenarioCode
	 *            入参|场景码|{@link java.lang.String}
	 * @param type
	 *            入参|类型|{@link java.lang.Integer}
	 * @return 1 成功<br>
	 */
	@InParams(param = { @Param(name = "serviceCode", comment = "服务码", type = java.lang.String.class),
			@Param(name = "scenarioCode", comment = "场景码", type = java.lang.String.class),
			@Param(name = "type", comment = "类型", type = java.lang.Integer.class) })
	@Returns(returns = { @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "服务调用异常", style = "判断型", type = "同步组件", comment = "服务异常返回", date = "2019-11-16 01:41:35")
	public static TCResult B_serviceInvokeFail(String serviceCode, String scenarioCode, Integer type) {
		return TechComp.call(() -> {
			if (type == null) {
				throw new ServiceInvokeFailException(serviceCode, scenarioCode);
			} else {
				throw new ServiceInvokeTimeOutlException(serviceCode, scenarioCode);
			}
		});
	}

	public static <T, R> IFuture getSdkIFuture(IFuture future,String src, String target,Class<T> rspType, Function<T, JavaDict> action) {
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
						logger.error("返回类型非法：[%s]", rspObj==null? "null":rspObj.getClass().getName());
						throw new ApValueTypeUnsupportException(rspObj==null? "null":rspObj.getClass().getName());
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
					setGlobalError(isFailed ? "F": "N", apEx.getErrorCode(), apEx.getErrorMsg());// 失败，要仔细的检查TechComp还有用么
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



	public static <T, R> IFuture getSdkIFuture2(IFuture future,String src, String target,Class<T> rspType, Function<T, JavaDict> action) {
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
					case CommConstant.PARTSUCCSTATUS:
						setGlobalError("P", errorCode, errorMsg);// 部分成功
						retStatus = 3;
						break;
					case CommConstant.HANDSTATUS:
						setGlobalError("I", errorCode, errorMsg);// 处理中
						retStatus = 4;
						break;							
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



	public static <T, R> IFuture getCustomIFuture(IFuture future,String src, String target,Class<T> rspType, Function<T, R> action) {
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
						logger.error("返回类型非法：[%s]", rspObj==null? "null":rspObj.getClass().getName());
						throw new ApValueTypeUnsupportException(rspObj==null? "null":rspObj.getClass().getName());
					}
					// 处理结果：T -> byte[]
					R msgDict = action.apply((T) rspObj);
					// 返回
					return new TCResult(SUCCESS, Arrays.asList(msgDict)); // 返回状态

				} catch (Throwable ex) {
					logger.exception(ex);
					ApException apEx = null;
					if (ex instanceof TimeoutException) { // 调用超时
						apEx = new ServiceInvokeTimeOutlException(src, target);
					} else {
						apEx = new ServiceInvokeFailException(src, target);// 服务调用异常
					}
					setGlobalError(isFailed ? "F": "N", apEx.getErrorCode(), apEx.getErrorMsg());// 失败，要仔细的检查TechComp还有用么
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

	public static <T,R> TCResult B_syncInvoke(String serviceCode, String scenarioCode, JavaDict params, Class<T> rspType, Function<T, R> action) {
		int tcStatus = FAILURE;
		try {
			JavaDict __REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
			String MC = __REQ__.getStringItem("__MC__");
			String TC = __REQ__.getStringItem("__TC__");
			String identifier = null;
			String serviceVersion = "1.0.0";
			String scenarioVersion = "1.0.0";
			long timeoutInMill = CommConstant.DefTimeOut;
			JavaDict attachment = null;
			String svcGroup = null;
			ServiceRelation serviceRelation = null;
			//暂未启用
			//			ServiceRelation serviceRelation = serviceInvoker.queryServiceRelation(serviceCode + "." + serviceCode, MC, TC); // 查询调用关系
			if (serviceRelation == null) {
				__REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
				MC = __REQ__.getStringItem("__MC__");
				TC = __REQ__.getStringItem("__TC__");
				identifier = MC + "_SDK_OUT";
			} else {
				identifier = serviceRelation.getIdentifier(); // serviceRelation.get
				timeoutInMill = serviceRelation.getTimeOut();
				serviceCode = serviceRelation.getSvcCode();
				scenarioCode = serviceRelation.getScnCode();
				svcGroup = serviceRelation.getSvcGroup();
			}
			logger.info("Svc:%s,Scn:%s,Identifier:%s,Group:%s,TimeOut:%s", serviceCode, scenarioCode, identifier, svcGroup,
					timeoutInMill);
			params.put(CommConstant.CSIS_HEADER, params.getDictItem(CommConstant.CSIS_HEADER, new JavaDict()));
			params.put(CommConstant.HEADER, params.getDictItem(CommConstant.HEADER, new JavaDict()));
			params.put(CommConstant.APP_HEADER, params.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
			params.put(CommConstant.APP_BODY, params.getDictItem(CommConstant.APP_BODY, new JavaDict()));
			JavaList reqList = new JavaList();
			reqList.add(params);
			tcStatus = EXCEPTION; // 通讯前设为异常
			TCResult tcRet = SdkBroker.syncInvokeV2(identifier, serviceCode, serviceVersion, scenarioCode, scenarioVersion,reqList, timeoutInMill, attachment);// 服务调用，涉及平台内容，本组件使用异步通讯
			logger.info("TcRet：%s, %s, %s", tcRet.getStatus(), tcRet.getErrorCode(), tcRet.getErrorMsg());
			// 处理异步结果
			IFuture ifuture1 = (IFuture) tcRet.getOutputParams().get(0);
			// 转换
			IFuture ifuture = getCustomIFuture(ifuture1, MC + "." + TC,serviceCode + "." + scenarioCode, rspType, action);
			// 返回成功
			return TCResult.newSuccessResult(ifuture);
		} catch (Exception ex) {
			logger.exception("服务调用失败", ex);
			ApException apException = new ServiceInvokeFailException(serviceCode + "." + scenarioCode);
			setGlobalError(tcStatus, apException.getErrorCode(), apException.getErrorMsg());// 失败，要仔细的检查TechComp还有用么
			return new TCResult(tcStatus);
		}
	}



	public static <T,R> T B_svcInvoke(String serviceCode, String scenarioCode, JavaDict params, Class<T> rspType, Function<T, JavaDict> action) {
		int tcStatus = FAILURE;
		JavaDict __REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
		String MC = __REQ__.getStringItem("__MC__");
		String TC = __REQ__.getStringItem("__TC__");
		String identifier = null;
		String serviceVersion = "1.0.0";
		String scenarioVersion = "1.0.0";
		long timeoutInMill = CommConstant.DefTimeOut;
		JavaDict attachment = null;
		String svcGroup = null;
		ServiceRelation serviceRelation = null;
		JavaList reqList = new JavaList();
		try {
			//暂未启用
			//ServiceRelation serviceRelation = serviceInvoker.queryServiceRelation(serviceCode + "." + serviceCode, MC, TC); // 查询调用关系
			if (serviceRelation == null) {
				__REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
				MC = __REQ__.getStringItem("__MC__");
				TC = __REQ__.getStringItem("__TC__");
				identifier = MC + "_SDK_OUT";
			} else {
				identifier = serviceRelation.getIdentifier(); // serviceRelation.get
				timeoutInMill = serviceRelation.getTimeOut();
				serviceCode = serviceRelation.getSvcCode();
				scenarioCode = serviceRelation.getScnCode();
				svcGroup = serviceRelation.getSvcGroup();
			}
			logger.info("Svc:%s,Scn:%s,Identifier:%s,Group:%s,TimeOut:%s", serviceCode, scenarioCode, identifier, svcGroup,
					timeoutInMill);
			params.put(CommConstant.CSIS_HEADER, params.getDictItem(CommConstant.CSIS_HEADER, new JavaDict()));
			params.put(CommConstant.HEADER, params.getDictItem(CommConstant.HEADER, new JavaDict()));
			params.put(CommConstant.APP_HEADER, params.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
			params.put(CommConstant.APP_BODY, params.getDictItem(CommConstant.APP_BODY, new JavaDict()));
			reqList.add(params);
			tcStatus = EXCEPTION; // 通讯前设为异常
		} catch (Exception ex) {
			logger.exception("服务调用失败", ex);
			ApException apException = new ServiceInvokeFailException(serviceCode + "." + scenarioCode);
			setGlobalError(tcStatus, apException.getErrorCode(), apException.getErrorMsg());// 失败，要仔细的检查TechComp还有用么
			throw apException;
		}
		TCResult tcRet = SdkBroker.syncInvoke(identifier, serviceCode, serviceVersion, scenarioCode, scenarioVersion,reqList, timeoutInMill, attachment);// 服务调用，涉及平台内容，本组件使用异步通讯
		logger.info("TcRet：%s, %s, %s", tcRet.getStatus(), tcRet.getErrorCode(), tcRet.getErrorMsg());
		if (tcRet.getStatus() != 1) {
			logger.error("服务调用失败");
			ApException apException = new ServiceInvokeFailException(serviceCode + "." + scenarioCode);
			setGlobalError(tcStatus, apException.getErrorCode(), apException.getErrorMsg());// 失败，要仔细的检查TechComp还有用么
			throw apException;
		}else {
			return (T) tcRet.getOutputParams().get(0);
		}

	}



}
