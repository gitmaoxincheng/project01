package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.build;

import java.util.ArrayList;
import java.util.Map;
import cn.com.agree.huanan.ap.tl.communicate.content.build.StringMsgBuilder;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat;
import cn.com.agree.huanan.ap.tl.message.std.MessageParser;

/**
 * @author xqq hcp
 * 拼包处理工具类
 */
public class MessageUtil {
	
	/**
	 * 拼接字符串报文
	 * @param messageContent 报文请求值容器
	 * @param msgFormat 拼包所用的接口字段配置类
	 * @param parser 拼包所有的处理类
	 * @param encoding 报文编码
	 * @param checkField 是否校验报文字段
	 * @return Object报文 对象
	 */
	public static Object packStringMsg(Map messageContent, ArrayList<MsgFormat> msgFormat,
			MessageParser parser, String encoding, boolean checkField) {
		StringMsgBuilder builder = new StringMsgBuilder();
		Map<String,Object> ioResult = builder.init(messageContent, msgFormat,checkField);
		return parser.pack(ioResult,encoding);
	}
	
	/**
	 * 拆分报文字段
	 * @param message 收到的字节流报文
	 * @param msgFormat 拆包所用格式
	 * @param parser 拆包处理对象
	 * @param encoding 报文编码
	 * @param checkField 是否校验报文字段
	 * @return 检验通过后的报文容器
	 */
	public static Map<String, Object> unpackStringMsg(byte[] message, ArrayList<MsgFormat> msgFormat,
			MessageParser parser, String encoding, boolean checkField) {
		Map <String, Object> messMap = parser.unpack(message, encoding);
		StringMsgBuilder builder = new StringMsgBuilder();
		return builder.init(messMap, msgFormat,checkField);
	}
}
