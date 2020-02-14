/**
 * 
 */
package cn.com.agree.huanan.ap.tl.communicate.content.build;

import java.util.ArrayList;
import java.util.Map;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat;

/**
 * 报文拼接接口
 * @author xqq hcp
 * @param <B>
 * @param <T>
 */
public interface MsgBuilder<B,T>{
	B init(Map msgContentMap, ArrayList<MsgFormat> format,boolean isCheck);
	T check(String fieldValue, FieldNode filedNode);
}
