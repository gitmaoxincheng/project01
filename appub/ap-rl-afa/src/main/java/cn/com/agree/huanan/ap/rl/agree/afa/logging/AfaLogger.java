
package cn.com.agree.huanan.ap.rl.agree.afa.logging;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.huanan.ap.tl.logging.AbstractLogger;

/**
 * afa日志
 * 
 * @author tan.ch
 *
 */
class AfaLogger extends AbstractLogger {
    /**
     * 模块类型
     * 
     * @param modType 模块类型
     */
    public AfaLogger(Class<?> modType) {
        super(modType);
    }

    @Override
    protected void initLogger() {
        // TODO: 待产品增加日志开关判断的接口再修复
        // debug
        logDebug = AppLogger::debug;
        isDebugEnabled = () -> true;
        // info
        logInfo = AppLogger::info;
        isInfoEnabled = () -> true;
        // error
        logError = AppLogger::error;
        isErrorEnabled = () -> true;
    }
}
