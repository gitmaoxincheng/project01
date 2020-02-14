package cn.com.agree.huanan.ap.tl.util;

import java.util.Objects;
import java.util.function.Function;

import cn.com.agree.huanan.ap.tl.logging.Logger;

public class FlowUtil<R> {
	
	private static Logger logger = Logger.getLogger(FlowUtil.class);
    private Throwable ex;
    private Function<StatusCtrl, R> mainAction;
    private Function<Throwable, R> failedAction;
    private Function<Throwable, R> abendAction;
    
    private FlowUtil() {}
    
    public interface StatusCtrl {
        public void setAbend();
    }
    
    private static class InternalStatusCtrl implements StatusCtrl {
        /** 是否异常 */
        private boolean isAbend = false;

        @Override
        public void setAbend() {
            isAbend = true;
        }
    }
    
    public FlowUtil<R> whenFailed(Function<Throwable, R> failedAction) {
        this.failedAction = failedAction;
        return this;
    }
    
    public FlowUtil<R> whenAbend(Function<Throwable, R> abendAction) {
        this.abendAction = abendAction;
        return this;
    }
    
    public R run() {
        // 检查参数
        Objects.requireNonNull(mainAction);
        Objects.requireNonNull(failedAction);
        Objects.requireNonNull(abendAction);
        
        // 创建控制器
        InternalStatusCtrl ctrl = new InternalStatusCtrl();
        
        // 流程处理
        try {
            // 主流程
            return mainAction.apply(ctrl);
        }
        catch (Throwable ex) {
        	logger.exception(ex);
            // 失败流程
            if (!ctrl.isAbend) {
                return failedAction.apply(ex);
            }
            // 异常流程
            else {
                return abendAction.apply(ex);
            }
        }
    }
    
    public static <R> FlowUtil<R> main(Function<StatusCtrl, R> mainAction) {
        FlowUtil<R> inst = new FlowUtil<>();
        inst.mainAction = mainAction;
        return inst;
    }
}
