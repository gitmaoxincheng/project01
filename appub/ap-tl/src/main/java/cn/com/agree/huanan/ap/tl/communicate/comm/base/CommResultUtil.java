package cn.com.agree.huanan.ap.tl.communicate.comm.base;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import cn.com.agree.huanan.ap.tl.exception.ApException;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;

public class CommResultUtil {
    private CommResultUtil() {
    }

    public static CommResult<byte[]> getFailedResult(Throwable ex) {
        ApException apEx = ExceptionUtil.convert(ex);
        return CommResult.getFailed(apEx.getErrorCode(), apEx.getErrorMsg(), new byte[] {});
    }

    public static CommResult<byte[]> getAbendResult(Throwable ex) {
        ApException apEx = ExceptionUtil.convert(ex);
        return CommResult.getAbend(apEx.getErrorCode(), apEx.getErrorMsg(), new byte[] {});
    }

    public static CommResult<byte[]> getAbendResult(String errorCode, String errorMsg) {
        return CommResult.getAbend(errorCode, errorMsg, new byte[] {});
    }
    
    public static <T>  CommResult<T> getAbendResult(String errorCode, String errorMsg,T t) {
        return CommResult.getAbend(errorCode, errorMsg,t);
    }
    
    public static <T> CompletableFuture<Supplier<T>> wrapByFuture(T t) {
        CompletableFuture<Supplier<T>> future = new CompletableFuture<>();
        future.complete(() -> t);
        return future;
    }
}