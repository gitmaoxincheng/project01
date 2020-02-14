package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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

/**
 * BASESVC BODHST1065 磁道校验
 * 旧核心系统
 * @author YYX
 */
@Component
public class BODHST1065 extends EciChannelService {

	private static BODHST1065_I i = new BODHST1065_I();
	private static BODHST1065_O o = new BODHST1065_O();

	public BODHST1065() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1065_I extends MsgBody {
		private MsgSegment  msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("track2", new MsgField(ContentEnum.MessageType.STRING.toString(), "track2", 35,0, false, "二磁道" )))
					.addNode(new FieldNode("track3", new MsgField(ContentEnum.MessageType.STRING.toString(), "track3", 35,0, false, "三磁道" )))
					.addNode(new FieldNode("winame", new MsgField(ContentEnum.MessageType.STRING.toString(), "winame", 20,0, false, "窗口名" )))
					.addNode(new FieldNode("downfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "downfg", 1,0, false, "是否允许降级交易" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 40,0, false, "卡号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODHST1065_O extends MsgBody {
		private MsgSegment  msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
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
