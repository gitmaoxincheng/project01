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
 * BASESVC BODCAP0039  网申接口-查询二维码有效期配置 
 *  BODCAP0039 ar3215
 *  信审系统
 * @author guyulong
 */
@Component
public class BODCAP0039 extends EciChannelService {
	private static BODCAP0039_I i = new BODCAP0039_I();
	private static BODCAP0039_O o = new BODCAP0039_O();
	public BODCAP0039() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODCAP0039_I extends MsgBody {
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
.addNode(new FieldNode("tdc_identity_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "tdc_identity_type", 2,0, false, "身份类型" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODCAP0039_O extends MsgBody {
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
.addNode(new ArrayNode("bodrcd",true)
.addNode(new FieldNode("tdc_identity_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "tdc_identity_type", 2,0, false, "身份类型" )))
.addNode(new FieldNode("default_indate", new MsgField(ContentEnum.MessageType.STRING.toString(), "default_indate", 19,0, false, "默认有效期天数" )))
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
		appHeader.put("transCode", "ar3215");
		appHeader.put("sysId", "121");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "ar3215");

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

