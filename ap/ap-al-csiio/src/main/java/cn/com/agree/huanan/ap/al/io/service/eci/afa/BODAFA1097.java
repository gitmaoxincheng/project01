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
 * BASESVC BODAFA1097  远程授权结果查询 
 *  BODAFA1097 204035
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1097 extends EciChannelService {

	private static BODAFA1097_I i = new BODAFA1097_I();
	private static BODAFA1097_O o = new BODAFA1097_O();
	public BODAFA1097() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1097_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("origchlbusseq", new MsgField(ContentEnum.MessageType.STRING.toString(), "origchlbusseq", 40,0, false, "原渠道业务流水号" )))
					.addNode(new FieldNode("busdtlno", new MsgField(ContentEnum.MessageType.STRING.toString(), "busdtlno", 40,0, false, "业务明细序号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1097_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("remoteauthno", new MsgField(ContentEnum.MessageType.STRING.toString(), "remoteauthno", 10,0, false, "远程授权柜员号" )))
					.addNode(new FieldNode("listnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "listnum", 10,0, false, "返回业务明细数" )))
					.addNode(new StructNode("bodrcd",true)
							.addNode(new FieldNode("busdtlno", new MsgField(ContentEnum.MessageType.STRING.toString(), "busdtlno", 40,0, false, "业务明细序号" )))
							.addNode(new FieldNode("authstatus", new MsgField(ContentEnum.MessageType.STRING.toString(), "authstatus", 1,0, false, "授权状态" )))
							.addNode(new FieldNode("authremark", new MsgField(ContentEnum.MessageType.STRING.toString(), "authremark", 200,0, false, "备注" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

