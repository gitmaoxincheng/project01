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
 * BASESVC BODQMS41  查询当前排队机可办业务
 * BODQMS41 iqs040 regflw
 *  智能排队机
 * @author WYJ
 */
@Component
public class BODQMS41 extends EciChannelService {

	private static BODQMS41_I i = new BODQMS41_I();
	private static BODQMS41_O o = new BODQMS41_O();

	public BODQMS41() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODQMS41_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("orgno", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgno", 10,0, false, "机构号" )))
					.addNode(new FieldNode("mdno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mdno", 10,0, false, "排队机编号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODQMS41_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new ArrayNode("info", false, "busi_list")
							.addNode(new FieldNode("queuetype", new MsgField(ContentEnum.MessageType.STRING.toString(), "queuetype", 100,0, false, "业务类型编码" )))
							.addNode(new FieldNode("queuename", new MsgField(ContentEnum.MessageType.STRING.toString(), "queuename", 100,0, false, "业务名称" )))
							.addNode(new FieldNode("bs_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_type", 100,0, false, "业务类型" )))
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
		appHeader.put("prcscd", "iqs040");
		
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
