package cn.com.agree.huanan.ap.tl.communicate.http.future;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;

/**
 * @author luo.hp
 *
 * @param <T> 类类型
 */
public interface FurtherCallbackHandler<T> {

    /**
     * 完成
     * @param context 结果容器 
     */
    public void completed(CommContext context);

    /**
     * 失败
     * @param ex 失败异常
     */
    public void failed(Exception ex);

    /**
     * 取消
     */
    public void cancelled();
}