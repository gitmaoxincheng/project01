package cn.com.agree.huanan.ap.al.io.service.eci.qms;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODQMS49  查询网点可办理业务及时间段配置 
 *  BODQMS49 regflw
 *  排队机
 * @author xuzhen
 */
@Component
public class BODQMS49 extends EciChannelService {

	private static BODQMS49_I i = new BODQMS49_I();
	private static BODQMS49_O o = new BODQMS49_O();
	public BODQMS49() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODQMS49_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
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
	
	public static class BODQMS49_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
				.addNode(new FieldNode("listnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnum", 10,0, false, "纪录数" )))
				.addNode(new FieldNode("branch_isreservable", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch_isreservable", 1,0, false, "机构是否可预约" )))
				.addNode(new FieldNode("reserv_maxday", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_maxday", 5,0, false, "最大可预约天数" )))
				.addNode(new FieldNode("reserv_minmin", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_minmin", 10,0, false, "当天最小可预约提前分数" )))
				.addNode(new ArrayNode("info",true,"data_list")
				.addNode(new FieldNode("bs_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_id", 20,0, false, "业务编号" )))
				.addNode(new FieldNode("bs_isreservable", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_isreservable", 1,0, false, "业务是否可预约" )))
				.addNode(new FieldNode("bs_name_ch", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_name_ch", 99,0, false, "业务名称" )))
				.addNode(new FieldNode("reserv_times", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_times", 99,0, false, "预约时间段" )))
				.addNode(new FieldNode("serv_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "serv_time", 99,0, false, "业务时间段" )))
				.addNode(new FieldNode("week", new MsgField(ContentEnum.MessageType.STRING.toString(), "week", 20,0, false, "可办理星期" )))
));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

