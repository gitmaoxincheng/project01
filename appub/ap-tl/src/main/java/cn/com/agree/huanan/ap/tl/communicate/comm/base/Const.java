package cn.com.agree.huanan.ap.tl.communicate.comm.base;

public class Const {
	// 通信参数设置
    // 连接的超时时间
	public static final int DEFAULT_CONNECT_TIMEOUT = 500;
    
    // 通信超时时间
	public static final int DEFAULT_SOCKET_TIMEOUT = 2000;
	
	
	// 数据流处理参数
	// 每次读取字节流大小
	public static final int DEFAULT_MAX_READ_BYTES = 1024;
	
	// 每写字节流大小
	public static final int DEFAULT_MAX_WRITE_BYTES = 1024;
	
	// 最大接收信息
    public static final int DEFAULT_MAX_BYTES = 1024 * 1024;
	
	
	// 编码
	public static final String DEFAULT_ENCODING = "UTF-8";
	
	
	// 通信类型
	// SOCKET通信
	public static final String COMM_TYPE_SOCKET = "SOCK";
		
	// NATP通信
	public static final String COMM_TYPE_NATP = "NATP";
	
	// HTTP通信
	public static final String COMM_TYPE_HTTP = "HTTP";
	
	// HTTPS通信
	public static final String COMM_TYPE_HTTPS = "HTTPS";
	
	// IBM MQ通信
	public static final String COMM_TYPE_MQIBM = "MQIBM";
	
	
	// 通信公共节点
	public static final String DEFAULT_NODE_NAME = "COMMON";
	
	// 通信公共AppId
	public static final String DEFAULT_COMM_APPID = "COMMON";
	
	// 通信公共非错误码
	public static final String DEFAULT_NO_EORRORCODE = "No Error Code";
	
	// 通信公共非错误信息
	public static final String DEFAULT_NO_EORRORMSG = "No Error Message";

	// 错误类型
	// 成功
	public static final int ERROR_TYPE_SUCCESS = 0;
	
	// 失败
	public static final int ERROR_TYPE_FAILED = 1;
	
	// 异常
	public static final int ERROR_TYPE_ABAND = 2;
	
	// 消息类型
	// 发送消息类型
	public static final int MESSAGE_SEND_TYPE = 0;
	// 接收消息类型
	public static final int MESSAGE_RECV_TYPE = 1;
	
	// 消息内容类型
	// 字符串消息
	public static final int MESSAGE_CONTENT_STRING_TYPE = 0;
	// 字节流消息
	public static final int MESSAGE_CONTENT_BYTES_TYPE = 1;
}
