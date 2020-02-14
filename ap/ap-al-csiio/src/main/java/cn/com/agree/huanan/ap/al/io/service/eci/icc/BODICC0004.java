package cn.com.agree.huanan.ap.al.io.service.eci.icc;

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
 * BASESVC BODICC0004 IC卡圈存冲正
 * BODICC0004 ic1116
 * ATM
 */
@Component
public class BODICC0004 extends EciChannelService{
	private static BODICC0004_I i = new BODICC0004_I();
	private static BODICC0004_O o = new BODICC0004_O();
	public BODICC0004() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODICC0004_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf",1080,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("loadType", new MsgField(ContentEnum.MessageType.STRING.toString(), "loadType",1,0, false, "圈存类别" )))
					.addNode(new FieldNode("chelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "chelserno",40,0, false, "原交易渠道流水号" )))
					.addNode(new FieldNode("reversalAmount", new MsgField(ContentEnum.MessageType.STRING.toString(), "reversalAmount",16,0, false, "冲正金额" )))
					.addNode(new FieldNode("queryflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "queryflag",1,0, false, "查询流水条件" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODICC0004_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("icSerialNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "icSerialNo", 12,0, false, "IC卡平台流水号" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
