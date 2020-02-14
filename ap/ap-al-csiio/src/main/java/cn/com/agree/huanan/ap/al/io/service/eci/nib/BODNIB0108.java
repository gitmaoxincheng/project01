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
 * BASESVC BODNIB0108  证书补发 
 *  BODNIB0108 
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0108 extends EciChannelService {

	private static BODNIB0108_I i = new BODNIB0108_I();
	private static BODNIB0108_O o = new BODNIB0108_O();
	public BODNIB0108() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0108_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("fromchannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "fromchannel", 1024,0, true, "上送渠道" )))
					.addNode(new FieldNode("id", new MsgField(ContentEnum.MessageType.STRING.toString(), "id", 1024,0, true, "证书主键" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0108_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("certdn", new MsgField(ContentEnum.MessageType.STRING.toString(), "certdn", 1024,0, true, "证书编号" )))
					.addNode(new FieldNode("usbkeyNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "usbkeyNo", 1024,0, true, "UKEY编号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

