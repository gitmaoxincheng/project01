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

/**
 * BASESVC BODAFA1671  全国财税三方协议解约
 * BODAFA1671 tips1005 581004
 *  综合前置
 * @author CZP
 */
@Component
public class BODAFA1671 extends EciChannelService {

	private static BODAFA1671_I i = new BODAFA1671_I();
	private static BODAFA1671_O o = new BODAFA1671_O();

	public BODAFA1671() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1671_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("protocolno", new MsgField(ContentEnum.MessageType.STRING.toString(), "protocolno", 1024,0, false, "协议书号" )))
					.addNode(new FieldNode("origcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origcode", 1024,0, false, "征收机关代码" )))
					.addNode(new FieldNode("detflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "detflag", 1024,0, false, "解约方式" )))
					.addNode(new FieldNode("strtranscode", new MsgField(ContentEnum.MessageType.STRING.toString(), "strtranscode", 1024,0, false, "验证发起方" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1671_O extends MsgBody {
		private MsgSegment msgSegment = init();

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
