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
 * @author xzf
 * ESB 新核心系统IO通讯服务 ZZC要求P031000701发送不要AppHeader
 * json报文
 */
public class EsbCore1ChannelService extends IOService {
	
	private static EsbHeaderI esbHeaderI = new EsbHeaderI();
	private static EsbHeaderO esbHeaderO = new EsbHeaderO();
	private static HeaderI headerI = new HeaderI();
	private static HeaderO headerO = new HeaderO();
	private static AppHeaderI appHeaderI = new AppHeaderI();
	private static AppHeaderO appHeaderO = new AppHeaderO();
	public EsbCore1ChannelService() {
		requestFormat.add(esbHeaderI);
		requestFormat.add(headerI);
//		requestFormat.add(appHeaderI);
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
			headStruct.addNode(new FieldNode("txn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_code", 20, 0, true, "交易码")))//txn_code由 原子服务表记录
					  .addNode(new FieldNode("cfrm_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "cfrm_flg", 1, 0, false, "确认标志")))
					  .addNode(new FieldNode("seal_vrfcn_rslt", new MsgField(ContentEnum.MessageType.STRING.toString(), "seal_vrfcn_rslt", 4, 0, false, "验印结果")))
					  .addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10, 0, false, "授权柜员")))
					  .addNode(new FieldNode("key_source", new MsgField(ContentEnum.MessageType.STRING.toString(), "key_source", 10, 0, false, "密钥来源")))
					  .addNode(new FieldNode("device_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "device_num", 20, 0, false, "终端设备号")))
					  .addNode(new FieldNode("ecrpt_seed", new MsgField(ContentEnum.MessageType.STRING.toString(), "ecrpt_seed", 20, 0, false, "加密因子")))
					  .addNode(new ArrayNode("dalrinfo")
							.addNode(new FieldNode("agnt_docs_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_catg", 10, 0, false, "代理人证件类型")))
					  		.addNode(new FieldNode("agnt_docs_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_docs_num", 80, 0, false, "代理人证件号码")))
  							.addNode(new FieldNode("agnt_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_nm", 100, 0, false, "消息处理方法")))
  							.addNode(new FieldNode("agnt_cntct_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_cntct_tel", 20, 0, false, "代理人联系电话")))
  							.addNode(new FieldNode("agnt_nationality", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_nationality", 10, 0,false, "代理人国籍")))
  							.addNode(new FieldNode("agnt_relation", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_relation", 10, 0, false, "与申请人关系")))
  							.addNode(new FieldNode("agnt_remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "agnt_remks_info", 400, 0, false, "代理人备注信息")))
  							  )
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
			headStruct.addNode(new FieldNode("totl_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "totl_cnt_num", 10, 0, false, "总笔数")))
					  .addNode(new ArrayNode("tishxinx")//提示信息集合
  							.addNode(new FieldNode("hint_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "hint_info", 1500, 0, false, "提示信息")))
  							  )
					  .addNode(new ArrayNode("wrng_info")//警告信息集合
	  							.addNode(new FieldNode("wrng_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "wrng_info", 1500, 0, false, "警告信息")))
	  						  )
					  .addNode(new FieldNode("fee_cfrm_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_cfrm_flg", 1, 0, false, "费用确认标志")))
					  .addNode(new ArrayNode("cjsfsvrlst")//场景收费服务列表
	  							.addNode(new FieldNode("scen_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "scen_dsc", 1500, 0, false, "场景描述")))
	  							.addNode(new FieldNode("chrg_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code", 8, 0, false, "收费代码")))
	  							.addNode(new FieldNode("chrg_code_nm", new MsgField(ContentEnum.MessageType.STRING.toString(), "chrg_code_nm", 80, 0, false, "收费代码名称")))
	  							.addNode(new FieldNode("fee_rcvbl_amt", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "fee_rcvbl_amt", 17, 2, false, "标准收费金额")))
	  							.addNode(new FieldNode("rcvbl_amt", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "rcvbl_amt", 17, 2, false, "应收金额")))
	  							.addNode(new FieldNode("pref_pcnt", new MsgField(ContentEnum.MessageType.DECIMALS.toString(), "pref_pcnt", 17, 2, false, "优惠比例")))
	  							.addNode(new FieldNode("pref_amt", new MsgField(ContentEnum.MessageType.AMOUNT.toString(), "pref_amt", 17, 2, false, "优惠金额")))
	  							.addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.INT.toString(), "qty", 10, 0, false, "数量")))
	  						  )					  
					  ;
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
//		Map<String,Object> appHeader = (Map) tradeContext.get("AppHeader");		
//		appHeader.put("txn_code", tradeContext.get("AtExtCode"));
		Map<String,Object> CsisHeader = (Map) tradeContext.get("CsisHeader");
		CsisHeader.put("SrcDate", DateTimeUtil.getSysDate());
		CsisHeader.put("SrcTime", DateTimeUtil.getSysTime());
		CsisHeader.put("ReqNo", CsisHeader.get(CommConstant.__REQNO__)==null?SernoGenUtil.getSerno(CommParam.ATOM_SEQ):CsisHeader.get(CommConstant.__REQNO__));
//		if (null != appHeader.get("tagsysheader")) {
//			appHeader.putAll((Map<String, Object>)appHeader.get("tagsysheader"));
//		}
	}

	@Override
	public Map<String,Object> buildInMessageContext(Map<String, Object> tradeContext) {
		tradeContext = super.buildInMessageContext(tradeContext);
		initContent(tradeContext);
		return tradeContext;
	}


}
