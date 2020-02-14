package cn.com.agree.huanan.ap.tl.communicate.comm.adapter;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResult;
import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;

/**
 * @author luo.hp
 *
 */
public interface CommunicateAdapter{
    
    /**
     * @param param 通信参数
     * @param msg 字节流
     * @return 通信结果容器
     */
    public default CommContext comm(CommParam param, byte [] msg){
        return comm(param, msg, Collections.emptyMap());
    }
    
    /**
     * @param param 通信参数
     * @param msg 字符串
     * @return 通信结果容器
     */
    public default CommContext comm(CommParam param, String msg){
        return comm(param, msg, Collections.emptyMap());
    }
    
    /**
     * @param param 通信参数
     * @param msg 字节流
     * @param additionParam 附属参数
     * @return 通信结果容器
     */
    public CommContext comm(CommParam param, byte [] msg, Map<String, Object> additionParam);
    
    /**
     * @param param 通信参数
     * @param msg 字符串
     * @param additionParam 附属参数 
     * @return 通信结果容器
     */
    public CommContext comm(CommParam param, String msg, Map<String, Object> additionParam);
    
    /**
     * 异步通信
     * @param param 参数
     * @param msg 报文
     * @param additionParam 附属参数 
     * @return 通信结果容器
     */
    default public CompletableFuture<Supplier<CommResult<byte[]>>> commAsync(CommParam param, String msg, Map<String, Object> additionParam) {
        throw new UnsupportedOperationException();
    }
}
