package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbSbcChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C022001403 贵金属订单管理.贵金属订单状态修改 
 * C0220014.03 MT0205
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C022001403 extends EsbSbcChannelService {

	private static C022001403_I i = new C022001403_I();
	private static C022001403_O o = new C022001403_O();
	public C022001403() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	

	public static class C022001403_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 10,0, true, "渠道" )))
					.addNode(new FieldNode("cifNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cifNo", 50,0, true, "核心客户号" )))
					.addNode(new FieldNode("cstNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "cstNo", 50,0, false, "客户号" )))
					.addNode(new FieldNode("orderNum", new MsgField(ContentEnum.MessageType.STRING.toString(), "orderNum", 50,0, true, "订单号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C022001403_O extends MsgBody {
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

