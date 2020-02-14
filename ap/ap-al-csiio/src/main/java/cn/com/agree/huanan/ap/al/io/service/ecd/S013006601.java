package cn.com.agree.huanan.ap.al.io.service.ecd;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCore1ChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S013006601 签退管理查询.柜员签退日终检查（票据系统） 
 * S0130066.01 mpused
 * 0227 票据系统
 * @author XZF
 */
@Component
public class S013006601 extends EsbCore1ChannelService {

	private static S013006601_I i = new S013006601_I();
	private static S013006601_O o = new S013006601_O();
	public S013006601() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013006601_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("exitus", new MsgField(ContentEnum.MessageType.STRING.toString(), "exitus", 10,0, true, "签退柜员" )))
					.addNode(new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 12,0, true, "操作网点" )))
					.addNode(new FieldNode("dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytp", 50,0, false, "岗位类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S013006601_O extends MsgBody {
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

