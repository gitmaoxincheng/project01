package cn.com.agree.huanan.ap.al.io.service.ecd;

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
 * BASESVC.S013006602 签退管理查询.机构签退日终检查（票据系统） 
 * S0130066.02 mpbred
 * 0227 票据系统
 * @author XZF
 */
@Component
public class S013006602 extends EsbChannelService {

	private static S013006602_I i = new S013006602_I();
	private static S013006602_O o = new S013006602_O();
	public S013006602() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013006602_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("exitus", new MsgField(ContentEnum.MessageType.STRING.toString(), "exitus", 10,0, true, "签退柜员" )))
					.addNode(new FieldNode("exitbr", new MsgField(ContentEnum.MessageType.STRING.toString(), "exitbr", 12,0, true, "签退机构" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S013006602_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("erorcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "erorcd", 8,0, true, "校验是否通过" )))
					.addNode(new FieldNode("ercotx", new MsgField(ContentEnum.MessageType.STRING.toString(), "ercotx", 200,0, true, "校验失败原因" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

