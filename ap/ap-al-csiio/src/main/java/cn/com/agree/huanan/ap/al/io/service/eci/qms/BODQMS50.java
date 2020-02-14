package cn.com.agree.huanan.ap.al.io.service.eci.qms;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODQMS50  微网点取号 
 *  BODQMS50 regflw
 *  排队机
 * @author xuzhen
 */
@Component
public class BODQMS50 extends EciChannelService {

	private static BODQMS50_I i = new BODQMS50_I();
	private static BODQMS50_O o = new BODQMS50_O();
	public BODQMS50() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODQMS50_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("APPBody",true,"Body")
				.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 10,0, false, "机构号" )))
				.addNode(new FieldNode("branch_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch_name", 99,0, false, "机构名称" )))
				.addNode(new FieldNode("bs_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_id", 99,0, false, "业务ID" )))
				.addNode(new FieldNode("bs_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_name", 99,0, false, "业务名称" )))
				.addNode(new FieldNode("custinfo_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_type", 99,0, false, "证件类型" )))
				.addNode(new FieldNode("custinfo_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_num", 99,0, false, "证件号码" )))
				.addNode(new FieldNode("remaind_phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "remaind_phone", 99,0, false, "手机号码" )))
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
		super.initContent(tradeContext);
		Map<String,Object> appHeader = (Map) tradeContext.get("AppHeader");
		Map<String,Object> csisHeader = (Map) tradeContext.get("CsisHeader");
		appHeader.put("xmlflag", "1");
		appHeader.put("templateCodeName", "params");
		appHeader.put("sysId", "96");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("vm_zoneno",  csisHeader.get("ZoneNo"));
		appHeader.put("vm_mbrno", csisHeader.get("MbrNo"));
		appHeader.put("vm_brno", csisHeader.get("BrNo"));
		appHeader.put("vm_tellerno", csisHeader.get("TellerNo"));
		appHeader.put("vm_tellertp",  csisHeader.get("TellerTp"));
	}
	
	public static class BODQMS50_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("Body",true,"APPBody")
				.addNode(new FieldNode("branch_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch_name", 99,0, false, "网点名称" )))
				.addNode(new FieldNode("bs_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_name", 99,0, false, "业务名称" )))
				.addNode(new FieldNode("queue_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "queue_num", 99,0, false, "排队号" )))
				.addNode(new FieldNode("waitnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "waitnum", 99,0, false, "队列等待人数" )))
				.addNode(new FieldNode("wait_area", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_area", 99,0, false, "等待区域" )))
				.addNode(new FieldNode("tradewin", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradewin", 99,0, false, "可办窗口" )))
				.addNode(new FieldNode("custtypes_ch", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtypes_ch", 99,0, false, "客户等级" )))
				.addNode(new FieldNode("queue_times", new MsgField(ContentEnum.MessageType.STRING.toString(), "queue_times", 99,0, false, "取号时间" )))
				.addNode(new FieldNode("hand_product", new MsgField(ContentEnum.MessageType.STRING.toString(), "hand_product", 99,0, false, "持有产品" )))
				.addNode(new FieldNode("mark_words", new MsgField(ContentEnum.MessageType.STRING.toString(), "mark_words", 99,0, false, "营销话语" )))
				.addNode(new FieldNode("phone_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone_status", 99,0, false, "手机号状态" )))
				.addNode(new FieldNode("kindly_remind", new MsgField(ContentEnum.MessageType.STRING.toString(), "kindly_remind", 99,0, false, "温馨提示" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

