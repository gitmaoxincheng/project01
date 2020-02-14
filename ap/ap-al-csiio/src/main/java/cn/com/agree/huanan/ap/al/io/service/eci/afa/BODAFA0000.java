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
 * 
 * @author YFK
 * BASESVC BODAFA0000 安全认证（ARQC验证）
 * BODAFA0000 204009
 * 回单机
 */
@Component
public class BODAFA0000 extends EciChannelService {

	private static BODAFA0000_I i = new BODAFA0000_I();
	private static BODAFA0000_O o = new BODAFA0000_O();
	public BODAFA0000() {
		requestFormat.add(i);
		responseFormat.add(o);
	}
	public static class BODAFA0000_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
			 .addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(),  "Eciorgbuf" , 1024 ,0, false, " 渠道备注信?? " )))
			 .addNode(new FieldNode("cardNo", new MsgField(ContentEnum.MessageType.STRING.toString(),  "cardNo" , 19 ,0, false, " IC卡卡号 " )))
			 .addNode(new FieldNode("cardSn", new MsgField(ContentEnum.MessageType.STRING.toString(),  "cardSn" , 2 ,0, false, " 卡序列号 " )))
			 .addNode(new FieldNode("cardAtc", new MsgField(ContentEnum.MessageType.STRING.toString(),  "cardAtc" , 4 ,0, false, " 过程因子 " )))
			 .addNode(new FieldNode("icdata", new MsgField(ContentEnum.MessageType.STRING.toString(),  "icdata" , 4 ,0, false, " arqc数据 " )))
			 .addNode(new FieldNode("icarqc", new MsgField(ContentEnum.MessageType.STRING.toString(),  "icarqc" , 16 ,0, false, " 待验证的ARQC " )))
			 .addNode(new FieldNode("issuerData", new MsgField(ContentEnum.MessageType.STRING.toString(),  "issuerData" , 30 ,0, false, " 发卡行应用数据 " )))
			);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
	public static class BODAFA0000_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
	
}
