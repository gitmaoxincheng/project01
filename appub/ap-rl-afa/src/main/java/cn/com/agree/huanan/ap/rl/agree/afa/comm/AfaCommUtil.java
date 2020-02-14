package cn.com.agree.huanan.ap.rl.agree.afa.comm;

import java.net.ConnectException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Supplier;

import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.util.future.IFuture;
import cn.com.agree.huanan.ap.rl.agree.afa.concurrent.IFutureAdapter;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResult;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResultUtil;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApCommConnectException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApCommTimeOutException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * 异步通讯处理工具类
 * @author tanch
 *
 */
public class AfaCommUtil {
	private static Logger logger = SpringUtil.getBean(Logger.class, AfaCommUtil.class);

	private AfaCommUtil() {

	}

	public static TCResult callCommAsyncAPI(String apiName, Supplier<TCResult> action) {
		// 异步通讯
		TCResult tcRet;
		long tm = System.currentTimeMillis();
		try {
			// call API
			tcRet = action.get();
		}
		catch (Exception ex) {
			logger.error("[%s]调用异常：%s", apiName, ex);
			throw ExceptionUtil.convertToRuntimeException(ex);
		}
		tm = System.currentTimeMillis() - tm;
		logger.info("[%s]调用结果：%s, %s, %s，耗时：%d.%03d",
				apiName,
				tcRet.getStatus(),
				tcRet.getErrorCode(),
				tcRet.getErrorMsg(),
				tm / 1000,
				tm % 1000
				);

		return tcRet;
	}

	public static <T> CompletableFuture<Supplier<CommResult<byte[]>>> procAsyncCommResult(TCResult tcRet, Class<T> rspType,CommParam commParam, Function<T, byte[]> action) {
		logger.debug("运行：AfaCommUtil.procAsyncCommResult");
		// 异常
		if (tcRet.getStatus() != 1) {
			return CommResultUtil.wrapByFuture(CommResultUtil.getAbendResult(tcRet.getErrorCode(), tcRet.getErrorMsg()));
		}
		// 提取future
		IFuture ifuture = (IFuture) tcRet.getOutputParams().get(0);
		// 包装
		CompletableFuture<Supplier<Object>> msgFuture = IFutureAdapter.getCompletableFuture(ifuture);
		CompletableFuture<Supplier<CommResult<byte[]>>> retFuture = new CompletableFuture<>();
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
						logger.error("返回类型非法：[%s]", rspObj==null? "null":rspObj.getClass().getName());
						throw new ApValueTypeUnsupportException(rspObj==null? "null":rspObj.getClass().getName());
					}

					// 处理结果：T -> byte[]
					byte[] msgBody = action.apply((T)rspObj);
					// 返回
					return CommResult.getSuccess(msgBody);
				}
				catch (Throwable ex) {
					logger.exception(ex);
					// 超时
					if (ex instanceof TimeoutException) {
						ex = new ApCommTimeOutException(commParam.getAppId());
					}
					// 连接错误
					else if (ex instanceof ConnectException) {
						ex = new ApCommConnectException(commParam.getAppId());
					}
					// 返回
					return isFailed ? CommResultUtil.getFailedResult(ex) : CommResultUtil.getAbendResult(ex);
				}
			});
		});   
		// 
		return retFuture;
	}
}
