package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.message;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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
public class QmsPXmlParserImpl extends XmlParserImpl {
	public static final Logger logger = Logger.getLogger(QmsPXmlParserImpl.class);
 
    @Override
    public Map<String, Object> unpack(Object msgObject, String encoding) {
        try { 
			byte[] msg = (byte[]) msgObject;
//			int headerLen = 8;
//			int fixedLen = 141;
			byte[] totalLen =  new byte[8];
			byte[] MsgHeader = new byte[141];
			System.arraycopy(msg, 0, totalLen, 0, 8);
			System.arraycopy(msg, 8, MsgHeader, 0, 141);
			logger.debug("报文总长"+new String(totalLen,encoding));
			logger.debug("报文头："+new String(MsgHeader,encoding));
			Map<String, Object> header = new HashMap<String, Object>();//消息头字典
			header.put("Start",new String(MsgHeader,0,3,encoding));		//起始标识
			header.put("M_XMLVer", new String(MsgHeader,3,2,encoding)); //版本号
			header.put("M_CustomerNo", new String(MsgHeader,5,10,encoding));//消费方系统编号
			header.put("M_ServicerNo", new String(MsgHeader,15,10,encoding));//服务方系统编号
			header.put("M_PackageType", new String(MsgHeader,25,6,encoding));//报文类型
			header.put("M_ServiceCode", new String(MsgHeader,31,30,encoding));//服务代码
			header.put("M_MesgSndDate", new String(MsgHeader,61,8,encoding));//报文发起日期
			header.put("M_MesgSndTime", new String(MsgHeader,69,6,encoding));//报文发起时间
			header.put("M_MesgId", new String(MsgHeader,75,20,encoding));//报文消息ID
			header.put("M_MesgRefId", new String(MsgHeader,95,20,encoding));//报文消息参考号
			header.put("M_MesgPriority", new String(MsgHeader,115,1,encoding));//报文优先级
			header.put("M_Direction", new String(MsgHeader,116,1,encoding));//报文方向
			header.put("M_CallMethod", new String(MsgHeader,117,1,encoding));//调用方式
			header.put("M_Reserve", new String(MsgHeader,118,20,encoding));//（保留域）
			header.put("End", new String(MsgHeader,138,3,encoding));//结束标识
			byte[] SecureHeader = new byte[8];
			System.arraycopy(msg, 149, SecureHeader, 0, 8);
			logger.debug("安全信息头："+new String(SecureHeader,encoding));
			header.put("__OriQmsMsgCtx__", MsgHeader);
			header.put("__OriQmsSecCtx__", SecureHeader);	//保留安全信息头，现在并没有使用

			//TODO 读安全信息头，因为现在排队不启用安全信息头，可不读
			byte[] msgBody = new byte[msg.length - 157];
			System.arraycopy(msg, 157, msgBody, 0, msgBody.length);
			logger.debug("报文体："+new String(msgBody,encoding));
			Map<String, Object> content = XmlUtils.parseQmsPXmlReqMsg(msgBody, encoding);
			Map<String, Object> qmsMap = new HashMap<>();
			qmsMap.put("MsgHeader",header);
			qmsMap.putAll(content);
			logger.debug("返回解析容器："+qmsMap);
            return  qmsMap;
        } catch (UnsupportedEncodingException e) {
            throw new ApUnsupportedEncodingException(e);
		}
    }
    
    
    @Override
    public Object pack(Map<String, Object> msgMap, String encoding) {
    	
    	Object msgHeader =  msgMap.get("__OriQmsMsgCtx__");
    	Object secureHeader =  msgMap.get("__OriQmsSecCtx__");
    	Map<String, Object> reqHdr =  (Map<String, Object>)msgMap.get("RspHdr");
    	Map<String, Object> content =  (Map<String, Object>)msgMap.get("Content");
    	Map<String, Object> msgBody =  new HashMap<>();
    	msgBody.put("ReqHdr", reqHdr);
    	msgBody.put("Content", content);
    	logger.debug("MsgHeader: "+msgHeader);
    	logger.debug("SecureHeader: "+secureHeader);
    	logger.debug("MsgBody: "+msgBody);
    	String msgStr = null;
        try {
        	msgStr = XmlUtils.buildQmsPXmlRspMsg(msgBody, encoding);
		} catch (Exception e) {
			throw new ApXmlParseException(e);
		}
        byte[] resultByte = null;
        try {
			msgStr = new String((byte[])msgHeader,encoding) + new String((byte[])secureHeader,encoding)+msgStr; //待改进 XXX，可用拷贝字节数组方法
			byte[] msgBytes = msgStr.getBytes();
			String msgLength = StrUtil.lJust(String.valueOf(msgBytes.length), 8, '0');
			resultByte = new byte[8 + msgBytes.length];
			System.arraycopy(msgLength.getBytes(), 0, resultByte, 0, 8);
			System.arraycopy(msgBytes, 0, resultByte, 8, msgBytes.length);
		} catch (UnsupportedEncodingException e1) {
			throw new ApUnsupportedEncodingException(e1);
		}
        //临时处理
    	return resultByte;
    }

    @Override
    public String mapToXml(Map<String, Object> map,String encoding) {

        return null;
    }

	@Override
	public Map<String, Object> xmlToMap(String xmlString, String encoding) {
		// TODO 自动生成的方法存根
		return null;
	}
}
