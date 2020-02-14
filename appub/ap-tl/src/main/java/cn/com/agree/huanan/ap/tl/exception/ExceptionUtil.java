package cn.com.agree.huanan.ap.tl.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import cn.com.agree.huanan.ap.tl.exception.tech.ApSystemException;

/**
 * 异常工具
 * 
 * @author tan.ch
 *
 */
public class ExceptionUtil {
    private ExceptionUtil() {
    }

    /**
     * 获取堆栈
     * 
     * @param ex 异常
     * @return 堆栈
     */
    public static String getStackTrace(Throwable ex) {
        StringWriter strWriter = new StringWriter();
        PrintWriter prtWriter = new PrintWriter(strWriter);
        ex.printStackTrace(prtWriter);
        return strWriter.toString();
    }

    /**
     * 转换异常
     * 
     * @param ex 源异常
     * @return 如果{@code ex}为{@link cn.com.agree.huanan.ap.tl.exception.ApException}则原样返回，否则返回{@link cn.com.agree.huanan.ap.tl.exception.tech.ApSystemException}
     */
    public static ApException convert(Throwable ex) {
        if (ex instanceof ApException) {
            return (ApException) ex;
        } else {
            return new ApSystemException(ex);
        }
    }
    
    public static RuntimeException convertToRuntimeException(Throwable ex) {
        if (ex instanceof RuntimeException) {
            return (RuntimeException) ex;
        } else {
            return new RuntimeException(ex);
        }
    }
}
