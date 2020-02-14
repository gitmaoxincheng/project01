package cn.com.agree.huanan.ap.tl.message.impl;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.http.UnsupportContentTypeException;
import cn.com.agree.huanan.ap.tl.communicate.http.base.Const;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIOException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.std.HttpParser;

/**
 * Http报文解析
 * 
 * @author luo.hp
 *
 */
@Component
public  class HttpParserImpl implements HttpParser {
   
    /**
     * 日志句柄
     */
    public Logger logger =  Logger.getLogger(HttpParserImpl.class);

    @Override
    public Map<String, Object> unpack(Object msgObject, String encoding) {
        return null;
    }

    @Override
    public Object pack(Map<String, Object> msgMap, String encoding) {
        // TODO 自动生成的方法存根
        if (encoding == null) {
            encoding = cn.com.agree.huanan.ap.tl.communicate.comm.base.Const.DEFAULT_ENCODING;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(baos);
        try {
            // Base Info
            dataOutputStream.writeBytes(Const.DEFAULT_HTTP_VERSION_TYPE);
            dataOutputStream.writeByte(Const.SP);
            dataOutputStream.writeBytes(Const.HTTP_SUCCESS_CODE);
            dataOutputStream.writeByte(Const.SP);
            dataOutputStream.writeBytes("OK");
            dataOutputStream.write(Const.CRLF);
            
            // Header
            if (msgMap.containsKey(Const.HEADER_KEY)){
                Object headerObject = (Map<?, ?>) msgMap.get(Const.HEADER_KEY);
                if (headerObject instanceof Map){
                    Map<?, ?>headerMap = (Map<?, ?>) headerObject;
                    for (Entry<?, ?> entry : headerMap.entrySet()) {
                        String keyStr = entry.getKey() == null ? "" : entry.getKey().toString();
                        String valStr = entry.getValue() == null ? "" : entry.getValue().toString();
                        dataOutputStream.write(keyStr.getBytes(encoding));
                        dataOutputStream.write(Const.HEADER_SEPARATOR);
                        dataOutputStream.write(valStr.getBytes(encoding));
                        dataOutputStream.write(Const.CRLF);
                    }
                }
            }
            
            // Content
            if (msgMap.containsKey(Const.CONTENT_KEY)){
                byte[] contentBytes = new byte[]{};
                Object content = msgMap.get(Const.CONTENT_KEY);
                if (content instanceof String) {
                    contentBytes = ((String) content).getBytes(encoding);
                }else if (content instanceof byte[]){
                    contentBytes = (byte[])content;
                }else {
                    logger.error("不支持类型: %s的Http报文", content.getClass().getName());
                    throw UnsupportContentTypeException.getException();
                }
                
                // Content-Length
                dataOutputStream.writeBytes(Const.PCK_LENGTH);
                dataOutputStream.write(Const.HEADER_SEPARATOR);
                dataOutputStream.writeBytes(String.valueOf(contentBytes.length));
                dataOutputStream.write(Const.CRLF);
                dataOutputStream.write(Const.CRLF);
                dataOutputStream.write(contentBytes);
//    			String result = new String(baos.toByteArray(), encoding).trim();
//    			logger.debug("HTTP返回报文: "+result);
            }
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            logger.error(ExceptionUtil.getStackTrace(e));
            throw new ApIOException(e);
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    // TODO 自动生成的 catch 块
                    logger.error(ExceptionUtil.getStackTrace(e));
                }
            }
            if (baos != null ){
                try {
                    baos.close();
                } catch (IOException e) {
                    // TODO 自动生成的 catch 块
                    logger.error(ExceptionUtil.getStackTrace(e));
                }
            }
        }
        return baos.toByteArray();
    }
}
