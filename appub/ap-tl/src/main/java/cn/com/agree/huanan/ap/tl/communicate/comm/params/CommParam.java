package cn.com.agree.huanan.ap.tl.communicate.comm.params;

import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.NoCommParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import lombok.Getter;

/**
 * @author luo.hp
 *
 */
@Getter
@Component
public class CommParam{
	/**
	 * 通信配置参数
	 */
	public static Logger logger =  Logger.getLogger(CommParam.class);
	
	// AppId
	private String appId;
		
	// 通信配置标识项
	private String commItem;
		
	// 节点名称
	private String nodeName;
	
	// 通信类型
	private String commType;
	// 服务IP
	private String serverIp;
	// 服务端口
	private int serverPort;
	//适配器
	private String identifier;

	// 连接超时时间
	private int connTimeOut;
	
	// 通讯超时时间
	private int sockTimeOut;
	
	// 通讯报文编码
	private String encoding;
	
	/**
	 * 无参构造
	 */
	public CommParam(){}

	// ip port mode	
	/**
	 * @param commType 通信类型
	 * @param ip IP地址
	 * @param port 端口
	 */
	public CommParam(String commType, String ip, int port) {
		this(commType, ip, port, Const.DEFAULT_CONNECT_TIMEOUT, Const.DEFAULT_SOCKET_TIMEOUT);
	}
	
	// url mode
	/**
	 * @param CommType  通信类型
	 * @param connTimeOut 连接超时时间
	 * @param sockTimeOut 通信超时时间
	 */
	public CommParam(String CommType, int connTimeOut, int sockTimeOut) {
		this(CommType, null, 0, connTimeOut, sockTimeOut);
	}
	
	/**
	 * @param commType 通信类型
	 */
	public CommParam(String commType) {
		this(commType, null, 0, Const.DEFAULT_CONNECT_TIMEOUT, Const.DEFAULT_SOCKET_TIMEOUT);
	}
	
	// mix mode
	/**
     * @param commType 通信类型
     * @param ip IP地址
     * @param port 端口
     * @param connTimeOut 连接超时时间
     * @param sockTimeOut 通信超时时间
	 */
	public CommParam(String commType, String ip, int port, int connTimeOut, int sockTimeOut) {
		this(commType, ip, port, connTimeOut, sockTimeOut, Const.DEFAULT_ENCODING);
	}
	
	// full mod
	/**
     * @param commType 通信类型
     * @param ip IP地址
     * @param port 端口
     * @param connTimeOut 连接超时时间
     * @param sockTimeOut 通信超时时间
	 * @param encoding 报文编码
	 */
	public CommParam(String commType, String ip, int port, int connTimeOut, int sockTimeOut, String encoding) {
		SetCommParam(commType, ip, port, connTimeOut, sockTimeOut, encoding,null);
	}
	
	// map params
	/**
	 * @param paramMap 通信参数map构造
	 */
	public CommParam(Map<String, Object> paramMap) {
		SetCommParam(paramMap);
	}
	
	/**
     * @param param 通信参数param构造
     */
    public CommParam init(CommParam param) {
        this.nodeName = param.getNodeName();
        this.appId = param.getAppId();
        this.commItem = param.getCommItem();
        this.commType = param.getCommType();
        this.serverIp = param.getServerIp();
        this.serverPort = param.getServerPort();
        this.identifier = param.getIdentifier();
        this.connTimeOut = param.getConnTimeOut();
        this.sockTimeOut = param.getSockTimeOut();
        this.encoding = param.getEncoding();
        return this;
    }
	

	/**
	 * @param appId 应用ID
	 * @param commItem 通信配置项
	 * @param nodeName 节点名称
	 */
	public void init(String appId, String commItem, String nodeName) {
		this.appId = appId;
		this.commItem = commItem;
		this.nodeName = nodeName;
		 ParamDao paramDao = SpringUtil.getBean(ParamDao.class);
		 Map<String, Object> paramMap =  paramDao.initParams(appId, commItem, nodeName);
		if (paramMap.isEmpty()){
			logger.error("未配置通信参数");
			throw NoCommParamException.getException();
		}
		logger.info("通讯参数："+paramMap);
		SetCommParam(paramMap);
	}
	
	private void SetCommParam(String commType, String ip, int port, int connTimeOut, int sockTimeOut, String encoding,String identifier) {
		
		this.commType = commType;
		
		this.serverIp = ip;
		
		this.serverPort = port;
		
		this.connTimeOut = connTimeOut;
		
		this.sockTimeOut = sockTimeOut;
		this.identifier = identifier;
		if (encoding != null && !encoding.trim().equals("")){
			this.encoding = encoding;
		}
	}
	
	/**
	 * @param paramMap 参数Map
	 */
	public void SetCommParam(Map<String, Object> paramMap) {
		String commType_t = "";
		if (paramMap.containsKey("commType")){
			commType_t = paramMap.get("commType").toString();
		}
		
		String ip_t = "";
		if (paramMap.containsKey("serverIp")){
			ip_t = paramMap.get("serverIp").toString();
		}
		
		int port_t=0;
		if (paramMap.containsKey("serverPort")){
			port_t = Integer.parseInt(paramMap.get("serverPort").toString());
		}
		String identifier = null;
		if (paramMap.containsKey("identifier")){
			identifier = paramMap.get("identifier").toString();
		}
		
		int connTimeOut_t = Const.DEFAULT_CONNECT_TIMEOUT;
		if (paramMap.containsKey("connTimeOut")){
			connTimeOut_t = Integer.parseInt(paramMap.get("connTimeOut").toString());
		}
		
		int sockTimeOut_t = Const.DEFAULT_SOCKET_TIMEOUT;
		if (paramMap.containsKey("sockTimeOut")){
			sockTimeOut_t = Integer.parseInt(paramMap.get("sockTimeOut").toString());
		}
		
		String encoding_t = Const.DEFAULT_ENCODING;
		if (paramMap.containsKey("encoding")){
			encoding_t = paramMap.get("encoding").toString();
		}
		SetCommParam(commType_t, ip_t, port_t, connTimeOut_t, sockTimeOut_t, encoding_t,identifier);
	}
	
	/**
	 * 打印通信参数
	 */
	public void showInfo(){		
		logger.debug("Communicate Type: %s", commType);
		logger.debug("Server IP: %s", serverIp);
		logger.debug("Server Port: %d",  serverPort);
		logger.debug("Identifier: %d",  identifier);
		logger.debug("Connect Timeout(ms): %d", connTimeOut);
		logger.debug("Socket Timeout(ms): %d",  sockTimeOut);
		logger.debug("Encoding: %s",  encoding);
	}
}
