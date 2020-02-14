package cn.com.agree.huanan.ap.al.io.service.ics;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbIcsChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.C013000107 客户信息查询.联网核查 
 * C0130001.07 8816215
 * 0026 联网身份核查系统
 * @author XZ
 */
@Component
public class C013000107 extends EsbIcsChannelService {
	private static C013000107_I i = new C013000107_I();
	private static C013000107_O o = new C013000107_O();
	public C013000107() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class C013000107_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 7,0, true, "处理码" )))
				.addNode(new FieldNode("checkflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "checkflag", 1,0, true, "核查标识" )))
				.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 50,0, true, "证件号码" )))
				.addNode(new FieldNode("name", new MsgField(ContentEnum.MessageType.STRING.toString(), "name", 256,0, true, "客户姓名" )))
				.addNode(new FieldNode("photo", new MsgField(ContentEnum.MessageType.STRING.toString(), "photo", 307200,0, false, "客户相片" )))
				.addNode(new FieldNode("channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "channel", 4,0, false, "调用渠道" )))
				.addNode(new FieldNode("custProperty", new MsgField(ContentEnum.MessageType.STRING.toString(), "custProperty", 4,0, false, "客户属性" )))
				.addNode(new FieldNode("isforce", new MsgField(ContentEnum.MessageType.STRING.toString(), "isforce", 1,0, false, "是否强制向人行查询" )))
				.addNode(new FieldNode("idcImg", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcImg", 102400,0, false, "客户身份证上的相片" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class C013000107_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
				.addNode(new FieldNode("queryresult", new MsgField(ContentEnum.MessageType.STRING.toString(), "queryresult", 200,0, false, "联网核查结果" )))
				.addNode(new FieldNode("issueoffice", new MsgField(ContentEnum.MessageType.STRING.toString(), "issueoffice", 200,0, false, "签发机关" )))
				.addNode(new FieldNode("simResult", new MsgField(ContentEnum.MessageType.STRING.toString(), "simResult", 200,0, false, "相似度结果" )))
				.addNode(new FieldNode("sim", new MsgField(ContentEnum.MessageType.STRING.toString(), "sim", 200,0, false, "相似度" )))
				.addNode(new FieldNode("message", new MsgField(ContentEnum.MessageType.STRING.toString(), "message", 200,0, false, "返回信息" )))
				.addNode(new FieldNode("photo", new MsgField(ContentEnum.MessageType.STRING.toString(), "photo", 307200,0, false, "客户相片" )))
				.addNode(new FieldNode("checkmodel", new MsgField(ContentEnum.MessageType.STRING.toString(), "checkmodel", 1,0, true, "核查方式" )))
);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

