package cn.com.agree.huanan.ap.al.io.service.enc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * C012000703 身份证联网核查确认
 * @author lf
 *
 */
@Component
public class C012000703 extends EsbChannelService {

	private static C012000703_I i = new C012000703_I();
	private static C012000703_O o = new C012000703_O();
	public C012000703() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C012000703_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
							.addNode(new FieldNode("identtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "identtype", 3,0, true, "证件类型" )))
							.addNode(new FieldNode("identno", new MsgField(ContentEnum.MessageType.STRING.toString(), "identno", 30,0, true, "证件码号" )))
							.addNode(new FieldNode("custname", new MsgField(ContentEnum.MessageType.STRING.toString(), "custname", 256,0, true, "同号多客户标志" )))
							.addNode(new FieldNode("internetinspectflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "internetinspectflag", 2,0, true, "联网核查标识" )))
							.addNode(new FieldNode("noinspectcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "noinspectcause", 1,0, false, "无法核实原因" )))		
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C012000703_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

