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
 * BASESVC BODCAP0004  待办任务查询(补件查询)
 * BODCAP0004 ap0101 ap0101
 *  信审平台
 * @author WYJ
 */
@Component
public class BODCAP0004 extends EciChannelService {

	private static BODCAP0004_I i = new BODCAP0004_I();
	private static BODCAP0004_O o = new BODCAP0004_O();

	public BODCAP0004() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODCAP0004_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("trxn_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "trxn_seq", 40,0, false, "交易流水" )))
					.addNode(new FieldNode("busi_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_seq", 40,0, false, "业务流水" )))
					.addNode(new FieldNode("sponsor_system", new MsgField(ContentEnum.MessageType.STRING.toString(), "sponsor_system", 40,0, false, "发起方系统编号" )))
					.addNode(new FieldNode("caller_system", new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_system", 40,0, false, "调用方系统编号" )))
					.addNode(new FieldNode("busi_org_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_org_id", 10,0, false, "业务法人" )))
					.addNode(new FieldNode("channel_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel_id", 40,0, false, "渠道" )))
					.addNode(new FieldNode("caller_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_date", 8,0, false, "调用方日期" )))
					.addNode(new FieldNode("busi_teller_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_teller_id", 32,0, false, "交易柜员" )))
					.addNode(new FieldNode("busi_branch_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_branch_id", 10,0, false, "业务机构ID" )))
					.addNode(new FieldNode("page_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_no", 19,0, false, "分页页码" )))
					.addNode(new FieldNode("page_size", new MsgField(ContentEnum.MessageType.STRING.toString(), "page_size", 19,0, false, "每页返回数量" )))
					.addNode(new FieldNode("org_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_id", 10,0, false, "业务法人代码" )))
					.addNode(new FieldNode("wf_product_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "wf_product_code", 64,0, false, "工作流产品代码" )))
					.addNode(new FieldNode("busi_seq_appno", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_seq_appno", 32,0, false, "申请编号" )))
					.addNode(new FieldNode("ref_seq1", new MsgField(ContentEnum.MessageType.STRING.toString(), "ref_seq1", 32,0, false, "申请类型" )))
					.addNode(new FieldNode("ref_seq2", new MsgField(ContentEnum.MessageType.STRING.toString(), "ref_seq2", 32,0, false, "手机号码" )))
					.addNode(new FieldNode("ref_seq3", new MsgField(ContentEnum.MessageType.STRING.toString(), "ref_seq3", 32,0, false, "客户姓名" )))
					.addNode(new FieldNode("id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_no", 32,0, false, "证件号码" )))
					.addNode(new FieldNode("cust_manager_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_id", 32,0, false, "客户经理ID" )))
					.addNode(new FieldNode("cust_manager_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_name", 200,0, false, "客户经理名称" )))
					.addNode(new FieldNode("start_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "start_date", 8,0, false, "开始日期" )))
					.addNode(new FieldNode("end_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_date", 8,0, false, "结束日期" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODCAP0004_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new ArrayNode("bodrcd", false, "task_list")
							.addNode(new FieldNode("org_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_id", 10,0, false, "业务法人代码" )))
							.addNode(new FieldNode("wf_product_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "wf_product_code", 64,0, false, "工作流产品代码" )))
							.addNode(new FieldNode("busi_seq_appno", new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_seq_appno", 32,0, false, "申请编号" )))
							.addNode(new FieldNode("ref_seq1", new MsgField(ContentEnum.MessageType.STRING.toString(), "ref_seq1", 32,0, false, "申请类型" )))
							.addNode(new FieldNode("ref_seq2", new MsgField(ContentEnum.MessageType.STRING.toString(), "ref_seq2", 32,0, false, "手机号码" )))
							.addNode(new FieldNode("ref_seq3", new MsgField(ContentEnum.MessageType.STRING.toString(), "ref_seq3", 32,0, false, "客户姓名" )))
							.addNode(new FieldNode("ref_seq4", new MsgField(ContentEnum.MessageType.STRING.toString(), "ref_seq4", 32,0, false, "预留字段" )))
							.addNode(new FieldNode("wf_proc_inst_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "wf_proc_inst_id", 64,0, false, "流程实例ID" )))
							.addNode(new FieldNode("wf_task_inst_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "wf_task_inst_id", 64,0, false, "任务实例ID" )))
							.addNode(new FieldNode("wf_task_def_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "wf_task_def_id", 64,0, false, "任务定义ID" )))
							.addNode(new FieldNode("main_busi_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "main_busi_seq", 32,0, false, "主申请编号" )))
							.addNode(new FieldNode("id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_no", 32,0, false, "证件号码" )))
							.addNode(new FieldNode("cust_manager_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_id", 32,0, false, "客户经理ID" )))
							.addNode(new FieldNode("cust_manager_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_name", 200,0, false, "客户经理名称" )))
							.addNode(new FieldNode("data_create_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "data_create_time", 23,0, false, "登记时间" )))
							)
					);
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
		appHeader.put("transCode", "ap0101");
		appHeader.put("sysId", "121");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "ap0101");

		Map<String, Object> appBody = (Map<String, Object>) tradeContext.get(CommConstant.APP_BODY);
		Map<String, Object> csisHeader = (Map<String, Object>) tradeContext.get(CommConstant.CSIS_HEADER);
		appBody.put("trxn_seq", csisHeader.get("GloSeqNo"));
		appBody.put("busi_seq", csisHeader.get("ReqNo"));
		appBody.put("sponsor_system", "0104");
		appBody.put("caller_system", "901");
		appBody.put("busi_org_id", csisHeader.get("MyBank"));
		appBody.put("channel_id", "MMP");
		appBody.put("caller_date", csisHeader.get("SrcDate"));
		appBody.put("busi_teller_id", csisHeader.get("TellerNo"));
		appBody.put("busi_branch_id", csisHeader.get("BrNo"));
		super.initContent(tradeContext);
	}

}
