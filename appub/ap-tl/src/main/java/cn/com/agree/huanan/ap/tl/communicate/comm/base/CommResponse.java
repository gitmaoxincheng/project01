package cn.com.agree.huanan.ap.tl.communicate.comm.base;

import lombok.Value;

@Value
public class CommResponse<B> {
    private B body;
    
    public CommResponse(B body) {
        this.body = body;
    }
}
