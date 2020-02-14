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
 * BASESVC BODTKMS004  更新终端密钥 
 *  BODTKMS004 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODTKMS004 extends EciChannelService {

	private static BODTKMS004_I i = new BODTKMS004_I();
	private static BODTKMS004_O o = new BODTKMS004_O();
	public BODTKMS004() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODTKMS004_I extends MsgBody {
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
					.addNode(new FieldNode("transFlag", new MsgField("0", "transFlag", 1,0, false, "传输标志" )))
					.addNode(new FieldNode("userInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "userInfo", 1024,0, false, "用户信息" )))
					
					
					.addNode(new FieldNode("termType", new MsgField(ContentEnum.MessageType.STRING.toString(), "termType", 8,0, false, "终端类型" )))
					.addNode(new FieldNode("termID", new MsgField(ContentEnum.MessageType.STRING.toString(), "termID", 40,0, false, "终端号" )))
					.addNode(new FieldNode("keyType", new MsgField(ContentEnum.MessageType.STRING.toString(), "keyType", 10,0, false, "密钥类型" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODTKMS004_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("keyName", new MsgField(ContentEnum.MessageType.STRING.toString(), "keyName", 128,0, false, "密钥名称" )))
					.addNode(new FieldNode("keyValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "keyValue", 48,0, false, "密钥密文" )))
					.addNode(new FieldNode("keyValue2", new MsgField(ContentEnum.MessageType.STRING.toString(), "keyValue2", 48,0, false, "密钥密文2" )))
					.addNode(new FieldNode("checkValue", new MsgField(ContentEnum.MessageType.STRING.toString(), "checkValue", 16,0, false, "校验值" )))
					
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" ),""))
					.addNode(new FieldNode("serviceCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "serviceCode", 1024,0, false, "服务代码" )))
					.addNode(new FieldNode("sysID", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysID", 1024,0, false, "系统ID" )))
					.addNode(new FieldNode("appID", new MsgField(ContentEnum.MessageType.STRING.toString(), "appID", 1024,0, false, "应用ID" )))
					.addNode(new FieldNode("clientIPAddr", new MsgField(ContentEnum.MessageType.STRING.toString(), "clientIPAddr", 1024,0, false, "客户端IP地址" )))
					.addNode(new FieldNode("transTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "transTime", 1024,0, false, "传输时间" )))
					.addNode(new FieldNode("transFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "transFlag", 1024,0, false, "传输标志" )))
					.addNode(new FieldNode("userInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "userInfo", 1024,0, false, "用户信息" )))
					.addNode(new FieldNode("useTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "useTime", 1024,0, false, "使用时间" )))
					.addNode(new FieldNode("hash", new MsgField(ContentEnum.MessageType.STRING.toString(), "hash", 1024,0, false, "摘要" )))
					.addNode(new FieldNode("responseCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "responseCode", 1024,0, false, "响应码" )))
					.addNode(new FieldNode("responseRemark", new MsgField(ContentEnum.MessageType.STRING.toString(), "responseRemark", 1024,0, false, "响应说明" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

