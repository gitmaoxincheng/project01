/**
 * FileName: ApIllegalArgumentException
 * Author:   Ren Xiaotian
 * Date:     2018/8/17 15:00
 */

package cn.com.agree.huanan.ap.tl.exception.tech;

/**
 * 自定义异常类：IllegalArgumentException
 */
public class ApIllegalArgumentException extends ApSystemException {
    /**
     * 构造方法
     *
     * @param ex 源异常
     */
    public ApIllegalArgumentException(Exception ex) {
        super(ex);
    }
}
