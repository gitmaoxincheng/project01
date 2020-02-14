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
public class BODAFA1099 extends EciChannelService {

	private static BODAFA1099_I i = new BODAFA1099_I();
	private static BODAFA1099_O o = new BODAFA1099_O();
	public BODAFA1099() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1099_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("origchlbusseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "origchlbusseq", 40,0, false, "原渠道业务流水号" )))
					.addNode(new FieldNode("authbusnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "authbusnum", 10, 0, false, "业务明细笔数")))
					.addNode(new StructNode("bodrcd",true)
					.addNode(new FieldNode("origbusdtlno", new MsgField(ContentEnum.MessageType.STRING.toString(), "origbusdtlno", 40, 0, false, "业务明细序号")))
					.addNode(new FieldNode("authresult", new MsgField(ContentEnum.MessageType.STRING.toString(), "authresult", 1, 0, false, "授权处理结果")))
					.addNode(new FieldNode("authremark", new MsgField(ContentEnum.MessageType.STRING.toString(), "authremark", 200, 0, false, "备注")))
					
					));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1099_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}


}
