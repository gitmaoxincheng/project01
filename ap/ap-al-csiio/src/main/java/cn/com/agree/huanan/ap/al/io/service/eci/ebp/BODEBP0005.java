package cn.com.agree.huanan.ap.al.io.service.eci.ebp;

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
 * BASESVC BODEBP0005  境外汇出汇款撤销 
 *  BODEBP0005 
 *  国结系统
 * @author XZF
 */
@Component
public class BODEBP0005 extends EciChannelService {

	private static BODEBP0005_I i = new BODEBP0005_I();
	private static BODEBP0005_O o = new BODEBP0005_O();
	public BODEBP0005() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODEBP0005_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("tNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "tNo", 50,0, false, "撤销交易的流水" )))
					.addNode(new FieldNode("launchMode", new MsgField(ContentEnum.MessageType.STRING.toString(), "launchMode", 1,0, false, "交易渠道" )))
					.addNode(new FieldNode("bizNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "bizNo", 50,0, false, "渠道业务编号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODEBP0005_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("code", new MsgField(ContentEnum.MessageType.STRING.toString(), "code", 2,0, false, "错误标识码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

