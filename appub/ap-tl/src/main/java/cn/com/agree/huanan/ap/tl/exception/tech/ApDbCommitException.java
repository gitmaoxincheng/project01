package cn.com.agree.huanan.ap.tl.exception.tech;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class ApDbCommitException extends ApException implements ApDbException {
    public ApDbCommitException(Exception cause) {
        super(cause);
    }
}
