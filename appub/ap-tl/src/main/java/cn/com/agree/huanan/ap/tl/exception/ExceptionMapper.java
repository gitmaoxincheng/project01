package cn.com.agree.huanan.ap.tl.exception;

/**
 * 异常映射器
 * 
 * @author tan.ch
 *
 */
@FunctionalInterface
public interface ExceptionMapper {
    /**
     * 映射
     * @param exceptionId 异常标识（类名）
     * @param errorMsgArgs 错误信息参数
     * @return 错误信息，包含[errorCode, errorMsg]
     */
    public String[] map(String exceptionId,int index, Object[] errorMsgArgs);
}
