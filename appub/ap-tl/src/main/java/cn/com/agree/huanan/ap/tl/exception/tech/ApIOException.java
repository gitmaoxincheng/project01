/**
 * FileName: ApIOException
 * Author:   Ren Xiaotian
 * Date:     2018/8/17 15:10
 */

package cn.com.agree.huanan.ap.tl.exception.tech;

/**
 * 自定义异常类：IOException
 */
public class ApIOException extends ApSystemException {
    /**
     * 构造方法
     *
     * @param ex 源异常
     */
    public ApIOException(Exception ex) {
        super(ex);
    }
}
