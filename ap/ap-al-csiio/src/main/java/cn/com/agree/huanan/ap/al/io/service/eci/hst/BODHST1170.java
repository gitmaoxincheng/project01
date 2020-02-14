package cn.com.agree.huanan.ap.al.io.service.eci.hst;

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
 * BASESVC BODHST1170  撤销预约 
 *  BODHST1170 
 *  旧核心系统
 * @author XZF
 */
@Component
public class BODHST1170 extends EciChannelService {

	private static BODHST1170_I i = new BODHST1170_I();
	private static BODHST1170_O o = new BODHST1170_O();
	public BODHST1170() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1170_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 20,0, false, "认购流水" )))
					.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "认购日期" )))
					.addNode(new FieldNode("tranam", new MsgField(ContentEnum.MessageType.STRING.toString(), "tranam", 18,0, false, "撤销金额" )))
					.addNode(new FieldNode("userid", new MsgField(ContentEnum.MessageType.STRING.toString(), "userid", 10,0, false, "交易柜员" )))
					.addNode(new FieldNode("ckbkus", new MsgField(ContentEnum.MessageType.STRING.toString(), "ckbkus", 10,0, false, "复核柜员" )))
					.addNode(new FieldNode("brchno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brchno", 10,0, false, "交易机构" )))
					.addNode(new FieldNode("winame", new MsgField(ContentEnum.MessageType.STRING.toString(), "winame", 25,0, false, "窗口名称" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1170_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("trandt", new MsgField(ContentEnum.MessageType.STRING.toString(), "trandt", 8,0, false, "核心交易日期" )))
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 20,0, false, "核心交易流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

