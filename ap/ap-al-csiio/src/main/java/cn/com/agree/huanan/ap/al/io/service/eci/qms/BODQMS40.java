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
 * BASESVC BODQMS40  变更业务
 * BODQMS40 iqs039 regflw
 *  智能排队机
 * @author WYJ
 */
@Component
public class BODQMS40 extends EciChannelService {

	private static BODQMS40_I i = new BODQMS40_I();
	private static BODQMS40_O o = new BODQMS40_O();

	public BODQMS40() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODQMS40_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 10,0, false, "机构号" )))
					.addNode(new FieldNode("work_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "work_date", 10,0, false, "日期" )))
					.addNode(new FieldNode("queue_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "queue_num", 10,0, false, "排队号" )))
					.addNode(new FieldNode("bs_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_id", 10,0, false, "业务编编号" )))
					.addNode(new FieldNode("bs_name_sh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_name_sh", 100,0, false, "业务名称" )))
					.addNode(new FieldNode("qm_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qm_num", 11,0, false, "排队机编号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODQMS40_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body"));
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
		appHeader.put("prcscd", "iqs039");
		
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
