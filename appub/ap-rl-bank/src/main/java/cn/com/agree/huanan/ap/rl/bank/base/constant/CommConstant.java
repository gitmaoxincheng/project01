package cn.com.agree.huanan.ap.rl.bank.base.constant;

public abstract interface CommConstant {
	
	/**
	 * __REQ__字段
	 */
	public static final String SRVPORT = "__SRVPORT__";
	
	/**
	 * 特定变量
	 */
	public static final String TimeOut = "TimeOut";	// 超时时间
	public static final long DefTimeOut = 29000;	// 默认超时时间(毫秒)，渠道整合预计最长超时时间为30秒，内部服务间请求耗时限制29秒
	public static final String TraceId = "__TRACEID__";	// 链路ID
	public static final String __REQNO__ = "__ReqNo__"; // 自定义请求后台的流水号  
	public static final String __ST__ = "__St__"; // 自定义场景区分标识 situation
	public static final String AFAFAIL = "ACMP0E001";//AFA系统报错

	/**
	 * 存储变量
	 */
	public static final String REGFLG = "Regflg"; // 流水登记标识，0-登记，1-不登记 2-超时流水登记
	public static final String CHKFLG = "Chkflg"; // 渠道核查标识
	public static final String SVCTYPE = "Svctype"; //服务类型标识
	public static final String SYSCODE = "0310";//渠道整合编码
	public static final String SYS = "CSI";



	/**
	 * Horizontal space
	 */
	public static final byte SP = 32;

	/**
	 * Carriage return
	 */
	public static final byte CR = 13;

	/**
	 * Line feed character
	 */
	public static final byte LF = 10;

	/**
	 * Colon ':'
	 */
	public static final byte COLON = 58;

	public static String PCK_LENGTH = "Content-Length";

	public static final byte[] CRLF = { CR, LF };
	public static final byte[] HEADER_SEPARATOR = { COLON, SP };
	
	
	/**
	 * 报文标签
	 */
	public static final String NAMESPACE = "http://www.dongguanbank.cn/"; // 命名空间
	public static final String ESB_HEADER = "EsbHeader";
	public static final String CSIS_HEADER = "CsisHeader";
//	public static final String SYSHEADER = "CsisHeader";
	public static final String APP_HEADER = "AppHeader";
	public static final String HEADER = "Header";
	public static final String APP_BODY = "APPBody";
	public static final String Ctrl = "Ctrl";
	public static final String Body = "Body";

	/**
	 * 特定错误码
	 */
	public static final String SUCCSTATUS = "S";//全部成功
	public static final String SUCCCODE = "AAAAAAAAAA";
	public static final String SUCCMSG = "交易成功";
	public static final String FAILSTATUS = "F";//全部失败
	public static final String FAILCODE = "0310E99999";
	public static final String FAILMSG = "系统发生未知错误"; //因为作为默认值，如果应用不设置则默认返回，无法知道这是异常错误然而程序未处理或是正常报错，如体现为未知状态，避免请求方因为明确的失败而误操作
	public static final String UNKNOWSTATUS = "U";//状态未知、异常
	public static final String UNKNOWCODE = "0310E99998";
	public static final String UNKNOWMSG = "交易异常或处于未知状态";
	public static final String PARTSUCCSTATUS = "P";//部分成功
	public static final String PARTSCODE = "0310E99997";
	public static final String PARTSMSG = "交易部分成功";
	public static final String HANDSTATUS = "I";//处理中
	public static final String HANDCODE = "0310E99996";
	public static final String HANDMSG = "交易处理中";	
	public static final String ALLFAILCODE = "0310E99995";
	public static final String ALLFAILMSG = "交易全部失败";	
	/**
	 * json/soap标准头标签
	 */
	public static final String SOAP_HEADER_FROM = "From";
//	public static final String HEADER_ADDRESS = "Address";
//	public static final String HEADER_ACTION = "Action";
	public static final String SOAP_BODY = "Body";
	public static final String SOAP_REQ = "Req";
	public static final String SOAP_RSP = "Rsp";
	
	/**
	 * Csis/Esb报文头内标签
	 */
	public static final String GloSeqNo = "GloSeqNo"; //全局流水号
	public static final String SRCDATE = "SrcDate"; // 请求方日期
	public static final String SRCTIME = "SrcTime"; // 请求方日期
	public static final String SRCSYSID = "SrcSysId"; // 源请求方系统标识
	public static final String SRCCALCOD = "SrcCalCod"; // 源请求方渠道编号
	public static final String REQNO = "ReqNo"; // 上送流水号	
	public static final String RSPNO = "RspNo"; // 返回流水号
	public static final String SRVTRANDT = "SrvTranDt"; // 服务方交易日期
	public static final String STATUS = "RespSts"; // 状态码
	public static final String ERROR_CODE = "ErrorCode"; // 消息码
	public static final String ERROR_MSG = "ErrorMsg"; // 消息码描述
	public static final String SRCIP1 = "SrcIP1"; // 源请求发起服务器的ip
	public static final String TLRNO = "TellerNo"; // 柜员号
	public static final String TLRTP = "TellerTp"; // 柜员类型
	public static final String BRNO = "BrNo"; // 机构号
	public static final String ZONENO = "ZoneNo"; //分行号
	public static final String MBRNO = "MbrNo"; // 网点号
	public static final String MYBANK = "MyBank"; //法人号
	public static final String TECHMSG = "TechFlwMsg"; //技术跟踪信息
	public static final String TRDDT = "SrvTranDt"; // 源请求发起服务器的ip
	public static final String SERINO = "SerialNo"; // 平台流水号


	
	/**
	 * 渠道整合AppHeader报文头内标签
	 */	
	public static final String BUSINO = "BussCeNo"; // 源请求发起服务器的ip
	public static final String SESSID = "SessId"; // 设备编号
	public static final String AUTHNO = "AuthNo"; // 授权柜员号
	public static final String DEVNO = "DevNo"; // 设备编号
	public static final String CSHBOXNO1 = "CshBoxNo1"; // 现金钱箱1
	public static final String VCHBOXNO1 = "VchBoxNo1"; // 凭证钱箱1
	public static final String BACKSYSDATE = "BackSysDate"; // 后台交易日期
	public static final String BACKSYSNO = "BackSysNo"; // 后台交易流水
	public static final String BACKSYSERRORCODE = "BackSysErrorCode"; // 后台消息码
	public static final String BACKSYSERRORMSG = "BackSysErrorMsg"; // 后台消息码描述
	public static final String BILLNO = "BillNo";// 单据号

	/**
	 * 渠道整合Header报文头涉及变量
	 */	
	public static final String ACTION = "Action";	// 请求渠道系统标识
	public static final String ADDRESS= "Address";	// 请求渠道系统标识
	public static final String EXSVC= "SvcOutCode";	// 对外服务码
	public static final String EXSCN = "ScnOutCode";	// 对外场景码
	public static final String SVCCODE = "SvcCode";	// 内部模板码 		// TODO  
	public static final String SCNCODE = "ScnCode";	// 内部应用码
	public static final String SVCGTOUP = "SvcGroup";	// 服务分组
	public static final String REQSYSID = "ReqSysId";	// 请求渠道系统ID
	public static final String REQCALCOD = "ReqCalCod";	// 渠道编码

	
	
	/**
	 * 通讯类
	 */
	public static final String COMMTYPE_TCP = "TCP";
	public static final String COMMTYPE_HTTP = "HTTP";
	public static final String COMMTYPE_HTTPS = "HTTPS";

	public static final String COMMPRO_XML = "XML";
	public static final String COMMPRO_SOAP = "SOAP";
	public static final String COMMPRO_JSON = "JSON";
	/**
	 * 字符编码类
	 */
	public static final String ENCODING_UTF8 = "UTF-8";
	public static final String ENCODING_GB18030 = "GB18030";
	public static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * specify httpVersion
	 */
	public static final String DEFAULT_VERSION = "HTTP/1.1";
}
