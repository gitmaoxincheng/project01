package cn.com.agree.huanan.ap.al.io.system.csis;

import java.util.ArrayList;
import java.util.Map;

import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.IOService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgHeader;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * @author HCP
 * CSIS 渠道整合系统IO校验服务
 */
public class CsisIOService extends IOService {
	    
	private static CsisHeaderI csisHeaderI = new CsisHeaderI();
	private static CsisHeaderO csisHeaderO = new CsisHeaderO();
	private static HeaderI headerI = new HeaderI();
	private static HeaderO headerO = new HeaderO();
	private static AppHeaderI appHeaderI = new AppHeaderI();
	private static AppHeaderO appHeaderO = new AppHeaderO();
	public CsisIOService() {
		// TODO 自动生成的构造函数存根
		requestFormat.add(csisHeaderI);
		requestFormat.add(headerI);
		requestFormat.add(appHeaderI);
		responseFormat.add(csisHeaderO);
		responseFormat.add(headerO);
		responseFormat.add(appHeaderO);
		initServieConf();
	}

	@Override
	public String getErrorCode(Map<String, Object> tradeContext) {
		return null;
	}

	@Override
	public String getErrorMessage(Map<String, Object> tradeContext) {
		return null;
	}

	@Override
	public String isTradeSuccess(Map<String, Object> tradeContext) {
		return null;
	}

	@Override
	public Map<String, Object> getResponseBody(Map<String, Object> tradeContext) {
		return null;
	}


	@Override
	public void initServieConf() {
        setAppId("CSI");
        setCommItem("CSI");
        setMessageType("JSON");
        setRequestEncoding("UTF-8");
        setResponseEncoding("UTF-8");
	}
	public static class CsisHeaderI extends MsgHeader {
		private  MsgSegment  msgSegment = init();
		private  MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			StructNode csisheadStruct = new StructNode("CsisbHeader");
			csisheadStruct.addNode(new FieldNode("VrsNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "VrsNo", 3, 0, true, "服务版本号")));
			csisheadStruct.addNode(new FieldNode("ScnNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ScnNo", 2, 0, true, "场景版本号")));
			csisheadStruct.addNode(new FieldNode("SrcDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcDate", 8, 0, true, "请求方日期")));
			csisheadStruct.addNode(new FieldNode("SrcTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcTime", 6, 0, true, "请求方时间")));
			csisheadStruct.addNode(new FieldNode("SrcSysId", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcSysId", 4, 0, true, "源请求方系统标识")));
			csisheadStruct.addNode(new FieldNode("SrcCalCod", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcCalCod", 3, 0, true, "源请求方渠道编号")));
			csisheadStruct.addNode(new FieldNode("GloSeqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "GloSeqNo", 25, 0, true, "全局流水号")));
			csisheadStruct.addNode(new FieldNode("GloEndTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "GloEndTime", 14, 0, false, "全局截止时间")));
			csisheadStruct.addNode(new FieldNode("ReqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqNo", 30, 0, false, "上送流水号")));
			csisheadStruct.addNode(new FieldNode("TellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerNo", 10, 0, false, "柜员号")));
			csisheadStruct.addNode(new FieldNode("TellerTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerTp", 1, 0, false, "柜员类别")));
			csisheadStruct.addNode(new FieldNode("BrNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BrNo", 8, 0, false, "机构号")));
			csisheadStruct.addNode(new FieldNode("ZoneNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZoneNo", 8, 0, false, "分行号")));
			csisheadStruct.addNode(new FieldNode("MyBank", new MsgField(ContentEnum.MessageType.STRING.toString(), "MyBank", 3, 0, false, "法人号")));
			csisheadStruct.addNode(new FieldNode("SrcIP1", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcIP1", 128, 0, false, "源请求方服务器IP")));
			csisheadStruct.addNode(new FieldNode("SrcIP2", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcIP2", 128, 0, false, "直接请求方服务器IP")));
			csisheadStruct.addNode(new FieldNode("TechFlwMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "TechFlwMsg", 256, 0, false, "技术跟踪信息")));
			messageNode.addStructNode(csisheadStruct);
			return messageNode;
		}
		
		/* （非 Javadoc）
		 * @see cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat#listNode()
		 */
		@Override
		public ArrayList<Node> listNode() {
			// TODO 自动生成的方法存根
			return msgSegment.getNodeList();
		}

	}
	
	public static class CsisHeaderO extends MsgHeader {
		private  MsgSegment  msgSegment = init();
		private  MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			StructNode csisHeadStruct = new StructNode("CsisbHeader");
			csisHeadStruct.addNode(new FieldNode("VrsNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "VrsNo", 3, 0, true, "服务版本号")));
			csisHeadStruct.addNode(new FieldNode("ScnNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ScnNo", 2, 0, true, "场景版本号")));
			csisHeadStruct.addNode(new FieldNode("SrcDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcDate", 8, 0, true, "请求方日期")));
			csisHeadStruct.addNode(new FieldNode("SrcTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcTime", 6, 0, true, "请求方时间")));
			csisHeadStruct.addNode(new FieldNode("SrcSysId", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcSysId", 4, 0, true, "源请求方系统标识")));
			csisHeadStruct.addNode(new FieldNode("SrcCalCod", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcCalCod", 3, 0, true, "源请求方渠道编号")));
			csisHeadStruct.addNode(new FieldNode("GloSeqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "GloSeqNo", 25, 0, true, "全局流水号")));
			csisHeadStruct.addNode(new FieldNode("GloEndTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "GloEndTime", 14, 0, false, "全局截止时间")));
			csisHeadStruct.addNode(new FieldNode("ReqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqNo", 30, 0, false, "上送流水号")));
			csisHeadStruct.addNode(new FieldNode("RspNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RspNo", 30, 0, false, "返回流水号")));
			csisHeadStruct.addNode(new FieldNode("SrvTranDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrvTranDt", 8, 0, false, "服务方系统交易日期")));
			csisHeadStruct.addNode(new FieldNode("TellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerNo", 10, 0, false, "柜员号")));
			csisHeadStruct.addNode(new FieldNode("TellerTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerTp", 1, 0, false, "柜员类别")));
			csisHeadStruct.addNode(new FieldNode("BrNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BrNo", 8, 0, false, "机构号")));
			csisHeadStruct.addNode(new FieldNode("ZoneNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZoneNo", 8, 0, false, "分行号")));
			csisHeadStruct.addNode(new FieldNode("MyBank", new MsgField(ContentEnum.MessageType.STRING.toString(), "MyBank", 3, 0, false, "法人号")));
			csisHeadStruct.addNode(new FieldNode("RespSts", new MsgField(ContentEnum.MessageType.STRING.toString(), "RespSts", 1, 0, true, "状态码"))); //XXX 原ESB文档为也服务方必输
			csisHeadStruct.addNode(new FieldNode("ErrorCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorCode", 10, 0, true, "消息码")));
			csisHeadStruct.addNode(new FieldNode("ErrorMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorMsg", 256, 0, true, "消息码描述")));
			csisHeadStruct.addNode(new FieldNode("TechFlwMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "TechFlwMsg", 256, 0, false, "技术跟踪信息")));
			messageNode.addStructNode(csisHeadStruct);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class HeaderI extends MsgHeader {
		private  MsgSegment  msgSegment = init();
		private  MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			StructNode headStruct = new StructNode("Header");
			headStruct.addNode(new FieldNode("Action", new MsgField(ContentEnum.MessageType.STRING.toString(), "Action", 50, 0, true, "服务请求方标识")));
			headStruct.addNode(new FieldNode("Address", new MsgField(ContentEnum.MessageType.STRING.toString(), "Address", 4, 0, true, "消息处理方法")));
			messageNode.addStructNode(headStruct);
			return messageNode;
		}
		/* （非 Javadoc）
		 * @see cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat#listNode()
		 */
		@Override
		public ArrayList<Node> listNode() {
			// TODO 自动生成的方法存根
			return msgSegment.getNodeList();
		}
	}
	
	public static class HeaderO extends MsgHeader {
		private  MsgSegment  msgSegment = init();

		private  MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			StructNode headStruct = new StructNode("Header");
			headStruct.addNode(new FieldNode("Action", new MsgField(ContentEnum.MessageType.STRING.toString(), "Action", 50, 0, true, "服务请求方标识")));
			headStruct.addNode(new FieldNode("Address", new MsgField(ContentEnum.MessageType.STRING.toString(), "Address", 4, 0, true, "消息处理方法")));
			messageNode.addStructNode(headStruct);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			// TODO 自动生成的方法存根
			return msgSegment.getNodeList();
		}
	}
	
	public static class AppHeaderO extends MsgBody {
        private  MsgSegment  msgSegment = init();

        private  MsgSegment init() {
            MsgSegment messageNode = new MsgSegment();
			StructNode appHeader = new StructNode("AppHeader");
			messageNode.addStructNode(appHeader);
            return messageNode;
        }
        /* （非 Javadoc）
         * @see cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat#listNode()
         */
        @Override
        public ArrayList<Node> listNode() {
            // TODO 自动生成的方法存根
            return msgSegment.getNodeList();
        }
    }
	
	public static class AppHeaderI extends MsgHeader {
		private  MsgSegment  msgSegment = init();

		private  MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			StructNode appHeader = new StructNode("AppHeader");
			messageNode.addStructNode(appHeader);
			return messageNode;
		}
		/* （非 Javadoc）
		 * @see cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat#listNode()
		 */
		@Override
		public ArrayList<Node> listNode() {
			// TODO 自动生成的方法存根
			return msgSegment.getNodeList();
		}
	}


/*
	*//**
	 * 组装报文头取值容器 与O表结构一致
	 * @param headerContext 报文头容器
	 *//*
	public  void initHeaderContent(Map<String , Object> headerContext){
		this.headerContext = requestFormat.stream().filter(format -> format instanceof MsgHeader).map(f -> {
			Map<String , Object> eachMap = new HashMap<>();
			ArrayList<Node> nodeList = f.listNode();
			if(nodeList.size() > 0){
				StructNode headerNode = (StructNode) nodeList.get(0);
				Map<String , Object> headMap = new HashMap<>();
				eachMap.put(headerNode.getNodeName(), headMap);
				for(Node node : (ArrayList<Node>) headerNode.getNodeList()){
					String nodeName = node.getNodeName();
					if(headerContext.containsKey(nodeName)){
						headMap.put(nodeName, headerContext.get(nodeName));
					}
				}
			}
			return eachMap;
		}).collect(
				HashMap::new,
				(fulMap, eachMap) -> {
					fulMap.putAll(eachMap);
				},
				(a, b) -> a.putAll(b));
	};
	*//**
	 * 初始化报文取值容器
	 * @param tradeContext 交易上下文容器
	 * @return ChannelService
	 *//*
	public CsisIOService buildInMessageContext(Map<String, Object> tradeContext){		//XXX 这里可以抽离实现？
		logger.debug("i表信息" + Arrays.toString(requestFormat.toArray()));
		logger.debug("o表信息" +Arrays.toString(responseFormat.toArray()));
		//大P请求上送的REQ容器里,报文体对应的key为Body
		Map <String, Object> bodyMap = (Map<String, Object>) tradeContext.getOrDefault("APPBody", new HashMap<>());
		//获取报文头同期节点 渠道报文头取值就来自于 Head区 body的BusiField区  Tail区
		Map <String, Object> csisHeader = (Map<String, Object>) tradeContext.getOrDefault("CsisHeader", new HashMap<>());
		Map <String, Object> appHeader = (Map<String, Object>) bodyMap.getOrDefault("AppHeader", new HashMap<>());
		Map <String, Object> header = (Map<String, Object>) tradeContext.getOrDefault("Header", new HashMap<>());
		Map <String, Object> headerContext = new HashMap<>();
		headerContext.putAll(csisHeader);
		headerContext.putAll(appHeader);
		headerContext.putAll(header);
		//初始化报文头容器
		initHeaderContent(headerContext);
		Map <String , Object> messageContext = new HashMap<>();
		messageContext.putAll(this.headerContext);
		for(MsgFormat f : requestFormat){
			if(f instanceof MsgBody){
				ArrayList<Node> bodyNodeList = f.listNode();
				if(bodyNodeList.size() > 0){
					String nodeName = bodyNodeList.get(0).getNodeName();
					logger.debug("获取请求报文节点:" + nodeName);
					messageContext.put(nodeName, bodyMap);
				}
				break;
			}
		}
		logger.debug("请求报文容器:" + messageContext);
		this.messageContext = messageContext;
		return this;
	}

	@Override
	public IOService buildOutMessageContext(Map<String, Object> tradeContext) {
		return null;
	}

*/

}
