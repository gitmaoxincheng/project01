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
 * BASESVC BODAFA1532  客户领卡 
 *  BODAFA1532 
 *  综合前端
 * @author XZF
 */
@Component
public class BODAFA1532 extends EciChannelService {

	private static BODAFA1532_I i = new BODAFA1532_I();
	private static BODAFA1532_O o = new BODAFA1532_O();
	public BODAFA1532() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1532_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 1024,0, false, "数据日期" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 1024,0, false, "卡号" )))
					.addNode(new FieldNode("sendbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sendbrno", 1024,0, false, "递送网点" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 1024,0, false, "卡状态" )))
					.addNode(new FieldNode("getflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "getflag", 1024,0, false, "领卡标志" )))
					.addNode(new FieldNode("agentname", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentname", 1024,0, false, "代理人名称" )))
					.addNode(new FieldNode("idtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "idtype", 1024,0, false, "证件类型" )))
					.addNode(new FieldNode("idcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcode", 1024,0, false, "证件号码" )))
					.addNode(new FieldNode("agentidtype", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentidtype", 1024,0, false, "代理人证件类型" )))
					.addNode(new FieldNode("agentidcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "agentidcode", 1024,0, false, "代理人证件号码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1532_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("pckgsq", new MsgField(ContentEnum.MessageType.STRING.toString(), "pckgsq", 1024,0, false, "错误码" )))
					.addNode(new FieldNode("erortx", new MsgField(ContentEnum.MessageType.STRING.toString(), "erortx", 1024,0, false, "错误信息" )))
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 1024,0, false, "打印流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

