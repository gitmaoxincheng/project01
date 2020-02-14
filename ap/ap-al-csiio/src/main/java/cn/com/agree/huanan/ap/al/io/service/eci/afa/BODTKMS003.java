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
 * BASESVC BODTKMS003  初始化终端主密钥 
 *  BODTKMS003 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODTKMS003 extends EciChannelService {

	private static BODTKMS003_I i = new BODTKMS003_I();
	private static BODTKMS003_O o = new BODTKMS003_O();
	public BODTKMS003() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODTKMS003_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("sysID", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysID", 4,0, false, "系统ID" )))
					.addNode(new FieldNode("appID", new MsgField(ContentEnum.MessageType.STRING.toString(), "appID", 4,0, false, "应用ID" )))
					.addNode(new FieldNode("clientIPAddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "clientIPAddr", 20,0, false, "客户端IP地址" )))
					.addNode(new FieldNode("transTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "transTime", 14,0, false, "传输时间" )))
					.addNode(new FieldNode("transFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "transFlag", 1,0, false, "传输标志" )))
					.addNode(new FieldNode("userInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "userInfo", 1024,0, false, "用户信息" )))					
					.addNode(new FieldNode("termType", new MsgField(ContentEnum.MessageType.STRING.toString(), "termType", 8,0, false, "终端类型" )))
					.addNode(new FieldNode("termID", new MsgField(ContentEnum.MessageType.STRING.toString(), "termID", 40,0, false, "终端号" )))
					.addNode(new FieldNode("protectKey", new MsgField(ContentEnum.MessageType.STRING.toString(), "protectKey", 1024,0, false, "保护密钥" )))
					.addNode(new FieldNode("isDeleteESSCKeyFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "isDeleteESSCKeyFlag", 1,0, true, "远程存在密钥时是否删除" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODTKMS003_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("keyName", new MsgField(ContentEnum.MessageType.STRING.toString(), "keyName", 128,0, false, "密钥名称" )))
					.addNode(new FieldNode("keyValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "keyValue", 48,0, false, "密钥密文" )))
					.addNode(new FieldNode("checkValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "checkValue", 16,0, false, "校验值" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

