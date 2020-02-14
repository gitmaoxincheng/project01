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
 * BASESVC BODNIB0117  个人网银证书更换 
 *  BODNIB0117 regflw
 *  新个人网银
 * @author XZF
 */
@Component
public class BODNIB0117 extends EciChannelService {

	private static BODNIB0117_I i = new BODNIB0117_I();
	private static BODNIB0117_O o = new BODNIB0117_O();
	public BODNIB0117() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODNIB0117_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("fromchannel", new MsgField(ContentEnum.MessageType.STRING.toString(), "fromchannel", 1024,0, true, "上送渠道" )))
					.addNode(new FieldNode("id", new MsgField(ContentEnum.MessageType.STRING.toString(), "id", 15,0, true, "网银客户号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODNIB0117_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

