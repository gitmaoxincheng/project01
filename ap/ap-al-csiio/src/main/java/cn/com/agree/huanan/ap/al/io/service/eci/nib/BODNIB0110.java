package cn.com.agree.huanan.ap.al.io.service.eci.nib;

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
 * BASESVC BODNIB0110  证书作废
 * BODNIB0110 regflw grsj10
 *  综合前置
 * @author CZP
 */
@Component
public class BODNIB0110 extends EciChannelService {
	
	private static BODNIB0110_I i = new BODNIB0110_I();
	private static BODNIB0110_O o = new BODNIB0110_O();

	public BODNIB0110() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0110_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("fromchannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "fromchannel", 1024,0, false, "上送渠道" )))
					.addNode(new FieldNode("id", new MsgField(ContentEnum.MessageType.STRING.toString(), "id", 1024,0, false, "UKEY主键" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODNIB0110_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("certdn", new MsgField(ContentEnum.MessageType.STRING.toString(), "certdn", 1024,0, false, "证书编号" )))
					.addNode(new FieldNode("usbkeyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "usbkeyno", 1024,0, false, "UKEY编号" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "证书状态" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
