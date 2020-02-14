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
 * BASESVC BODAFA0098 IC卡脚本处理结果通知
 * BODAFA0098 883313
 * ATM
 */
@Component
public class BODAFA0098 extends EciChannelService{
	private static BODAFA0098_I i = new BODAFA0098_I();
	private static BODAFA0098_O o = new BODAFA0098_O();
	public BODAFA0098() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0098_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno",20,0, false, "IC卡号" )))
					.addNode(new FieldNode("iccardseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "iccardseq",3,0, false, "IC卡序列号" )))
					.addNode(new FieldNode("icdata", new MsgField(ContentEnum.MessageType.STRING.toString(), "icdata",300,0, false, "IC卡数据" )))
					.addNode(new FieldNode("ableflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "ableflag",1,0, false, "终端读取能力" )))
					.addNode(new FieldNode("ictjdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "ictjdm",1,0, false, "IC卡条件代码" )))
					.addNode(new FieldNode("prechannelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "prechannelserno",40,0, false, "原渠道流水" )))
					.addNode(new FieldNode("fridcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "fridcode",20,0, false, "转发机构代码 " )))
					.addNode(new FieldNode("acidcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "acidcode",20,0, false, "代理行机构代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0098_O extends MsgBody {
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
