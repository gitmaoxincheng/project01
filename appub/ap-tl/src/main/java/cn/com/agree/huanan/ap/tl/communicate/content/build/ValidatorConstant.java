/**
 * 
 */
package cn.com.agree.huanan.ap.tl.communicate.content.build;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xqq
 * 校验方法参数类
 */
public final class ValidatorConstant {
  public static final String ENCODING_DEFAULT = "UTF-8";
  
  public ValidatorConstant() {
	// TODO 自动生成的构造函数存根
}
  @Setter
  @Getter
  private String encoding = ENCODING_DEFAULT;
}
