/**
 * Author: hcp
 * Xml解析异常
 */
package cn.com.agree.huanan.ap.tl.exception.tech;

/**
 * 自定义异常类：Json解析异常
 */
public class ApJsonParseException extends ApSystemException {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;
    /**
     * 构造方法
     *
     * @param ex 源异常
     */
    public ApJsonParseException(Exception ex) {
        super(ex);
    }
}
