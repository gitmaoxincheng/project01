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
 * 
 * @author zhuzc-->XZF(HYuSeng)
 * BASESVC BODHST1065 本行卡存款确认-> BODSAF0009 磁道校验
 * BODSAF0009 dp2120
 * ATM
 */
@Component
public class BODSAF0009 extends EciChannelService{
	private static BODSAF0009_I i = new BODSAF0009_I();
	private static BODSAF0009_O o = new BODSAF0009_O();
	public BODSAF0009() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODSAF0009_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("track2", new MsgField(ContentEnum.MessageType.STRING.toString(), "track2", 35,0, false, "二磁道" )))
					.addNode(new FieldNode("track3", new MsgField(ContentEnum.MessageType.STRING.toString(), "track3", 35,0, false, "三磁道" )))
					.addNode(new FieldNode("winame", new MsgField(ContentEnum.MessageType.STRING.toString(), "winame", 20,0, false, "窗口名" )))
					.addNode(new FieldNode("downfg", new MsgField(ContentEnum.MessageType.STRING.toString(), "downfg",1,0, false, "是否允许降级交易" )))

					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODSAF0009_O extends MsgBody {
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
