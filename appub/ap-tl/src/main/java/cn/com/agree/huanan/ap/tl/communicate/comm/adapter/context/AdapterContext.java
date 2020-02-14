package cn.com.agree.huanan.ap.tl.communicate.comm.adapter.context;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.CommunicateAdapter;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResult;
import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;

/**
 * @author luo.hp
 * @category 通信适配器容器
 *
 */
public class AdapterContext{
    
    // 通信适配器
    private CommunicateAdapter adapter;
    
    // 通信定义参数
    private CommParam commParam;
    
    // 附属参数
    private Map<String, Object> additionParam;

    /**
     * @param adpater 通信适配器
     * @param commParam 通信参数
     */
    public AdapterContext(CommunicateAdapter adpater, CommParam commParam){
        this.adapter = adpater;
        this.commParam = commParam;
        this.additionParam = new HashMap<>();
    }
    
    /**
     * @param msg 报文
     * @return 通信结果
     */
    public CommContext comm(byte[] msg) {
        return adapter.comm(commParam, msg, additionParam);
    }

    /**
     * @param msg 报文
     * @return 通信结果
     */
    public CommContext comm(String msg) {
        return adapter.comm(commParam, msg, additionParam);
    }

    /**
     * 异步通信
     * @param msg 报文
     * @return 通信结果
     */
    public CompletableFuture<Supplier<CommResult<byte[]>>> commAsync(String msg) {
        return adapter.commAsync(commParam, msg, additionParam);
    }
    
    /**
     * @param paramName 参数名称
     * @param paramValue 参数值
     * @return 通信适配容器
     */
    public AdapterContext addAdditionParam(String paramName, Object paramValue){
        additionParam.put(paramName, paramValue);
        return this;
    }
    
    /**
     * @param paramMap 附属参数MAP，附属参数：
     *          HTTP通信：__HTTP_HEADER__  ：   http头Map字典
     *                   mc               ：    http url中的MC
     *                   tc               ：    http url中的TC
     * @return 通信适配容器
     */
    public AdapterContext addAdditionParam(Map<String, Object> paramMap){
        additionParam.putAll(paramMap);
        return this;
    }
}
