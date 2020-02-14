package cn.com.agree.huanan.ap.tl.communicate.comm.msg;

import java.io.UnsupportedEncodingException;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.tech.ApUnsupportedEncodingException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

public class Message {
    
    public static final Logger logger =  Logger.getLogger(Message.class);
    
	// 消息类型 0-发送 1-接收
	final private int msgType;
	
	// 消息内容类型 0-String 1-byte[]
	final private int msgContentType;
	
	// 字节流消息
	final private byte [] bMsg;
	
	// 字符串消息
	final private String sMsg;
	
	// 消息编码
	final private String encoding;
	
	
	public Message(int msgType, String msg){
		this.msgType = msgType;
		this.msgContentType = Const.MESSAGE_CONTENT_STRING_TYPE;
		this.encoding = Const.DEFAULT_ENCODING;
		this.sMsg = msg;
		this.bMsg = null;
	}
	
	public Message(int msgType, byte [] msg){
		this.msgType = msgType;
		this.msgContentType = Const.MESSAGE_CONTENT_BYTES_TYPE;
		this.encoding = Const.DEFAULT_ENCODING;
		this.bMsg = msg;
		this.sMsg = null;
	}
	
	public Message(int msgType, String encoding, String msg){
		this.msgType = msgType;
		this.msgContentType = Const.MESSAGE_CONTENT_STRING_TYPE;
		this.encoding = encoding;
		this.sMsg = msg;
		this.bMsg = null;
	}
	
	public Message(int msgType, String encoding, byte [] msg){
		this.msgType = msgType;
		this.msgContentType = Const.MESSAGE_CONTENT_BYTES_TYPE;
		this.encoding = encoding;
		this.sMsg = null;
		this.bMsg = msg;
	}
	
	public int getMsgType(){
		return msgType;
	}
	
	public int getMsgContentType(){
		return msgContentType;
	}
	
	public String getEncoding(){
		return encoding;
	}
	
	// String
	public String getStringMsg(){
		if (msgContentType == Const.MESSAGE_CONTENT_STRING_TYPE)
		{
			return sMsg;
		}
		try {
            return new String(bMsg, this.encoding);
        } catch (UnsupportedEncodingException e) {
            // TODO 自动生成的 catch 块
            logger.error(ExceptionUtil.getStackTrace(e));
            throw new ApUnsupportedEncodingException(e);
        }
	}
	
	// byte []
	public byte[] getBytesMsg(){
		return getBytesMsg(this.encoding);
	}
	
	// byte [] 
	public byte[] getBytesMsg(String encoding){
	    try {
    		if (encoding.equals(this.encoding)){
    			if (msgContentType == Const.MESSAGE_CONTENT_STRING_TYPE){
    			    
                        return sMsg.getBytes(this.encoding);
                    
    			}else{
    			    return bMsg;
    			}
    		}else{
    		    if (msgContentType == Const.MESSAGE_CONTENT_STRING_TYPE){
                    return sMsg.getBytes(encoding);
                }else{
                    return (new String(bMsg, this.encoding)).getBytes(encoding);
                }
    		}
	    } catch (UnsupportedEncodingException e) {
            // TODO 自动生成的 catch 块
            logger.error(ExceptionUtil.getStackTrace(e));
            throw new ApUnsupportedEncodingException(e);
        }
	}
}
