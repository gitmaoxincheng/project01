package tc.platform.component.communicate;

import java.util.Map;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.CIResult;
import tc.platform.util.ConvertUtils;
import tc.platform.util.message.SoapUtils;

/**
 * Soap处理类组件
 * 
 * @date 20190528 17:25:18
 */
@ComponentGroup(level = "平台", groupName = "通讯类组件")
public class P_Soap {

	/**
	 * @category SOAP拆包
	 * @param from
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param target
	 *            入参|取键|{@link java.lang.String}
	 * @param length
	 *            入参|soap报文长度|int
	 * @param flag
	 *            入参|是否拆报文体|boolean
	 * @since to 出参|返回容器|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "from", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "target", comment = "取键", type = java.lang.String.class),
			@Param(name = "length", comment = "soap报文长度", type = int.class),
			@Param(name = "flag", comment = "是否拆报文体", type = boolean.class) })
	@OutParams(param = { @Param(name = "to", comment = "返回容器", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "SOAP拆包", style = "判断型", type = "同步组件", comment = "SOAP拆包", date = "20190528 08:45:15")
	public static TCResult P_SoapUnpack(JavaDict from, String target, int length, boolean flag) {
		AppLogger.info("soap拆包 P_SoapUnpack() 开始");
		try {
			byte[] message = (byte[]) from.getItem(target);
			AppLogger.info("打印soap请求报文string: " + new String(message));
			byte[] soap = new byte[message.length - length];
			System.arraycopy(message, length, soap, 0, soap.length);
			JavaDict soapDict = new JavaDict();
			Map<String, Object> soapMap = null;
			try {
				soapMap = SoapUtils.parseSoapMessage(soap);
			} catch (Exception e) {
				AppLogger.error("soap报文转Map<String, Object>失败: " + e);
				AppLogger.error(e);
				return CIResult.newFailureResult(CommonErrorCodeEnum.SOAPBYTE_TO_MAP_ERROR);
			}
			try {
				ConvertUtils.map2Dict(soapMap, soapDict);
			} catch (Exception e) {
				AppLogger.error("soap报文转JavaDict失败: " + e);
				AppLogger.error(e);
				return CIResult.newFailureResult(CommonErrorCodeEnum.SOAPMAP_TO_DICT_ERROR);
			}
			AppLogger.info("打印解析后soap请求报文dict: " + soapMap);
			soapDict =null; //XXXX
			AppLogger.info("打印处理后soap请求报文dict: " + soapDict);
			return CIResult.newSuccessResult(soapDict);
		} catch (Exception e) {
			AppLogger.error("P_SoapUnpack(): " + e);
			AppLogger.error(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.UNPACK_SOAP_ERR);
		} finally {
			AppLogger.info("soap拆包 P_SoapUnpack() 结束");
		}
	}

	/**
	 * @category SOAP拼包
	 * @param fromReq
	 *            入参|请求交易容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param fromRsp
	 *            入参|返回交易容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since to 出参|返回容器|{@link java.lang.String}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "fromReq", comment = "请求交易容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "fromRsp", comment = "返回交易容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "to", comment = "返回容器", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "SOAP拼包", style = "判断型", type = "同步组件", comment = "SOAP拼包", date = "20190529 12:00:18")
	public static TCResult P_SoapPacket(JavaDict fromReq, JavaDict fromRsp) {
		AppLogger.info("soap拼包  P_JsonPacket() 开始");
		try {
			Map<String, Object> dict = null;
			AppLogger.info("打印拼包后soap报文dict：" + dict);
			return CIResult.newSuccessResult(dict);
		} catch (Exception e) {
			AppLogger.info("P_SoapPacket():" + e);
			AppLogger.error(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.PACKET_SOAP_ERR);
		} finally {
			AppLogger.info("soap拼包  P_SoapPacket() 结束");
		}
	}

}
