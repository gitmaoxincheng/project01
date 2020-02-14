package cn.com.agree.huanan.ap.al.io.service.eci.cap;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODCAP0034  渠道端已有卡单独分期申请接口
 * BODCAP0034 ar1510 ar1510
 *  信审平台
 * @author WYJ
 */
@Component
public class BODCAP0034 extends EciChannelService {

	private static BODCAP0034_I i = new BODCAP0034_I();
	private static BODCAP0034_O o = new BODCAP0034_O();

	public BODCAP0034() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODCAP0034_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody", true, "Body")
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
					.addNode(new FieldNode("appl_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_no", 40,0, false, "申请编号" )))
					.addNode(new FieldNode("full_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "full_name", 120,0, false, "申请人姓名" )))
					.addNode(new FieldNode("appl_type_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_type_id", 40,0, false, "申请类型ID" )))
					.addNode(new FieldNode("cust_manager_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_id", 32,0, false, "客户经理ID" )))
					.addNode(new FieldNode("cust_manager_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "cust_manager_name", 120,0, false, "客户经理名称" )))
					.addNode(new FieldNode("brch_belong", new MsgField(ContentEnum.MessageType.STRING.toString(), "brch_belong", 10,0, false, "所属机构" )))
					.addNode(new FieldNode("payee_acct_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "payee_acct_no", 40,0, false, "收款账号" )))
					.addNode(new FieldNode("remark", new MsgField(ContentEnum.MessageType.STRING.toString(), "remark", 500,0, false, "备注" )))
					.addNode(new FieldNode("card_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_no", 35,0, false, "卡号" )))
					.addNode(new FieldNode("id_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_type", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("id_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "id_no", 32,0, false, "证件号码" )))
					.addNode(new FieldNode("request_ipp_amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "request_ipp_amount", 21,0, false, "申请分期额度" )))
					.addNode(new FieldNode("period_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "period_id", 19,0, false, "期数ID" )))
					.addNode(new FieldNode("ipp_fee_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_fee_id", 11,0, false, "分期费率ID" )))
					.addNode(new FieldNode("fee_rate", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_rate", 4,0, false, "手续费率" )))
					.addNode(new FieldNode("fee_charge_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "fee_charge_type", 1,0, false, "手续费收取方式" )))
					.addNode(new FieldNode("payee_bank_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "payee_bank_id", 16,0, false, "收款行ID" )))
					.addNode(new FieldNode("payee_bank_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "payee_bank_name", 120,0, false, "收款行名称" )))
					.addNode(new FieldNode("payee_acct_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "payee_acct_name", 120,0, false, "收款户名" )))
					.addNode(new FieldNode("payto_method", new MsgField(ContentEnum.MessageType.STRING.toString(), "payto_method", 1,0, false, "资金支付方式" )))
					.addNode(new FieldNode("ipp_product_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_product_code", 5,0, false, "分期产品代码" )))
					.addNode(new FieldNode("ipp_purpose", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_purpose", 512,0, false, "分期用途" )))
					.addNode(new FieldNode("ipp_purpose_other", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_purpose_other", 100,0, false, "分期用途其他" )))
					.addNode(new FieldNode("issigned", new MsgField(ContentEnum.MessageType.STRING.toString(), "issigned", 1,0, false, "申请表是否有客户签名" )))
					.addNode(new FieldNode("ishad_appl_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "ishad_appl_date", 1,0, false, "申请表是否已写申请时间" )))
					.addNode(new FieldNode("project_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "project_code", 120,0, false, "项目代码" )))
					.addNode(new FieldNode("first_use", new MsgField(ContentEnum.MessageType.STRING.toString(), "first_use", 32,0, false, "一级用途" )))
					.addNode(new FieldNode("second_use", new MsgField(ContentEnum.MessageType.STRING.toString(), "second_use", 32,0, false, "二级用途" )))
					.addNode(new FieldNode("ipp_config_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "ipp_config_code", 20,0, false, "分期配置代码" )))
					.addNode(new FieldNode("recommand_staff_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_staff_id", 10,0, false, "推荐人ID" )))
					.addNode(new FieldNode("recommand_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_name", 120,0, false, "推荐人姓名" )))
					.addNode(new FieldNode("recommand_mobile", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_mobile", 20,0, false, "推荐人手机号" )))
					.addNode(new FieldNode("recommand_brch_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "recommand_brch_no", 10,0, false, "推荐人机构" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODCAP0034_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("result_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "result_code", 64,0, false, "执行结果代码" )))
					.addNode(new FieldNode("result_desc", new MsgField(ContentEnum.MessageType.STRING.toString(), "result_desc", 200,0, false, "执行结果描述" )))
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
		appHeader.put("transCode", "ar1510");
		appHeader.put("sysId", "121");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "ar1510");

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
