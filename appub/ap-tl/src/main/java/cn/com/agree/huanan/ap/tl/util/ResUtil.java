package cn.com.agree.huanan.ap.tl.util;

import cn.com.agree.huanan.ap.tl.logging.Logger;

public class ResUtil {
    /** 日志 */
    private static final Logger logger = Logger.getLogger(ResUtil.class);

    private ResUtil() {
    }

    /**
     * 关闭资源
     * 
     * @param res 资源
     */
    public static void closeResource(AutoCloseable res) {
        closeResource(res, null);
    }
    /**
     * 关闭资源
     * 
     * @param res 资源
     * @param mainException 主异常
     */
    public static void closeResource(AutoCloseable res, Exception mainException) {
        try {
            res.close();
        } catch (Exception ex) {
            logger.exception("关闭资源发生错误，忽略：", ex);
            // 有上送主异常
            if (mainException != null) {
                // 添加到主异常的抑制信息中
                mainException.addSuppressed(ex);
            }
        }
    }
}
