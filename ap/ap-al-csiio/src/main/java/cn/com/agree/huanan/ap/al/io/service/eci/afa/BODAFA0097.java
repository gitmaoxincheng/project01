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
 * 
 * @author zhuzc
 * BASESVC BODAFA0097 贷记卡取款
 * BODAFA0097 883315
 * ATM
 */
@Component
public class BODAFA0097 extends EciChannelService{
	private static BODAFA0097_I i = new BODAFA0097_I();
	private static BODAFA0097_O o = new BODAFA0097_O();
	public BODAFA0097() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0097_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("currtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "currtype",2,0, false, "币种" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno",22,0, false, "卡号" )))
					.addNode(new FieldNode("amount", new MsgField(ContentEnum.MessageType.STRING.toString(), "amount",12,0, false, "交易金额" )))
					.addNode(new FieldNode("prechannelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "prechannelserno",40,0, false, "原渠道流水" )))
					.addNode(new FieldNode("iccardseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "iccardseq",3,0, false, "IC卡序列号" )))
					.addNode(new FieldNode("icdata", new MsgField(ContentEnum.MessageType.STRING.toString(), "icdata",300,0, false, "IC卡数据" )))
					.addNode(new FieldNode("ableflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ableflag",1,0, false, "终端读取能力" )))
					.addNode(new FieldNode("ictjdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictjdm",1,0, false, "IC卡条件代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0097_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
