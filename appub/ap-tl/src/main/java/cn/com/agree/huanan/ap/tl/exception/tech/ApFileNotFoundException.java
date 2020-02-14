/**
 * FileName: ApFileNotFoundException
 * Author:   Ren Xiaotian
 * Date:     2018/8/17 15:09
 */

package cn.com.agree.huanan.ap.tl.exception.tech;

/**
 * 自定义异常类：FileNotFoundException
 */
public class ApFileNotFoundException extends ApSystemException {
    /**
     * 构造方法
     *
     * @param ex 源异常
     */
    public ApFileNotFoundException(Exception ex) {
        super(ex);
    }
}
