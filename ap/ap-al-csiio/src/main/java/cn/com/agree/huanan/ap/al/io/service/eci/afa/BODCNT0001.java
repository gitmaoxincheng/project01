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

@Component
public class BODCNT0001 extends EciChannelService {

	private static BODCNT0001_I i = new BODCNT0001_I();
	private static BODCNT0001_O o = new BODCNT0001_O();
	public BODCNT0001 () {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODCNT0001_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("branch", new MsgField(ContentEnum.MessageType.STRING.toString(), "branch", 20,0, false, "网点号" )))
					.addNode(new FieldNode("qm_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "qm_num", 20,0, false, "排队机号" )))
					.addNode(new FieldNode("queue_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "queue_num", 20,0, false, "队列号" )))
					.addNode(new FieldNode("waitnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "waitnum", 20,0, false, "队列等待人数" )))
					.addNode(new FieldNode("bs_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "bs_id", 20,0, false, "业务ID" )))
					.addNode(new FieldNode("msgtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "msgtype", 20,0, false, "消息类型" )))
					.addNode(new FieldNode("pdno", new MsgField(ContentEnum.MessageType.STRING.toString(), "pdno", 20,0, false, "设备编号" )))
					.addNode(new FieldNode("waitting", new MsgField(ContentEnum.MessageType.STRING.toString(), "waitting", 20,0, false, "等待时间" )))
					.addNode(new FieldNode("en_queue_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "en_queue_num", 20,0, false, "进队时间" )))
					.addNode(new FieldNode("oid", new MsgField(ContentEnum.MessageType.STRING.toString(), "oid", 20,0, false, "设备ID" )))
					.addNode(new FieldNode("deviceip", new MsgField(ContentEnum.MessageType.STRING.toString(), "deviceip", 20,0, false, "设备IP" )))
					.addNode(new FieldNode("deviceport", new MsgField(ContentEnum.MessageType.STRING.toString(), "deviceport", 20,0, false, "设备端口" )))
					.addNode(new FieldNode("deviceaddition", new MsgField(ContentEnum.MessageType.STRING.toString(), "deviceaddition", 20,0, false, "设备附加信息" )))
					
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODCNT0001_O extends MsgBody {
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
