package cn.com.agree.huanan.ap.tl.logging;

import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * 日志
 * 
 * @author tan.ch
 *
 */
public interface Logger {
    /**
     * 获取日志对象
     * @param modType 模块类型
     * @return 日志
     */
    public static Logger getLogger(Class<?> modType) {
        return SpringUtil.getBean(Logger.class, modType);
    }

    /**
     * 调试
     * 
     * @param msg 信息
     */
    public void debug(String msg);

    /**
     * 调试
     * 
     * @param msg 信息
     * @param arg1 参数1
     */
    public void debug(String msg, Object arg1);

    /**
     * 调试
     * 
     * @param msg 信息
     * @param arg1 参数1
     * @param arg2 参数2
     */
    public void debug(String msg, Object arg1, Object arg2);

    /**
     * 调试
     * 
     * @param msg 信息
     * @param args 参数
     */
    public void debug(String msg, Object... args);

    /**
     * 信息
     * 
     * @param msg 信息
     */
    public void info(String msg);

    /**
     * 信息
     * 
     * @param msg 信息
     * @param arg1 参数1
     */
    public void info(String msg, Object arg1);

    /**
     * 信息
     * 
     * @param msg 信息
     * @param arg1 参数1
     * @param arg2 参数2
     */
    public void info(String msg, Object arg1, Object arg2);

    /**
     * 信息
     * 
     * @param msg 信息
     * @param args 参数
     */
    public void info(String msg, Object... args);

    /**
     * 错误
     * 
     * @param msg 信息
     */
    public void error(String msg);

    /**
     * 错误
     * 
     * @param msg 信息
     * @param arg1 参数1
     */
    public void error(String msg, Object arg1);

    /**
     * 错误
     * 
     * @param msg 信息
     * @param arg1 参数1
     * @param arg2 参数2
     */
    public void error(String msg, Object arg1, Object arg2);

    /**
     * 错误
     * 
     * @param msg 信息
     * @param args 参数
     */
    public void error(String msg, Object... args);

    /**
     * 异常
     * 
     * @param ex 错误
     */
    public void exception(Throwable ex);

    /**
     * 异常
     * 
     * @param msg 信息
     * @param ex 错误
     */
    public void exception(String msg, Throwable ex);
}
