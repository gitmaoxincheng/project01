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
 * BASESVC BODCAP0019  网申接口-网申接口产品 
 *  BODCAP0019 ar4110
 *  柜面透传
 * @author XZF
 */
@Component
public class BODCAP0019 extends EciChannelService {

	private static BODCAP0019_I i = new BODCAP0019_I();
	private static BODCAP0019_O o = new BODCAP0019_O();

	public BODCAP0019() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODCAP0019_I extends MsgBody {
		private MsgSegment  msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
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
					.addNode(new FieldNode("appl_channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_channel", 40,0, false, "申请渠道" )))
					.addNode(new FieldNode("product_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "product_code", 4,0, false, "卡产品代码" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODCAP0019_O extends MsgBody {
		private MsgSegment  msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new ArrayNode("bodrcd", true)
							.addNode(new FieldNode("appl_channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "appl_channel", 5,0, false, "申请渠道" )))
							.addNode(new FieldNode("product_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "product_code", 20,0, false, "卡产品代码" )))
							.addNode(new FieldNode("product_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "product_name", 100,0, false, "卡产品名称" )))
							.addNode(new FieldNode("feetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "feetype", 20,0, false, "年费代码" )))
							.addNode(new FieldNode("feetype_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "feetype_name", 200,0, false, "年费名称" )))
							.addNode(new FieldNode("card_photo_base64", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_photo_base64", 100000,0, false, "卡版面图片base64" )))
							.addNode(new FieldNode("card_equity_desc", new MsgField(ContentEnum.MessageType.STRING.toString(), "card_equity_desc", 500,0, false, "权益描述" )))
							.addNode(new FieldNode("valid_ind", new MsgField(ContentEnum.MessageType.STRING.toString(), "valid_ind", 1,0, true, "有效标识" )))
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
		appHeader.put("transCode", "ar4110");
		appHeader.put("sysId", "121");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "ar4110");

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

