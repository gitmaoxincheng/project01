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
 * BASESVC BODQMS45  机构预警时间阈值查询
 * BODQMS45 iqs044 regflw
 *  智能排队机
 * @author WYJ
 */
@Component
public class BODQMS45 extends EciChannelService {

	private static BODQMS45_I i = new BODQMS45_I();
	private static BODQMS45_O o = new BODQMS45_O();

	public BODQMS45() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODQMS45_I extends MsgBody {
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

	public static class BODQMS45_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 100,0, false, "机构号" )))
					.addNode(new FieldNode("waittime_threshold", new MsgField(ContentEnum.MessageType.STRING.toString(), "waittime_threshold", 100,0, false, "等待时间阈值" )))
					.addNode(new FieldNode("waitpeople_threshold", new MsgField(ContentEnum.MessageType.STRING.toString(), "waitpeople_threshold", 100,0, false, "等待人数阈值" )))
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
		appHeader.put("prcscd", "iqs044");
		
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
