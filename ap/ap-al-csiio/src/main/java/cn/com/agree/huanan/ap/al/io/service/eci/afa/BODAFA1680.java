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
 * BASESVC BODAFA1680  广州ETS电子实时扣税解约
 * BODAFA1680 ckdlac eft00081
 *  综合前置
 * @author CZP
 */
@Component
public class BODAFA1680 extends EciChannelService {

	private static BODAFA1680_I i = new BODAFA1680_I();
	private static BODAFA1680_O o = new BODAFA1680_O();

	public BODAFA1680() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1680_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("flag2", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag2", 1024,0, false, "纳税类型" )))
					.addNode(new FieldNode("origcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origcode", 1024,0, false, "征收机关" )))
					.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 1024,0, false, "纳税编号" )))
					.addNode(new FieldNode("acctrl", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctrl", 1024,0, false, "付款账号" )))
					.addNode(new FieldNode("flag3", new MsgField(ContentEnum.MessageType.STRING.toString(), "flag3", 1024,0, false, "ETS签约标志" )))
					.addNode(new FieldNode("custregno", new MsgField(ContentEnum.MessageType.STRING.toString(), "custregno", 1024,0, false, "注册编号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODAFA1680_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body", true, "APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("sendbank", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendbank", 1024,0, false, "签约行号" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
