package cn.com.agree.huanan.ap.tl.exception.tech;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class ApDbConnectionException extends ApException implements ApDbException {
    public ApDbConnectionException(Exception cause) {
        super(cause);
    }
}
