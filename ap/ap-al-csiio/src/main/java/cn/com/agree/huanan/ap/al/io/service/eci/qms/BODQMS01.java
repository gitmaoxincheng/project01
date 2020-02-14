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
 * BASESVC BODQMS01  排队机
 *  BODQMS01 
 *  预约信息登记
 * @author xuzhen
 */
@Component
public class BODQMS01 extends EciChannelService {

	private static BODQMS01_I i = new BODQMS01_I();
	private static BODQMS01_O o = new BODQMS01_O();
	public BODQMS01 () {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODQMS01_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("request_seq", new MsgField(ContentEnum.MessageType.STRING.toString(), "request_seq", 48,0, false, "请求序号" )))
					.addNode(new FieldNode("request_channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "request_channel", 2,0, false, "请求渠道" )))
					.addNode(new FieldNode("reserv_bs_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_bs_id", 20,0, false, "预约业务ID" )))
					.addNode(new FieldNode("reserv_begin_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_begin_date", 8,0, false, "预约开始日期" )))
					.addNode(new FieldNode("reserv_end_date", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_end_date", 8,0, false, "预约结束日期" )))
					.addNode(new FieldNode("reserv_begin_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_begin_time", 14,0, false, "预约开始时间" )))
					.addNode(new FieldNode("reserv_end_time", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_end_time", 14,0, false, "预约结束时间" )))
					.addNode(new FieldNode("reserv_zone", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_zone", 9,0, false, "预约区域" )))
					.addNode(new FieldNode("reserv_branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_branch", 9,0, false, "预约网点机构号" )))
					.addNode(new FieldNode("custinfo_type", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_type", 2,0, false, "证件类型" )))
					.addNode(new FieldNode("custinfo_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_num", 30,0, false, "证件号码" )))
					.addNode(new FieldNode("custinfo_name", new MsgField(ContentEnum.MessageType.STRING.toString(), "custinfo_name", 60,0, false, "客户姓名" )))
					.addNode(new FieldNode("account", new MsgField(ContentEnum.MessageType.STRING.toString(), "account", 16,0, false, "卡号/账号" )))
					.addNode(new FieldNode("sms_customer", new MsgField(ContentEnum.MessageType.STRING.toString(), "sms_customer", 1,0, false, "是否短信通知客户" )))
					.addNode(new FieldNode("phone_no", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone_no", 13,0, false, "预约人手机号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	@Override
	public void initServieConf() {
		// TODO 自动生成的方法存根
		super.initServieConf();
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

	public static class BODQMS01_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("check_reserv_value", new MsgField(ContentEnum.MessageType.STRING.toString(), "check_reserv_value", 20,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("reserv_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "reserv_id", 13,0, false, "预约编号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
