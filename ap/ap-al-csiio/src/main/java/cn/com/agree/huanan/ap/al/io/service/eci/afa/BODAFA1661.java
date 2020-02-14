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
 * BASESVC BODAFA1661  回单机删除签约 
 *  BODAFA1661 8815704
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1661 extends EciChannelService {

	private static BODAFA1661_I i = new BODAFA1661_I();
	private static BODAFA1661_O o = new BODAFA1661_O();
	public BODAFA1661() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1661_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("count", new MsgField(ContentEnum.MessageType.STRING.toString(), "count", 10,0, false, "账号数量" )))
					.addNode(new StructNode("acctnolist",true)
							.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 32,0, false, "账号" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1661_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("clientserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "clientserialno", 32,0, false, "前端流水" )))
					.addNode(new FieldNode("hostserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "hostserialno", 32,0, false, "核心流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

