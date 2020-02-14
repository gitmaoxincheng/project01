/**
 * FileName: StrUtil
 * Author:   Ren Xiaotian
 * Date:     2018/8/14 11:17
 */

package cn.com.agree.huanan.ap.tl.util;

import java.lang.NullPointerException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 基础判断类
 */
public class Judgment {

	public static Logger logger =  Logger.getLogger(Judgment.class);
	
    /**
     * 基础判断类
     * @param boolObject 判断是否为真对象
     *
     * @return 返回去掉空格后的字符串
     */
	
    public static boolean boolFrame(Object boolObject) {
    	if (boolObject == null) {
			throw new NullPointerException();
		}
		if (boolObject instanceof Boolean) {
			if (((Boolean) boolObject).booleanValue()) {
				return true;
			} else {
				return false;
			}
		} else if (boolObject instanceof Integer) {
			if (((Integer) boolObject).intValue() == 0) {
				return false;
			} else {
				return true;
			}
		} else {
			throw new IllegalArgumentException();
		}
    }
}
