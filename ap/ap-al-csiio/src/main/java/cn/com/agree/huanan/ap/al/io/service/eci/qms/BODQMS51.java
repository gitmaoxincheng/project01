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
 * BASESVC BODQMS51  查询某排队号前等待人数 
 *  BODQMS51 regflw
 *  排队机
 * @author xuzhen
 */
@Component
public class BODQMS51 extends EciChannelService {

	private static BODQMS51_I i = new BODQMS51_I();
	private static BODQMS51_O o = new BODQMS51_O();
	public BODQMS51() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODQMS51_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("APPBody",true,"Body")
				.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 10,0, false, "机构号" )))
				.addNode(new FieldNode("work_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "work_date", 8,0, false, "日期" )))
				.addNode(new FieldNode("queue_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "queue_num", 10,0, false, "排队号" )))
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
	
	public static class BODQMS51_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("Body",true,"APPBody")
				.addNode(new FieldNode("wait_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "wait_num", 99,0, false, "排队人数" )))
				.addNode(new FieldNode("queue_status", new MsgField(ContentEnum.MessageType.STRING.toString(), "queue_status", 99,0, false, "排队号状态" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

