package cn.com.agree.huanan.ap.al.io.system.esb;

import java.util.ArrayList;
import java.util.Map;

import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommParam;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.rl.bank.base.util.SernoGenUtil;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.IOService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgHeader;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * @author cts
 * 0209 集中业务处理平台
 * json报文  
 */ 
public class EsbSdsChannelService extends IOService {

	private static EsbHeaderI esbHeaderI = new EsbHeaderI();
	private static EsbHeaderO esbHeaderO = new EsbHeaderO();
	private static HeaderI headerI = new HeaderI();
	private static HeaderO headerO = new HeaderO();
	private static AppHeaderI appHeaderI = new AppHeaderI();
	private static AppHeaderO appHeaderO = new AppHeaderO();
	public EsbSdsChannelService() {
		requestFormat.add(esbHeaderI);
		requestFormat.add(headerI);
		requestFormat.add(appHeaderI);
		responseFormat.add(esbHeaderO);
		responseFormat.add(headerO);
		responseFormat.add(appHeaderO);
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
			esbheadStruct.addNode(new FieldNode("VrsNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "VrsNo", 10, 0, true, "服务版本号")));
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
		/* （非 Javadoc）
		 * @see cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat#listNode()
		 */
		@Override
		public ArrayList<Node> listNode() {
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
			StructNode headStruct = new StructNode("AppHeader");
			headStruct.addNode(new FieldNode("CBOE_TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "CBOE_TRADECODE", 30, 0, true, "子流程交易码")))
			.addNode(new FieldNode("TASKID", new MsgField(ContentEnum.MessageType.STRING.toString(), "TASKID", 24, 0, false, "子流程任务号")))
			.addNode(new FieldNode("TRANSID", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRANSID", 30, 0, false, "流程id")))
			.addNode(new FieldNode("FLOWID", new MsgField(ContentEnum.MessageType.STRING.toString(), "FLOWID", 20, 0, false, "子流程工作流ID")))
			.addNode(new FieldNode("MAIN_TASKID", new MsgField(ContentEnum.MessageType.STRING.toString(), "MAIN_TASKID", 22, 0, false, "主流程任务号")))
			.addNode(new FieldNode("MAIN_FLOWID", new MsgField(ContentEnum.MessageType.STRING.toString(), "MAIN_FLOWID", 20, 0, false, "子流程工作流ID")))
			.addNode(new FieldNode("WORKITEM_FLAG", new MsgField(ContentEnum.MessageType.STRING.toString(), "WORKITEM_FLAG", 2, 0, false, "工作项标志")))
			.addNode(new FieldNode("SENDDATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "SENDDATE", 20, 0, false, "任务发起日期")))
			.addNode(new FieldNode("YY_GUID", new MsgField(ContentEnum.MessageType.STRING.toString(), "YY_GUID", 50, 0, false, "验印影像ID")))
			.addNode(new FieldNode("LAST_SEQUENCE", new MsgField(ContentEnum.MessageType.STRING.toString(), "LAST_SEQUENCE", 2, 0, false, "上一时序")))
			.addNode(new FieldNode("NOW_SEQUENCE", new MsgField(ContentEnum.MessageType.STRING.toString(), "NOW_SEQUENCE", 2, 0, false, "当前时序")))
			.addNode(new FieldNode("NODE_NAME", new MsgField(ContentEnum.MessageType.STRING.toString(), "NODE_NAME", 20, 0, false, "角色号")))
			.addNode(new FieldNode("WORKITEM_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "WORKITEM_ID", 21, 0, false, "工作项ID")))
			.addNode(new FieldNode("LSTNODNAM", new MsgField(ContentEnum.MessageType.STRING.toString(), "LSTNODNAM", 22, 0, false, "前一个岗位的名称号")))
			.addNode(new FieldNode("STS", new MsgField(ContentEnum.MessageType.STRING.toString(), "STS", 23, 0, false, "岗位状态")))
			.addNode(new FieldNode("STATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "STATE", 24, 0, false, "前端显示界面的标识")))
			.addNode(new FieldNode("PROSTS", new MsgField(ContentEnum.MessageType.STRING.toString(), "PROSTS", 25, 0, false, "流程状态")))
			.addNode(new FieldNode("PROINSNAM", new MsgField(ContentEnum.MessageType.STRING.toString(), "PROINSNAM", 26, 0, false, "当前流程名称")))
			.addNode(new FieldNode("FLOW_FLAG", new MsgField(ContentEnum.MessageType.STRING.toString(), "FLOW_FLAG", 27, 0, false, "任务提交标识")))
			.addNode(new FieldNode("BATCHID", new MsgField(ContentEnum.MessageType.STRING.toString(), "BATCHID", 100, 0, false, "影像批次号")))
			.addNode(new FieldNode("CASEID", new MsgField(ContentEnum.MessageType.STRING.toString(), "CASEID", 100, 0, false, "消息的接收队列")))
			.addNode(new FieldNode("TotalnumResult", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotalnumResult", 100, 0, false, "凭证扫描张数")))
			.addNode(new FieldNode("OcrnumResult", new MsgField(ContentEnum.MessageType.STRING.toString(), "OcrnumResult", 200, 0, false, "凭证识别张数")))
			.addNode(new ArrayNode("CONTENT")
					.addNode(new FieldNode("FileName", new MsgField(ContentEnum.MessageType.STRING.toString(), "FileName", 200, 0, false, "影像名称")))
					.addNode(new FieldNode("TypeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TypeName", 200, 0, false, "图片类型")))
					.addNode(new FieldNode("FloatName", new MsgField(ContentEnum.MessageType.STRING.toString(), "FloatName", 200, 0, false, "板式代码")))
					).addNode(new ArrayNode("AUTOVALUE")
							.addNode(new FieldNode("IsseDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsseDt", 20, 0, false, "出票日期")))
							.addNode(new FieldNode("TranAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranAm", 20, 0, false, "交易金额")))
							.addNode(new FieldNode("IncfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncfNo", 32, 0, false, "票据号码")))
							).addNode(new FieldNode("menutrcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "menutrcd", 50, 0, false, "菜单码")))
			.addNode(new FieldNode("winame", new MsgField(ContentEnum.MessageType.STRING.toString(), "winame", 20, 0, false, "窗口码")))
			.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 20, 0, false, "操作支行")))
			.addNode(new FieldNode("csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxno", 10, 0, false, "柜员钱箱号")))
			.addNode(new FieldNode("dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytp", 10, 0, false, "岗位类型")))
			.addNode(new FieldNode("dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyno", 20, 0, false, "实体岗位编号")))
			.addNode(new FieldNode("authno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authno", 20, 0, false, "授权柜员号")))
			.addNode(new FieldNode("abaufg", new MsgField(ContentEnum.MessageType.STRING.toString(), "abaufg", 10, 0, false, "新前端集中授权检查标识")))
			.addNode(new FieldNode("isab", new MsgField(ContentEnum.MessageType.STRING.toString(), "isab", 20, 0, false, "新综合前端柜面标识")))
			.addNode(new FieldNode("spckcdc", new MsgField(ContentEnum.MessageType.STRING.toString(), "spckcdc", 20, 0, false, "主机控制前端上送脚本")))
			.addNode(new FieldNode("fglwided", new MsgField(ContentEnum.MessageType.STRING.toString(), "fglwided", 255, 0, false, "法人身份证到期提示,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgvldtcf", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgvldtcf", 255, 0, false, "支票超期付款提示,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgzeroac", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgzeroac", 255, 0, false, "零余额账户提示,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgovdutg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgovdutg", 255, 0, false, "钱箱配对确认标志,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgfesave", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgfesave", 255, 0, false, "未清收费提示,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgckflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgckflag", 255, 0, false, "主机控制前端上送脚本")))
			.addNode(new FieldNode("fgckfrac", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgckfrac", 255, 0, false, "结汇待支付检查标志,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgckidtf", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgckidtf", 255, 0, false, "灰名单提示,主机控制前端上送脚本")))
			.addNode(new FieldNode("fginsptg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fginsptg", 10, 0, false, "信用代码过期标志")))
			.addNode(new FieldNode("casetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "casetype", 20, 0, false, "影像模型")))
			.addNode(new FieldNode("txttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "txttype", 20, 0, false, "文档部件名")))
			.addNode(new ArrayNode("OCRCOUNT")
					.addNode(new FieldNode("fileno", new MsgField(ContentEnum.MessageType.STRING.toString(), "fileno", 200, 0, false, "影像图片id")))
					)
			.addNode(new FieldNode("startnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "startnumber", 20, 0, false, "交易发起渠道编号")))
			.addNode(new FieldNode("startcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "startcode", 20, 0, false, "交易发起渠道代码")))
			.addNode(new ArrayNode("img_list")
					.addNode(new FieldNode("nodename", new MsgField(ContentEnum.MessageType.STRING.toString(), "nodename", 100, 0, false, "影像目录名称")))
					.addNode(new FieldNode("nodedesc", new MsgField(ContentEnum.MessageType.STRING.toString(), "nodedesc", 100, 0, false, "影像KEY值")))
					);
			messageNode.addStructNode(headStruct);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			// TODO 自动生成的方法存根
			return msgSegment.getNodeList();
		}
	}

	public static class AppHeaderO extends MsgHeader {
		private  MsgSegment  msgSegment = init();

		private  MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			StructNode headStruct = new StructNode("AppHeader");
			headStruct.addNode(new FieldNode("CBOE_TRADECODE", new MsgField(ContentEnum.MessageType.STRING.toString(), "CBOE_TRADECODE", 30, 0, true, "子流程交易码")))
			.addNode(new FieldNode("TASKID", new MsgField(ContentEnum.MessageType.STRING.toString(), "TASKID", 24, 0, false, "子流程任务号")))
			.addNode(new FieldNode("TRANSID", new MsgField(ContentEnum.MessageType.STRING.toString(), "TRANSID", 30, 0, false, "流程id")))
			.addNode(new FieldNode("FLOWID", new MsgField(ContentEnum.MessageType.STRING.toString(), "FLOWID", 20, 0, false, "子流程工作流ID")))
			.addNode(new FieldNode("MAIN_TASKID", new MsgField(ContentEnum.MessageType.STRING.toString(), "MAIN_TASKID", 22, 0, false, "主流程任务号")))
			.addNode(new FieldNode("MAIN_FLOWID", new MsgField(ContentEnum.MessageType.STRING.toString(), "MAIN_FLOWID", 20, 0, false, "子流程工作流ID")))
			.addNode(new FieldNode("WORKITEM_FLAG", new MsgField(ContentEnum.MessageType.STRING.toString(), "WORKITEM_FLAG", 2, 0, false, "工作项标志")))
			.addNode(new FieldNode("SENDDATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "SENDDATE", 20, 0, false, "任务发起日期")))
			.addNode(new FieldNode("YY_GUID", new MsgField(ContentEnum.MessageType.STRING.toString(), "YY_GUID", 50, 0, false, "验印影像ID")))
			.addNode(new FieldNode("LAST_SEQUENCE", new MsgField(ContentEnum.MessageType.STRING.toString(), "LAST_SEQUENCE", 2, 0, false, "上一时序")))
			.addNode(new FieldNode("NOW_SEQUENCE", new MsgField(ContentEnum.MessageType.STRING.toString(), "NOW_SEQUENCE", 2, 0, false, "当前时序")))
			.addNode(new FieldNode("NODE_NAME", new MsgField(ContentEnum.MessageType.STRING.toString(), "NODE_NAME", 20, 0, false, "角色号")))
			.addNode(new FieldNode("WORKITEM_ID", new MsgField(ContentEnum.MessageType.STRING.toString(), "WORKITEM_ID", 21, 0, false, "工作项ID")))
			.addNode(new FieldNode("LSTNODNAM", new MsgField(ContentEnum.MessageType.STRING.toString(), "LSTNODNAM", 22, 0, false, "前一个岗位的名称号")))
			.addNode(new FieldNode("STS", new MsgField(ContentEnum.MessageType.STRING.toString(), "STS", 23, 0, false, "岗位状态")))
			.addNode(new FieldNode("STATE", new MsgField(ContentEnum.MessageType.STRING.toString(), "STATE", 24, 0, false, "前端显示界面的标识")))
			.addNode(new FieldNode("PROSTS", new MsgField(ContentEnum.MessageType.STRING.toString(), "PROSTS", 25, 0, false, "流程状态")))
			.addNode(new FieldNode("PROINSNAM", new MsgField(ContentEnum.MessageType.STRING.toString(), "PROINSNAM", 26, 0, false, "当前流程名称")))
			.addNode(new FieldNode("FLOW_FLAG", new MsgField(ContentEnum.MessageType.STRING.toString(), "FLOW_FLAG", 27, 0, false, "任务提交标识")))
			.addNode(new FieldNode("BATCHID", new MsgField(ContentEnum.MessageType.STRING.toString(), "BATCHID", 100, 0, false, "影像批次号")))
			.addNode(new FieldNode("CASEID", new MsgField(ContentEnum.MessageType.STRING.toString(), "CASEID", 100, 0, false, "消息的接收队列")))
			.addNode(new FieldNode("TotalnumResult", new MsgField(ContentEnum.MessageType.STRING.toString(), "TotalnumResult", 100, 0, false, "凭证扫描张数")))
			.addNode(new FieldNode("OcrnumResult", new MsgField(ContentEnum.MessageType.STRING.toString(), "OcrnumResult", 200, 0, false, "凭证识别张数")))
			.addNode(new ArrayNode("CONTENT")
					.addNode(new FieldNode("FileName", new MsgField(ContentEnum.MessageType.STRING.toString(), "FileName", 200, 0, false, "影像名称")))
					.addNode(new FieldNode("TypeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "TypeName", 200, 0, false, "图片类型")))
					.addNode(new FieldNode("FloatName", new MsgField(ContentEnum.MessageType.STRING.toString(), "FloatName", 200, 0, false, "板式代码")))
					).addNode(new ArrayNode("AUTOVALUE")
							.addNode(new FieldNode("IsseDt", new MsgField(ContentEnum.MessageType.STRING.toString(), "IsseDt", 20, 0, false, "出票日期")))
							.addNode(new FieldNode("TranAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranAm", 20, 0, false, "交易金额")))
							.addNode(new FieldNode("IncfNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "IncfNo", 32, 0, false, "票据号码")))
							).addNode(new FieldNode("menutrcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "menutrcd", 50, 0, false, "菜单码")))
			.addNode(new FieldNode("winame", new MsgField(ContentEnum.MessageType.STRING.toString(), "winame", 20, 0, false, "窗口码")))
			.addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 20, 0, false, "操作支行")))
			.addNode(new FieldNode("csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxno", 10, 0, false, "柜员钱箱号")))
			.addNode(new FieldNode("dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytp", 10, 0, false, "岗位类型")))
			.addNode(new FieldNode("dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyno", 20, 0, false, "实体岗位编号")))
			.addNode(new FieldNode("authno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authno", 20, 0, false, "授权柜员号")))
			.addNode(new FieldNode("abaufg", new MsgField(ContentEnum.MessageType.STRING.toString(), "abaufg", 10, 0, false, "新前端集中授权检查标识")))
			.addNode(new FieldNode("isab", new MsgField(ContentEnum.MessageType.STRING.toString(), "isab", 20, 0, false, "新综合前端柜面标识")))
			.addNode(new FieldNode("spckcdc", new MsgField(ContentEnum.MessageType.STRING.toString(), "spckcdc", 20, 0, false, "主机控制前端上送脚本")))
			.addNode(new FieldNode("fglwided", new MsgField(ContentEnum.MessageType.STRING.toString(), "fglwided", 255, 0, false, "法人身份证到期提示,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgvldtcf", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgvldtcf", 255, 0, false, "支票超期付款提示,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgzeroac", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgzeroac", 255, 0, false, "零余额账户提示,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgovdutg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgovdutg", 255, 0, false, "钱箱配对确认标志,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgfesave", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgfesave", 255, 0, false, "未清收费提示,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgckflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgckflag", 255, 0, false, "主机控制前端上送脚本")))
			.addNode(new FieldNode("fgckfrac", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgckfrac", 255, 0, false, "结汇待支付检查标志,主机控制前端上送脚本")))
			.addNode(new FieldNode("fgckidtf", new MsgField(ContentEnum.MessageType.STRING.toString(), "fgckidtf", 255, 0, false, "灰名单提示,主机控制前端上送脚本")))
			.addNode(new FieldNode("fginsptg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fginsptg", 10, 0, false, "信用代码过期标志")))
			.addNode(new FieldNode("casetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "casetype", 20, 0, false, "影像模型")))
			.addNode(new FieldNode("txttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "txttype", 20, 0, false, "文档部件名")))
			.addNode(new ArrayNode("OCRCOUNT")
					.addNode(new FieldNode("fileno", new MsgField(ContentEnum.MessageType.STRING.toString(), "fileno", 200, 0, false, "影像图片id")))
					)
			.addNode(new FieldNode("startnumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "startnumber", 20, 0, false, "交易发起渠道编号")))
			.addNode(new FieldNode("startcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "startcode", 20, 0, false, "交易发起渠道代码")));
			messageNode.addStructNode(headStruct);
			messageNode.addStructNode(headStruct);
			return messageNode;
		}
		/* （非 Javadoc）
		 * @see cn.com.agree.huanan.ap.tl.communicate.content.format.MsgFormat#listNode()
		 */
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}


	public void initContent(Map<String, Object> tradeContext) {
		Map<String,Object> Header = (Map) tradeContext.get("Header");
		Header.put("Action", CommConstant.NAMESPACE+tradeContext.get("AtSysSvc")+"/"+tradeContext.get("AtSysScn"));
		Header.put("Address", CommConstant.SYSCODE);
		Map<String,Object> appHeader = (Map) tradeContext.get("AppHeader");		
		appHeader.put("txn_code", tradeContext.get("AtExtCode"));
		Map<String,Object> CsisHeader = (Map) tradeContext.get("CsisHeader");
		CsisHeader.put("SrcDate", DateTimeUtil.getSysDate());
		CsisHeader.put("SrcTime", DateTimeUtil.getSysTime());
		CsisHeader.put("ReqNo", CsisHeader.get(CommConstant.__REQNO__)==null?SernoGenUtil.getSerno(CommParam.ATOM_SEQ):CsisHeader.get(CommConstant.__REQNO__));
		if (null != appHeader.get("tagsysheader")) {
			appHeader.putAll((Map<String, Object>)appHeader.get("tagsysheader"));
		}
	}


	@Override
	public Map<String,Object> buildInMessageContext(Map<String, Object> tradeContext) {
		tradeContext = super.buildInMessageContext(tradeContext);
		initContent(tradeContext);
		return tradeContext;
	}

}
