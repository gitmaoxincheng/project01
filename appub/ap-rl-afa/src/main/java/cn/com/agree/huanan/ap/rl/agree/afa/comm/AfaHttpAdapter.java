package cn.com.agree.huanan.ap.rl.agree.afa.comm;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cn.com.agree.afa.jcomponent.HttpClient;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.HttpAdapter;
import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.impl.HttpAdapterImpl;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommFlowUtil;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResult;
import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.HttpCommParam;
import cn.com.agree.huanan.ap.tl.communicate.http.base.Const;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfRangeException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import cn.com.agree.huanan.ap.tl.util.FlowUtil.StatusCtrl;

@Component
@Primary
public class AfaHttpAdapter implements HttpAdapter {
    @Autowired
    private Logger logger;
    
    @Override
    public CommContext comm(CommParam param, byte[] msg, Map<String, Object> additionParam) {
        return SpringUtil.getBean(HttpAdapterImpl.class).comm(param, msg);
    }

    @Override
    public CommContext comm(CommParam param, String msg, Map<String, Object> additionParam) {
        return SpringUtil.getBean(HttpAdapterImpl.class).comm(param, msg);
    }

    @Override
    public CompletableFuture<Supplier<CommResult<byte[]>>> commAsync(CommParam param, String msg, Map<String, Object> additionParam) {
        // 执行异步通讯流程
        return CommFlowUtil.runCommAsyncFlow((ctrl) -> {
            return commAsync0(param, msg, additionParam, ctrl);
        });
    }
    
    private CompletableFuture<Supplier<CommResult<byte[]>>> commAsync0(CommParam param, String msg, Map<String, Object> additionParam, StatusCtrl ctrl) {
        // 初始化http参数
        HttpCommParam httpCommParam = new HttpCommParam();
        httpCommParam.init(param, additionParam);

        // 初始化http头
        JavaDict httpHeader = new JavaDict();
        Object headerObject = (Map<?, ?>) additionParam.get(Const.HEADER_KEY);
        if (headerObject instanceof Map) {
            Map<?, ?> headerMap = (Map<?, ?>) headerObject;
            headerMap.forEach((k, v) -> httpHeader.put(k == null ? "" : k.toString(), v == null ? "" : v.toString()));
        }

        // method
        String method = httpCommParam.getOperator();
        if (!method.equals("POST")) {
            throw new UnsupportedOperationException(method);
        }

        // 标记异常
        ctrl.setAbend();
        
        // 异步通讯
        TCResult tcRet = AfaCommUtil.callCommAsyncAPI("HttpClient.asyncPost", () -> {
            return HttpClient.asyncPost(param.getIdentifier(), 
                    httpCommParam.getServerUrl(), 
                    httpHeader,
                    msg, 
                    httpCommParam.getEncoding(), 
                    httpCommParam.getSockTimeOut()
                    );
        });
        
        // 处理异步结果
        return AfaCommUtil.procAsyncCommResult(tcRet, List.class,param,(rspList) -> {
            /**
             * index-0：http响应码，200-正常
             * index-1：http响应头
             * index-2：http响应报文体
             * index-3：通讯耗时
             */
            if (rspList.size() < 4) {
                throw new ApValueOutOfRangeException(rspList.size());
            }
            int httpCode = (int) rspList.get(0);
            Map<?, ?> msgHeader = (Map<?, ?>) rspList.get(1);
            byte[] msgBody = (byte[]) rspList.get(2);
            Number commTime = (Number) rspList.get(3);
            long commTimeLong = commTime.longValue();
            logger.info("通讯状态码：%s，耗时：%d.%03d", 
                    httpCode,
                    commTimeLong / 1000,
                    commTimeLong % 1000
                    );
            if (httpCode != 200) {
                throw new ApValueOutOfRangeException(httpCode);
            }
            return msgBody;
        });
    }
}
