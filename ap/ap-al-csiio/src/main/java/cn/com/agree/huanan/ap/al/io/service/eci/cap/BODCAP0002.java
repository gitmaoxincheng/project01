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
 * BASESVC BODCAP0002 申请编号生成 BODCAP0002 ar2220 ar2220 信审平台
 * 
 * @author GYL
 */
@Component
public class BODCAP0002 extends EciChannelService {

	private static BODCAP0002_I i = new BODCAP0002_I();
	private static BODCAP0002_O o = new BODCAP0002_O();

	public BODCAP0002() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODCAP0002_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode
					.addStructNode(new StructNode("APPBody", true, "Body")
							.addNode(new FieldNode("trxn_seq",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "trxn_seq", 40, 0, false,
											"交易流水")))
							.addNode(new FieldNode("busi_seq",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_seq", 40, 0, false,
											"业务流水")))
							.addNode(new FieldNode("sponsor_system",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "sponsor_system", 40, 0,
											false, "发起方系统编号")))
							.addNode(new FieldNode("caller_system",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_system", 40, 0,
											false, "调用方系统编号")))
							.addNode(new FieldNode("busi_org_id",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_org_id", 10, 0, false,
											"业务法人")))
							.addNode(new FieldNode("channel_id",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "channel_id", 40, 0, false,
											"渠道")))
							.addNode(new FieldNode("caller_date",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "caller_date", 8, 0, false,
											"调用方日期")))
							.addNode(new FieldNode("busi_teller_id",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_teller_id", 32, 0,
											false, "交易柜员")))
							.addNode(new FieldNode("busi_branch_id",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "busi_branch_id", 10, 0,
											false, "业务机构ID")))
							.addNode(new FieldNode("page_no",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "page_no", 19, 0, false,
											"分页页码")))
							.addNode(new FieldNode("page_size",
									new MsgField(ContentEnum.MessageType.STRING.toString(), "page_size", 19, 0, false,
											"每页返回数量")))
							.addNode(new FieldNode("appl_type_id", new MsgField(
									ContentEnum.MessageType.STRING.toString(), "appl_type_id", 40, 0, false, "申请类型"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODCAP0002_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody").addNode(new FieldNode("appl_no",
					new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_no", 40, 0, false, "申请编号"))));
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
		appHeader.put("transCode", "ar2220");
		appHeader.put("sysId", "121");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "ar2220");

		Map<String, Object> appBody = (Map<String, Object>) tradeContext.get(CommConstant.APP_BODY);
		Map<String, Object> csisHeader = (Map<String, Object>) tradeContext.get(CommConstant.CSIS_HEADER);
		appBody.put("trxn_seq", appBody.get("trxn_seq"));
		appBody.put("busi_seq", appBody.get("busi_seq"));
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
