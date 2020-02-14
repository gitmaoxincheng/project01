package cn.com.agree.huanan.ap.al.io.service.bpm;

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
 * BASESVC.M012000501 交易处理状态管理.推送通用处理结果确认
 *  M0120005.01 push_900 
 *  0321 参数管理平台
 * @author XZ
 */
@Component
public class M012000501 extends EsbChannelService {
	
	private static M012000501_I i = new M012000501_I();
	private static M012000501_O o = new M012000501_O();

	public M012000501() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class M012000501_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true)
					.addNode(new FieldNode("recvsysid",new MsgField(ContentEnum.MessageType.STRING.toString(), "recvsysid", 10, 0, true,"原接收系统标识")))
					.addNode(new FieldNode("srcserno",new MsgField(ContentEnum.MessageType.STRING.toString(), "srcserno", 100, 0, true,"原推送流水号/文件名")))
					.addNode(new FieldNode("prcst",new MsgField(ContentEnum.MessageType.STRING.toString(), "prcst", 1, 0, true, "处理状态")))
					.addNode(new FieldNode("prcmsg",new MsgField(ContentEnum.MessageType.STRING.toString(), "prcmsg", 256, 0, false, "处理信息"))));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class M012000501_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init() {
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}
