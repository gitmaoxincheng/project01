package cn.com.agree.huanan.ap.al.io.service.eci.afa;

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
 * BASESVC BODAFA0142  短信验证码生成/校验 
 *  BODAFA0142 881003
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA0142 extends EciChannelService {

	private static BODAFA0142_I i = new BODAFA0142_I();
	private static BODAFA0142_O o = new BODAFA0142_O();
	public BODAFA0142() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0142_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
									.addNode(new FieldNode("useropt", new MsgField(ContentEnum.MessageType.STRING.toString(), "useropt", 1,0, true, "操作标识" )))
									.addNode(new FieldNode("usermvt", new MsgField(ContentEnum.MessageType.STRING.toString(), "usermvt", 1,0, false, "验证码失效" )))
									.addNode(new FieldNode("phone", new MsgField(ContentEnum.MessageType.STRING.toString(), "phone", 15,0, true, "手机号码" )))
									.addNode(new FieldNode("userno", new MsgField(ContentEnum.MessageType.STRING.toString(), "userno", 32,0, false, "关键字符串的md5" )))
									.addNode(new FieldNode("msginsro", new MsgField(ContentEnum.MessageType.STRING.toString(), "msginsro", 8,0, false, "短信提示的序号" )))
									.addNode(new FieldNode("insrotxt", new MsgField(ContentEnum.MessageType.STRING.toString(), "insrotxt", 140,0, false, "短信提示语" )))
									.addNode(new FieldNode("msgpwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "msgpwd", 6,0, false, "短信验证码" )))
									.addNode(new FieldNode("isdigitret", new MsgField(ContentEnum.MessageType.STRING.toString(), "isdigitret", 2,0, false, "是否返回纯数字验证码" )))
									);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0142_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
									.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
									);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

