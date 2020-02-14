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
 * BASESVC BODQMS48  查询客户级别的排队人数 
 *  BODQMS48 regflw
 *  排队机
 * @author xuzhen
 */
@Component
public class BODQMS48 extends EciChannelService {

	private static BODQMS48_I i = new BODQMS48_I();
	private static BODQMS48_O o = new BODQMS48_O();
	public BODQMS48() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODQMS48_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("APPBody",true,"Body")
				.addNode(new FieldNode("custtype_e", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype_e", 10,0, false, "外部客户类型" )))
				.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 10,0, false, "机构号" )))
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
	
	public static class BODQMS48_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
				.addStructNode(new StructNode("Body",true,"APPBody")
				.addNode(new FieldNode("wait_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "waitnum", 10,0, false, "队列等待人数" )))
				.addNode(new FieldNode("custtype_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "custtype_name", 100,0, false, "客户类型" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

