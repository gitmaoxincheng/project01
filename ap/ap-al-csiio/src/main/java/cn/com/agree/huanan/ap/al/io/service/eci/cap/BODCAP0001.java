package cn.com.agree.huanan.ap.al.io.service.eci.cap;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODCAP0001  申请进度查询 
 *  BODCAP0001 ar2210
 *  柜面透传
 * @author XZF
 */
@Component
public class BODCAP0001 extends EciChannelService {

	private static BODCAP0001_I i = new BODCAP0001_I();
	private static BODCAP0001_O o = new BODCAP0001_O();
	public BODCAP0001() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODCAP0001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("trxn_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "trxn_seq", 40,0, false, "交易流水" )))
					.addNode(new FieldNode("busi_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_seq", 40,0, false, "业务流水" )))
					.addNode(new FieldNode("sponsor_system", new MsgField(ContentEnum.MessageType.STRING.toString(), "sponsor_system", 40,0, false, "发起方系统编号" )))
					.addNode(new FieldNode("caller_system", new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_system", 40,0, false, "调用方系统编号" )))
					.addNode(new FieldNode("busi_org_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_org_id", 10,0, false, "业务法人" )))
					.addNode(new FieldNode("channel_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel_id", 40,0, true, "渠道" )))
					.addNode(new FieldNode("caller_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_date", 8,0, true, "调用方日期" )))
					.addNode(new FieldNode("busi_teller_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_teller_id", 32,0, false, "交易柜员" )))
					.addNode(new FieldNode("busi_branch_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_branch_id", 10,0, false, "业务机构ID" )))
					.addNode(new FieldNode("page_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_no", 19,0, false, "分页页码" )))
					.addNode(new FieldNode("page_size", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_size", 19,0, false, "每页返回数量" )))
					.addNode(new FieldNode("appl_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_no", 40,0, false, "申请编号" )))
					.addNode(new FieldNode("full_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "full_name", 120,0, false, "申请人姓名" )))
					.addNode(new FieldNode("id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_no", 32,0, false, "证件号码" )))
					.addNode(new FieldNode("start_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "start_date", 8,0, false, "开始日期" )))
					.addNode(new FieldNode("end_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_date", 8,0, false, "结束日期" )))
					.addNode(new FieldNode("card_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_no", 35,0, false, "卡号" )))
					.addNode(new FieldNode("mobile_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile_no", 11,0, false, "手机号码" )))
					.addNode(new FieldNode("wf_task_def_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "wf_task_def_id", 64,0, false, "当前节点名称ID" )))
					.addNode(new FieldNode("cust_manager_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_id", 32,0, false, "客户经理ID" )))
					.addNode(new FieldNode("cust_manager_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_name", 120,0, false, "客户经理名称" )))
					.addNode(new FieldNode("brch_belong", new MsgField(ContentEnum.MessageType.STRING.toString(), "brch_belong", 10,0, false, "机构号" )))
					.addNode(new FieldNode("page_size", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_size", 8,0, false, "页面记录大小" )))
					.addNode(new FieldNode("page_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_no", 8,0, false, "当前页码" )))
					.addNode(new FieldNode("appl_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_status", 10,0, false, "审批状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODCAP0001_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("trxn_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "trxn_code", 10,0, false, "交易处理码" )))
					.addNode(new FieldNode("trxn_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "trxn_seq", 32,0, false, "交易流水" )))
					.addNode(new FieldNode("busi_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_seq", 32,0, false, "业务流水" )))
					.addNode(new FieldNode("sponsor_system", new MsgField(ContentEnum.MessageType.STRING.toString(), "sponsor_system", 16,0, false, "发起方系统编号" )))
					.addNode(new FieldNode("caller_system", new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_system", 16,0, false, "调用方系统编号" )))
					.addNode(new FieldNode("channel_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel_id", 10,0, true, "渠道" )))
					.addNode(new FieldNode("trxn_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "trxn_date", 8,0, true, "交易日期" )))
					.addNode(new FieldNode("busi_branch_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_branch_id", 10,0, false, "业务机构ID" )))
					.addNode(new FieldNode("busi_teller_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_teller_id", 32,0, false, "交易柜员" )))
					.addNode(new FieldNode("page_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_no", 19,0, false, "分页页码" )))
					.addNode(new FieldNode("page_size", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_size", 19,0, false, "每页返回数量" )))
					.addNode(new FieldNode("total_count", new MsgField(ContentEnum.MessageType.STRING.toString(), "total_count", 19,0, false, "总共数量" )))
					.addNode(new FieldNode("busi_org_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_org_id", 10,0, false, "业务法人" )))
					.addNode(new FieldNode("compute_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "compute_date", 8,0, true, "电脑日期" )))
					.addNode(new FieldNode("compute_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "compute_time", 8,0, false, "电脑时间" )))
					.addNode(new ArrayNode("bodrcd",true)
							.addNode(new FieldNode("appl_type_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_type_id", 40,0, false, "申请类型" )))
							.addNode(new FieldNode("appl_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_no", 40,0, false, "申请编号" )))
							.addNode(new FieldNode("full_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "full_name", 120,0, false, "客户姓名" )))
							.addNode(new FieldNode("id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_no", 32,0, false, "证件号码" )))
							.addNode(new FieldNode("appl_status_desc", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_status_desc", 10,0, false, "审批状态" )))
							.addNode(new FieldNode("wf_task_def_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "wf_task_def_name", 100,0, false, "流程节点定义名称" )))
							.addNode(new FieldNode("total_count", new MsgField(ContentEnum.MessageType.STRING.toString(), "total_count", 8,0, false, "总记录数" )))
							.addNode(new FieldNode("approve_crd_amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "approve_crd_amount", 21,0, false, "核准卡级额度" )))
							.addNode(new FieldNode("request_ipp_amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "request_ipp_amount", 21,0, false, "申请分期额度" )))
							.addNode(new FieldNode("ipp_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_limit", 21,0, false, "分期额度" )))
							.addNode(new FieldNode("ad_crd_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "ad_crd_limit", 21,0, false, "附卡额度" )))
							.addNode(new FieldNode("decline_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "decline_code", 4,0, false, "拒绝代码" )))
							.addNode(new FieldNode("decline_desc", new MsgField(ContentEnum.MessageType.STRING.toString(), "decline_desc", 500,0, false, "拒绝描述" )))
							.addNode(new FieldNode("decline_desc_sub", new MsgField(ContentEnum.MessageType.STRING.toString(), "decline_desc_sub", 500,0, false, "支行拒绝描述" )))
							.addNode(new FieldNode("wf_task_task_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "wf_task_task_time", 8,0, false, "进入当前节点时间" )))
							.addNode(new FieldNode("card_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_no", 35,0, false, "卡号" )))
							.addNode(new FieldNode("supp_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "supp_ind", 20,0, false, "主附卡标识" )))
							.addNode(new FieldNode("product_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "product_code", 20,0, false, "产品代码" )))
							.addNode(new FieldNode("product_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "product_name", 100,0, false, "产品简称" )))
							.addNode(new FieldNode("mobile_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "mobile_no", 11,0, false, "手机号码" )))
							.addNode(new FieldNode("cust_manager_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_id", 32,0, false, "客户经理ID" )))
							.addNode(new FieldNode("cust_manager_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_name", 120,0, false, "客户经理名称" )))
							.addNode(new FieldNode("data_create_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "data_create_time", 23,0, false, "登记时间" )))
							.addNode(new FieldNode("appl_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_status", 10,0, false, "审批状态" )))
							.addNode(new FieldNode("wf_proc_inst_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "wf_proc_inst_id", 64,0, false, "工作流流程实例id" )))
							.addNode(new FieldNode("wf_task_inst_assignee", new MsgField(ContentEnum.MessageType.STRING.toString(), "wf_task_inst_assignee", 64,0, false, "当前处理人ID" )))
							.addNode(new FieldNode("user_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "user_name", 64,0, false, "当前处理人姓名" )))
							.addNode(new FieldNode("request_amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "request_amount", 21,0, false, "请求金额" )))
							.addNode(new FieldNode("approve_adj_limit", new MsgField(ContentEnum.MessageType.STRING.toString(), "approve_adj_limit", 21,0, false, "核准调额额度" )))
							.addNode(new FieldNode("data_create_user", new MsgField(ContentEnum.MessageType.STRING.toString(), "data_create_user", 32,0, false, "登记员" )))
							.addNode(new FieldNode("adjust_limit_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "adjust_limit_type", 1,0, false, "调额额度类型" )))
							.addNode(new FieldNode("first_use", new MsgField(ContentEnum.MessageType.STRING.toString(), "first_use", 32,0, false, "一级用途" )))
							.addNode(new FieldNode("second_use", new MsgField(ContentEnum.MessageType.STRING.toString(), "second_use", 32,0, false, "二级用途" )))
							.addNode(new FieldNode("ipp_config_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_config_code", 20,0, false, "分期配置代码" )))
							.addNode(new FieldNode("period_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "period_no", 10,0, false, "分期期数" )))
							.addNode(new FieldNode("fee_rate", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_rate", 4,0, false, "手续费率" )))
							.addNode(new FieldNode("payee_acct_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "payee_acct_no", 1024,0, false, "收款账号" )))
							.addNode(new FieldNode("payee_acct_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "payee_acct_name", 120,0, false, "收款账户名" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	@Override
	public void initContent(Map<String, Object> tradeContext) {
		Map<String, Object> appHeader = (Map<String, Object>) tradeContext.get(CommConstant.APP_HEADER);
		appHeader.put("xmlflag", "1");
		appHeader.put("templateCodeName", "params");
		appHeader.put("transCode", "ar2210");
		appHeader.put("sysId", "121");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "ar2210");

		Map<String, Object> appBody = (Map<String, Object>) tradeContext.get(CommConstant.APP_BODY);
		Map<String, Object> csisHeader = (Map<String, Object>) tradeContext.get(CommConstant.CSIS_HEADER);
		appBody.put("trxn_seq", csisHeader.get("GloSeqNo"));
		appBody.put("busi_seq", csisHeader.get("ReqNo"));
		appBody.put("sponsor_system", "0464");
		appBody.put("caller_system", "901");
		appBody.put("busi_org_id", csisHeader.get("MyBank"));
		appBody.put("channel_id", "NMP");
		appBody.put("caller_date", csisHeader.get("SrcDate"));
		appBody.put("busi_teller_id", csisHeader.get("TellerNo"));
		appBody.put("busi_branch_id", csisHeader.get("BrNo"));
		super.initContent(tradeContext);
	}
}

