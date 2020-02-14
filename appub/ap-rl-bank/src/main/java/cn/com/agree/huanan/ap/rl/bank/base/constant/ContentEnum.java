/**
 * 
 */
package cn.com.agree.huanan.ap.rl.bank.base.constant;

/**
 * @author xqq
 * 渠道通讯枚举类
 */
public class ContentEnum {
	/**
	 * 
	 * @author xqq
     *  报文类型枚举
     *  类型包括:字符串,数字,小数,金额,加密报文
	 */
  public static enum MessageType{
	STRING("string"),INT("int"),DECIMALS("decimals"),AMOUNT("amount"),ENCIPHER("encipher");
	private String type;
  	private MessageType(String type){
  		this.type = type;
  	};
  	
  	@Override
  	public String toString() { 
  		// TODO 自动生成的方法存根
  		return type;
  	}
  }

}
