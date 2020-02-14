package cn.com.agree.huanan.ap.tl.exception;

public class ApSuccessException extends ApException {
    private static final ApException INSTANCE = new ApSuccessException();
    
    private ApSuccessException() {
        
    }
    
    public static ApException getInstance() {
        return INSTANCE;
    }
    
    @Override
    public StackTraceElement[] getStackTrace() {
        // 不返还堆栈
        return new StackTraceElement[] {};
    }
}
