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
 * BASESVC BODAFA1542  查询社保卡状态
 * BODAFA1542 socard45 881003
 *  综合前置
 * @author ouyangzk
 */
@Component
public class BODAFA1542 extends EciChannelService {

	private static BODAFA1542_I i = new BODAFA1542_I();
	private static BODAFA1542_O o = new BODAFA1542_O();

	public BODAFA1542() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1542_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("ACCTNO", new MsgField(ContentEnum.MessageType.STRING.toString(), "ACCTNO", 40,0, false, "金融帐号卡号" ))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1542_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 10,0, false, "社保卡状态" ))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
