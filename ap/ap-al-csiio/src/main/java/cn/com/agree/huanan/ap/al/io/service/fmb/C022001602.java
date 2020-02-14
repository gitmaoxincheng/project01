package cn.com.agree.huanan.ap.al.io.service.fmb;

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
 * BASESVC.C022001602 业务状态管理.微网点申请信息状态变更 
 * C0220016.02 8819705
 * 0339 综合前置(微网点模块)
 * @author XZF
 */
@Component
public class C022001602 extends EsbChannelService {

	private static C022001602_I i = new C022001602_I();
	private static C022001602_O o = new C022001602_O();
	public C022001602() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C022001602_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("RequNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "RequNo", 50,0, false, "申请编号" )))
					.addNode(new FieldNode("TranCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "TranCode", 10,0, true, "交易码" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 2,0, true, "申请状态" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C022001602_O extends MsgBody {
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

