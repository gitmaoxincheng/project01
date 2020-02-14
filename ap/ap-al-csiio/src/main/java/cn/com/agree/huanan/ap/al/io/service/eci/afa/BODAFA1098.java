package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;
@Component
public class BODAFA1098 extends EciChannelService {

	private static BODAFA1098_I i = new BODAFA1098_I();
	private static BODAFA1098_O o = new BODAFA1098_O();
	public BODAFA1098() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1098_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 40,0, false, "客户身份证号" )))
					.addNode(new FieldNode("authteller", new MsgField(ContentEnum.MessageType.STRING.toString(), "authteller", 10,0, false, "经办移动柜员" )))
					.addNode(new FieldNode("chlbusseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "chlbusseq", 40,0, false, "渠道业务流水号" )))
					.addNode(new FieldNode("authbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authbrno", 10,0, false, "经办移动网点" )))
					.addNode(new FieldNode("subchancode", new MsgField(ContentEnum.MessageType.STRING.toString(), "subchancode", 03,0, false, "受理渠道" )))
					.addNode(new FieldNode("maxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "maxnum", 1,0, true, "翻页标识" )))
					.addNode(new FieldNode("authbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authbrno", 10,0, false, "最大记录数" )))
					.addNode(new FieldNode("idxnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "idxnum", 20,0, false, "翻页索引" )))
				
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1098_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("listnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnm", 10,0, false, "查询记录数" )))
					.addNode(new StructNode("bodrcd",true)
					.addNode(new FieldNode("chlbusseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "chlbusseq", 40,0, false, "渠道业务流水号" )))
					.addNode(new FieldNode("authteller", new MsgField(ContentEnum.MessageType.STRING.toString(), "authteller", 10,0, false, "经办移动柜员" )))
					.addNode(new FieldNode("custidtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "custidtype", 1,0, false, "证件类型" )))
					.addNode(new FieldNode("custidno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custidno", 40,0, true, "证件号码" )))
					.addNode(new FieldNode("authbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authbrno", 10,0, false, "经办移动网点" )))
					.addNode(new FieldNode("subchancode", new MsgField(ContentEnum.MessageType.STRING.toString(), "subchancode", 03,0, false, "受理渠道" )))
					.addNode(new FieldNode("brnoname", new MsgField(ContentEnum.MessageType.STRING.toString(), "brnoname", 200,0, true, "经办网点名称" )))
					.addNode(new FieldNode("stmteller", new MsgField(ContentEnum.MessageType.STRING.toString(), "stmteller", 10,0, true, "STM柜员号" )))
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
