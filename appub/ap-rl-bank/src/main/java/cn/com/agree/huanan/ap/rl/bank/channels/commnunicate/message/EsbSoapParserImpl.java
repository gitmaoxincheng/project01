package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.message;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.utils.SoapUtils;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIOException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApUnsupportedEncodingException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApXmlParseException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.impl.SoapParserImpl;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

/**
 * @author hcp
 * DGYH_ESB拆拼包方法类
 */
@Component
public class EsbSoapParserImpl extends SoapParserImpl {
    
	public static final Logger logger = Logger.getLogger(EsbSoapParserImpl.class);

	
	@Override
	public Map<String, Object> unpack(Object msgObject, String encoding) {
		Map<String, Object> messageMap = null;
		try {
			byte[] msg = (byte[]) msgObject;
			byte[] msgBody = new byte[msg.length - 8];
			System.arraycopy(msg, 8, msgBody, 0, msgBody.length);
			messageMap = soaptomap(new String( (byte[]) msgBody, encoding), encoding);
		} catch (UnsupportedEncodingException e) {
            throw new ApUnsupportedEncodingException(e);
		}
		return messageMap;
	}
	

	@Override
	public Object pack(Map<String, Object> msgMap, String encoding) {	//改成返回String 
		String soapMsg = maptosoap(msgMap, encoding);
		byte[] soapRet = soapMsg.getBytes();
		String msgLength = StrUtil.lJust(String.valueOf(soapRet.length), 8, '0');
		byte[] resultByte = new byte[8 + soapRet.length];
		System.arraycopy(msgLength.getBytes(), 0, resultByte, 0, 8);
		System.arraycopy(soapRet, 0, resultByte, 8, soapRet.length);
		String result;
		try {
			result = new String(resultByte, encoding);
		} catch (UnsupportedEncodingException e) {
            throw new ApUnsupportedEncodingException(e);
		}
		return result;
	}
	
	@Override 
	public Map<String, Object> soaptomap(String soapmessage, String encoding) {
		logger.info("打印soapMsg: " + soapmessage);
		byte[] soap = soapmessage.getBytes(); // XXX
		try {
			return SoapUtils.parseSoapMessage(soap,encoding);
		} catch (IOException e) {
			throw new ApIOException(e);
		} catch (XMLStreamException e) {
			throw new ApXmlParseException(e);

		}
	}
	
	@Override
	public String maptosoap(Map<String, Object> msgMap, String encoding) {
		String  reqSysId = (String)msgMap.get("ReqSysId");
		String  proSysId = (String)msgMap.get("ProSysId");
		String  reqMsgId = (String)msgMap.get("ReqMsgId");
		String  svcCode = (String)msgMap.get("SvcCode");
		String  scnCode = (String)msgMap.get("ScnCode");
		msgMap.remove("ReqSysId");msgMap.remove("ProSysId");msgMap.remove("ReqMsgId");msgMap.remove("SvcCode");msgMap.remove("ScnCode");
		String result =null;
		try {
			byte[] soapRet  = SoapUtils.buildResponseSoapMessage(reqSysId, proSysId, reqMsgId, svcCode,scnCode, msgMap, encoding);
			result = new String(soapRet, encoding);
			logger.debug("打印soap响应报文：" + result);
			return result;
		} catch (IOException e) {
			throw new ApIOException(e);
		} catch (XMLStreamException e) {
			throw new ApXmlParseException(e);
		}
	}
	

}
