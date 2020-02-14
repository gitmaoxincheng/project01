
package cn.com.agree.huanan.ap.rl.corp.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.agree.huanan.ap.tl.logging.AbstractLogger;

/**
 * afa日志
 * 
 * @author tan.ch
 *
 */
class Slf4jLogger extends AbstractLogger {
    /** slf4j日志对象 */
    private Logger logger;
    /**
     * 模块类型
     * 
     * @param modType 模块类型
     */
    public Slf4jLogger(Class<?> modType) {
        super(modType);
    }

    @Override
    protected void initLogger() {
        // 获取日志对象
        logger = LoggerFactory.getLogger(modType);
        // debug
        logDebug = logger::debug;
        isDebugEnabled = logger::isDebugEnabled;
        // info
        logInfo = logger::info;
        isInfoEnabled = logger::isInfoEnabled;
        // error
        logError = logger::error;
        isErrorEnabled = logger::isErrorEnabled;
    }
}
