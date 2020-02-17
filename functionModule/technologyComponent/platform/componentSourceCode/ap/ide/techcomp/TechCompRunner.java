package ap.ide.techcomp;

/**
 * 技术组件执行器
 * 
 * @author tan.ch
 *
 */
public class TechCompRunner {
    /**
     * 构造方法
     */
    private TechCompRunner() {
    }

    /**
     * 技术组件执行器
     * 
     * @author tan.ch
     *
     */
    @FunctionalInterface
    public interface TcRunner {
        /**
         * 执行业务逻辑，若抛出异常则走0分支，否则走1分支
         * 
         * @return 出参
         * @throws Exception 异常
         */
        public Object[] run() throws Exception;
    }

    /**
     * 技术组件执行器（带bean）
     * 
     * @author tan.ch
     *
     * @param <T> bean类型
     */
    @FunctionalInterface
    public interface TcBeanRunner<T> {
        /**
         * 执行业务逻辑，若抛出异常则走0分支，否则走1分支
         * 
         * @param bean bean
         * @return 出参
         * @throws Exception 异常
         */
        public Object[] run(T bean) throws Exception;
    }
}
