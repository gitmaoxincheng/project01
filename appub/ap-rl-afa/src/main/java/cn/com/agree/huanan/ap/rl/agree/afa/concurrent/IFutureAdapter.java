package cn.com.agree.huanan.ap.rl.agree.afa.concurrent;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import cn.com.agree.afa.util.future.IFuture;
import cn.com.agree.afa.util.future.IFutureListener;

/**
 * IFuture适配器
 * 
 * @author tan.ch
 *
 */
public class IFutureAdapter {
//	private static Logger logger = Logger.getLogger(IFutureAdapter.class);


	private IFutureAdapter() {
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
				// 首次获取
				if (result == null) {
					// 获取future结果
					T futureRet = supplier.get();
					// 调用处理方法
					R getRet = whenGet.apply(futureRet, throwable);
					// 正常（包装）
					result = Optional.ofNullable(getRet);
				}
				// 获取结果
				return result.get();
			}

			@Override
			public IFuture addListener(IFutureListener listener) {
				// 适配
				future.whenComplete((sup, ex) -> {
					// 保存结果
					supplier = sup;
					throwable = ex;
					// 通知
					try {
						listener.operationCompleted(this);
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
				return (T) localIFuture.getNow();
			});
		});
		
		// 返回
		return future;
	}
}
