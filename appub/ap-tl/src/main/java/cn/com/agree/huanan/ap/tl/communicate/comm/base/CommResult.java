package cn.com.agree.huanan.ap.tl.communicate.comm.base;

import cn.com.agree.huanan.ap.tl.exception.ApException;
import cn.com.agree.huanan.ap.tl.exception.ApSuccessException;
import lombok.Value;

@Value
public class CommResult<R> {
    private final CommStatus commStatus;
    private final String errorCode;
    private final String errorMsg;
    private final CommResponse<R> response;
    
    public static <R> CommResult<R> getSuccess(R body) {
        ApException ex = ApSuccessException.getInstance();
        return new CommResult<>(CommStatus.SUCCESS, ex.getErrorCode(), ex.getErrorMsg(), new CommResponse<>(body));
    }
    
    public static <R> CommResult<R> getFailed(String errorCode, String errorMsg, R body) {
        return new CommResult<>(CommStatus.FAILED, errorCode, errorMsg, new CommResponse<>(body));
    }
    
    public static <R> CommResult<R> getAbend(String errorCode, String errorMsg, R body) {
        return new CommResult<>(CommStatus.ABEND, errorCode, errorMsg, new CommResponse<>(body));
    }
}