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
 * @author XZ
 * 0026 联网身份核查系统
 * json报文  
 */ 
public class EsbIcsChannelService extends IOService {
	  
	private static EsbHeaderI esbHeaderI = new EsbHeaderI();
	private static EsbHeaderO esbHeaderO = new EsbHeaderO();
	private static HeaderI headerI = new HeaderI();
	private static HeaderO headerO = new HeaderO();
	private static AppHeaderI appHeaderI = new AppHeaderI();
	private static AppHeaderO appHeaderO = new AppHeaderO();
	public EsbIcsChannelService() {
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
		// TODO 自动生成的方法存根
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
			esbheadStruct.addNode(new FieldNode("VrsNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "VrsNo", 3, 0, true, "服务版本号")));
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
			esbheadStruct.addNode(new FieldNode("RespSts", new MsgField(ContentEnum.MessageType.STRING.toString(), "RespSts", 1, 0, false, "状态码"))); //原ESB文档为也服务方必输，但互联网金融平台的接口特殊处理
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
			headStruct.addNode(new FieldNode("SerSys", new MsgField(ContentEnum.MessageType.STRING.toString(), "SerSys", 4,0, true, "服务方的系统标识")))
					  .addNode(new FieldNode("xmlflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "xmlflag", 1,0, true, "报文标识")))
					  .addNode(new FieldNode("templateCodeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "templateCodeName", 7,0, true, "模板名称")))
					  .addNode(new FieldNode("transCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "transCode", 7,0, true, "交易代码")))
					  .addNode(new FieldNode("channelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelCode", 3,0, true, "渠道分类")))
					  .addNode(new FieldNode("subchannelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "subchannelCode", 3,0, false, "渠道标识")))
					  .addNode(new FieldNode("tradeFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeFlag", 1,0, false, "是否需要勾兑")))
					  .addNode(new FieldNode("checkFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "checkFlag", 1,0, false, "是否需要判重")))
					  .addNode(new FieldNode("sessid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sessid", 32,0, false, "会话标识")))
					  .addNode(new FieldNode("menutrcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "menutrcd", 20,0, false, "菜单码")))
					  .addNode(new FieldNode("winame", new MsgField(ContentEnum.MessageType.STRING.toString(), "winame", 20,0, false, "窗口码")))
					  .addNode(new FieldNode("checksession", new MsgField(ContentEnum.MessageType.STRING.toString(), "checksession", 32,0, false, "检索会话标识")))
					  .addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 10,0, false, "操作支行")))
					  .addNode(new FieldNode("csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxno", 10,0, false, "柜员钱箱号")))
					  .addNode(new FieldNode("dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytp", 10,0, false, "岗位类型")))
					  .addNode(new FieldNode("dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyno", 20,0, false, "实体岗位编号")))
					  .addNode(new FieldNode("vm_tellerflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellerflag", 1,0, false, "交易柜员使用标志")))
					  .addNode(new FieldNode("vm_sessid", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_sessid", 1,0, false, "交易柜员会话标识")))
					  .addNode(new FieldNode("vm_zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_zoneno", 10,0, false, "交易柜员操作分行")))
					  .addNode(new FieldNode("vm_mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_mbrno", 10,0, false, "交易柜员操作支行")))
					  .addNode(new FieldNode("vm_brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_brno", 10,0, false, "交易柜员操作网点")))
					  .addNode(new FieldNode("vm_tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellerno", 10,0, false, "交易柜员")))
					  .addNode(new FieldNode("vm_tellertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellertp", 1,0, false, "交易柜员柜员类别")))
					  .addNode(new FieldNode("vm_csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_csbxno", 10,0, false, "交易柜员柜员钱箱")))
					  .addNode(new FieldNode("vm_dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_dutytp", 10,0, false, "交易柜员岗位类型")))
					  .addNode(new FieldNode("vm_dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_dutyno", 20,0, false, "交易柜员岗位编号")))
					  .addNode(new FieldNode("authno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authno", 20,0, false, "授权柜员号")))
					  .addNode(new FieldNode("authpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "authpw", 20,0, false, "授权柜员密码")))
					  .addNode(new FieldNode("authmg", new MsgField(ContentEnum.MessageType.STRING.toString(), "authmg", 20,0, false, "授权柜员指纹")))
					  .addNode(new FieldNode("authce", new MsgField(ContentEnum.MessageType.STRING.toString(), "authce", 20,0, false, "授权柜员验证方式")))
					  .addNode(new FieldNode("authmanfttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "authmanfttype", 20,0, false, "授权员指纹厂商")))
					  .addNode(new FieldNode("promno", new MsgField(ContentEnum.MessageType.STRING.toString(), "promno", 20,0, false, "推荐人员代码")))
					  .addNode(new FieldNode("promna", new MsgField(ContentEnum.MessageType.STRING.toString(), "promna", 20,0, false, "推荐人名称")))
					  .addNode(new FieldNode("saleno", new MsgField(ContentEnum.MessageType.STRING.toString(), "saleno", 20,0, false, "营销人员代码")))
					  .addNode(new FieldNode("salena", new MsgField(ContentEnum.MessageType.STRING.toString(), "salena", 20,0, false, "营销人员名称")))
					  .addNode(new FieldNode("spckcd_c", new MsgField(ContentEnum.MessageType.STRING.toString(), "spckcd_c", 20,0, false, "主机控制前端上送脚本")))
					  .addNode(new FieldNode("fg_lwided", new MsgField(ContentEnum.MessageType.STRING.toString(), "fg_lwided", 255,0, false, "法人身份证到期提示,主机控制前端上送脚本")))
					  .addNode(new FieldNode("fg_vldtcf", new MsgField(ContentEnum.MessageType.STRING.toString(), "fg_vldtcf", 255,0, false, "支票超期付款提示,主机控制前端上送脚本")))
					  .addNode(new FieldNode("fg_zeroac", new MsgField(ContentEnum.MessageType.STRING.toString(), "fg_zeroac", 255,0, false, "零余额账户提示,主机控制前端上送脚本")))
					  .addNode(new FieldNode("fg_ovdutg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fg_ovdutg", 255,0, false, "钱箱配对确认标志,主机控制前端上送脚本")))
					  .addNode(new FieldNode("fg_fesave", new MsgField(ContentEnum.MessageType.STRING.toString(), "fg_fesave", 255,0, false, "未清收费提示,主机控制前端上送脚本")))
					  .addNode(new FieldNode("fg_ckflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "fg_ckflag", 255,0, false, "主机控制前端上送脚本")))
					  .addNode(new FieldNode("fg_ckfrac", new MsgField(ContentEnum.MessageType.STRING.toString(), "fg_ckfrac", 255,0, false, "结汇待支付检查标志,主机控制前端上送脚本")))
					  .addNode(new FieldNode("fg_ckidtf", new MsgField(ContentEnum.MessageType.STRING.toString(), "fg_ckidtf", 255,0, false, "灰名单提示,主机控制前端上送脚本")))
					  .addNode(new FieldNode("ISABS", new MsgField(ContentEnum.MessageType.STRING.toString(), "ISABS", 20,0, false, "新综合前端柜面标识")))
					  .addNode(new FieldNode("YTDFLAG", new MsgField(ContentEnum.MessageType.STRING.toString(), "YTDFLAG", 10,0, false, "新综合前端柜面预处理标识")))
					  .addNode(new FieldNode("YTDISINO", new MsgField(ContentEnum.MessageType.STRING.toString(), "YTDISINO", 40,0, false, "新综合前端柜面预处理前置流水号")))
					  .addNode(new FieldNode("abaufg", new MsgField(ContentEnum.MessageType.STRING.toString(), "abaufg", 10,0, false, "新前端集中授权检查标识")))
					  .addNode(new FieldNode("replyquery", new MsgField(ContentEnum.MessageType.STRING.toString(), "replyquery", 20,0, false, "请求应答队列名")))
					  .addNode(new FieldNode("script", new MsgField(ContentEnum.MessageType.STRING.toString(), "script", 255,0, false, "脚本信息")))
					  ;
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
	
	
	public void initContent(Map<String, Object> tradeContext) {
		Map<String,Object> Header = (Map) tradeContext.get("Header");
		Header.put("Action", CommConstant.NAMESPACE+tradeContext.get("AtSysSvc")+"/"+tradeContext.get("AtSysScn"));
		Header.put("Address", CommConstant.SYSCODE);
		Map<String,Object> CsisHeader = (Map) tradeContext.get("CsisHeader");
		CsisHeader.put("SrcDate", DateTimeUtil.getSysDate());
		CsisHeader.put("SrcTime", DateTimeUtil.getSysTime());
		CsisHeader.put("ReqNo", CsisHeader.get(CommConstant.__REQNO__)==null?SernoGenUtil.getSerno(CommParam.ATOM_SEQ):CsisHeader.get(CommConstant.__REQNO__));
		Map<String,Object> appHeader = (Map) tradeContext.get("AppHeader");		
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
