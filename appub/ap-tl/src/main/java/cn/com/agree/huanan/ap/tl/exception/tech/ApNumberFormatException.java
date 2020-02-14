/**
 * FileName: ApNumberFormatException
 * Author:   Ren Xiaotian
 * Date:     2018/8/17 15:03
 */

package cn.com.agree.huanan.ap.tl.exception.tech;

/**
 * 自定义异常类：NumberFormatException
 */
public class ApNumberFormatException extends ApSystemException {
    /**
     * 构造方法
     *
     * @param ex 源异常
     */
    public ApNumberFormatException(Exception ex) {
        super(ex);
    }
}
