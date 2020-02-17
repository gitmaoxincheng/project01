package tc.platform.component.communicate;

import java.util.Map;

import ap.ide.utils.JavaDictUtil;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.utils.SealAPI;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.CIResult;
import tc.platform.util.StringUtil;
import tc.platform.util.message.XmlUtils;

/**
 * Xml处理类组件
 * 
 * @date 2019-06-30 11:56:3
 */
@ComponentGroup(level = "平台", groupName = "通讯类组件")
public class P_Xml {

	/**
	 * @category Eci_Xml报文拆包
	 * @param from
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param key
	 *            入参|取键|{@link java.lang.String}
	 * @param length
	 *            入参|报文头长度|int
	 * @param encoding
	 *            入参|报文编码|{@link java.lang.String}
	 * @since outDict
	 *        出参|返回容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "from", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "key", comment = "取键", type = java.lang.String.class),
			@Param(name = "length", comment = "报文头长度", type = int.class),
			@Param(name = "encoding", comment = "报文编码", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "outDict", comment = "返回容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "Eci_Xml报文拆包", style = "判断型", type = "同步组件", comment = "Eci_Xml报文拆包", date = "2019-07-13 02:50:13")
	public static TCResult P_XmlUnpack(JavaDict from, String key, int length, String encoding) {
		AppLogger.info("Eci_Xml报文拆包开始");
		try {
			byte[] message = (byte[]) from.getItem(key);
			AppLogger.info("请求报文: " + new String(message));
			byte[] msgBody = new byte[message.length - length];
			System.arraycopy(message, length, msgBody, 0, msgBody.length);
			JavaDict reqDict = new JavaDict();
			AppLogger.info("请求报文: " + new String(msgBody));
			try {
				reqDict = XmlUtils.parseReqXmlMessage(msgBody, encoding);
			} catch (Exception e) {
				AppLogger.error("Xml报文转JavaDict失败: " + e);
				AppLogger.error(e);
				return CIResult.newFailureResult(CommonErrorCodeEnum.UNPACK_XML_ERR);
			}
			AppLogger.info("解析后请求报文Dict: " + reqDict);
			return CIResult.newSuccessResult(reqDict);
		} catch (Exception e) {
			AppLogger.error("Eci_Xml报文拆包失败: " + e);
			AppLogger.error(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.UNPACK_XML_ERR);
		}
	}

	/**
	 * @category Eci_Xml报文拼包
	 * @param inDict
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param encoding
	 *            入参|报文编码|{@link java.lang.String}
	 * @param length
	 *            入参|报文头长度|int
	 * @since outBytes 出参|返回数组|{@link Object}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "inDict", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "encoding", comment = "报文编码", type = java.lang.String.class),
			@Param(name = "length", comment = "报文头长度", type = int.class) })
	@OutParams(param = { @Param(name = "outBytes", comment = "返回数组", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "Eci_Xml报文拼包", style = "判断型", type = "同步组件", comment = "Eci_Xml报文拼包", date = "2019-07-13 02:58:39")
	public static TCResult P_XmlPack(JavaDict inDict, String encoding, int length) {
		AppLogger.info("Eci_Xml报文拼包开始");
		try {
			AppLogger.info("拼包内容: " + inDict);
			Map<String, Object> message = JavaDictUtil.dictToMap(inDict);
			byte[] outBytes = null;
			byte[] result = null;
			try {
				outBytes = XmlUtils.buildRequestMessage(message, encoding);
				String msgLength = String.valueOf(outBytes.length);
				msgLength = StringUtil.rJust(msgLength, length, "0");
				result = new byte[length + outBytes.length];
				System.arraycopy(msgLength.getBytes(), 0, result, 0, 8);
				System.arraycopy(outBytes, 0, result, 8, outBytes.length);
				AppLogger.info("打印Xml响应报文：" + new String(result, CommConstant.ENCODING_UTF8));
			} catch (Exception e) {
				AppLogger.error("Xml报文转JavaDict失败: " + e);
				AppLogger.error(e);
				return CIResult.newFailureResult(CommonErrorCodeEnum.UNPACK_XML_ERR);
			}
			AppLogger.info("解析后请求报文Dict: " + new String(outBytes));
			return CIResult.newSuccessResult(result);
		} catch (Exception e) {
			AppLogger.error("Eci_Xml报文拆包失败: " + e);
			AppLogger.error(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.UNPACK_XML_ERR);
		}
	}

	

	/**
	 * @category Svs_Xml报文拆包
	 * @param from
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param key
	 *            入参|取键|{@link java.lang.String}
	 * @param length
	 *            入参|报文头长度|int
	 * @param encoding
	 *            入参|报文编码|{@link java.lang.String}
	 * @since outDict
	 *        出参|返回容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "from", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "key", comment = "取键", type = java.lang.String.class),
			@Param(name = "length", comment = "报文头长度", type = int.class),
			@Param(name = "encoding", comment = "报文编码", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "outDict", comment = "返回容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "Svs_Xml报文拆包", style = "判断型", type = "同步组件", comment = "Eci_Xml报文拆包", date = "2019-07-13 02:50:13")
	public static TCResult P_SvsXmlUnpack(JavaDict from, String key, int length, String encoding) {
		AppLogger.info("Svs_Xml报文拆包开始");
		try {
			byte[] message = (byte[]) from.getItem(key);
			AppLogger.info("请求报文: " + new String(message));
//			byte[] msgBody = new byte[message.length - length];
//			System.arraycopy(message, length, msgBody, 0, msgBody.length);
			Map reqMap = null;
//			AppLogger.info("请求报文: " + new String(msgBody));
			try {
				reqMap = SealAPI.parseSvsXmlRspMsgfromByte(message, encoding);
			} catch (Exception e) {
				AppLogger.error("Xml报文转JavaDict失败: " + e);
				AppLogger.error(e);
				return CIResult.newFailureResult(CommonErrorCodeEnum.UNPACK_XML_ERR);
			}
			return CIResult.newSuccessResult(JavaDictUtil.mapToDict(reqMap));
		} catch (Exception e) {
			AppLogger.error("Eci_Xml报文拆包失败: " + e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.UNPACK_XML_ERR);
		}
	}


	/**
	 * @category Svs_Xml报文拼包
	 * @param inDict
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param encoding
	 *            入参|报文编码|{@link java.lang.String}
	 * @param length
	 *            入参|报文头长度|int
	 * @since outBytes 出参|返回数组|{@link Object}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "inDict", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "encoding", comment = "报文编码", type = java.lang.String.class),
			@Param(name = "length", comment = "报文头长度", type = int.class) })
	@OutParams(param = { @Param(name = "outBytes", comment = "返回数组", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "Svs_Xml报文拼包", style = "判断型", type = "同步组件", comment = "Eci_Xml报文拼包", date = "2019-07-13 02:58:39")
	public static TCResult P_SvsXmlPack(JavaDict inDict, String encoding, int length) {
		AppLogger.info("Svs_Xml报文拼包开始");
		try {
			AppLogger.info("拼包内容: " + inDict);
			Map<String, Object> message = JavaDictUtil.dictToMap(inDict);
			byte[] outBytes = null;
			try {
				outBytes = SealAPI.buildSvsXmlRspMsg(message, encoding);
//				String msgLength = String.valueOf(outBytes.length);
//				msgLength = StringUtil.rJust(msgLength, length, "0");
//				result = new byte[length + outBytes.length];
//				System.arraycopy(msgLength.getBytes(), 0, result, 0, 8);
//				System.arraycopy(outBytes, 0, result, 8, outBytes.length);
				AppLogger.info("打印Xml响应报文：" + new String(outBytes, CommConstant.ENCODING_UTF8));
			} catch (Exception e) {
				AppLogger.error("Xml报文转JavaDict失败: " + e);
				AppLogger.error(e);
				return CIResult.newFailureResult(CommonErrorCodeEnum.UNPACK_XML_ERR);
			}
			AppLogger.info("解析后请求报文Dict: " + new String(outBytes));
			return CIResult.newSuccessResult(outBytes);
		} catch (Exception e) {
			AppLogger.error("Svs_Xml报文拆包失败: " + e);
			AppLogger.error(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.UNPACK_XML_ERR);
		}
	}
	
	
	
	
}
