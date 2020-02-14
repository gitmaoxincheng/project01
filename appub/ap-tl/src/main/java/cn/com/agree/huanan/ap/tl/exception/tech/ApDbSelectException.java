package cn.com.agree.huanan.ap.tl.exception.tech;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class ApDbSelectException extends ApException implements ApDbException {
    public ApDbSelectException(Exception cause) {
        super(cause);
    }
}
