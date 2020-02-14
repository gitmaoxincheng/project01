package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODAFA1688  柜员间贷记卡调出 
 *  BODAFA1688 883746
 *  综合前置
 * @author LSJ
 */
@Component
public class BODAFA1688 extends EciChannelService {

	private static BODAFA1688_I i = new BODAFA1688_I();
	private static BODAFA1688_O o = new BODAFA1688_O();
	public BODAFA1688() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	public static class BODAFA1688_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true,"Body")
				.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
				.addNode(new FieldNode("totnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totnum", 10,0, true, "总记录数" )))
				.addNode(new ArrayNode("card_list",true,"bodrcd")
					.addNode(new FieldNode("recvtl", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvtl", 10,0, true, "调入柜员编号" )))
					.addNode(new FieldNode("recvtn", new MsgField(ContentEnum.MessageType.STRING.toString(), "recvtn", 60,0, true, "调入柜员名称" )))
					.addNode(new FieldNode("readtp", new MsgField(ContentEnum.MessageType.STRING.toString(), "readtp", 1,0, true, "读取方式  1-接触；2-非接；3-刷磁；9-手工输入" )))
					.addNode(new FieldNode("cardno", new MsgField(ContentEnum.MessageType.STRING.toString(), "cardno", 32,0, true, "卡号" )))
				));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1688_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("Body",true,"APPBody")
				//.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
				);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

