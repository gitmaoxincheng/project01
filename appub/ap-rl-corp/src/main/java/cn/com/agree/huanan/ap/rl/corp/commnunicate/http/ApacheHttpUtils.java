package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.http.NullHttpEntityException;
import cn.com.agree.huanan.ap.tl.communicate.comm.msg.RecvMessage;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author luo.hp
 *
 */
public class ApacheHttpUtils {
	/**
	 * 日志句柄
	 */
	public static final Logger logger =  Logger.getLogger(ApacheHttpUtils.class);
	
	/**
	 * @param entityRes 实体资源
	 * @param encoding 缺省编码
	 * @return 通信结果容器
	 * @throws IOException IO异常
	 */
	public static CommContext getContent(HttpEntity entityRes, String encoding) throws IOException{
    	if (entityRes == null) {
    		logger.error("实体HttpEntity为空");
    		throw NullHttpEntityException.getException();
        }
    	
    	String responseEncoding = encoding;
    	Header encodingHeader = entityRes.getContentEncoding();
    	if (encodingHeader != null && encodingHeader.getValue() != null){
    	    responseEncoding = encodingHeader.getValue();
    	}
    	Charset defaultCharset = Charset.forName(responseEncoding);
    	
    	// ContentType
    	ContentType contentType = null;
        try {
            contentType = ContentType.get(entityRes);
        } catch (final UnsupportedCharsetException ex) {
            logger.info("实体无有效ContentTpye，使用默认");
        }
        // ContentType处理
        if (contentType != null) {
            // 实体无字符集
            if (contentType.getCharset() == null) {
                contentType = contentType.withCharset(defaultCharset);
            }
            // 默认ContentType
        } else {
            contentType = ConstMapAndList.CONTENT_TYPE_TEXT_MAP.get("APPLICATION_JSON").withCharset(defaultCharset);
        }
        
        // 数据流最大大小
        int capacity = (int)entityRes.getContentLength();
        Args.check(entityRes.getContentLength() <= Integer.MAX_VALUE,
                "HTTP entity too large to be buffered in memory");
        if (capacity < 0) {
            capacity = cn.com.agree.huanan.ap.tl.communicate.comm.base.Const.DEFAULT_MAX_BYTES;
        }
        
        // 每次读取数据流大小
        int readSize = cn.com.agree.huanan.ap.tl.communicate.comm.base.Const.DEFAULT_MAX_READ_BYTES;
        // 读实体内容
        InputStream instream = entityRes.getContent();
        if (instream == null) {
            logger.error("读取实体输入流为空");
            return CommContext.getCommAbandonContext(new NullHttpEntityException());
        }        
        try {
            ByteArrayBuffer buffer = new ByteArrayBuffer(capacity);
            byte[] readBuffer = new byte[readSize];
            int nread = -1;
            while((nread = instream.read(readBuffer, 0, readSize)) != -1) {
                buffer.append(readBuffer, 0, nread);
            }
//            logger.debug("RstStr:%s",new String(buffer.toByteArray()));
            return CommContext.getCommContext(new RecvMessage(buffer.toByteArray(), contentType.getCharset().name()));
        } finally {
            instream.close();
        }
    }
}
