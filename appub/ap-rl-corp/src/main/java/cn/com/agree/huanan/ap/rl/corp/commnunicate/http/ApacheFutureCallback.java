package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import org.apache.http.concurrent.FutureCallback;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherCallbackHandler;

/**
 * @author luo.hp
 *
 */
public class ApacheFutureCallback implements FutureCallback<CommContext>{

    FurtherCallbackHandler<CommContext> callback;
    /**
     * @param callback 回调处理
     */
    public ApacheFutureCallback(FurtherCallbackHandler<CommContext> callback) {
        // TODO 自动生成的构造函数存根
        this.callback = callback;
    }

    @Override
    public void completed(CommContext context) {
        // TODO 自动生成的方法存根
        callback.completed(context);
    }

    @Override
    public void failed(Exception ex) {
        // TODO 自动生成的方法存根
        callback.failed(ex);
    }

    @Override
    public void cancelled() {
        // TODO 自动生成的方法存根
        callback.cancelled();
    }
}
