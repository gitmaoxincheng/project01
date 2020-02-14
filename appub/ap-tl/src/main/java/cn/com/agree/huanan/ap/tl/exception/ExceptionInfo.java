package cn.com.agree.huanan.ap.tl.exception;

/**
 * 异常信息
 * 
 * @author tan.ch
 *
 */
public interface ExceptionInfo {
    /**
     * 获取错误应用标识
     * 
     * @return 错误应用标识
     */
    public String getErrorAppId();

    /**
     * 获取错误代码
     * 
     * @return 错误代码
     */
    public String getErrorCode();

    /**
     * 获取错误信息
     * 
     * @return 错误信息
     */
    public String getErrorMsg();
}
