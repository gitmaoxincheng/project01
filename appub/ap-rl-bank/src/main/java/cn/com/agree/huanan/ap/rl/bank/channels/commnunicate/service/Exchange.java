/**
 * 
 */
package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResult;

/**
 * @author xqq
 * 通讯接口
 * @param <I> I
 * @param <O> O
 */
public interface Exchange<I,O> {
	/**
	 * 获取请求报文
	 * @return I
	 */
	I getRequest();

	/**
	 * 与渠道系统通讯
	 */
	void exchange();

    /**
     * 与渠道系统异步通讯
     */
    default CompletableFuture<Supplier<CommResult<Map<String, Object>>>> exchangeAsync() {
        throw new UnsupportedOperationException();
    }

	
	/**
	 * 获取响应结果容器
	 * @return O
	 */
	O getResponse();
}
