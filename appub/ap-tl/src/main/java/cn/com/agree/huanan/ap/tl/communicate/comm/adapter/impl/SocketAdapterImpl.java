package cn.com.agree.huanan.ap.tl.communicate.comm.adapter.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.SocketAdapter;
import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.CommAbandException;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;
import cn.com.agree.huanan.ap.tl.communicate.comm.msg.RecvMessage;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.tech.ApCommConnectException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApCommTimeOutException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author luo.hp
 *
 */
@Component
public class SocketAdapterImpl extends CommunicateAdapterImpl implements SocketAdapter{
    
    private final Logger logger = Logger.getLogger(SocketAdapterImpl.class);  
    
    private final static int MAX_BYTES_SIZE = 1024;
    
    protected CommContext commWith(CommParam param, byte[] msg, Map<String, Object> additionParam) {
    	logger.debug("执行Socket通讯过程");
        // 与服务端建立连接
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            socket = new Socket();
            SocketAddress endpoint = new InetSocketAddress(param.getServerIp(), param.getServerPort());
            socket.setSoTimeout(param.getSockTimeOut());
            socket.connect(endpoint, param.getConnTimeOut());
            // 建立连接后获得输出流
            outputStream = socket.getOutputStream();
            socket.getOutputStream().write(msg);
            //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
            socket.shutdownOutput();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[MAX_BYTES_SIZE];
            int len;
            while ((len = inputStream.read(bytes, 0, MAX_BYTES_SIZE)) != -1) {
                bos.write(bytes, 0, len);
            }
            return CommContext.getCommContext(new RecvMessage(bos.toByteArray(), param.getEncoding()));
        } catch (Throwable ex) {
            logger.exception(ex);
                logger.exception(ex);
                // 超时
//                if (ex instanceof TimeoutException) {
                if (ex instanceof SocketTimeoutException || ex instanceof TimeoutException ) {                	
                    return CommContext.getCommAbandonContext(new ApCommTimeOutException(param.getAppId()));

                }
                // 连接错误
                else if (ex instanceof ConnectException) {
                    return CommContext.getCommAbandonContext(new ApCommConnectException(param.getAppId()));
                }
                //其它异常
                return CommContext.getCommAbandonContext(new CommAbandException(param.getAppId()));
        } finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    // TODO 自动生成的 catch 块
                    logger.error(ExceptionUtil.getStackTrace(e));
                }
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO 自动生成的 catch 块
                    logger.error(ExceptionUtil.getStackTrace(e));
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO 自动生成的 catch 块
                    logger.error(ExceptionUtil.getStackTrace(e));
                }
            }
        }
      } 
    
    @Override
    public CommContext comm(CommParam param, byte[] msg, Map<String, Object> additionParam) {
        // TODO 自动生成的方法存根
        return commWith(param, msg, additionParam);
    }

    @Override
    public CommContext comm(CommParam param, String msg, Map<String, Object> additionParam) {
        // TODO 自动生成的方法存根
        try {
            return commWith(param, msg.getBytes(param.getEncoding()), additionParam);
        } catch (UnsupportedEncodingException e) {
            // TODO 自动生成的 catch 块
            logger.error(ExceptionUtil.getStackTrace(e));
            return CommContext.getFailedCommContext(new BaseException(e));
        }
    }
}
