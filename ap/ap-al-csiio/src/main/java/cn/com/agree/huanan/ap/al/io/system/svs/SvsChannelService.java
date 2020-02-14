/**
 * 
 */
package cn.com.agree.huanan.ap.al.io.system.svs;

import java.util.ArrayList;
import java.util.Map;

import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.IOService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgHeader;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * @author HCP
 * 0003 Svs 验印系统
 * Http+ Webservice报文
 */
public class SvsChannelService extends IOService {

	private static RHeaderI headerI = new RHeaderI();
	private static RHeaderO headerO = new RHeaderO();
	public SvsChannelService() {
		requestFormat.add(headerI);
		responseFormat.add(headerO);
		initServieConf();
	}

	@Override
	public String isTradeSuccess(Map<String,Object> tradeContext) {
		if("AAAAAAAAAA".equals(getErrorCode(tradeContext))){
			return CommConstant.SUCCSTATUS;
		}else{
			return CommConstant.FAILSTATUS;
		}
	}

	@Override
	public String getErrorCode(Map<String,Object> tradeContext) {
		String errorCode= (((Map)tradeContext.get("ResponseBody")).get("FaultCode").toString());
		if ("00000".equals(errorCode)) {
			errorCode="AAAAAAAAAA";
		}
		return errorCode;
	}
	
	
	@Override
	public String getErrorMessage(Map<String,Object> tradeContext) {
		return (((Map)tradeContext.get("ResponseBody")).get("FaultString").toString());
	}


	@Override
	public void initServieConf() {
		setAppId("SVS");
		setCommItem("SVS");
		setMessageType("SVSXML");
		setRequestEncoding("UTF-8");
		setResponseEncoding("UTF-8");
	}


	public static class RHeaderI extends MsgHeader {
		private  MsgSegment  msgSegment = init();
		private  MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			StructNode headStruct = new StructNode("AppHeader",true,"RequestHeader");
			headStruct
			.addNode(new FieldNode("VersionNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "VersionNo", 10, 0, true, "版本号")))
			.addNode(new FieldNode("ReqSysCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqSysCode", 20, 0, false, "发起端系统编号")))
			.addNode(new FieldNode("ReqSecCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqSecCode", 20, 0, false, "发起端备用系统编号")))
			.addNode(new FieldNode("TxType", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxType", 20, 0, false, "报文类型")))
			.addNode(new FieldNode("TxMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxMode", 10, 0, false, "报文发送方式")))
			.addNode(new FieldNode("TxCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxCode", 10, 0, false, "报文校验码")))
			.addNode(new FieldNode("ReqDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqDate", 10, 0, false, "报文发送日期")))  //XXX 确人一下，是否在I表还需要加
			.addNode(new FieldNode("ReqTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqTime", 8, 0, false, "报文发送时间"))) 	//XXX 确人一下，是否在I表还需要加
			.addNode(new FieldNode("ReqSeqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqSeqNo", 10, 0, false, "交易序号")))
			.addNode(new FieldNode("ChanlNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChanlNo", 20, 0, true, "渠道标识")))
			.addNode(new FieldNode("BusinessType", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusinessType", 8, 0, true, "业务类型")))
			.addNode(new FieldNode("SndFileName", new MsgField(ContentEnum.MessageType.STRING.toString(), "SndFileName", 64, 0, false, "文件名")))
			.addNode(new FieldNode("BeginRec", new MsgField(ContentEnum.MessageType.STRING.toString(), "BeginRec", 8, 0, false, "报文发送时间")))
			.addNode(new FieldNode("MaxRec", new MsgField(ContentEnum.MessageType.STRING.toString(), "MaxRec", 8, 0, false, "等待时间")))
			.addNode(new FieldNode("FileHMac", new MsgField(ContentEnum.MessageType.STRING.toString(), "FileHMac", 10, 0, false, "文件服务器Mac地址")))
			.addNode(new FieldNode("HMac", new MsgField(ContentEnum.MessageType.STRING.toString(), "HMac", 20, 0, false, "发送端Mac地址")))
			.addNode(new FieldNode("ResURL", new MsgField(ContentEnum.MessageType.STRING.toString(), "ResURL", 256, 0, false, "请求地址")))
			.addNode(new FieldNode("IP", new MsgField(ContentEnum.MessageType.STRING.toString(), "IP", 64, 0, false, "请求IP")))
			.addNode(new FieldNode("Port", new MsgField(ContentEnum.MessageType.STRING.toString(), "Port", 4, 0, false, "请求端口")))
			.addNode(new FieldNode("TranSID", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranSID", 64, 0, false, "交易ID")))
			.addNode(new FieldNode("NodeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "NodeName", 64, 0, false, "节点名")))
			.addNode(new FieldNode("ExtendInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ExtendInfo", 128, 0, false, "扩展信息")));
			messageNode.addStructNode(headStruct);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class RHeaderO extends MsgHeader {
		private  MsgSegment  msgSegment = init();

		private  MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			StructNode headStruct = new StructNode("ResponseHeader",true,"AppHeader");
			headStruct
			.addNode(new FieldNode("VersionNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "VersionNo", 10, 0, true, "版本号")))
			.addNode(new FieldNode("ReqSysCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqSysCode", 20, 0, false, "发起端系统编号")))
			.addNode(new FieldNode("ReqSecCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqSecCode", 20, 0, false, "发起端备用系统编号")))
			.addNode(new FieldNode("TxType", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxType", 20, 0, false, "报文类型")))
			.addNode(new FieldNode("TxMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxMode", 10, 0, false, "报文发送方式")))
			.addNode(new FieldNode("TxCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TxCode", 10, 0, false, "报文校验码")))
			.addNode(new FieldNode("ReqDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqDate", 10, 0, false, "报文发送日期")))  //XXX 确人一下，是否在I表还需要加
			.addNode(new FieldNode("ReqTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqTime", 8, 0, false, "报文发送时间"))) 	//XXX 确人一下，是否在I表还需要加
			.addNode(new FieldNode("ReqSeqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ReqSeqNo", 10, 0, false, "交易序号")))
			.addNode(new FieldNode("ChanlNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ChanlNo", 20, 0, true, "渠道标识")))
			.addNode(new FieldNode("BusinessType", new MsgField(ContentEnum.MessageType.STRING.toString(), "BusinessType", 8, 0, true, "业务类型")))
			.addNode(new FieldNode("SndFileName", new MsgField(ContentEnum.MessageType.STRING.toString(), "SndFileName", 64, 0, false, "文件名")))
			.addNode(new FieldNode("BeginRec", new MsgField(ContentEnum.MessageType.STRING.toString(), "BeginRec", 8, 0, false, "报文发送时间")))
			.addNode(new FieldNode("MaxRec", new MsgField(ContentEnum.MessageType.STRING.toString(), "MaxRec", 8, 0, false, "等待时间")))
			.addNode(new FieldNode("FileHMac", new MsgField(ContentEnum.MessageType.STRING.toString(), "FileHMac", 10, 0, false, "文件服务器Mac地址")))
			.addNode(new FieldNode("HMac", new MsgField(ContentEnum.MessageType.STRING.toString(), "HMac", 20, 0, false, "发送端Mac地址")))
			.addNode(new FieldNode("ResURL", new MsgField(ContentEnum.MessageType.STRING.toString(), "ResURL", 256, 0, false, "请求地址")))
			.addNode(new FieldNode("IP", new MsgField(ContentEnum.MessageType.STRING.toString(), "IP", 64, 0, false, "请求IP")))
			.addNode(new FieldNode("Port", new MsgField(ContentEnum.MessageType.STRING.toString(), "Port", 4, 0, false, "请求端口")))
			.addNode(new FieldNode("TranSID", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranSID", 64, 0, false, "交易ID")))
			.addNode(new FieldNode("NodeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "NodeName", 64, 0, false, "节点名")))
			.addNode(new FieldNode("ExtendInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ExtendInfo", 128, 0, false, "扩展信息")));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public void initContent(Map<String, Object> tradeContext) {
		Map<String,Object> appHeader = (Map) tradeContext.get("AppHeader");
		appHeader.put("VersionNo", "1.0.0");
		logger.debug("APPID: SvsXmL");
	}

	@Override
	public Map<String,Object> buildInMessageContext(Map<String, Object> tradeContext) {
		tradeContext = super.buildInMessageContext(tradeContext);
		initContent(tradeContext);
		return tradeContext;
	}

}
