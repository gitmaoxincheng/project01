/**
 * 
 */
package cn.com.agree.huanan.ap.tl.communicate.comm.adapter.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.SimpleTcpAdapter;
import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;
import cn.com.agree.huanan.ap.tl.communicate.comm.msg.RecvMessage;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.SimpleTcpParam;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.IntUtils;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

/**
 * @author xqq
 * 基于tcp协议的socket通讯 报文格式: 8位长度标识报文头 + 报文体(不包含报文头)
 */
@Component
public class SimpleTcpAdapterImpl implements SimpleTcpAdapter {
    
    private final Logger logger = Logger.getLogger(SimpleTcpAdapterImpl.class);  
    
    protected CommContext commWith(CommParam param, byte[] msg) {
        // 与服务端建立连接
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        SimpleTcpParam tcpParam = new SimpleTcpParam();
        tcpParam.init(param);
        int headSize = tcpParam.getHeadSize();
        int headType = tcpParam.getHeadType();
        boolean isContainHeadLength = tcpParam.isContainHeadLength();
        try {
            socket = new Socket();
            SocketAddress endpoint = new InetSocketAddress(tcpParam.getServerIp(), tcpParam.getServerPort());
            socket.setSoTimeout(tcpParam.getSocketReadTimeOutMilliseconds());
            socket.setSoLinger(true, tcpParam.getSocketCloseTimeOutMilliseconds());
            socket.connect(endpoint, tcpParam.getConnTimeOut());
            byte[] body = msg;
            int bodyLen = body.length;
            byte[] headByte = getHeadBytes(bodyLen, headSize, isContainHeadLength, headType);
            
            byte[][] reqPackets = { headByte, body };
            logger.info("发送的报文："+new String(msg,"UTF-8"));
            OutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            int j = reqPackets.length;
            for (int i = 0; i < j; i++)
            {
				bos.write(reqPackets[i]);
				bos.flush();
            }
            //通过shutdownOutput通知服务器已经发送完数据，后续只能接受数据
            socket.shutdownOutput();
            
            DataInputStream dis = new DataInputStream(new BufferedInputStream(
              socket.getInputStream()));
            byte[] rspPacket = receive(dis, headSize, headType, isContainHeadLength);
            logger.info("响应的报文："+new String(rspPacket,"UTF-8"));
            return CommContext.getCommContext(new RecvMessage(rspPacket, tcpParam.getEncoding()));
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            logger.error(ExceptionUtil.getStackTrace(e));
            return CommContext.getCommAbandonContext(new BaseException(e));
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
    
	private static byte[] getHeadBytes(int bodyLenth, int headSize, boolean isContain, int headType) throws IllegalArgumentException{
		byte[] headByte = null;
		int totalLength = 0;
		if (isContain) {
			totalLength = bodyLenth + headSize;
		} else {
			totalLength = bodyLenth;
		}
		switch (headType) {
		case 0:
			headByte = StrUtil.zfill(totalLength, headSize).getBytes();
			break;
		case 1:
			headByte = IntUtils.toBytes(totalLength, 4);
			break;
		case 2:
			headByte = IntUtils.toBytes(totalLength, 2);
		default:
			throw new IllegalArgumentException("无效的报文头类型");
		}
		return headByte;
	}
    
    /**
     * 使用readfully读取指定长度的数据
     * @param dis
     * @param headLength
     * @param headType
     * @param isContainHeadLength
     * @return
     * @throws IOException
     * @throws IllegalArgumentException
     */
	private static byte[] receive(DataInputStream dis, int headLength,
			int headType, boolean isContainHeadLength) throws IOException,IllegalArgumentException {
		int bodyLen = 0;
		byte[] headBytes;
		switch (headType) {
		case 0:
			headBytes = new byte[headLength];
			dis.readFully(headBytes);
			try {
				bodyLen = Integer.valueOf(new String(headBytes)).intValue();
			} catch (NumberFormatException e) {
				throw new IOException("报文头数据有误:" + e.getMessage());
			}
			break;
		case 1:
			headBytes = new byte[4];
			dis.readFully(headBytes);
			bodyLen = IntUtils.toInt(headBytes);
			break;
		case 2:
			headBytes = new byte[2];
			dis.readFully(headBytes);
			bodyLen = IntUtils.toInt(headBytes);
			break;
		default:
			throw new IllegalArgumentException("无效的报文头类型");
		}

		if (bodyLen > 64000000) {
			throw new IOException("报文大小不能超过64M");
		}
		if (isContainHeadLength) {
			bodyLen -= headLength;
		}
		byte[] bodyBytes = new byte[bodyLen];
		dis.readFully(bodyBytes);
		return bodyBytes;
	}
    
    @Override
    public CommContext comm(CommParam param, byte[] msg) {
        // TODO 自动生成的方法存根
        return commWith(param, msg);
    }

    @Override
    public CommContext comm(CommParam param, String msg) {
        // TODO 自动生成的方法存根
        try {
            return commWith(param, msg.getBytes(param.getEncoding()));
        } catch (UnsupportedEncodingException e) {
            // TODO 自动生成的 catch 块
            logger.error(ExceptionUtil.getStackTrace(e));
            return CommContext.getFailedCommContext(new BaseException(e));
        }
    }

	@Override
	public CommContext comm(CommParam param, byte[] msg,
			Map<String, Object> additionParam) {
		// TODO 自动生成的方法存根
		return commWith(param, msg);
	}

	@Override
	public CommContext comm(CommParam param, String msg,
			Map<String, Object> additionParam) {
		// TODO 自动生成的方法存根
		 try {
	            return commWith(param, msg.getBytes(param.getEncoding()));
	        } catch (UnsupportedEncodingException e) {
	            // TODO 自动生成的 catch 块
	            logger.error(ExceptionUtil.getStackTrace(e));
	            return CommContext.getFailedCommContext(new BaseException(e));
	        }
	}
}
