package cn.com.agree.huanan.ap.al.io.service.eci.qms;

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
 * BASESVC BODQMS42  优先叫号
 * BODQMS42 iqs041 regflw
 *  智能排队机
 * @author WYJ
 */
@Component
public class BODQMS42 extends EciChannelService {

	private static BODQMS42_I i = new BODQMS42_I();
	private static BODQMS42_O o = new BODQMS42_O();

	public BODQMS42() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODQMS42_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("orgno", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgno", 10,0, false, "机构号" )))
					.addNode(new FieldNode("mdno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mdno", 10,0, false, "排队机编号" )))
					.addNode(new FieldNode("queueno", new MsgField(ContentEnum.MessageType.STRING.toString(), "queueno", 10,0, false, "队列号" )))
					.addNode(new FieldNode("to_queuetype_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "to_queuetype_id", 100,0, false, "优先队列" )))
					.addNode(new FieldNode("releflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "releflag", 100,0, false, "关联排队号标识" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODQMS42_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("waitnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "waitnum", 100,0, false, "队列等待人数" )))
					.addNode(new FieldNode("queue_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "queue_num", 100,0, false, "队列号" )))
					.addNode(new FieldNode("tradewin", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradewin", 100,0, false, "可办窗口" )))
					.addNode(new FieldNode("vwaittime", new MsgField(ContentEnum.MessageType.STRING.toString(), "vwaittime", 100,0, false, "虚拟等待叫号时间" )))
					.addNode(new FieldNode("custinfo_tel", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_tel", 100,0, false, "客户电话" )))
					.addNode(new FieldNode("check_queue_value", new MsgField(ContentEnum.MessageType.STRING.toString(), "check_queue_value", 100,0, false, "排队号验证码" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initContent(Map<String, Object> tradeContext) {
		Map<String, Object> appHeader = (Map<String, Object>) tradeContext.get(CommConstant.APP_HEADER);
		appHeader.put("xmlflag", "1");
		appHeader.put("templateCodeName", "params");
		appHeader.put("transCode", "regflw");
		appHeader.put("sysId", "96");
		appHeader.put("tradeFlag", "0");
		appHeader.put("checkFlag", "0");
		appHeader.put("prcscd", "iqs041");
		
		Map<String, Object> csisHeader = (Map<String, Object>) tradeContext.get(CommConstant.CSIS_HEADER);
		appHeader.put("vm_zoneno", csisHeader.get("ZoneNo"));
		appHeader.put("vm_mbrno", "");
		appHeader.put("vm_brno", csisHeader.get("BrNo"));
		appHeader.put("vm_tellerno", csisHeader.get("TellerNo"));
		appHeader.put("vm_tellertp", "");
		appHeader.put("zoneno", csisHeader.get("ZoneNo"));
		appHeader.put("mbrno", "");
		appHeader.put("brno", csisHeader.get("BrNo"));
		appHeader.put("tellerno", csisHeader.get("TellerNo"));
		appHeader.put("tellertp", "");
		
		super.initContent(tradeContext);
	}

}
