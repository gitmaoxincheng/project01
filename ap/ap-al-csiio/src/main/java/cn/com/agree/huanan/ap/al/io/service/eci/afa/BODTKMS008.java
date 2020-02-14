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
 * BASESVC BODTKMS008  注册终端 
 * BODTKMS008  
 *  综合前置
 * @author YYX
 */
@Component
public class BODTKMS008 extends EciChannelService {

	private static BODTKMS008_I i = new BODTKMS008_I();
	private static BODTKMS008_O o = new BODTKMS008_O();

	public BODTKMS008() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODTKMS008_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody", true, "Body")
					.addNode(new FieldNode("termType", new MsgField(ContentEnum.MessageType.STRING.toString(), "termType", 10,0, false, "终端类型" )))
					.addNode(new FieldNode("deviceId", new MsgField(ContentEnum.MessageType.STRING.toString(), "deviceId", 40,0, false, "终端编号" )))
					.addNode(new FieldNode("factoryId", new MsgField(ContentEnum.MessageType.STRING.toString(), "factoryId", 40,0, false, "厂商编号" )))
					.addNode(new FieldNode("organization", new MsgField(ContentEnum.MessageType.STRING.toString(), "organization", 64,0, false, "机构编号" )))
					.addNode(new FieldNode("pkMLenth", new MsgField(ContentEnum.MessageType.STRING.toString(), "pkMLenth", 10,0, false, "公钥模长" )))
					.addNode(new FieldNode("authCodeLen", new MsgField(ContentEnum.MessageType.STRING.toString(), "authCodeLen", 3,0, false, "认证码长度" )))
					.addNode(new FieldNode("authCodeType", new MsgField(ContentEnum.MessageType.STRING.toString(), "authCodeType", 1,0, false, "认证码复杂度" )))
					.addNode(new FieldNode("sysID", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysID",4,0, false, "系统ID" )))
					.addNode(new FieldNode("appID", new MsgField(ContentEnum.MessageType.STRING.toString(), "appID",4,0, false, "应用ID" )))
					.addNode(new FieldNode("clientIPAddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "clientIPAddr",20 ,0, false, "客户端IP地址" )))
					.addNode(new FieldNode("transTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "transTime",14 ,0, false, "传输时间" )))
					.addNode(new FieldNode("transFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "transFlag",1 ,0, false, "传输标志" )))
					.addNode(new FieldNode("userInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "userInfo",24 ,0, false, "用户信息" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class BODTKMS008_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
