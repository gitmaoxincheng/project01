/**
 * FileName: ApUnsupportedEncodingException
 * Author:   Ren Xiaotian
 * Date:     2018/8/17 14:58
 */

package cn.com.agree.huanan.ap.tl.exception.tech;

/**
 * 自定义异常类：UnsupportedEncodingException
 */
public class ApUnsupportedEncodingException extends ApSystemException {
    /**
     * 构造方法
     *
     * @param ex 源异常
     */
    public ApUnsupportedEncodingException(Exception ex) {
        super(ex);
    }
}
