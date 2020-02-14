package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.message;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.utils.SealAPI;
import cn.com.agree.huanan.ap.tl.exception.tech.ApUnsupportedEncodingException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApXmlParseException;
import cn.com.agree.huanan.ap.tl.message.impl.SoapParserImpl;

/**
 * @author hcp
 * DGYH_ECI拆拼包方法类  
 */

@Component
public class SvsXmlParserImpl extends SoapParserImpl {

	@Override
	public Map<String, Object> soaptomap(String soapmessage, String encoding) {
        try {
            return SealAPI.parseSvsRspMsg(soapmessage, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new ApUnsupportedEncodingException(e);
        } catch (DocumentException e) {
        	throw new ApXmlParseException(e);
		} catch (Exception e) {
        	throw new ApXmlParseException(e);
		}
	}

	@Override
	public String maptosoap(Map<String, Object> messageInfoMap, String encoding) {
		
        try {
            return SealAPI.buildSvsReqMsg(messageInfoMap, encoding);
		} catch (Exception e) {
        	throw new ApXmlParseException(e);
		}
	}
}
