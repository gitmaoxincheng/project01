package cn.com.agree.huanan.ap.tl.exception.tech;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class ApDbExecuteException extends ApException implements ApDbException {
    public ApDbExecuteException(Exception cause) {
        super(cause);
    }
}
