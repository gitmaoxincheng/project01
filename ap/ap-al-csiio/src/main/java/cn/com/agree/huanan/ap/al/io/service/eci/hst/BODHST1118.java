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
 * BASESVC BODHST1118  借记卡自助服务签约查询 
 *  BODHST1118 
 *  旧核心系统
 * @author XZF
 */
@Component
public class BODHST1118 extends EciChannelService {

	private static BODHST1118_I i = new BODHST1118_I();
	private static BODHST1118_O o = new BODHST1118_O();
	public BODHST1118() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODHST1118_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new StructNode(" ",true)
							.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
							).addNode(new FieldNode("dispno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dispno", 240,0, false, "卡/账号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODHST1118_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("lmttp1", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmttp1", 1,0, false, "行内转账开通状态" )))
					.addNode(new FieldNode("lmtam1", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmtam1", 18,0, false, "行内转账限额" )))
					.addNode(new FieldNode("lmttp2", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmttp2", 1,0, false, "跨行转账开通状态" )))
					.addNode(new FieldNode("lmtam2", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmtam2", 18,0, false, "跨行转账限额" )))
					.addNode(new FieldNode("lmttp3", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmttp3", 1,0, false, "境内消费开通状态" )))
					.addNode(new FieldNode("lmtam3", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmtam3", 18,0, false, "境内消费限额" )))
					.addNode(new FieldNode("lmttp4", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmttp4", 1,0, false, "境外消费开通状态" )))
					.addNode(new FieldNode("lmtam4", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmtam4", 18,0, false, "境外消费限额" )))
					.addNode(new FieldNode("lmttp5", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmttp5", 1,0, false, "境外取现开通状态" )))
					.addNode(new FieldNode("lmtam5", new MsgField(ContentEnum.MessageType.STRING.toString(), "lmtam5", 18,0, false, "境外取现限额" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

