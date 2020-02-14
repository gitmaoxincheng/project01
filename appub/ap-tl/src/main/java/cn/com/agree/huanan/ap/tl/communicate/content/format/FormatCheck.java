/**
 * 
 */
package cn.com.agree.huanan.ap.tl.communicate.content.format;

import java.util.Map;

/**
 * @author xqq
 * 报文检查接口
 */
@FunctionalInterface
public interface FormatCheck {
  boolean check(Map req, Node msgNode);
}
