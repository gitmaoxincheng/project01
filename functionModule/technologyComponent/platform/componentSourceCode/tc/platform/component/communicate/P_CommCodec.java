package tc.platform.component.communicate;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.util.StringUtils;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.constant.communication.HttpCodec;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.CIResult;
import tc.platform.util.StringUtil;
import tc.platform.util.message.SoapUtils;

/**
 * 通讯组件
 * 
 * @date 20190523 9:4:49
 */
@ComponentGroup(level = "平台", groupName = "通讯类组件")
public class P_CommCodec {
	public static final Logger logger = Logger.getLogger(P_CommCodec.class);

	/**
	 * @category HTTP响应报文(字符型)
	 * @param status
	 *            入参|响应状态代码 ，如200, 502|{@link java.lang.String}
	 * @param headers
	 *            入参|头部信息字典|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param content
	 *            入参|报文内容|{@link java.lang.String}
	 * @param encoding
	 *            入参|编码,默认使用UTF8|{@link java.lang.String}
	 * @param version
	 *            入参|http报文版本|{@link java.lang.String}
	 * @since response 出参|HTTP响应报文，设置到 __RSP__['__SNDPCK__']，以便返回给客户端|byte
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "status", comment = "响应状态代码 ，如200, 502", type = java.lang.String.class),
			@Param(name = "headers", comment = "头部信息字典", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "content", comment = "报文内容", type = java.lang.String.class),
			@Param(name = "encoding", comment = "编码,默认使用UTF8", type = java.lang.String.class),
			@Param(name = "version", comment = "http报文版本", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "response", comment = "HTTP响应报文，设置到 __RSP__['__SNDPCK__']，以便返回给客户端", type = byte[].class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "HTTP响应报文(字符型)", style = "判断型", type = "同步组件", comment = "HTTP响应报文(字符型)", date = "20190523 10:12:24")
	public static TCResult P_HttpRspStrPack(String status, JavaDict headers, String content, String encoding,
			String version) {
		byte[] bytes;
		try {
			bytes = content.getBytes(encoding);
		} catch (UnsupportedEncodingException e) {
			logger.exception(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.PACKET_JSON_ERR);
		}
		return P_HttpRspBytePack(status, headers, bytes, encoding, version);
	}

	/**
	 * @category HTTP响应报文(字节型)
	 * @param status
	 *            入参|响应状态代码 ，如200, 502|{@link java.lang.String}
	 * @param headers
	 *            入参|头部信息字典|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param content
	 *            入参|报文内容|byte
	 * @param encoding
	 *            入参|编码,默认使用UTF8|{@link java.lang.String}
	 * @param version
	 *            入参|http报文版本|{@link java.lang.String}
	 * @since response 出参|HTTP响应报文，设置到 __RSP__['__SNDPCK__']，以便返回给客户端|byte
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = { @Param(name = "status", comment = "响应状态代码 ，如200, 502", type = java.lang.String.class),
			@Param(name = "headers", comment = "头部信息字典", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "content", comment = "报文内容", type = byte[].class),
			@Param(name = "encoding", comment = "编码,默认使用UTF8", type = java.lang.String.class),
			@Param(name = "version", comment = "http报文版本", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "response", comment = "HTTP响应报文，设置到 __RSP__['__SNDPCK__']，以便返回给客户端", type = byte[].class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "HTTP响应报文(字节型)", style = "判断型", type = "同步组件", comment = "HTTP响应报文(字节型)", date = "2019-12-02 03:35:18")
	public static TCResult P_HttpRspBytePack(String status, JavaDict headers, byte[] contentBytes, String encoding,
			String version) {
		if (StringUtils.isNullOrEmpty(encoding)) {
			encoding = CommConstant.DEFAULT_CHARSET;
		}
		if (StringUtils.isNullOrEmpty(version)) {
			version = CommConstant.DEFAULT_VERSION;
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeBytes(version);
			dos.writeByte(CommConstant.SP);
			dos.writeBytes(status);
			dos.writeByte(CommConstant.SP);
			dos.writeBytes(HttpCodec.getReason(Integer.parseInt(status)));
			dos.write(CommConstant.CRLF);
			if (headers != null) {
				Iterator<Entry<Object, Object>> headerIterator = headers.entrySet().iterator();
				while (headerIterator.hasNext()) {
					Map.Entry<Object, Object> entry = headerIterator.next();
					dos.write(((String) entry.getKey()).getBytes(encoding));
					dos.write(CommConstant.HEADER_SEPARATOR);
					dos.write(((String) entry.getValue()).getBytes(encoding));
					dos.write(CommConstant.CRLF);
				}
			}
			if (headers == null || !headers.hasKey(CommConstant.PCK_LENGTH)) {
				dos.writeBytes(CommConstant.PCK_LENGTH);
				dos.write(CommConstant.HEADER_SEPARATOR);
				dos.writeBytes(String.valueOf(contentBytes.length));
				dos.write(CommConstant.CRLF);
			}
			dos.write(CommConstant.CRLF);
			dos.write(contentBytes);
			logger.info("Http响应报文：" + new String(baos.toByteArray(), encoding));
			return CIResult.newSuccessResult(baos.toByteArray());
		} catch (Exception e) {
			logger.exception(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.PACKET_JSON_ERR);
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				return CIResult.newFailureResult(CommonErrorCodeEnum.PACKET_JSON_OS_CLOSE_ERROR);
			}
		}
	}

	/**
	 * @category SOAP响应报文
	 * @param rspMap
	 *            入参|soap响应报文|{@link java.util.Map}
	 * @param requestSystemId
	 *            入参|服务请求方标识Address|{@link java.lang.String}
	 * @param providerSystemId
	 *            入参|providerSystemId预留,无需送值|{@link java.lang.String}
	 * @param reqMessageId
	 *            入参|reqMessageId预留,无需送值|{@link java.lang.String}
	 * @param serviceNameEn
	 *            入参|服务编码serviceNameEn|{@link java.lang.String}
	 * @param operationNameEn
	 *            入参|场景编码operationNameEn|{@link java.lang.String}
	 * @param length
	 *            入参|报文头长度|int
	 * @since soapBytes 出参|soap报文对应的字节流|byte
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "rspMap", comment = "soap响应报文", type = java.util.Map.class),
			@Param(name = "requestSystemId", comment = "服务请求方标识Address", type = java.lang.String.class),
			@Param(name = "providerSystemId", comment = "providerSystemId预留,无需送值", type = java.lang.String.class),
			@Param(name = "reqMessageId", comment = "reqMessageId预留,无需送值", type = java.lang.String.class),
			@Param(name = "serviceNameEn", comment = "服务编码serviceNameEn", type = java.lang.String.class),
			@Param(name = "operationNameEn", comment = "场景编码operationNameEn", type = java.lang.String.class),
			@Param(name = "length", comment = "报文头长度", type = int.class) })
	@OutParams(param = { @Param(name = "soapBytes", comment = "soap报文对应的字节流", type = byte[].class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "SOAP响应报文", style = "判断型", type = "同步组件", comment = "SOAP响应报文", date = "20190530 04:41:28")
	public static TCResult P_SoapResponsePacket(Map rspMap, String requestSystemId, String providerSystemId,
			String reqMessageId, String serviceNameEn, String operationNameEn, int length) {
		logger.info("SOAP响应报文 P_SoapResponsePacket() 开始");
		try {
			byte[] soapRet = null;
			soapRet = SoapUtils.buildResponseSoapMessage(requestSystemId, providerSystemId, reqMessageId, serviceNameEn,
					operationNameEn, rspMap, CommConstant.ENCODING_UTF8);
			logger.info("打印soap响应报文：" + new String(soapRet, CommConstant.ENCODING_UTF8));
			String msgLength = String.valueOf(soapRet.length);
			msgLength = StringUtil.rJust(msgLength, length, "0");
			byte[] result = new byte[length + soapRet.length];
			System.arraycopy(msgLength.getBytes(), 0, result, 0, 8);
			System.arraycopy(soapRet, 0, result, 8, soapRet.length);
			logger.info("打印soap响应报文：" + new String(result, CommConstant.ENCODING_UTF8));
			return CIResult.newSuccessResult(result);
		} catch (Exception e) {
			logger.error("拼接soap响应报文失败: " + e);
			logger.exception(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.PACKET_SOAP_ERR);
		}
	}

}
