package cn.com.agree.huanan.ap.al.io.service.eci.qms;

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
 * BASESVC BODQMS44  队列信息查询(客户维度)
 * BODQMS44 iqs043 regflw
 *  智能排队机
 * @author WYJ
 */
@Component
public class BODQMS44 extends EciChannelService {

	private static BODQMS44_I i = new BODQMS44_I();
	private static BODQMS44_O o = new BODQMS44_O();

	public BODQMS44() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODQMS44_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 10,0, false, "机构号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODQMS44_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new ArrayNode("info", false, "cust_list")
							.addNode(new FieldNode("custtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype", 30,0, false, "客户内部类型" )))
							.addNode(new FieldNode("custtype_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype_name", 100,0, false, "客户内部类型名称" )))
							.addNode(new FieldNode("total", new MsgField(ContentEnum.MessageType.STRING.toString(), "total", 30,0, false, "等待人数" )))
							)
					.addNode(new ArrayNode("data", false, "quinfo_list")
							.addNode(new FieldNode("queue_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "queue_num", 30,0, false, "排队号" )))
							.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 30,0, false, "机构号" )))
							.addNode(new FieldNode("en_queue_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "en_queue_time", 30,0, false, "入队时间" )))
							.addNode(new FieldNode("customer_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "customer_num", 30,0, false, "客户号" )))
							.addNode(new FieldNode("custinfo_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_name", 100,0, false, "客户名" )))
							.addNode(new FieldNode("custinfo_sex", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_sex", 10,0, false, "客户性别" )))
							.addNode(new FieldNode("bs_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_id", 30,0, false, "业务编号" )))
							.addNode(new FieldNode("bs_name_ch", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_name_ch", 100,0, false, "业务名称" )))
							.addNode(new FieldNode("bs_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_type", 30,0, false, "业务类型" )))
							.addNode(new FieldNode("custtype_i", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype_i", 30,0, false, "客户类型" )))
							));
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
		appHeader.put("prcscd", "iqs043");
		
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
