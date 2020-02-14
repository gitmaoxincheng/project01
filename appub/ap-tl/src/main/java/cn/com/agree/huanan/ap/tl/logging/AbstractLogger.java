package cn.com.agree.huanan.ap.tl.logging;

import java.util.function.Consumer;
import java.util.function.Supplier;

import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;

/**
 * 日志（抽象）
 * 
 * @author tan.ch
 *
 */
public abstract class AbstractLogger implements Logger {
    /** 模块类型 */
    protected final Class<?> modType;

    /** 是否已初始化 */
    private volatile boolean isInitialized = false;

    // debug
    /** debug是否启用判断方法 */
    protected Supplier<Boolean> isDebugEnabled;
    /** debug日志方法.无格式化参数 */
    protected Consumer<String> logDebug;

    // info
    /** info是否启用判断方法 */
    protected Supplier<Boolean> isInfoEnabled;
    /** info日志方法.无格式化参数 */
    protected Consumer<String> logInfo;

    // error
    /** error是否启用判断方法 */
    protected Supplier<Boolean> isErrorEnabled;
    /** error日志方法.无格式化参数 */
    protected Consumer<String> logError;

    /**
     * 构造方法
     * 
     * @param modType 模块类型
     */
    public AbstractLogger(Class<?> modType) {
        this.modType = modType;
    }

    @Override
    public void debug(String msg) {
        logInternal(LogLevel.DEBUG, msg);
    }

    @Override
    public void debug(String msg, Object arg1) {
        logInternal(LogLevel.DEBUG, msg, arg1);
    }

    @Override
    public void debug(String msg, Object arg1, Object arg2) {
        logInternal(LogLevel.DEBUG, msg, arg1, arg2);
    }

    @Override
    public void debug(String msg, Object... args) {
        logInternal(LogLevel.DEBUG, msg, args);
    }

    @Override
    public void info(String msg) {
        logInternal(LogLevel.INFO, msg);
    }

    @Override
    public void info(String msg, Object arg1) {
        logInternal(LogLevel.INFO, msg, arg1);
    }

    @Override
    public void info(String msg, Object arg1, Object arg2) {
        logInternal(LogLevel.INFO, msg, arg1, arg2);
    }

    @Override
    public void info(String msg, Object... args) {
        logInternal(LogLevel.INFO, msg, args);
    }

    @Override
    public void error(String msg) {
        logInternal(LogLevel.ERROR, msg);
    }

    @Override
    public void error(String msg, Object arg1) {
        logInternal(LogLevel.ERROR, msg, arg1);
    }

    @Override
    public void error(String msg, Object arg1, Object arg2) {
        logInternal(LogLevel.ERROR, msg, arg1, arg2);
    }

    @Override
    public void error(String msg, Object... args) {
        logInternal(LogLevel.ERROR, msg, args);
    }

    @Override
    public void exception(Throwable ex) {
        exception(null, ex);
    }

    @Override
    public void exception(String msg, Throwable ex) {
        // 输出提示信息
        if (msg != null) {
            error(msg);
        }
        // 转换为String
        String stackTrace = ExceptionUtil.getStackTrace(ex);
        // 输出
        logInternal(LogLevel.ERROR, stackTrace);
    }

    /**
     * 初始化日志，子类需要在本方法初始化各protected变量
     * 
     */
    protected abstract void initLogger();

    /**
     * 日志
     * 
     * @param level 级别
     * @param msg 信息
     */
    protected void logInternal(LogLevel level, String msg) {
        logInternal(level, msg, (Object[]) null);
    }

    /**
     * 日志（内部）
     * 
     * @param level 级别
     * @param msg 信息
     * @param arg1 参数1
     */
    protected void logInternal(LogLevel level, String msg, Object arg1) {
        logInternal(level, msg, new Object[] {
            arg1
        });
    }

    /**
     * 日志（内部）
     * 
     * @param level 级别
     * @param msg 信息
     * @param arg1 参数1
     * @param arg2 参数2
     */
    protected void logInternal(LogLevel level, String msg, Object arg1, Object arg2) {
        logInternal(level, msg, new Object[] {
                arg1,
                arg2
        });
    }

    /**
     * 日志（内部）
     * 
     * @param level 级别
     * @param msg 信息
     * @param args 参数
     */
    protected void logInternal(LogLevel level, String msg, Object[] args) {
        // 未初始化
        if (!isInitialized) {
            synchronized (this) {
                if (!isInitialized) {
                    // 初始化日志
                    initLogger();
                    // 标记已初始化
                    isInitialized = true;
                }
            }
        }

        // 处理级别
        Supplier<Boolean> isLevelEnabled;
        Consumer<String> log0;
        if (level == LogLevel.DEBUG) {
            isLevelEnabled = isDebugEnabled;
            log0 = logDebug;
        } else if (level == LogLevel.INFO) {
            isLevelEnabled = isInfoEnabled;
            log0 = logInfo;
        } else if (level == LogLevel.ERROR) {
            isLevelEnabled = isErrorEnabled;
            log0 = logError;
        } else {
            // 未知
            return;
        }
        // 级别关闭，不输出
        if (!isLevelEnabled.get()) {
            return;
        }
        // 有上送参数
        if (args != null && args.length > 0) {
            // 格式化参数：("name = %s", "agree") -> "name = agree"
            msg = String.format(msg, args);
        }
        // 输出
        log0.accept(msg);
    }
}
