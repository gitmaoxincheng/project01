package cn.com.agree.huanan.ap.tl.communicate.comm.base;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import cn.com.agree.huanan.ap.tl.util.FlowUtil;
import cn.com.agree.huanan.ap.tl.util.FlowUtil.StatusCtrl;

public class CommFlowUtil {
    private static Logger logger = SpringUtil.getBean(Logger.class, CommFlowUtil.class);
    
    private CommFlowUtil() {
    }
    
    public static CompletableFuture<Supplier<CommResult<byte[]>>> runCommAsyncFlow(Function<StatusCtrl, CompletableFuture<Supplier<CommResult<byte[]>>>> action) {
        // 主流程
        return FlowUtil.main(action)
        // 失败流程
        .whenFailed((ex) -> {
            logger.exception("通讯失败：", ex);
            CommResult<byte[]> commRet = CommResultUtil.getFailedResult(ex);
            return CommResultUtil.wrapByFuture(commRet);
        })
        // 异常流程
        .whenAbend((ex) -> {
            logger.exception("通讯异常：", ex);
            return CommResultUtil.wrapByFuture(CommResultUtil.getAbendResult(ex));
        })
        // 执行
        .run();
    }
}