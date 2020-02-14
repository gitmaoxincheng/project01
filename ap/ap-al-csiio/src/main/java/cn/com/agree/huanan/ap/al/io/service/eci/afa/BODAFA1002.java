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
public class BODAFA1002 extends EciChannelService {

	private static BODAFA1002_I i = new BODAFA1002_I();
	private static BODAFA1002_O o = new BODAFA1002_O();
	public BODAFA1002 () {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1002_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("strchanneldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "strchanneldate", 8,0, false, "渠道交易日期" )))
					.addNode(new FieldNode("strchannelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "strchannelserno", 40,0, false, "渠道交易流号" )))
			
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1002_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("hostdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostdate", 8,0, false, "核心日期" )))
					.addNode(new FieldNode("hostserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostserialno", 40,0, false, "核心流水" )))
					.addNode(new FieldNode("entrustmsgid", new MsgField(ContentEnum.MessageType.STRING.toString(), "entrustmsgid", 10,0, false, "委托报文序号" )))
					.addNode(new FieldNode("optstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "optstatus", 40,0, false, "操作状态" )))
					.addNode(new FieldNode("flowstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "flowstatus", 1,0, false, "流程状态" )))
					.addNode(new FieldNode("workdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "workdate", 200,0, false, "报文前置日期" )))
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 40,0, false, "报文前置流水" )))
					.addNode(new FieldNode("extend", new MsgField(ContentEnum.MessageType.STRING.toString(), "extend", 512,0, false, "扩展信息" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
