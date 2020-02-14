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
 * BASESVC BODAFA0165  卡密码申请/重置 
 *  BODAFA0165 
 *  综合前端
 * @author XZF
 */
@Component
public class BODAFA0165 extends EciChannelService {

	private static BODAFA0165_I i = new BODAFA0165_I();
	private static BODAFA0165_O o = new BODAFA0165_O();
	public BODAFA0165() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA0165_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 19,0, false, "卡号" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 2,0, false, "证件种类" )))
					.addNode(new FieldNode("idno", new MsgField(ContentEnum.MessageType.STRING.toString(), "idno", 18,0, false, "证件号码" )))
					.addNode(new FieldNode("birthday", new MsgField(ContentEnum.MessageType.STRING.toString(), "birthday", 8,0, false, "出生年月日" )))
					.addNode(new FieldNode("track2", new MsgField(ContentEnum.MessageType.STRING.toString(), "track2", 37,0, false, "第二磁道" )))
					.addNode(new FieldNode("option", new MsgField(ContentEnum.MessageType.STRING.toString(), "option", 1,0, false, "选项" )))
					.addNode(new FieldNode("new_pwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "new_pwd", 300,0, false, "新密码" )))
					.addNode(new FieldNode("cardnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardnm", 30,0, false, "持卡人姓名" )))
					.addNode(new FieldNode("zmackey", new MsgField(ContentEnum.MessageType.STRING.toString(), "zmackey", 20,0, false, "密钥序号" )))
					.addNode(new FieldNode("zpwdfrm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zpwdfrm", 20,0, false, "密码的来源" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA0165_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("transq", new MsgField(ContentEnum.MessageType.STRING.toString(), "transq", 22,0, false, "流水号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

