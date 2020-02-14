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
 * BASESVC.C022001101 企业网银证书管理.证书申请 
 * C0220011.01 CM0201
 * 0212 金融互联网服务平台
 * @author XZF
 */
@Component
public class C022001101 extends EsbSbcChannelService {

	private static C022001101_I i = new C022001101_I();
	private static C022001101_O o = new C022001101_O();
	public C022001101() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class C022001101_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("enterpriseId", new MsgField(ContentEnum.MessageType.STRING.toString(), "enterpriseId", 20,0, true, "网银客户id" )))
					.addNode(new FieldNode("number", new MsgField(ContentEnum.MessageType.STRING.toString(), "number", 10,0, true, "证书申请个数" )))
					.addNode(new FieldNode("username", new MsgField(ContentEnum.MessageType.STRING.toString(), "username", 120,0, true, "企业名称" )))
					.addNode(new FieldNode("branchId", new MsgField(ContentEnum.MessageType.STRING.toString(), "branchId", 20,0, true, "经办网点" )))
					.addNode(new FieldNode("TellerNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TellerNo", 15,0, true, "经办柜员" )))
					.addNode(new FieldNode("TellerName", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerName", 50,0, true, "经办柜员名称" )))
					.addNode(new FieldNode("agentIdNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentIdNumber", 20,0, true, "申请人证件号码" )))
					.addNode(new FieldNode("agentIdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentIdType", 2,0, true, "申请人证件类型" )))
					.addNode(new FieldNode("agentName", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentName", 50,0, true, "申请人姓名" )))
					.addNode(new FieldNode("agentPhoneNumber", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentPhoneNumber", 20,0, true, "申请人手机号" )))
					.addNode(new FieldNode("oprFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprFlag", 10,0, true, "操作标识" )))
					.addNode(new FieldNode("uKeyType", new MsgField(ContentEnum.MessageType.STRING.toString(), "uKeyType", 10,0, false, "ukey类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C022001101_O extends MsgBody {
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

