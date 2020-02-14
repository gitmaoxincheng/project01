package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.message;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.utils.XmlUtils;
import cn.com.agree.huanan.ap.tl.exception.tech.ApUnsupportedEncodingException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApXmlParseException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.impl.XmlParserImpl;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

/**
 * @author hcp
 * DGYH_ECI拆拼包方法类  
 */

@Component
public class EciXmlParserImpl extends XmlParserImpl {
    
    @Override
    public Map<String, Object> unpack(Object msgObject, String encoding) {
        try {
			byte[] msg = (byte[]) msgObject;
			byte[] msgBody = new byte[msg.length - 8];
			System.arraycopy(msg, 8, msgBody, 0, msgBody.length);
            return XmlUtils.parseEciXmlMessage(msgBody, encoding);
        } catch (Exception e) {
        	throw new ApXmlParseException(e);
		}
    }
    
    @Override
    public String mapToXml(Map<String, Object> map,String encoding) {
    	String msgBody = "";
        try {
        	msgBody = XmlUtils.buildEciXmlMessage(map, encoding);
		} catch (Exception e) {
			throw new ApXmlParseException(e);
		}
        Logger logger = Logger.getLogger(EciXmlParserImpl.class);
        logger.debug("ECI拼接报文:" + msgBody);
		byte[] bodyBytes = msgBody.getBytes();
		String msgLength = StrUtil.lJust(String.valueOf(bodyBytes.length), 8, '0');
		byte[] resultByte = new byte[8 + bodyBytes.length];
		System.arraycopy(msgLength.getBytes(), 0, resultByte, 0, 8);
		System.arraycopy(bodyBytes, 0, resultByte, 8, bodyBytes.length);
		String result;
		try {
			result = new String(resultByte, encoding);
		} catch (UnsupportedEncodingException e) {
            throw new ApUnsupportedEncodingException(e);
		}
        return result;
    }

	@Override
	public Map<String, Object> xmlToMap(String xmlString, String encoding) {
		return null;
	}
	
	
	
	
}
