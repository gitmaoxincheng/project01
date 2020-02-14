package cn.com.agree.huanan.ap.al.io.system.esb;

import java.util.ArrayList;
import java.util.Map;

import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommParam;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.rl.bank.base.util.SernoGenUtil;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.IOService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgHeader;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * @author HCP
 * ES 新核心系统IO通讯服务
 * json报文
 */
public class EsbUmpChannelService extends IOService {
	
	private static EsbHeaderI esbHeaderI = new EsbHeaderI();
	private static EsbHeaderO esbHeaderO = new EsbHeaderO();
	private static HeaderI headerI = new HeaderI();
	private static HeaderO headerO = new HeaderO();
	public EsbUmpChannelService() {
		requestFormat.add(esbHeaderI);
		requestFormat.add(headerI);
		responseFormat.add(esbHeaderO);
		responseFormat.add(headerO);
		initServieConf();
	}
	
	@Override
	public String isTradeSuccess(Map<String,Object> tradeContext) {
		return (((Map)tradeContext.get("EsbHeader")).get("RespSts").toString());
	}
	
	@Override
	public String getErrorCode(Map<String,Object> tradeContext) {
			return (((Map)tradeContext.get("EsbHeader")).get("ErrorCode").toString());
	}

	@Override
	public String getErrorMessage(Map<String,Object> tradeContext) {
		return (((Map)tradeContext.get("EsbHeader")).get("ErrorMsg").toString());
	}
	
	@Override
	public void initServieConf() {
		setAppId("ESB");
		setCommItem("ESB");
		setMessageType("JSON");
		setRequestEncoding("UTF-8");
		setResponseEncoding("UTF-8");
	}
	
	public static class EsbHeaderI extends MsgHeader {
		private  MsgSegment  msgSegment = init();

		private  MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			StructNode esbheadStruct = new StructNode("CsisHeader",true,"EsbHeader");
			esbheadStruct.addNode(new FieldNode("VrsNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "VrsNo", 3, 0, true, "服务版本号")));
			esbheadStruct.addNode(new FieldNode("ScnNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ScnNo", 2, 0, true, "场景版本号")));
			esbheadStruct.addNode(new FieldNode("SrcDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcDate", 8, 0, true, "请求方日期")));
			esbheadStruct.addNode(new FieldNode("SrcTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcTime", 6, 0, true, "请求方时间")));
			esbheadStruct.addNode(new FieldNode("SrcSysId", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcSysId", 4, 0, true, "源请求方系统标识")));
			esbheadStruct.addNode(new FieldNode("SrcCalCod", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcCalCod", 3, 0, true, "源请求方渠道编号")));
			esbheadStruct.addNode(new FieldNode("GloSeqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "GloSeqNo", 25, 0, true, "全局流水号")));
			esbheadStruct.addNode(new FieldNode("GloEndTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "GloEndTime", 14, 0, false, "全局截止时间")));
			esbheadStruct.addNode(new FieldNode("ReqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqNo", 30, 0, false, "上送流水号")));
			esbheadStruct.addNode(new FieldNode("TellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerNo", 10, 0, false, "柜员号")));
			esbheadStruct.addNode(new FieldNode("TellerTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerTp", 1, 0, false, "柜员类别")));
			esbheadStruct.addNode(new FieldNode("BrNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BrNo", 10, 0, false, "机构号")));
			esbheadStruct.addNode(new FieldNode("ZoneNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZoneNo", 10, 0, false, "分行号")));
			esbheadStruct.addNode(new FieldNode("MyBank", new MsgField(ContentEnum.MessageType.STRING.toString(), "MyBank", 3, 0, false, "法人号")));
/*			esbheadStruct.addNode(new FieldNode("SrcIP1", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcIP1", 128, 0, false, "源请求方服务器IP")));  // ESB系统虽定义，但未使用，需严格按照接口定义上传
			esbheadStruct.addNode(new FieldNode("SrcIP2", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcIP2", 128, 0, false, "直接请求方服务器IP")));*/
			esbheadStruct.addNode(new FieldNode("TechFlwMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "TechFlwMsg", 256, 0, false, "技术跟踪信息")));
			messageNode.addStructNode(esbheadStruct);
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
	
	public static class EsbHeaderO extends MsgHeader {
		private  MsgSegment  msgSegment = init();
		private  MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			StructNode esbheadStruct = new StructNode("EsbHeader",true,"CsisHeader");
			esbheadStruct.addNode(new FieldNode("VrsNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "VrsNo", 10, 0, true, "服务版本号")));
			esbheadStruct.addNode(new FieldNode("ScnNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ScnNo", 2, 0, true, "场景版本号")));
			esbheadStruct.addNode(new FieldNode("SrcDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcDate", 8, 0, true, "请求方日期")));
			esbheadStruct.addNode(new FieldNode("SrcTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcTime", 6, 0, true, "请求方时间")));
			esbheadStruct.addNode(new FieldNode("SrcSysId", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcSysId", 4, 0, true, "源请求方系统标识")));
			esbheadStruct.addNode(new FieldNode("SrcCalCod", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcCalCod", 3, 0, true, "源请求方渠道编号")));
			esbheadStruct.addNode(new FieldNode("GloSeqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "GloSeqNo", 25, 0, true, "全局流水号")));
			esbheadStruct.addNode(new FieldNode("GloEndTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "GloEndTime", 14, 0, false, "全局截止时间")));
			esbheadStruct.addNode(new FieldNode("ReqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqNo", 30, 0, false, "上送流水号")));
			esbheadStruct.addNode(new FieldNode("RspNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RspNo", 30, 0, false, "返回流水号")));
			esbheadStruct.addNode(new FieldNode("SrvTranDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrvTranDt", 8, 0, false, "服务方系统交易日期")));
			esbheadStruct.addNode(new FieldNode("TellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerNo", 10, 0, false, "柜员号")));
			esbheadStruct.addNode(new FieldNode("TellerTp", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerTp", 1, 0, false, "柜员类别")));
			esbheadStruct.addNode(new FieldNode("BrNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BrNo", 10, 0, false, "机构号")));
			esbheadStruct.addNode(new FieldNode("ZoneNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZoneNo", 10, 0, false, "分行号")));
			esbheadStruct.addNode(new FieldNode("MyBank", new MsgField(ContentEnum.MessageType.STRING.toString(), "MyBank", 3, 0, false, "法人号")));
			esbheadStruct.addNode(new FieldNode("RespSts", new MsgField(ContentEnum.MessageType.STRING.toString(), "RespSts", 1, 0, true, "状态码"))); //XXX 原ESB文档为也服务方必输
			esbheadStruct.addNode(new FieldNode("ErrorCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorCode", 10, 0, true, "消息码")));
			esbheadStruct.addNode(new FieldNode("ErrorMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorMsg", 256, 0, true, "消息码描述")));
			esbheadStruct.addNode(new FieldNode("TechFlwMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "TechFlwMsg", 256, 0, false, "技术跟踪信息")));
			messageNode.addStructNode(esbheadStruct);
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
		public ArrayList<Node> listNode() {
			// TODO 自动生成的方法存根
			return msgSegment.getNodeList();
		}
	}

	public void initContent(Map<String, Object> tradeContext) {
		Map<String,Object> Header = (Map) tradeContext.get("Header");
		Header.put("Action", CommConstant.NAMESPACE+tradeContext.get("AtSysSvc")+"/"+tradeContext.get("AtSysScn"));
		Header.put("Address", CommConstant.SYSCODE);
		Map<String,Object> CsisHeader = (Map) tradeContext.get("CsisHeader");
		CsisHeader.put("SrcDate", DateTimeUtil.getSysDate());
		CsisHeader.put("SrcTime", DateTimeUtil.getSysTime());
		CsisHeader.put("ReqNo", CsisHeader.get(CommConstant.__REQNO__)==null?SernoGenUtil.getSerno(CommParam.ATOM_SEQ):CsisHeader.get(CommConstant.__REQNO__));
	}
	
	@Override
	public Map<String,Object> buildInMessageContext(Map<String, Object> tradeContext) {
		tradeContext = super.buildInMessageContext(tradeContext);
		initContent(tradeContext);
		return tradeContext;
	}

}
