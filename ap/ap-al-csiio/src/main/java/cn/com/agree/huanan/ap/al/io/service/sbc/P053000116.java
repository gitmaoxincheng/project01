package cn.com.agree.huanan.ap.al.io.service.sbc;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.P053000116 赎回检查 
 * P053000116 
 * 0005 新核心系统
 * @author Huangys
 */ 
@Component
public class P053000116 extends EsbCoreChannelService {
	private static P053000116_I i = new P053000116_I();
	private static P053000116_O o = new P053000116_O();
	public P053000116() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class P053000116_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("AcctNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "AcctNo", 40,1, true, "账号" )))
					.addNode(new FieldNode("TranAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranAm", 18,1, true, "交易金额" )))
					.addNode(new FieldNode("FeeAm", new MsgField(ContentEnum.MessageType.STRING.toString(), "FeeAm", 18,0, false, "手续费金额" )))
					.addNode(new FieldNode("TranType", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranType", 1,1, false, "交易类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList(); 
		}

	}

	public static class P053000116_O extends MsgBody {
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